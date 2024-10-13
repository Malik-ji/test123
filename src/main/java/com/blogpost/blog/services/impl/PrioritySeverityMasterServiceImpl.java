package com.blogpost.blog.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.blogpost.blog.entities.PrioritySeverityMaster;
import com.blogpost.blog.entities.User;
import com.blogpost.blog.exceptions.ResourceAlreadyExistsException;
import com.blogpost.blog.exceptions.ResourceNotFoundException;
import com.blogpost.blog.payloads.ApiResponse;
import com.blogpost.blog.payloads.CategoryDto;
import com.blogpost.blog.payloads.PrioritySeverityMasterDto;
import com.blogpost.blog.payloads.UserDto;
import com.blogpost.blog.repositories.PriorityMasterRepo;
import com.blogpost.blog.services.PrioritySeverityMasterService;
@Service
public class PrioritySeverityMasterServiceImpl implements PrioritySeverityMasterService{

	@Autowired
	PriorityMasterRepo masterRepo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public ResponseEntity<?> createPrioritySeverityMaster(PrioritySeverityMasterDto userDto) {
		 PrioritySeverityMasterDto map2 = null ;
		 PrioritySeverityMaster save=null;
		try {
			
			 PrioritySeverityMaster map = mapper.map(userDto, PrioritySeverityMaster.class);
			 Optional<PrioritySeverityMaster> findByPriorityIgnoreCase = this.masterRepo.findByPriorityCompany(map.getCompany(),map.getPriority());
			if(findByPriorityIgnoreCase.isPresent())
			{
				System.out.println("AAAAAAAAAAA");
				return  ResponseEntity.ok().body(new ApiResponse("Already Exist",false));
				
			}else
			{
				  save = masterRepo.save(map);
				  map2 = mapper.map(save,PrioritySeverityMasterDto.class);
				  return  ResponseEntity.ok().body(map2);
//				  return map2
			}
			  

//			System.out.println("BBBBBBBBBBBBBB");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		System.out.println("AAAAAAAAAAA");
		return null;
		
	
	}

	@Override
	public PrioritySeverityMasterDto updateUPriority(PrioritySeverityMasterDto priorityDto,String priority) {
		PrioritySeverityMaster master = this.masterRepo.findByPriorityIgnoreCase(priority).orElseThrow(()->new ResourceNotFoundException("Priority","Not Found With : ",priority));
		master.setCompany(priorityDto.getCompany());
		master.setPriority(priorityDto.getPriority());
		master.setSeverity(priorityDto.getSeverity());
		PrioritySeverityMaster save = this.masterRepo.save(master);
		PrioritySeverityMasterDto map = this.mapper.map(save,PrioritySeverityMasterDto.class);
		return map;
	}
	@Override
	public PrioritySeverityMasterDto getPrioritySeverityMasterByPriority(String priority) {
		Optional<PrioritySeverityMaster> findByPriorityIgnoreCase = this.masterRepo.findByPriorityIgnoreCase(priority);
		System.out.println("SSSSSSSSSSSSSSSSS : "+findByPriorityIgnoreCase);
		return this.mapper.map(findByPriorityIgnoreCase, PrioritySeverityMasterDto.class);
	}
	
	@Override
	public List<PrioritySeverityMasterDto> getAllPrioritySeverityMasters() {
		List<PrioritySeverityMaster> findAll = this.masterRepo.findAll();
	 return	findAll.stream().map(element->this.mapper.map(element, PrioritySeverityMasterDto.class)).collect(Collectors.toList());
	}

	@Override
	public void deletePrioritySeverityMaster(String userId) {
		this.masterRepo.findByPriorityIgnoreCase(userId).orElseThrow(()->new ResourceNotFoundException("Priority"," Not found with :",userId));
	}	
	
}
