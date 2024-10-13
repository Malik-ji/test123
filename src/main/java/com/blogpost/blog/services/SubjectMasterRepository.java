package com.blogpost.blog.services;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogpost.blog.entities.SubjectMaster;

@Repository
public interface SubjectMasterRepository extends JpaRepository<SubjectMaster, Long> {
}