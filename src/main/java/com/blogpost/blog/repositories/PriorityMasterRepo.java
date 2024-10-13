package com.blogpost.blog.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blogpost.blog.entities.PrioritySeverityMaster;

@Repository
public interface PriorityMasterRepo extends JpaRepository<PrioritySeverityMaster, Long>{
	
	Optional<PrioritySeverityMaster> findByPriorityIgnoreCase(String priority);
	@Query(value = "SELECT * FROM priority_severity_master WHERE company = ?1 AND priority = ?2", nativeQuery = true)
	Optional<PrioritySeverityMaster> findByPriorityCompany(String company, String priority);
}
