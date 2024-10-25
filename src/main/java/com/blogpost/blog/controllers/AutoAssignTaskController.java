package com.blogpost.blog.controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
			System.out.println("ADDDDDDDDD" + autoAssignConfig);
			String assignTo = autoAssignConfig.getAssignTo();
			String groupName = autoAssignConfig.getGroupName();
			String defaultAssignTime = autoAssignConfig.getAssignTime();

			List<Ticket> allNewTickets = ticketRepo.getAllNewTickets(autoAssignConfig.getCompany(),
					autoAssignConfig.getPriority(), autoAssignConfig.getSeverity());
			System.out.println("AAAAAAAAAAAA" + allNewTickets);
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
							System.out.println("dffffdf" + ticket.getTicketID());
							Optional<Ticket> ticketIds = ticketRepo.findByCustomTicketId(ticket.getTicketID());
							Ticket ticketId = ticketIds.get();
							System.out.println("AAAAAAAAAAAAAAAAAAAA " + ticketId.getStatus());
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
							System.out.println("AAAAAAAAAAAAAAAAAAAA " + save2.getStatus());

							int findBysrNo = ticketTrackingRepository.findBysrNo();
							TicketTracking tt = new TicketTracking();
							tt.setActivityCompany(AssignerName.TNPL.toString());
							tt.setActivityDateTime(currentDate);
							tt.setCategory(ticketId.getCategory());
							tt.setSubCategory1(ticketId.getSubCategory1());
							tt.setSubCategory2(ticketId.getSubCategory2());
							tt.setDescription(ticketId.getDescription());
							tt.setMessage(TrackDetails.setNewTicketTrackingDetails(raise_time,
									STATUS.Assigned.toString(), AssignerName.Test12.toString(), assignTo, groupName));
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


//						int SRNO1 = 0;
//						try {
//
//							Criteria crit = sessionFactory.getCurrentSession().createCriteria(historical_sla.class)
//									.setProjection(Projections.max("SR_NO"));
//							Integer SRNO2 = (Integer) crit.uniqueResult();
//
//							// System.out.println(" SRNO1 IS: " + SRNO2);
//
//							if (SRNO2 != null) {
//								SRNO1 = SRNO2.intValue();
//								SRNO1 = SRNO1 + 1;
//								// System.out.println("IN IF SRNO2 IS: " + SRNO1);
//							} else {
//								SRNO1 = 1;
//								// System.out.println("IN ELSE SRNO2 IS: " +SRNO1);
//							}
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//							// System.out.println(e);
//						}

