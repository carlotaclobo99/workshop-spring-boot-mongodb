package com.mcarlotalobo.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mcarlotalobo.workshopmongo.domain.Post;
import com.mcarlotalobo.workshopmongo.domain.User;
import com.mcarlotalobo.workshopmongo.dto.AuthorDTO;
import com.mcarlotalobo.workshopmongo.repository.PostRepository;
import com.mcarlotalobo.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		userRepository.deleteAll();
		postRepository.deleteAll();
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null,sdf.parse("12/11/1999"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null,sdf.parse("12/07/2015"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		postRepository.saveAll(Arrays.asList(post1, post2));

	}

}
