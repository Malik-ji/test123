package com.blogpost.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.blogpost.blog.entities.SlaTrackerMaster;
import com.blogpost.blog.payloads.ApiResponse;
import com.blogpost.blog.services.SlaTrackerMasterService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/slatracker")
public class SlaTrackerMasterController {

    @Autowired
    private SlaTrackerMasterService slaTrackerMasterService;

    // Get all SLA trackers
    @GetMapping
    public ResponseEntity<List<SlaTrackerMaster>> getAllSlaTrackers() {
        List<SlaTrackerMaster> slaTrackers = slaTrackerMasterService.getAllSlaTrackers();
        return ResponseEntity.ok(slaTrackers);
    }

    // Create a new SLA tracker
    @PostMapping
    public ResponseEntity<SlaTrackerMaster> createSlaTracker(@RequestBody SlaTrackerMaster slaTrackerMaster) {
        SlaTrackerMaster createdSlaTracker = slaTrackerMasterService.createSlaTracker(slaTrackerMaster);
        return ResponseEntity.ok(createdSlaTracker);
    }

    // Get an SLA tracker by ID
    @GetMapping("/{id}")
    public ResponseEntity<SlaTrackerMaster> getSlaTrackerById(@PathVariable Long id) {
        SlaTrackerMaster slaTracker = slaTrackerMasterService.getSlaTrackerById(id);
        return ResponseEntity.ok(slaTracker);
    }

    // Update an SLA tracker
    @PatchMapping("/{id}")
    public ResponseEntity<SlaTrackerMaster> updateSlaTracker(
            @PathVariable Long id, @RequestBody SlaTrackerMaster slaTrackerDetails) {
        SlaTrackerMaster updatedSlaTracker = slaTrackerMasterService.updateSlaTracker(id, slaTrackerDetails);
        return ResponseEntity.ok(updatedSlaTracker);
    }

    // Delete an SLA tracker
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteSlaTracker(@PathVariable Long id) {
        slaTrackerMasterService.deleteSlaTracker(id);
        return ResponseEntity.ok(new ApiResponse("SLA Tracker deleted successfully", true));
    }
}
