package com.blogpost.blog.services;



import java.util.List;

import com.blogpost.blog.entities.SubjectMaster;

public interface SubjectMasterService {
    List<SubjectMaster> getAllSubjects();
    SubjectMaster createSubject(SubjectMaster subjectMaster);
    SubjectMaster getSubjectById(Long id);
    SubjectMaster updateSubject(Long id, SubjectMaster subjectDetails);
    void deleteSubject(Long id);
}
