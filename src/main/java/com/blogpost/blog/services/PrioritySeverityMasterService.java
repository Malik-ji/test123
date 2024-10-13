package com.blogpost.blog.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.blogpost.blog.entities.PrioritySeverityMaster;
import com.blogpost.blog.payloads.PrioritySeverityMasterDto;
import com.blogpost.blog.payloads.PrioritySeverityMasterDto;
@Service
public interface PrioritySeverityMasterService {

	ResponseEntity<?> createPrioritySeverityMaster(PrioritySeverityMasterDto userDto);

	PrioritySeverityMasterDto updateUPriority(PrioritySeverityMasterDto userDto, String  userId);

	PrioritySeverityMasterDto getPrioritySeverityMasterByPriority(String priority);

	List<PrioritySeverityMasterDto> getAllPrioritySeverityMasters();

	void deletePrioritySeverityMaster(String userId);

}
