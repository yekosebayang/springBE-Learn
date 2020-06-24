package com.practice.crud.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.crud.dao.CharacterRepo;
import com.practice.crud.dao.MovieRepo;
import com.practice.crud.entity.Character;
import com.practice.crud.entity.Movie;
import com.practice.crud.service.CharacterService;

@Service
// jangan lupa di dedclare dia implemen dari mana
public class CharacterServiceImpl implements CharacterService {
	@Autowired
	private CharacterRepo characterRepo;
	
	@Autowired
	private MovieRepo movieRepo;

	@Override
	public Character addCharacter(Character character) {
		character.setId(0);
		return characterRepo.save(character);
	}

	@Override
	public Iterable<Character> readCharacter() {
		return characterRepo.findAll();
	}

	@Override
	public void deleteCharacterById(int characterId) {
		Character findCharacter = characterRepo.findById(characterId).get();
		
		findCharacter.getMovie().forEach(movie -> {
			movie.setCharacter(null);
			movieRepo.save(movie);
		});
		
		findCharacter.setMovie(null);
		characterRepo.deleteById(characterId);
		
//		Optional<Character> findCharacter = characterRepo.findById(characterId);
//		if (findCharacter.toString() == "Optional.empty")
//			throw new RuntimeException("Id not exist, ID: " + characterId);
//		characterRepo.deleteById(characterId);
		
	}

	@Override
	public Character editCharacterById(Character character, int characterId) {
		character.setId(characterId);
		Optional<Character> findCharacter = characterRepo.findById(characterId);
		if (findCharacter.toString() == "Optional.empty")
			throw new RuntimeException("Id not exist, ID: " +characterId);
		return characterRepo.save(character);
	}
}
