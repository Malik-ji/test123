package com.blogpost.blog.services;

import java.util.List;

import com.blogpost.blog.entities.CategoryMaster;

public interface CategoryMasterService {

    // Create a new CategoryMaster
    CategoryMaster createCategoryMaster(CategoryMaster categoryMaster);

    // Get all CategoryMasters
    List<CategoryMaster> getAllCategoryMasters();

    // Get a specific CategoryMaster by srNo
    CategoryMaster getCategoryMasterBySrNo(Long srNo);

    // Update a CategoryMaster
    CategoryMaster updateCategoryMaster(Long srNo, CategoryMaster categoryMasterDetails);

    // Delete a CategoryMaster
    void deleteCategoryMaster(Long srNo);
}
