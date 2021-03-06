package com.practice.crud.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "categories")
public class Category {
	
	@Id //karena dia ID
	@GeneratedValue(strategy = GenerationType.IDENTITY) //??
	private int id;
	
	private String name;	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = {
			CascadeType.DETACH, 
			CascadeType.PERSIST,
			CascadeType.REFRESH})
	@JoinTable(name = "category_movie", 
	joinColumns = @JoinColumn(name = "category_id"),
	inverseJoinColumns = @JoinColumn(name = "movie_id"))
	@JsonIgnore
	private List<Movie> movie;
	
	public List<Movie> getMovie() {
		return movie;
	}

	public void setMovie(List<Movie> movie) {
		this.movie = movie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
