package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImp implements UserDetailsService{
	
	@Autowired
	UserRepository userRepositoy;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		//System.out.println(username+1);
		//long a = Long.parseLong(username, 10);
		//System.out.println(a+1);
		//User user=userRepositoy.findOne(a);
		User user=userRepositoy.findByUsername(username);
		return new UserDetailsImp(user);
	}
	

}
