package com.practice.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.crud.entity.Category;
import com.practice.crud.service.CategoryService;

@RestController // dia kontroller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping //dia post command
	@RequestMapping("/new")
//	publik dari movies, namanya addMovies minta parameter untuk Movies dinamain movies
	public Category addCategory(@RequestBody Category category) {
		return categoryService.addCategory(category); 	
	}
	
	@GetMapping
	public Iterable<Category> readCategory(){
		return categoryService.readCategory();
	}
	
	@PutMapping("/edit/{categoryId}")
	public Category editCategoryById(@RequestBody Category category, @PathVariable int categoryId) {
		return categoryService.editCategoryById(category, categoryId);
	}
	
	@DeleteMapping("{categoryId}")
	public void deleteCategoryById(@PathVariable int categoryId) {
		categoryService.deleteCategoryById(categoryId);
	}

}
