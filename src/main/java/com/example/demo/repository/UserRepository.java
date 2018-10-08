package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.User;


public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByUsername(String username);
}
