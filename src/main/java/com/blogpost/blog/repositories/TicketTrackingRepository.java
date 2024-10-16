package com.blogpost.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blogpost.blog.entities.TicketTracking;

@Repository
public interface TicketTrackingRepository extends JpaRepository<TicketTracking, String> {

    // Custom query to get the maximum SrNo
    @Query("SELECT COALESCE(MAX(t.srNo), 0) FROM TicketTracking t")
    int findBysrNo();
}

