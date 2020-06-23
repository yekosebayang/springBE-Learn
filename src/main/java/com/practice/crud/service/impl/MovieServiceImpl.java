package com.practice.crud.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.crud.dao.MovieRepo;
import com.practice.crud.entity.Movie;
import com.practice.crud.service.MovieService;

@Service
// jangan lupa di dedclare dia implemen dari mana
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieRepo movieRepo;
	
	@Override
	public Movie addMovies(Movie movie) {
		movie.setId(0);
		return movieRepo.save(movie);
	}

	@Override
	public Iterable<Movie> readMovies() {
		return movieRepo.findAll();
	}

	@Override
	public void deleteMoviebyId(int movieId) {
		Optional<Movie> findMovie = movieRepo.findById(movieId);
		if (findMovie.toString() == "Optional.empty")
			throw new RuntimeException("Id not exist, ID: " + movieId);
		movieRepo.deleteById(movieId);
	}

	@Override
	public Movie editProductById(Movie movie, int movieId) {
		movie.setId(movieId);
		Optional<Movie> findMovie = movieRepo.findById(movieId);
		if (findMovie.toString() == "Optional.empty")
			throw new RuntimeException("Id not exist, ID: " + movieId);
		return movieRepo.save(movie);
	}

	@Override
	public Movie readMoviesById(int movieId) {		
		Movie findMovie = movieRepo.findById(movieId).get();
		if (findMovie == null)
			throw new RuntimeException("Id not exist, ID: " + movieId);
		return findMovie;
	}
}
