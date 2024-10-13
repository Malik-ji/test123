package com.blogpost.blog.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blogpost.blog.entities.CategoryMaster;
import com.blogpost.blog.exceptions.ResourceNotFoundException;
import com.blogpost.blog.repositories.CategoryMasterRepository;
import com.blogpost.blog.services.CategoryMasterService;

@Service
public class CategoryMasterServiceImpl implements CategoryMasterService {

	@Autowired
	private CategoryMasterRepository categoryMasterRepository;

	// Create a new CategoryMaster
	@Override
	public CategoryMaster createCategoryMaster(CategoryMaster categoryMaster) {
		return categoryMasterRepository.save(categoryMaster);
	}

	// Get all CategoryMasters
	@Override
	public List<CategoryMaster> getAllCategoryMasters() {
		return categoryMasterRepository.findAll();
	}

	// Get a specific CategoryMaster by srNo
	@Override
	public CategoryMaster getCategoryMasterBySrNo(Long srNo) {
		return categoryMasterRepository.findById(srNo)
				.orElseThrow(() -> new ResourceNotFoundException("CategoryMaster", "srNo", srNo));
	}

	// Update a CategoryMaster by srNo
	@Override
	public CategoryMaster updateCategoryMaster(Long srNo, CategoryMaster categoryMasterDetails) {
		CategoryMaster categoryMaster = getCategoryMasterBySrNo(srNo);

		categoryMaster.setCompany(categoryMasterDetails.getCompany());
		categoryMaster.setCategory(categoryMasterDetails.getCategory());
		categoryMaster.setSubCategory1(categoryMasterDetails.getSubCategory1());
		categoryMaster.setSubCategory2(categoryMasterDetails.getSubCategory2());

		return categoryMasterRepository.save(categoryMaster);
	}

	// Delete a CategoryMaster by srNo
	@Override
	public void deleteCategoryMaster(Long srNo) {
		CategoryMaster categoryMaster = getCategoryMasterBySrNo(srNo);
		categoryMasterRepository.delete(categoryMaster);
	}

}
