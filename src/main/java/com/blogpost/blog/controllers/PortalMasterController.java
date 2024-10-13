package com.blogpost.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.blogpost.blog.entities.PortalMaster;
import com.blogpost.blog.payloads.ApiResponse;
import com.blogpost.blog.services.PortalMasterService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/portal")
public class PortalMasterController {

    @Autowired
    private PortalMasterService portalMasterService;

    // Create a new PortalMaster
    @PostMapping("/")
    public ResponseEntity<PortalMaster> createPortalMaster(@RequestBody PortalMaster portalMaster) {
        PortalMaster createdPortalMaster = portalMasterService.createPortalMaster(portalMaster);
        return new ResponseEntity<>(createdPortalMaster, HttpStatus.CREATED);
    }

    // Get all PortalMasters
    @GetMapping("/getAll")
    public ResponseEntity<List<PortalMaster>> getAllPortalMasters() {
        List<PortalMaster> portalMasters = portalMasterService.getAllPortalMasters();
        return new ResponseEntity<>(portalMasters, HttpStatus.OK);
    }

    // Get a specific PortalMaster by srNo
    @GetMapping("/getBySrNo/{srNo}")
    public ResponseEntity<PortalMaster> getPortalMasterBySrNo(@PathVariable Long srNo) {
    	PortalMaster portalMaster = portalMasterService.getPortalMasterBySrNo(srNo);
        return  null;
//                .orElseGet(() -> new ResponseEntity<>(new A,HttpStatus.NOT_FOUND));
    }
    
  
    @PatchMapping("/update/{srNo}")
    public ResponseEntity<PortalMaster> updatePortalMaster(@PathVariable Long srNo,
            @RequestBody PortalMaster portalMasterDetails) {
        PortalMaster updatedPortalMaster = portalMasterService.updatePortalMaster(srNo, portalMasterDetails);
        return new ResponseEntity<>(updatedPortalMaster, HttpStatus.OK);
    }

    // Delete a PortalMaster by srNo
    @DeleteMapping("/delete/{srNo}")
    public ResponseEntity<ApiResponse> deletePortalMaster(@PathVariable Long srNo) {
        portalMasterService.deletePortalMaster(srNo);
        return new ResponseEntity<>(new ApiResponse("PortalMaster Deleted Successfully", true), HttpStatus.OK);
    }
}
