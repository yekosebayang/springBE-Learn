package com.practice.crud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.crud.dao.CategoryRepo;
import com.practice.crud.dao.MovieRepo;
import com.practice.crud.entity.Category;
import com.practice.crud.entity.Character;
import com.practice.crud.entity.Movie;
import com.practice.crud.service.CategoryService;

@Service
// jangan lupa di dedclare dia implemen dari mana
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private MovieRepo movieRepo;

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
		
		Category findCategory = categoryRepo.findById(categoryId).get();
		
		findCategory.getMovie().forEach(movie -> {
			movie.getCategory().remove(findCategory);
			movieRepo.save(movie);
		});
		
		findCategory.setMovie(null);
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
