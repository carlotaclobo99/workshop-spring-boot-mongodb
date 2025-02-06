package com.mcarlotalobo.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcarlotalobo.workshopmongo.domain.User;
import com.mcarlotalobo.workshopmongo.repository.UserRepository;
import com.mcarlotalobo.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	//Esta anotação instancia automaticamente 
	//o objecto UserRepository:
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	 
	public User findById(String id) { 
		Optional<User> obj = repo.findById(id); 
		 return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")); 
	}
}
