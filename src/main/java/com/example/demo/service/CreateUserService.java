package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;

@Service
public class CreateUserService {
	@Autowired
	UserRepository ur;
	
	public void addUser(User user)
	{
		ur.save(user);
	}
	
	public long countOfUsers()
	{
		long i=0;
		for(User tmp:ur.findAll())
		{
			i++;
		}
		return i;
	}

}
