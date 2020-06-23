package com.practice.crud.service;

import com.practice.crud.entity.Category;

public interface CategoryService {
	public Category addCategory(Category category);

	public Iterable<Category> readCategory();

	public void deleteCategoryById(int categoryId);

	public Category editCategoryById(Category category, int categoryId);
}


// jembatan