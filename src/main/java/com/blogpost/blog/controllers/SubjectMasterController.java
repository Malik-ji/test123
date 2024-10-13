package com.blogpost.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.blogpost.blog.entities.SubjectMaster;
import com.blogpost.blog.services.SubjectMasterService;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectMasterController {

    @Autowired
    private SubjectMasterService subjectMasterService;

    // Get all subjects
    @GetMapping
    public List<SubjectMaster> getAllSubjects() {
        return subjectMasterService.getAllSubjects();
    }

    // Create a new subject
    @PostMapping
    public SubjectMaster createSubject(@RequestBody SubjectMaster subjectMaster) {
        return subjectMasterService.createSubject(subjectMaster);
    }

    // Get a subject by ID
    @GetMapping("/{id}")
    public ResponseEntity<SubjectMaster> getSubjectById(@PathVariable Long id) {
        SubjectMaster subject = subjectMasterService.getSubjectById(id);
        return subject != null ? ResponseEntity.ok(subject) : ResponseEntity.notFound().build();
    }

    // Update a subject
    @PatchMapping("/{id}")
    public ResponseEntity<SubjectMaster> updateSubject(@PathVariable Long id, @RequestBody SubjectMaster subjectDetails) {
        SubjectMaster updatedSubject = subjectMasterService.updateSubject(id, subjectDetails);
        return updatedSubject != null ? ResponseEntity.ok(updatedSubject) : ResponseEntity.notFound().build();
    }

    // Delete a subject
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable Long id) {
        subjectMasterService.deleteSubject(id);
        return ResponseEntity.noContent().build();
    }
}
