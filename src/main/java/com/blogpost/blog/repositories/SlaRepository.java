package com.blogpost.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogpost.blog.entities.Sla;

@Repository
public interface SlaRepository extends JpaRepository<Sla, String> {
    // Custom query methods can be added here if needed
}

