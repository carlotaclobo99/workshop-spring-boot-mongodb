package com.mcarlotalobo.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcarlotalobo.workshopmongo.domain.User;
import com.mcarlotalobo.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	//Esta anotação instancia automaticamente 
	//o objecto UserRepository:
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
}
