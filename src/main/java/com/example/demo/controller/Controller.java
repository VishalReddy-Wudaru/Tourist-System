package com.example.demo.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Place;
import com.example.demo.entities.Placetheme;
import com.example.demo.entities.Theme;
import com.example.demo.service.PlaceService;
import com.example.demo.service.PlaceThemeService;
import com.example.demo.service.ThemeService;

@RestController
public class Controller {
	@Autowired
	private PlaceService ps;
	
	@Autowired
	private ThemeService ts;
	
	@Autowired
	private PlaceThemeService pts;
	
	@RequestMapping("/places")
	public Iterable<Place> getAllPlaces()
	{
		return ps.getAllPlaces();
	}
	
	@RequestMapping("/place/{name}")
	public Place getPlace(@PathVariable String name)
	{
		return ps.getPlace(name);
	}
	
	@RequestMapping("/themes")
	public Iterable<Theme> getAllThemes()
	{
		return ts.getAllThemes();
	}
	
	@RequestMapping("/theme/{name}")
	public Theme getTheme(@PathVariable String name)
	{
		return ts.getTheme(name);
	}
	
	@RequestMapping("/placethemes")
	public Iterable<Placetheme> getAllPlaceThemes()
	{
		return pts.getAllPlaceThemes();
	}
	
	@RequestMapping("/placethemebyplace/{name}")
	public List<Placetheme> getPlaceThemeByPlace(@PathVariable String name)
	{
		return pts.getPlaceThemeByPlace(name);
	}
	
	@RequestMapping("/placethemebytheme/{name}")
	public List<Placetheme> getPlaceThemeByTheme(@PathVariable String name)
	{
		return pts.getPlaceThemeByTheme(name);
	}
	
	@RequestMapping("/placesbyoneofthethemes/{name1}/{name2}")
	public List<Place> getPlaceThemeByOneoftheThemes(@PathVariable String name1,@PathVariable String name2)
	{
		Set<String> name = new HashSet<>();
		name.add(name1);
		name.add(name2);
		
		return pts.getPlacesByOneoftheThemes(name);
	}
	
	@RequestMapping("/placesbyallthemes/{name1}/{name2}")
	public List<Place> getPlaceThemeByAllThemes(@PathVariable String name1,@PathVariable String name2)
	{
		Set<String> name = new HashSet<>();
		name.add(name1);
		name.add(name2);
		return pts.getPlacesByAllThemes(name);
	}

}
