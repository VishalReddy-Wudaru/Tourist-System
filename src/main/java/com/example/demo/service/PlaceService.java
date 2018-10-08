package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Place;
import com.example.demo.repository.PlaceRepository;

@Service
public class PlaceService {
	@Autowired
	private PlaceRepository pr;
	
	public Iterable<Place> getAllPlaces()
	{
		return pr.findAll();
	}
	
	public Place getPlace(String place)
	{
		return pr.findByName(place);
	}

}
