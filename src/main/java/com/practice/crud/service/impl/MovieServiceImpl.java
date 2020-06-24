package com.practice.crud.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.crud.dao.CategoryRepo;
import com.practice.crud.dao.CharacterRepo;
import com.practice.crud.dao.MovieRepo;
import com.practice.crud.entity.Movie;
import com.practice.crud.entity.Category;
import com.practice.crud.entity.Character;
import com.practice.crud.service.MovieService;

@Service
// jangan lupa di dedclare dia implemen dari mana
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieRepo movieRepo;
	
	@Autowired
	private CharacterRepo characterRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
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
//		movieRepo.deleteById(movieId);// cuma data tanpa relasi
		// cari movie berdasarkan id
		Movie findMovie = movieRepo.findById(movieId).get();
		//
		findMovie.setCategory(null);
//		findMovie.setCharacter(null);
		movieRepo.save(findMovie);
		movieRepo.deleteById(movieId);
		
	}

	@Override
	public Movie editMovieById(Movie movie, int movieId) {
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

	@Override
	public Movie addCharacterToMovie(int movieId, int charId) {
		Movie findMovie = movieRepo.findById(movieId).get();
		Character findCharacter = characterRepo.findById(charId).get();
		
		findMovie.setCharacter(findCharacter);
		return movieRepo.save(findMovie);
	}
	
	@Override
	public Movie addCategoryToMovie(int movieId, int cateId) {
//		Movie findMovie = movieRepo.findById(movieId).get();
//		Category findCategory = categoryRepo.findById(cateId).get();
//		
//		findMovie.getCategory().add(findCategory);
////		findMovie.setCategory();
//		return movieRepo.save(findMovie);
		
		Movie findMovie = movieRepo.findById(movieId).get();
		Category findCategory = categoryRepo.findById(cateId).get();
		
		if (findMovie.getCategory().contains(findCategory)) {
			throw new RuntimeException("This category already declared at this movie!");
		}
			
		findMovie.getCategory().add(findCategory);
		return movieRepo.save(findMovie);
	}

	@Override
	public Movie deleteCategoryInMovie(int movieId, int cateId) {
		Movie findMovie = movieRepo.findById(movieId).get();
		Category findCategory = categoryRepo.findById(cateId).get();

		findMovie.getCategory().remove(findCategory);
		return movieRepo.save(findMovie);
	}
}
