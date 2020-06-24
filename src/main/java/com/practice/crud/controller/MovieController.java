package com.practice.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.crud.entity.Movie;
import com.practice.crud.service.MovieService;

@RestController // dia kontroller
@RequestMapping("/movies")
@CrossOrigin
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@PostMapping //dia post command
	@RequestMapping("/new")
//	publik dari movies, namanya addMovies minta parameter untuk Movies dinamain movies
	public Movie addMovies(@RequestBody Movie movie) {
		return movieService.addMovies(movie); 	
	}
	
	@GetMapping
	public Iterable<Movie> readMovies(){
		return movieService.readMovies();
	}
	
	@GetMapping("/{movieId}")
	public Movie readMoviesById(@PathVariable int movieId){
		return movieService.readMoviesById(movieId);
	}
	
	@PutMapping("/edit/{movieId}")
	public Movie editMovieById(@RequestBody Movie movie, @PathVariable int movieId) {
		return movieService.editMovieById(movie, movieId);
	}
	
	@DeleteMapping("/{movieId}")
	public void deleteMoviebyId(@PathVariable int movieId) {
		movieService.deleteMoviebyId(movieId);
	}
	
	@PostMapping("{movieId}/char/{charId}")
	public Movie addCharacterToMovie(@PathVariable int movieId, @PathVariable int charId) {
		return movieService.addCharacterToMovie(movieId, charId);
	}
	
	@PostMapping("{movieId}/cate/{cateId}")
	public Movie addCategoryToMovie(@PathVariable int movieId, @PathVariable int cateId) {
		return movieService.addCategoryToMovie(movieId, cateId);
	}
	
	@DeleteMapping("{movieId}/cate/{cateId}")
	public Movie deleteCategoryInMovie(@PathVariable int movieId, @PathVariable int cateId) {
		return movieService.deleteCategoryInMovie(movieId, cateId);
	}

}
