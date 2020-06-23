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

import com.practice.crud.entity.Character;
import com.practice.crud.service.CharacterService;

@RestController // dia kontroller
@RequestMapping("/character")
public class CharacterController {
	
	@Autowired
	private CharacterService characterService;
	
	@PostMapping //dia post command
	@RequestMapping("/new")
//	publik dari movies, namanya addMovies minta parameter untuk Movies dinamain movies
	public Character addCharacter(@RequestBody Character character) {
		return characterService.addCharacter(character); 	
	}
	
	@GetMapping
	public Iterable<Character> readCharacter(){
		return characterService.readCharacter();
	}
	
	@PutMapping("/edit/{characterId}")
	public Character editCharacterById(@RequestBody Character character, @PathVariable int characterId) {
		return characterService.editCharacterById(character, characterId);
	}
	
	@DeleteMapping("{characterId}")
	public void deleteCharacterById(@PathVariable int characterId) {
		characterService.deleteCharacterById(characterId);
	}

}
