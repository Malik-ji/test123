package com.blogpost.blog.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blogpost.blog.entities.Ticket;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer> {

	@Query("SELECT COALESCE(MAX(SrNo), 0) FROM Ticket")
	int findMaxSrNo();

	@Query("SELECT t FROM Ticket t WHERE t.TicketID = :ticketID")
	Optional<Ticket> findByCustomTicketId(@Param("ticketID") String ticketID);

	@Query("SELECT t FROM Ticket t WHERE t.Company = :company  AND t.Priority = :priority AND t.Severity = :severity AND t.Status = 'New'")
	List<Ticket> getAllNewTickets(@Param("company") String company, @Param("priority") String priority,
			@Param("severity") String severity);

	@Query(value = "SELECT * FROM ticket AS ta WHERE (ta.group_name IN (:groupNames) AND ta.company = :company) OR (ta.engineer_name = :engineerName OR ta.company = :company)", nativeQuery = true)
	List<Ticket> findTicketsByEngineerDetails(@Param("groupNames") List<String> groupNames,
			@Param("company") String company, @Param("engineerName") String engineerName);

	@Query("SELECT t FROM Ticket t WHERE t.TicketID = :ticketID")
	Optional<List<Ticket>> findByTicketID(@Param("ticketID") String ticketID);

	@Query(value = "SELECT * FROM ticket AS ta WHERE (ta.group_name IN (:groupNames) AND ta.company = :company) OR (ta.engineer_name = :engineerName OR ta.company = :company) and Status= :status", nativeQuery = true)
	Optional<List<Ticket>> getAllWIPEngineerTicket(@Param("groupNames") List<String> groupNames,
			@Param("company") String company, @Param("engineerName") String engineerName,
			@Param("status") String status);

	@Query(value = "SELECT * FROM ticket AS ta WHERE ta.raised_by = :username AND ta.Company = :company AND (:status IS NULL OR ta.Status = :status)", nativeQuery = true)
	Optional<List<Ticket>> getAllMyTicket(@Param("username") String username, @Param("company") String company,
			@Param("status") String status);
	

}
