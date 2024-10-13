package com.blogpost.blog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogpost.blog.entities.PortalMaster;

import java.util.List;
import java.util.Optional;

@Service
public interface PortalMasterService {

	 PortalMaster createPortalMaster(PortalMaster portalMaster);

	    // Get all PortalMaster records
	    List<PortalMaster> getAllPortalMasters();

	    // Get PortalMaster by srNo
	    PortalMaster getPortalMasterBySrNo(Long srNo);

	    // Update a PortalMaster record
	    PortalMaster updatePortalMaster(Long srNo, PortalMaster portalMasterDetails);

	    // Delete a PortalMaster record by srNo
	    void deletePortalMaster(Long srNo);
}
