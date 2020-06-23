package com.practice.crud.service;

import com.practice.crud.entity.Movie;

public interface MovieService {
	public Movie addMovies(Movie movie);

	public Iterable<Movie> readMovies();

	public void deleteMoviebyId(int movieId);

	public Movie editProductById(Movie movie, int movieId);

	public Movie readMoviesById(int movieId);
}


// jembatan