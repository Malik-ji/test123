package com.blogpost.blog.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogpost.blog.entities.PortalMaster;
import com.blogpost.blog.exceptions.ResourceNotFoundException;
import com.blogpost.blog.repositories.PortalMasterRepository;
import com.blogpost.blog.services.PortalMasterService;

import java.util.List;
import java.util.Optional;

@Service
public class PortalMasterServiceImpl implements PortalMasterService {

    @Autowired
    private PortalMasterRepository portalMasterRepository;

    // Create a new PortalMaster record
    @Override
    public PortalMaster createPortalMaster(PortalMaster portalMaster) {
        // Logic to save the new PortalMaster record in the database
        return portalMasterRepository.save(portalMaster);
    }

    // Get all PortalMaster records
    @Override
    public List<PortalMaster> getAllPortalMasters() {
        // Logic to fetch all PortalMaster records from the database
        return portalMasterRepository.findAll();
    }

    // Get PortalMaster by srNo
    @Override
    public PortalMaster getPortalMasterBySrNo(Long srNo) {
        // Logic to fetch a PortalMaster record by its srNo
        return portalMasterRepository.findById(srNo).orElseThrow(() -> new ResourceNotFoundException("Request Mode", " id :", srNo
        		));
    }

    // Update a PortalMaster record
    @Override
    public PortalMaster updatePortalMaster(Long srNo, PortalMaster portalMasterDetails) {
        // Fetch the existing PortalMaster record
        PortalMaster existingPortalMaster = portalMasterRepository.findById(srNo)
                .orElseThrow(() -> new RuntimeException("PortalMaster not found with srNo: " + srNo));
        
        // Update the details
        existingPortalMaster.setCompany(portalMasterDetails.getCompany());
        existingPortalMaster.setRequestType(portalMasterDetails.getRequestType());
        
        // Save the updated record back to the database
        return portalMasterRepository.save(existingPortalMaster);
    }

    // Delete a PortalMaster record by srNo
    @Override
    public void deletePortalMaster(Long srNo) {
        // Logic to delete a PortalMaster record by its srNo
        portalMasterRepository.deleteById(srNo);
    }
}
