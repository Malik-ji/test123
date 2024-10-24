package com.blogpost.blog.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogpost.blog.config.STATUS;
import com.blogpost.blog.entities.Ticket;
import com.blogpost.blog.entities.TicketDetailsResponse;
import com.blogpost.blog.entities.TicketTracking;
import com.blogpost.blog.exceptions.ResourceNotFoundException;
import com.blogpost.blog.repositories.TicketRepo;
import com.blogpost.blog.repositories.TicketTrackingRepository;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/engineer")
@CrossOrigin("*")
public class EngineerActivityController {
//
//	@GetMapping("/getAllEngineerTicket")
//	public List<Ticket> getAllEngineerTicket(HttpServletRequest httpServletRequest, HttpSession httpSession) {
//		String username = httpSession.getAttribute("username").toString();
//		String Company = httpSession.getAttribute("Company").toString();
//		String GroupName = httpSession.getAttribute("GroupName").toString();
//
//		return null;
//	}

	@Autowired
	TicketRepo ticketRepo;

	@Autowired
	TicketTrackingRepository ticketTracking;

	@GetMapping("/getAllEngineerTicket")
	public ResponseEntity<?> getAllEngineerTicket(@RequestParam("username") String username,
			@RequestParam("company") String company, @RequestParam("groupName") String groupNames) {
		try {

			List<String> groupName = Arrays.stream(groupNames.split(",")).map(String::trim)
					.collect(Collectors.toList());

			// Fetch tickets using the repository method
			List<Ticket> findTicketsByEngineerDetails = ticketRepo.findTicketsByEngineerDetails(groupName, company,
					username);

			// Check if any tickets were found
			if (findTicketsByEngineerDetails.isEmpty()) {
				return new ResponseEntity<>("No tickets found for the provided details.", HttpStatus.NO_CONTENT);
			}

			// If tickets are found, return the list of tickets with 200 OK status
			return new ResponseEntity<>(findTicketsByEngineerDetails, HttpStatus.OK);

		} catch (Exception e) {
			// Handle any exceptions that occur
			return new ResponseEntity<>("An error occurred while fetching tickets: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getAllWIPEngineerTicket")
	public ResponseEntity<?> getAllWIPEngineerTicket(
	        @RequestParam("username") String username,
	        @RequestParam("company") String company,
	        @RequestParam("groupName") String groupNames,
	        @RequestParam("status") String status) {
	    try {
	        // Split and trim group names
	        List<String> groupNameList = Arrays.stream(groupNames.split(","))
	                .map(String::trim)
	                .collect(Collectors.toList());

	        // Fetch tickets using the repository method
	        Optional<List<Ticket>> ticketsOptional = ticketRepo.getAllWIPEngineerTicket(groupNameList, company, username, status);

	        // Initialize response object
	        TicketDetailsResponse response = new TicketDetailsResponse();

	        // Check if any tickets were found
	        if (!ticketsOptional.isPresent() || ticketsOptional.get().isEmpty()) {
	            return new ResponseEntity<>("No tickets found for the provided details.", HttpStatus.NO_CONTENT);
	        }

	        List<Ticket> tickets = ticketsOptional.get();
	        response.setTickets(ticketsOptional);

	        // Fetch tracking details for all found tickets
	        List<TicketTracking> allTrackingDetails = new ArrayList<>();
	        for (Ticket ticket : tickets) {
	            Optional<List<TicketTracking>> trackingDetails = ticketTracking.getByTicketIds(ticket.getTicketID());
	            trackingDetails.ifPresent(allTrackingDetails::addAll); // Collect all tracking details
	        }

	        response.setTrackingDetails(Optional.of(allTrackingDetails)); // Set tracking details in response

	        // Return the list of tickets with 200 OK status
	        return new ResponseEntity<>(response, HttpStatus.OK);

	    } catch (Exception e) {
	        // Handle any exceptions that occur
	        return new ResponseEntity<>("An error occurred while fetching tickets: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
		
	

	@GetMapping("/{ticketID}")
	public ResponseEntity<?> getTicketDetails(@PathVariable String ticketID) {
		try {
			// Fetch ticket details
			Optional<List<Ticket>> ticketOptional = ticketRepo.findByTicketID(ticketID);
			if (ticketOptional.isPresent() && !ticketOptional.get().isEmpty()) {

				Optional<List<TicketTracking>> trackingDetails = ticketTracking.getByTicketIds(ticketID);

				TicketDetailsResponse response = new TicketDetailsResponse();
				response.setTickets(ticketOptional); // Directly set the list of tickets
				response.setTrackingDetails(trackingDetails); // Set tracking details

				return new ResponseEntity<>(response, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Ticket not found.", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/WIP")
	@Transactional
	@Operation(summary = "WIP a Assign ticket", description = "WIP a Assign ticke")
	public ResponseEntity<?> WIPTicket(@RequestParam("tid") String ticketID, @RequestParam("engname") String Engname,
			@RequestParam("company") String Company, @RequestParam("desc") String Desc,
			@RequestParam("engnamefullname") String EngnameFullname) {
		try {
//			System.out.println("jjjjjjjjjjjjjjj  "+ticketID);
 			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");
			String formattedDate = now.format(formatter); 
			Ticket ticket = ticketRepo.findByCustomTicketId(ticketID)
					.orElseThrow(() -> new ResourceNotFoundException("Ticket", "ID", ticketID));
			ticket.setStatus(STATUS.InProgress.toString());
			ticket.setEngineerName(Engname);
			ticket.setEnggCompany(Company);
			ticket.setCurrentDateTime(formattedDate);
			ticket.setEngineerFullName(EngnameFullname);
			Ticket savedTicket = ticketRepo.save(ticket);
//			System.out.println("Ticket updated successfully. SR No: " + savedTicket.getSrNo());
			if (savedTicket.getSrNo() > 0) {
				int findMaxSrNo = ticketTracking.findBysrNo();
				System.out.println("Max tracking SrNo: " + findMaxSrNo);
				TicketTracking tracking = new TicketTracking();
				tracking.setStatus(STATUS.InProgress.toString());
				tracking.setCategory(savedTicket.getCategory());
				tracking.setSubCategory1(savedTicket.getSubCategory1());
				tracking.setSubCategory2(savedTicket.getSubCategory2());
				tracking.setActivityDateTime(formattedDate);
				tracking.setActivityCompany(savedTicket.getCompany());
				tracking.setPriority(savedTicket.getPriority());
				tracking.setSeverity(savedTicket.getSeverity());
				tracking.setDescription(savedTicket.getDescription());
				tracking.setMessage("Timestamp: " + formattedDate + " Status: " + STATUS.InProgress + " Inprogress: "
						+ savedTicket.getEngineerName());
				tracking.setTicketRaisedByName(savedTicket.getRaisedBy());
				tracking.setTicketRaisedByCompany(savedTicket.getCompany());
				tracking.setSubject(savedTicket.getSubject());
				tracking.setTicketID(ticketID);
				tracking.setSrNo(findMaxSrNo + 1);
				TicketTracking savedTracking = ticketTracking.save(tracking);
				System.out.println("Ticket tracking updated. Tracking Sr No: " + savedTracking.getSrNo());
			}
			return new ResponseEntity<>("Ticket Work in Progress Sucessfully: " + ticketID, HttpStatus.OK);

		} catch (ResourceNotFoundException e) {
			System.err.println("Ticket not found: " + e.getMessage());
			return new ResponseEntity<>("Ticket Not Found: " + e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			System.err.println("Exception occurred while processing the ticket: " + e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<>("Failed to Change Status : " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//	trQuery.setParameter("A_ENGINEER_NAME", loginname);
//	trQuery.setParameter("RESOLVED_ENGINEER_NAME", loginname);
//	trQuery.setParameter("RESOLVED_ENGINEER_COMPANY", engcompany);
//	trQuery.setParameter("T_STATUS", status);
//	trQuery.setParameter("T_RESOLVED_TIME", currenttime11);
//	trQuery.setParameter("RESOLVED_DATE", currenttime11);
//	trQuery.setParameter("SOLUTION", solution);
//	trQuery.setParameter("RESOLVED_ENGINEER_FULLNAME", fullnameoflogin);
//	trQuery.setParameter("RESOLVED_ENGINEER_EMAIL", engemailid);
//	trQuery.setParameter("CURRENT_ACTIVITY_TIME", currenttime);
//	trQuery.setParameter("ASSIGNED_ENGINEER_FULLNAME", fullnameoflogin);
//	trQuery.setParameter("CALL_TYPE", calltype);
//	trQuery.setParameter("solutionCode", solutionCode);
//
//	trQuery.setParameter("T_CATEGORY", category);
//	trQuery.setParameter("T_SUBCATEGORY1", subcat1);
//	trQuery.setParameter("T_SUBCATEGORY2", subcat2);

}
