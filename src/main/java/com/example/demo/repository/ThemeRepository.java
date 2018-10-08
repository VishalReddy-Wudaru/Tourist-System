package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;


import com.example.demo.entities.Theme;

public interface ThemeRepository extends CrudRepository<Theme,Long> {
	
	public Theme findByTheme(String theme);

}
