package com.blogpost.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.blogpost.blog.entities.CategoryMaster;
import com.blogpost.blog.payloads.ApiResponse;
import com.blogpost.blog.services.CategoryMasterService;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryMasterController {

    @Autowired
    private CategoryMasterService categoryMasterService;

    // Create a new CategoryMaster
    @PostMapping("/")
    public ResponseEntity<CategoryMaster> createCategoryMaster(@RequestBody CategoryMaster categoryMaster) {
        CategoryMaster createdCategoryMaster = categoryMasterService.createCategoryMaster(categoryMaster);
        return new ResponseEntity<>(createdCategoryMaster, HttpStatus.CREATED);
    }

    // Get all CategoryMasters
    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryMaster>> getAllCategoryMasters() {
        List<CategoryMaster> categoryMasters = categoryMasterService.getAllCategoryMasters();
        return new ResponseEntity<>(categoryMasters, HttpStatus.OK);
    }

    // Get a specific CategoryMaster by srNo
    @GetMapping("/getBySrNo/{srNo}")
    public ResponseEntity<CategoryMaster> getCategoryMasterBySrNo(@PathVariable Long srNo) {
        CategoryMaster categoryMaster = categoryMasterService.getCategoryMasterBySrNo(srNo);
        return new ResponseEntity<>(categoryMaster, HttpStatus.OK);
    }

    // Update a CategoryMaster by srNo
    @PatchMapping("/update/{srNo}")
    public ResponseEntity<CategoryMaster> updateCategoryMaster(@PathVariable Long srNo,
                                                               @RequestBody CategoryMaster categoryMasterDetails) {
        CategoryMaster updatedCategoryMaster = categoryMasterService.updateCategoryMaster(srNo, categoryMasterDetails);
        return new ResponseEntity<>(updatedCategoryMaster, HttpStatus.OK);
    }
 
    // Delete a CategoryMaster by srNo
    @DeleteMapping("/delete/{srNo}")
    public ResponseEntity<ApiResponse> deleteCategoryMaster(@PathVariable Long srNo) {
        categoryMasterService.deleteCategoryMaster(srNo);
        return new ResponseEntity<>(new ApiResponse("CategoryMaster Deleted Successfully", true), HttpStatus.OK);
    }
}
