package com.practice.crud.service;

import com.practice.crud.entity.Character;

public interface CharacterService {
	public Character addCharacter(Character character);

	public Iterable<Character> readCharacter();

	public void deleteCharacterById(int characterId);

	public Character editCharacterById(Character character, int characterId);
}


// jembatan