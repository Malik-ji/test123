package com.blogpost.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogpost.blog.entities.PortalMaster;

public interface PortalMasterRepository extends JpaRepository<PortalMaster, Long> {
    // You can define custom queries here if needed
}