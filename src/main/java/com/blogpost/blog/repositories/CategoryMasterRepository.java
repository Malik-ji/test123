package com.blogpost.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogpost.blog.entities.CategoryMaster;

public interface CategoryMasterRepository extends JpaRepository<CategoryMaster, Long> {
}
