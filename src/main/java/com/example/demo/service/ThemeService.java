package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entities.Theme;

import com.example.demo.repository.ThemeRepository;

@Service
public class ThemeService {
	@Autowired
	private ThemeRepository tr;
	
	public Iterable<Theme> getAllThemes()
	{
		return tr.findAll();
	}
	
	public Theme getTheme(String theme)
	{
		return tr.findByTheme(theme);
	}

}
