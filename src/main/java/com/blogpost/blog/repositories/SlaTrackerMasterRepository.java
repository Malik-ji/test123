package com.blogpost.blog.repositories;

import com.blogpost.blog.entities.SlaTrackerMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlaTrackerMasterRepository extends JpaRepository<SlaTrackerMaster, Long> {
	
	
	  java.util.List<SlaTrackerMaster> findByCompanyAndPriorityAndSeverity(String company, String priority, String severity);
}
