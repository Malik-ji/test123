package com.blogpost.blog.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogpost.blog.entities.SubjectMaster;
import com.blogpost.blog.services.SubjectMasterRepository;
import com.blogpost.blog.services.SubjectMasterService;

import java.util.List;
import java.util.Optional;
 
@Service
public class SubjectMasterServiceImpl implements SubjectMasterService {

    @Autowired
    private SubjectMasterRepository subjectMasterRepository;

    @Override
    public List<SubjectMaster> getAllSubjects() {
        return subjectMasterRepository.findAll();
    }

    @Override
    public SubjectMaster createSubject(SubjectMaster subjectMaster) {
        return subjectMasterRepository.save(subjectMaster);
    }

    @Override
    public SubjectMaster getSubjectById(Long id) {
        Optional<SubjectMaster> optionalSubject = subjectMasterRepository.findById(id);
        return optionalSubject.orElse(null); // Return null if not found
    }

    @Override
    public SubjectMaster updateSubject(Long id, SubjectMaster subjectDetails) {
        return subjectMasterRepository.findById(id).map(subject -> {
            subject.setCompany(subjectDetails.getCompany());
            subject.setCategory(subjectDetails.getCategory());
            subject.setSubCategory1(subjectDetails.getSubCategory1());
            subject.setSubCategory2(subjectDetails.getSubCategory2());
            subject.setPriority(subjectDetails.getPriority());
            subject.setSeverity(subjectDetails.getSeverity());
            return subjectMasterRepository.save(subject);
        }).orElse(null); // Return null if not found
    }

    @Override
    public void deleteSubject(Long id) {
        subjectMasterRepository.findById(id).ifPresent(subjectMasterRepository::delete);
    }
}

