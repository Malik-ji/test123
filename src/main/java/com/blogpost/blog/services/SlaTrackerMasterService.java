package com.blogpost.blog.services;

import com.blogpost.blog.entities.SlaTrackerMaster;

import java.util.List;

public interface SlaTrackerMasterService {

    List<SlaTrackerMaster> getAllSlaTrackers();

    SlaTrackerMaster createSlaTracker(SlaTrackerMaster slaTrackerMaster);

    SlaTrackerMaster getSlaTrackerById(Long id);

    SlaTrackerMaster updateSlaTracker(Long id, SlaTrackerMaster slaTrackerDetails);

    void deleteSlaTracker(Long id);
}
