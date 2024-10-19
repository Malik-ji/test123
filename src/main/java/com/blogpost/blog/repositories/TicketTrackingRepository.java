package com.blogpost.blog.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blogpost.blog.entities.Ticket;
import com.blogpost.blog.entities.TicketTracking;

@Repository
public interface TicketTrackingRepository extends JpaRepository<TicketTracking, String> {

	// Custom query to get the maximum SrNo
	@Query("SELECT COALESCE(MAX(t.srNo), 0) FROM TicketTracking t")
	int findBysrNo();

	@Query("SELECT t FROM TicketTracking t WHERE t.TicketID = :ticketID")
	Optional<Ticket> findByTicketID(@Param("ticketID") String ticketID);
}
