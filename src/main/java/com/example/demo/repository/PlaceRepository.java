package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Place;

public interface PlaceRepository extends CrudRepository<Place,Long>{
	public Place findByName(String place);
}
