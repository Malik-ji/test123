package com.blogpost.blog.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogpost.blog.entities.Ticket;
import com.blogpost.blog.entities.TicketDetailsResponse;
import com.blogpost.blog.repositories.TicketRepo;
import com.blogpost.blog.repositories.TicketTrackingRepository;

@RestController
@RequestMapping("/api/engineer")
public class EngineerActivityController {

	@GetMapping("/getAllEngineerTicket")
	public List<Ticket> getAllEngineerTicket(HttpServletRequest httpServletRequest, HttpSession httpSession) {
		String username = httpSession.getAttribute("username").toString();
		String Company = httpSession.getAttribute("Company").toString();
		String GroupName = httpSession.getAttribute("GroupName").toString();

		return null;
	}

	@Autowired
	TicketRepo ticketRepo;

	@Autowired
	TicketTrackingRepository ticketTracking;

	@GetMapping("/getAllEngineerTicket")
	public ResponseEntity<?> getAllEngineerTicket(HttpSession session) {
		try {
			// Retrieve session attributes
			String username = session.getAttribute("username").toString();
			String company = session.getAttribute("company").toString();
			List<String> groupName = (List<String>) session.getAttribute("groupName");

			// Check if session attributes are valid
			if (username == null || company == null || groupName == null) {
				return new ResponseEntity<>("Session attributes missing. Please log in again.",
						HttpStatus.UNAUTHORIZED);
			}

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

	@GetMapping("/{ticketID}")
	public ResponseEntity<?> getTicketDetails(@PathVariable String ticketID) {
		try {
			// Fetch ticket details
			Optional<Ticket> ticketOptional = ticketRepo.findByTicketID(ticketID);
			if (ticketOptional.isPresent()) {
				Ticket ticket = ticketOptional.get();

				Optional<Ticket> trackingDetails = ticketTracking.findByTicketID(ticketID);

				// Create response DTO
				TicketDetailsResponse response = new TicketDetailsResponse();
//            response.setTickets(ticketOptional.get());
//            response.setTrackingDetails(trackingDetails);

				return new ResponseEntity<>(response, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Ticket not found.", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
