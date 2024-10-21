package com.blogpost.blog.controllers;



import com.blogpost.blog.entities.AutoAssignConfig;
import com.blogpost.blog.exceptions.ResourceNotFoundException;
import com.blogpost.blog.payloads.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autoassignconfig")
@CrossOrigin("*")
public class AutoAssignConfigController {

    @Autowired
    private com.blogpost.blog.repositories.AutoAssignConfigRepository autoAssignConfigRepository;
    
    // CREATE
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createConfig(@RequestBody AutoAssignConfig autoAssignConfig) {
        autoAssignConfigRepository.save(autoAssignConfig);
        return new ResponseEntity<>(new ApiResponse("AutoAssignConfig created successfully", true), HttpStatus.CREATED);
    }

    // READ ALL
    @GetMapping("/all")
    public ResponseEntity<List<AutoAssignConfig>> getAllConfigs() {
        List<AutoAssignConfig> configs = autoAssignConfigRepository.findAll();
        return new ResponseEntity<>(configs, HttpStatus.OK);
    }

    // READ ONE BY ID
    @GetMapping("/{srNo}")
    public ResponseEntity<AutoAssignConfig> getConfigById(@PathVariable int srNo) {
        AutoAssignConfig config = autoAssignConfigRepository.findById(srNo)
                .orElseThrow(() -> new ResourceNotFoundException("AutoAssignConfig", "SrNo", srNo));
        return new ResponseEntity<>(config, HttpStatus.OK);
    }

    // UPDATE
    @PutMapping("/update/{srNo}")
    public ResponseEntity<ApiResponse> updateConfig(@PathVariable int srNo, @RequestBody AutoAssignConfig newConfig) {
        AutoAssignConfig existingConfig = autoAssignConfigRepository.findById(srNo)
                .orElseThrow(() -> new ResourceNotFoundException("AutoAssignConfig", "SrNo", srNo));

        existingConfig.setCategory(newConfig.getCategory());
        existingConfig.setPriority(newConfig.getPriority());
        existingConfig.setAssignTime(newConfig.getAssignTime());
        existingConfig.setCompany(newConfig.getCompany());
        existingConfig.setSeverity(newConfig.getSeverity());
        existingConfig.setAssignTo(newConfig.getAssignTo());
        existingConfig.setGroupName(newConfig.getGroupName());

        autoAssignConfigRepository.save(existingConfig);
        return new ResponseEntity<>(new ApiResponse("AutoAssignConfig updated successfully", true), HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("/delete/{srNo}")
    public ResponseEntity<ApiResponse> deleteConfig(@PathVariable int srNo) {
        AutoAssignConfig config = autoAssignConfigRepository.findById(srNo)
                .orElseThrow(() -> new ResourceNotFoundException("AutoAssignConfig", "SrNo", srNo));

        autoAssignConfigRepository.delete(config);
        return new ResponseEntity<>(new ApiResponse("AutoAssignConfig deleted successfully", true), HttpStatus.OK);
    }
}
