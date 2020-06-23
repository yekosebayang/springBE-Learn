package com.practice.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.crud.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
