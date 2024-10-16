package com.blogpost.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blogpost.blog.entities.Ticket;

@Repository
public interface TicketRepo  extends JpaRepository<Ticket,Integer>{

	
	  @Query("SELECT COALESCE(MAX(SrNo), 0) FROM Ticket")
	    int findMaxSrNo();
	  
	  @Query("SELECT t FROM Ticket t WHERE t.TicketID = :ticketID")
	  Ticket findByCustomTicketId(@Param("ticketID") String ticketID);
	  
	  @Query("SELECT t FROM Ticket t WHERE t.Company = :company AND t.Category = :category AND t.Priority = :priority AND t.Severity = :severity AND t.Status = 'New'")
	  List<Ticket> getAllNewTickets(@Param("company") String company, @Param("category") String category, @Param("priority") String priority, @Param("severity") String severity);  
	  
//	  @Query("SELECT t FROM Ticket t WHERE t.Company = :company AND t.Category = :category AND t.Priority = :priority AND t.Severity = :severity AND t.Status = 'New'")
//	  List<Ticket> getAllEngineers(@Param("company") String company, @Param("category") String category, @Param("priority") String priority, @Param("severity") String severity);  

	  
}
