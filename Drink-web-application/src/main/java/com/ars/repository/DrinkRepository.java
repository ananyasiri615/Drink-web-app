package com.ars.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ars.entity.Drink;

public interface DrinkRepository extends CrudRepository<Drink, Integer>{

	List<Drink> findByName(String name);
	
}