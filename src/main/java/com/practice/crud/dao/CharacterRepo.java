package com.practice.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.crud.entity.Character;

public interface CharacterRepo extends JpaRepository<Character, Integer> {

}
