package com.blogpost.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.blogpost.blog.entities.Ticket;

public interface TicketRepo  extends JpaRepository<Ticket,Integer>{

	
	  @Query("SELECT COALESCE(MAX(SrNo), 0) FROM Ticket")
	    int findMaxSrNo();
	
}
