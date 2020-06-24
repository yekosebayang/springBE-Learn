package com.practice.crud.service;

import com.practice.crud.entity.Movie;

public interface MovieService {
	public Movie addMovies(Movie movie);

	public Iterable<Movie> readMovies();

	public void deleteMoviebyId(int movieId);

	public Movie editMovieById(Movie movie, int movieId);

	public Movie readMoviesById(int movieId);

	public Movie addCharacterToMovie(int movieId, int charId);

	public Movie addCategoryToMovie(int movieId, int cateId);

	public Movie deleteCategoryInMovie(int movieId, int cateId);
}


// jembatan