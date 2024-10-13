package com.blogpost.blog.controllers;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogpost.blog.STATUS;
import com.blogpost.blog.entities.SlaTrackerMaster;
import com.blogpost.blog.entities.Ticket;
import com.blogpost.blog.entities.TicketTracking;
import com.blogpost.blog.repositories.SlaRepository;
import com.blogpost.blog.repositories.SlaTrackerMasterRepository;
import com.blogpost.blog.repositories.TicketRepo;
import com.blogpost.blog.repositories.TicketTrackingRepository;

@RestController
@RequestMapping(value = "/ticket/v1")
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
	
	public ResponseEntity<?> raiseTicket(@RequestBody Ticket request) {
		try {

			System.out.println(request.getRaisedByFullName() + "ADDDDDDDDDD");
			LocalDateTime now = LocalDateTime.now();

			// Define the desired date format
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");

			// Format the current date and time as a string
			String formattedDate = now.format(formatter);
			int maxSrNo = ticketRepo.findMaxSrNo();
			int MaxId = maxSrNo + 1;
			Ticket ticket = new Ticket();

			// Generate unique Ticket ID
			ticket.setTicketID("INC-" + MaxId);

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
			ticket.setSrNo(MaxId); // Increment the max srno by 1
			ticket.setDescription(ticket.getDescription());
			// Handle attachment
			if (request.getAttachment() != null && !request.getAttachment().isEmpty()) {
                ticket.setAttachment("NA");
//                ticket.setAttachmentName(request.getAttachment().getOriginalFilename());
			}

			// Save the ticket to the database using the JPA save() method
           Ticket save = ticketRepo.save(ticket);
            if(save.getSrNo()>0)
            {
            	
            	int findMaxSrNo = ticketTrackingRepo.findMaxSrNo();
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
            	t.setMessage("TimeStamp: "+formattedDate+" Status : "+STATUS.New.toString()+"RaisedBy"+ticket.getRaisedBy());
            	t.setTicketRaisedByName(ticket.getRaisedBy());
            	t.setTicketRaisedByCompany(ticket.getCompany());
            	TicketTracking save2 = ticketTrackingRepo.save(t);
            	
            	
            	
            	List<SlaTrackerMaster> findByCompanyAndPriorityAndSeverity = slaTrackerMasterRepository.findByCompanyAndPriorityAndSeverity(ticket.getCompany(), ticket.getPriority(),
            			ticket.getSeverity());
            	
            	
            	
            	
            }
            
            
			// Return the new srno in the response
			return new ResponseEntity<>("Ticket Raised With Ticket ID: " + "INC" + maxSrNo, HttpStatus.CREATED);

		} catch (Exception e) {
			// Log the error (omitted for brevity)
			return new ResponseEntity<>("Failed to create ticket: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}