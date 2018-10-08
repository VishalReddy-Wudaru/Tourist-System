package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Place;
import com.example.demo.entities.Placetheme;
import com.example.demo.repository.PlaceThemeRepository;

@Service
public class PlaceThemeService {

	@Autowired
	private PlaceThemeRepository ptr;
	
	@Autowired
	private PlaceService ps;
	
	@Autowired
	private ThemeService ts;
	
	public Iterable<Placetheme> getAllPlaceThemes()
	{
		return ptr.findAll();
	}
	
	public List<Placetheme> getPlaceThemeByPlace(String name)
	{
		List <Placetheme> placetheme= new ArrayList<>();
		ptr.findByPlace(ps.getPlace(name)).forEach(placetheme::add);
		return placetheme;
	}
	
	public List<Placetheme> getPlaceThemeByTheme(String name)
	{
		List <Placetheme> placetheme= new ArrayList<>();
		ptr.findByTheme(ts.getTheme(name)).forEach(placetheme::add);
		return placetheme;
	}
	
	public List<Place> getPlacesByOneoftheThemes(Set<String> name)
	{
		List <Placetheme> placetheme= new ArrayList<>();
		List <String> al= new ArrayList<>();
		for(String tmp: name)
		{
			ptr.findByTheme(ts.getTheme(tmp)).forEach(placetheme::add);
			for(Placetheme temp:placetheme)
			{
				al.add(temp.getPlace().getName());
			}
		}
		Set<String> hs = new HashSet<>();
		hs.addAll(al);
		al.clear();
		al.addAll(hs);
		List<Place> places=new ArrayList<>();
		for(String temp: al)
		{
			places.add(ps.getPlace(temp));
		}
		return places;
	}
	
	public List<Place> getPlacesByAllThemes(Set<String> name)
	{
		List<Place>places=new ArrayList<>();
		List <Placetheme> placetheme= new ArrayList<>();
		List <String> al1= new ArrayList<>();
		List <String> al2= new ArrayList<>();
		for(String tmp:name)
		{
			ptr.findByTheme(ts.getTheme(tmp)).forEach(placetheme::add);
			for(Placetheme temp:placetheme)
			{
				al1.add(temp.getPlace().getName());
			}
			break;
		}
		for(String tmp:name)
		{
			List <Placetheme> placetheme2= new ArrayList<>();
			ptr.findByTheme(ts.getTheme(tmp)).forEach(placetheme2::add);
			for(Placetheme temp:placetheme2)
			{
				al2.add(temp.getPlace().getName());
			}
			al1.retainAll(al2);
		}
		for(String temp: al1)
		{
			places.add(ps.getPlace(temp));
		}
		return places;
	}
	
}