//						if (OLD_STATUS.equals("Hold") && statusupdateENG.equals("Hold")
//								|| OLD_STATUS.equals("Hold") && !statusupdateENG.equals("Hold")) {
//
//							// System.out.println("INSIDE BOTH HOLD AND OLD YES OR CURRENT NOT3 " +" OLD
//							// STATUS ==" + OLD_STATUS + " AND CURRENT STATUS IS"+statusupdateENG);
//
//							Criteria criteriaformax = sessionFactory.getCurrentSession().createCriteria(historical_sla.class)
//									.setProjection(Projections.max("SR_NO")).add(Restrictions.eq("TICKET_ID", ticketidupdateTD));
//
//							int maxsrno1 = (int) criteriaformax.uniqueResult();
//
//							// System.out.println("MAX NO is THAT " + maxsrno1);
//
//							Query updathistoricalsla = sessionFactory.getCurrentSession().createQuery(
//									"update historical_sla set HOLD_END_DATE=:HOLD_END_DATE ,TICKET_STATUS=:TICKET_STATUS WHERE SR_NO=:SR_NO");
//							updathistoricalsla.setParameter("HOLD_END_DATE", currenttime);
//							updathistoricalsla.setParameter("SR_NO", maxsrno1);
//							updathistoricalsla.setParameter("TICKET_STATUS", statusupdateENG);
//
//							////////////////////////////// CODE FOR FIND ELAPSE AND HOLD DURATION
//							////////////////////////////// //////////////////////////////
//							int check = updathistoricalsla.executeUpdate();
//
//							String GETSTARTHOLDTIME = "";
//							String GETENDHOLDTIME = "";
//							// System.out.println("VALUE OF CHECK " + check);
//							if (check != 0) {
//
//								// System.out.println("INSIDE ELAPSE IF BLOCK");
//								Query QUERYFORBOTHDATE = sessionFactory.getCurrentSession()
//										.createQuery("from historical_sla where SR_NO='" + maxsrno1 + "'");
//
//								List<historical_sla> historicalvalue = QUERYFORBOTHDATE.list();
//								for (historical_sla getvalue : historicalvalue) {
//
//									GETENDHOLDTIME = getvalue.getHOLD_END_DATE();
//									GETSTARTHOLDTIME = getvalue.getHOLD_START_DATE();
//
//								}
//								// System.out.println("GETENDHOLDTIME VALUE "+ GETENDHOLDTIME);
//								// System.out.println("GETSTARTHOLDTIME VALUE "+ GETSTARTHOLDTIME);
//
//								SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//
//								Date stratdate = sdf.parse(GETSTARTHOLDTIME);
//								Date enddate = sdf.parse(GETENDHOLDTIME);
//
//								long duration = enddate.getTime() - stratdate.getTime();
//
//								// System.out.println("difference_In_Time is " + duration);
//
//								int diffInSeconds = (int) TimeUnit.MILLISECONDS.toSeconds(duration);
//								long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
//								long diffInHours = TimeUnit.MILLISECONDS.toHours(duration);
//								long diffInDays = TimeUnit.MILLISECONDS.toDays(duration);
//
//								// System.out.println("diffInDays: " + diffInDays);
//								// System.out.println("diffInHours: " + diffInHours);
//								// System.out.println("diffInMinutes: " + diffInMinutes);
//								// System.out.println("diffInSeconds: " + diffInSeconds);
//
//								///////////////// START DATE TO END DATE DURATION Starts///////
//								int day_StartEndDate = (int) TimeUnit.SECONDS.toDays(diffInSeconds);
//								long hours_StartEndDate = TimeUnit.SECONDS.toHours(diffInSeconds) - (day_StartEndDate * 24);
//								long minute_StartEndDate = TimeUnit.SECONDS.toMinutes(diffInSeconds)
//										- (TimeUnit.SECONDS.toHours(diffInSeconds) * 60);
//								long second_StartEndDate = TimeUnit.SECONDS.toSeconds(diffInSeconds)
//										- (TimeUnit.SECONDS.toMinutes(diffInSeconds) * 60);
//
//								String day_StartEndDate1 = "";
//								String hours_StartEndDate1 = "";
//								String minute_StartEndDate1 = "";
//								String second_StartEndDate1 = "";
//
//								if (day_StartEndDate != 0) {
//									day_StartEndDate1 = Integer.toString(day_StartEndDate) + " Days ";
//								}
//								if (hours_StartEndDate != 0) {
//									hours_StartEndDate1 = Long.toString(hours_StartEndDate) + " Hours ";
//								}
//								if (minute_StartEndDate != 0) {
//									minute_StartEndDate1 = Long.toString(minute_StartEndDate) + " Minutes ";
//								}
//								if (second_StartEndDate != 0) {
//									second_StartEndDate1 = Long.toString(second_StartEndDate) + " Seconds ";
//								}
//
//								String StartEndDateDuration = day_StartEndDate1 + hours_StartEndDate1 + minute_StartEndDate1
//										+ second_StartEndDate1;
//								// System.out.println("START & END DATE DURATION: " + StartEndDateDuration);
//								// System.out.println(" TOTAL ELAPS TIME IS " + diffInSeconds);
//
//								if (!StartEndDateDuration.isEmpty() && diffInSeconds != 0) {
//
//									Query updateelapsandduration = sessionFactory.getCurrentSession().createQuery(
//											"update historical_sla set HOLD_DURATION=:HOLD_DURATION,HOLD_ELAPSED_TIME=:HOLD_ELAPSED_TIME  WHERE SR_NO=:SR_NO");
//									updateelapsandduration.setParameter("HOLD_ELAPSED_TIME",
//											Integer.valueOf(diffInSeconds).toString());
//									updateelapsandduration.setParameter("SR_NO", maxsrno1);
//									updateelapsandduration.setParameter("HOLD_DURATION", StartEndDateDuration);
//									int check2 = updateelapsandduration.executeUpdate();
//
//									// System.out.println("check2 value "+ check2);
//
//								}
//
//							}
//
//							/////////////////// TOTAL HOLD DURATION FOUND END///////////////////
//
//							if (OLD_STATUS.equals("Hold") && statusupdateENG.equals("Hold")) {
//
//								historical_sla historicalsla = new historical_sla();
//
//								historicalsla.setSR_NO(SRNO1);
//								historicalsla.setTICKET_ID(ticketidupdateTD);
//
//								historicalsla.setTICKET_STATUS(statusupdateENG);
//
//								historicalsla.setSLA_STATUS("NA");
//								historicalsla.setHOLD_START_DATE(currenttime);
//								historicalsla.setHOLD_END_DATE("NA");
//								historicalsla.setHOLD_ELAPSED_TIME("NA");
//
//								historicalsla.setHOLD_DURATION("NA");
//
//								historicalsla.setT_COMPANY(companyupdateUD);
//								historicalsla.setT_BRANCH(siteupdateUD);
//								historicalsla.setT_DEPARTMENT(deptupdateUD);
//								sessionFactory.getCurrentSession().save(historicalsla);
//
//							}
//
//						}
//
//						else if (!OLD_STATUS.equals("Hold") && statusupdateENG.equals("Hold")) {
//
//							// System.out.println("INSIDE OLD not HOLD AND CURRENT IS HOLD " +" OLD STATUS
//							// ==" + OLD_STATUS + " AND CURRENT STATUS IS"+statusupdateENG);
//							historical_sla historicalsla = new historical_sla();
////						
//							historicalsla.setSR_NO(SRNO1);
//							historicalsla.setTICKET_ID(ticketidupdateTD);
//							historicalsla.setTICKET_STATUS(statusupdateENG);
//
//							historicalsla.setSLA_STATUS("NA");
//							historicalsla.setHOLD_START_DATE(currenttime);
//							historicalsla.setHOLD_END_DATE("NA");
//							historicalsla.setHOLD_ELAPSED_TIME("NA");
//
//							historicalsla.setHOLD_DURATION("NA");
//
//							historicalsla.setT_COMPANY(companyupdateUD);
//							historicalsla.setT_BRANCH(siteupdateUD);
//							historicalsla.setT_DEPARTMENT(deptupdateUD);
//							sessionFactory.getCurrentSession().save(historicalsla);
//
//						}
//
//					
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
