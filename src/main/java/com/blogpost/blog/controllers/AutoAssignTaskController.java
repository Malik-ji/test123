package com.blogpost.blog.controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import com.blogpost.blog.config.AssignerName;
import com.blogpost.blog.config.STATUS;
import com.blogpost.blog.config.TrackDetails;
import com.blogpost.blog.entities.AutoAssignConfig;
import com.blogpost.blog.entities.Ticket;
import com.blogpost.blog.entities.TicketTracking;
import com.blogpost.blog.repositories.TicketRepo;
import com.blogpost.blog.repositories.TicketTrackingRepository;
import com.blogpost.blog.repositories.UserRepo;

@RestController
public class AutoAssignTaskController {

	@Autowired
	AutoAssignConfigController assignTaskController;

	@Autowired
	TicketRepo ticketRepo;

	@Autowired
	TicketTrackingRepository ticketTrackingRepository;
	@Autowired
	UserRepo userRepo;

//	@Scheduled(cron = "*/1 * * * * *")
	public void setAutoAssignTask() {

		ResponseEntity<List<AutoAssignConfig>> allConfigs = assignTaskController.getAllConfigs();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		List<AutoAssignConfig> body = allConfigs.getBody();
		for (AutoAssignConfig autoAssignConfig : body) {
			System.out.println("ADDDDDDDDD"+autoAssignConfig);
			String assignTo = autoAssignConfig.getAssignTo();
			String groupName = autoAssignConfig.getGroupName();
			String defaultAssignTime = autoAssignConfig.getAssignTime();

			List<Ticket> allNewTickets = ticketRepo.getAllNewTickets(autoAssignConfig.getCompany(),autoAssignConfig.getPriority(), autoAssignConfig.getSeverity());
			System.out.println("AAAAAAAAAAAA"+allNewTickets);
			Iterator<Ticket> iterator = allNewTickets.iterator();
			while (iterator.hasNext()) {
				Ticket ticket = iterator.next();
				String raise_time = ticket.getRaiseDate();
				LocalDateTime nows = LocalDateTime.now();

				// Define the desired date format
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");

				// Format the current date and time as a string
				String currentDate = nows.format(formatter);
				try {
					java.util.Date TicketRaisedate = format.parse(raise_time);
					Date Currentdate = new Date();
					long diffrence_in_milisec = Currentdate.getTime() - TicketRaisedate.getTime();
					long diffrence_in_sec = diffrence_in_milisec / 1000;
					System.out.println("TICKET ID: " + ticket);
                       System.out.println("Difference Time:" + diffrence_in_sec);
					long defaultAssignTime1 = Long.parseLong(defaultAssignTime);

					if (diffrence_in_sec >= defaultAssignTime1) {
						System.out.println("TICKET IDs: " + ticket.getTicketID());
//                    	   assgin toEn
						if (assignTo.equals("Engineer")) {
//                    		   List<Loginmaster> allEngineers = userRepo.getAllEngineers();
//                    		   allEngineers.forEach(e->{
//                    			  
//                    		   });

						} else { // assing to group
								System.out.println("dffffdf" +ticket.getTicketID());
							Ticket ticketId = ticketRepo.findByCustomTicketId(ticket.getTicketID());
							System.out.println("AAAAAAAAAAAAAAAAAAAA "+ticketId.getStatus());
							ticketId.setAssignDate(defaultAssignTime);
							ticketId.setAssignBy(AssignerName.Test12.toString());
							ticketId.setAssignByFullName(AssignerName.Test1234567.toString());
							ticketId.setStatus("Assigned");
							ticketId.setGroupName(groupName);
							ticketId.setEngineerFullName("NA");
							ticketId.setEngineerName("NA");
							ticketId.setAttachment("NA");
							ticketId.setCurrentDateTime(currentDate);
							ticketId.setDescription(ticket.getDescription());
							
							Ticket save2 = ticketRepo.save(ticketId);
							System.out.println("AAAAAAAAAAAAAAAAAAAA "+save2.getStatus());
							
							int findBysrNo = ticketTrackingRepository.findBysrNo();
							TicketTracking tt=new TicketTracking();
							tt.setActivityCompany(AssignerName.TNPL.toString());
							tt.setActivityDateTime(currentDate);
							tt.setCategory(ticketId.getCategory());
							tt.setSubCategory1(ticketId.getSubCategory1());
							tt.setSubCategory2(ticketId.getSubCategory2());
							tt.setDescription(ticketId.getDescription());
							tt.setMessage(TrackDetails.setNewTicketTrackingDetails(raise_time, STATUS.Assigned.toString(), AssignerName.Test12.toString(),
									assignTo,groupName ));
							tt.setActivityName(AssignerName.Test12.toString());
							tt.setPriority(ticket.getPriority());
							tt.setSeverity(ticket.getSeverity());
							tt.setSrNo(++findBysrNo);
							tt.setStatus(STATUS.Assigned.toString());
							tt.setSubject(ticket.getSubject());
							tt.setTicketRaisedByName(ticket.getRaisedBy());
							tt.setTicketRaisedByCompany(ticket.getCompany());
							tt.setTicketID(ticket.getTicketID());
							TicketTracking save = ticketTrackingRepository.save(tt);
							
						}

//						System.out.println("ADDDDDDDDDDD " + ticket.getRaiseDate());

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
//				System.out.println("ASASASASASASASAS :: "+iterator.next());
			}
		}

//		System.out.println("ADDDDDDDDD" + allConfigs);
	}

}
