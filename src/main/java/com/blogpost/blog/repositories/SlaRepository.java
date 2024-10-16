package com.blogpost.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blogpost.blog.entities.Sla;

@Repository
public interface SlaRepository extends JpaRepository<Sla, String> {

	 @Query("SELECT COALESCE(MAX(s.srNo), 0) FROM Sla s")
	    Integer findMaxSrNo();
    // Custom query methods can be added here if needed
	
//		public Sla findByTICKETID(String ticketId);
}

