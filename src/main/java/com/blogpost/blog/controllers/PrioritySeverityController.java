package com.blogpost.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogpost.blog.payloads.ApiResponse;
import com.blogpost.blog.payloads.PrioritySeverityMasterDto;
import com.blogpost.blog.payloads.UserDto;
import com.blogpost.blog.services.PrioritySeverityMasterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/priority")
public class PrioritySeverityController {

	@Autowired
	PrioritySeverityMasterService priorityService;

	@PostMapping("/")
	public ResponseEntity<?> createUser(@RequestBody PrioritySeverityMasterDto userDto) {
		
		System.out.println("mmmmmm"+userDto);
		ResponseEntity<?> createPrioritySeverityMaster = this.priorityService
				.createPrioritySeverityMaster(userDto);
		return new ResponseEntity<>(createPrioritySeverityMaster, HttpStatus.CREATED);
	}
	@PatchMapping("/updateByPriority/{priority}")
	public ResponseEntity<PrioritySeverityMasterDto> updateUsers(@Valid @RequestBody PrioritySeverityMasterDto userDto,
			@PathVariable("priority") String priority) {
		PrioritySeverityMasterDto updateUSer = this.priorityService.updateUPriority(userDto, priority);
		return new ResponseEntity<PrioritySeverityMasterDto>(updateUSer, HttpStatus.OK);
	}

	@GetMapping("/getByPriority/{priority}")
	public ResponseEntity<PrioritySeverityMasterDto> getPriority(@PathVariable String priority) {	
		System.out.println("AAAAAAAAAAAAAA  : "+priority);
		PrioritySeverityMasterDto prioritySeverityMasterByPriority = this.priorityService.getPrioritySeverityMasterByPriority(priority.trim());
		System.out.println("AAAAAAAAAAAAAA  : "+prioritySeverityMasterByPriority);
		return ResponseEntity.ok(this.priorityService.getPrioritySeverityMasterByPriority(priority.trim()));
	}

	@GetMapping("/getAllPriority")
	public ResponseEntity<List<PrioritySeverityMasterDto>> getAllPriority() {
		List<PrioritySeverityMasterDto> allPrioritySeverityMasters = this.priorityService.getAllPrioritySeverityMasters();
		return ResponseEntity.ok(allPrioritySeverityMasters);
	}
	
	@PatchMapping("/deleteByPriority/{priority}")
	public ResponseEntity<ApiResponse> deleteUserById(@PathVariable("priority") String id) {
		System.out.println("ADDDDDDDDDDDDDDDDDDDDDDD" + id);
		this.priorityService.deletePrioritySeverityMaster(id);
		return new ResponseEntity<>(new ApiResponse("Priority Deleted Successfully", true), HttpStatus.OK);
	}

}
