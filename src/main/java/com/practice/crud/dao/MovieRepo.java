package com.practice.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.crud.entity.Movie;

public interface MovieRepo extends JpaRepository<Movie, Integer> {

}
