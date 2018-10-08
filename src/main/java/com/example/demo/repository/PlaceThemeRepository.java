package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Place;
import com.example.demo.entities.Placetheme;
import com.example.demo.entities.Theme;

public interface PlaceThemeRepository extends CrudRepository<Placetheme,Long>{
	
	public List<Placetheme> findByPlace(Place place);
	
	public List<Placetheme> findByTheme(Theme theme);

}
