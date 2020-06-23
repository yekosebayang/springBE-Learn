package com.practice.crud.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.crud.dao.CategoryRepo;
import com.practice.crud.entity.Category;
import com.practice.crud.entity.Movie;
import com.practice.crud.service.CategoryService;

@Service
// jangan lupa di dedclare dia implemen dari mana
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public Category addCategory(Category category) {
		category.setId(0);
		return categoryRepo.save(category);
	}
	
	@Override
	public Iterable<Category> readCategory() {
		return categoryRepo.findAll();
	}

	@Override
	public void deleteCategoryById(int categoryId) {
		Optional<Category> findCategory = categoryRepo.findById(categoryId);
		if (findCategory.toString() == "Optional.empty")
			throw new RuntimeException("Id not exist, ID: " + categoryId);
		categoryRepo.deleteById(categoryId);
	}

	@Override
	public Category editCategoryById(Category category, int categoryId) {
		category.setId(categoryId);
		Optional<Category> findCategory = categoryRepo.findById(categoryId);
		if (findCategory.toString() == "Optional.empty")
			throw new RuntimeException("Id not exist, ID: " + categoryId);
		return categoryRepo.save(category);
	}
}
