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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {
	
	@Id //karena dia ID
	@GeneratedValue(strategy = GenerationType.IDENTITY) // supaya dia unique dan PK
	private int id;
	
	private String name;
	private String year;
	private String description;
	
	@ManyToOne(cascade = { 
			CascadeType.DETACH, 
			CascadeType.MERGE, 
			CascadeType.PERSIST, 
			CascadeType.REFRESH})
	@JoinColumn(name = "character_id")
	private Character character;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = {
			CascadeType.DETACH, 
			CascadeType.PERSIST, 
			CascadeType.REFRESH})
	@JoinTable(name = "category_movie", 
	joinColumns = @JoinColumn(name = "movie_id"), 
	inverseJoinColumns = @JoinColumn(name = "category_id"))
	private List<Category> category;
	
	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDescription() {
		return description;
	}

	public void setDesc(String description) {
		this.description = description;
	}	
	
}
