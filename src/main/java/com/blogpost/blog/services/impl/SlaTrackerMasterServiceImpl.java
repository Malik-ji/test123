package com.blogpost.blog.services.impl;

import com.blogpost.blog.entities.SlaTrackerMaster;
import com.blogpost.blog.repositories.SlaTrackerMasterRepository;
import com.blogpost.blog.services.SlaTrackerMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SlaTrackerMasterServiceImpl implements SlaTrackerMasterService {

    @Autowired
    private SlaTrackerMasterRepository slaTrackerMasterRepository;

    @Override
    public List<SlaTrackerMaster> getAllSlaTrackers() {
        return slaTrackerMasterRepository.findAll();
    }

    @Override
    public SlaTrackerMaster createSlaTracker(SlaTrackerMaster slaTrackerMaster) {
        return slaTrackerMasterRepository.save(slaTrackerMaster);
    }

    @Override
    public SlaTrackerMaster getSlaTrackerById(Long id) {
        Optional<SlaTrackerMaster> slaTrackerOpt = slaTrackerMasterRepository.findById(id);
        return slaTrackerOpt.orElse(null);
    }

    @Override
    public SlaTrackerMaster updateSlaTracker(Long id, SlaTrackerMaster slaTrackerDetails) {
        Optional<SlaTrackerMaster> slaTrackerOpt = slaTrackerMasterRepository.findById(id);
        if (slaTrackerOpt.isPresent()) {
            SlaTrackerMaster slaTracker = slaTrackerOpt.get();
            slaTracker.setCompany(slaTrackerDetails.getCompany());
            slaTracker.setPriority(slaTrackerDetails.getPriority());
            slaTracker.setSeverity(slaTrackerDetails.getSeverity());
            slaTracker.setSlaDuration(slaTrackerDetails.getSlaDuration());
            return slaTrackerMasterRepository.save(slaTracker);
        }
        return null;
    }

    @Override
    public void deleteSlaTracker(Long id) {
        slaTrackerMasterRepository.deleteById(id);
    }
}
