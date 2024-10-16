package com.blogpost.blog.repositories;

import com.blogpost.blog.entities.AutoAssignConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoAssignConfigRepository extends JpaRepository<AutoAssignConfig, Integer> {
}
