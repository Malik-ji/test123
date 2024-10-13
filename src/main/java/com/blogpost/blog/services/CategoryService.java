package com.blogpost.blog.services;

import java.util.List;


import com.blogpost.blog.payloads.CategoryDto;

public interface CategoryService {

	public CategoryDto createCategory(CategoryDto categoryDto);
	CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	void deleteCategory(Integer catId);
	CategoryDto getCategory(Integer id);
	List<CategoryDto> getAllCAtegory();
	
}
