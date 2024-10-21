package com.blogpost.blog.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogpost.blog.config.STATUS;
import com.blogpost.blog.entities.Sla;
import com.blogpost.blog.entities.Ticket;
import com.blogpost.blog.entities.TicketTracking;
import com.blogpost.blog.repositories.SlaRepository;
import com.blogpost.blog.repositories.SlaTrackerMasterRepository;
import com.blogpost.blog.repositories.TicketRepo;
import com.blogpost.blog.repositories.TicketTrackingRepository;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/api/ticket")
@CrossOrigin("*")
public class TicketActionController {

	@Autowired
	TicketRepo ticketRepo;
	
	@Autowired
	SlaTrackerMasterRepository slaTrackerMasterRepository;
	@Autowired 
	TicketTrackingRepository ticketTrackingRepo;
	
	@Autowired
	SlaRepository slaRepository;
	@PostMapping("/raise")

	
	@Transactional
	@Operation(summary = "Raise a new ticket", description = "Creates a new ticket in the system")

	public ResponseEntity<?> raiseTicket(@RequestBody Ticket request) {
		try {

			System.out.println(request.getRaisedByFullName() + "ADDDDDDDDDD");
			LocalDateTime now = LocalDateTime.now();

			// Define the desired date format
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");

			// Format the current date and time as a string
			String formattedDate = now.format(formatter);
			int maxSrNo = ticketRepo.findMaxSrNo();
		
			Ticket ticket = new Ticket();
			String TicketID="INC-" +( maxSrNo + 1);
			// Generate unique Ticket ID
			ticket.setTicketID(TicketID);

			// Set basic information
			ticket.setRaisedBy(request.getRaisedBy());
			ticket.setRequestType(request.getRequestType());
			ticket.setCompany(request.getCompany());
			ticket.setBranch(request.getBranch());
			ticket.setDepartment(request.getDepartment());
			ticket.setLocation(request.getLocation());

			// Set subject and categories
			ticket.setSubject(request.getSubject());
			ticket.setCategory(request.getCategory());
			ticket.setSubCategory1(request.getSubCategory1());
			ticket.setSubCategory2(request.getSubCategory2());
			ticket.setPriority(request.getPriority());
			ticket.setSeverity(request.getSeverity());
			ticket.setRaisedByFullName(request.getRaisedByFullName());
			// Set initial status and timestamps
			ticket.setStatus(STATUS.New.toString());
			ticket.setRaiseDate(formattedDate);
			ticket.setCurrentDateTime(formattedDate);
			ticket.setSrNo(maxSrNo+1); // Increment the max srno by 1
			ticket.setDescription(ticket.getDescription());
			// Handle attachment
			if (request.getAttachment() != null && !request.getAttachment().isEmpty()) {
                ticket.setAttachment("NA");
                
//                ticket.setAttachmentName(request.getAttachment().getOriginalFilename());
			}

			// Save the ticket to the database using the JPA save() method
           Ticket save = ticketRepo.save(ticket);
           System.out.println("DFDFDFDFDFDFDFDFDFDFDF  :: "+save.getSrNo());
            if(save.getSrNo()>0)
            {
            	
            	int findMaxSrNo = ticketTrackingRepo.findBysrNo();
            	System.out.println("DFDFDFDFDFDFDFDFDFDF tracking findMaxSrNo"+findMaxSrNo);
            	TicketTracking t=new TicketTracking();
            	t.setStatus(STATUS.New.toString());
            	t.setCategory(ticket.getCategory());
            	t.setSubCategory1(ticket.getSubCategory1());
            	t.setSubCategory2(ticket.getSubCategory2());
            	t.setActivityDateTime(formattedDate);
            	t.setActivityCompany(ticket.getCompany());
            	t.setPriority(ticket.getPriority());
            	t.setSeverity(ticket.getSeverity());
            	t.setDescription(ticket.getDescription());
            	t.setMessage("TimeStamp: "+formattedDate+" Status : "+STATUS.New.toString()+"RaisedBy :"+ticket.getRaisedBy());
            	t.setTicketRaisedByName(ticket.getRaisedBy());
            	t.setTicketRaisedByCompany(ticket.getCompany());
            	t.setSubject(request.getSubject());
            	t.setTicketID(TicketID);
            	t.setSrNo(findMaxSrNo+1);
            	
            	TicketTracking save2 = ticketTrackingRepo.save(t);
            	System.out.println("AAAAAAAAA"+save2.getTicketID());
            	 int findMaxSrNo2 = slaRepository.findMaxSrNo();
            	 Sla findByTICKETID=new Sla();
            	System.out.println("ADDDDDDDDDDDDDDDDD :: "+findByTICKETID.getTicketId());
            	findByTICKETID.setTicketId(TicketID);
            	findByTICKETID.setTicketStatus(STATUS.New.toString());
            	
            	findByTICKETID.setPriority(ticket.getPriority());
            	findByTICKETID.setSeverity(ticket.getSeverity());
            	findByTICKETID.setStartDate(formattedDate);
            	findByTICKETID.setStopDate("NA");
            	findByTICKETID.setStartEndTime("NA");
            	findByTICKETID.setElapsedTime("NA");
            	findByTICKETID.setHoldStartDate("NA");
				findByTICKETID.setHoldEndDate("NA");
				findByTICKETID.setHoldElapsedTime("NA");
				findByTICKETID.setHoldDuration("NA");
				findByTICKETID.setSlaStatus("NA");
				findByTICKETID.setSlaTarget("NA");
				findByTICKETID.setSlaTime("NA");
				findByTICKETID.setActualWorkingTime("NA");
				findByTICKETID.setSrNo(++findMaxSrNo2);
				slaRepository.save(findByTICKETID);
				
            }
            
            
			// Return the new srno in the response
			return new ResponseEntity<>("Ticket Raised With Ticket ID: " + "INC" + maxSrNo, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			// Log the error (omitted for brevity)
			return new ResponseEntity<>("Failed to create ticket: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}