package com.teamSystem.usermanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.teamSystem.usermanager.entity.User;

import com.teamSystem.usermanager.repository.UserRepository;

@SpringBootApplication
public class UserManagerApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(UserManagerApplication.class, args);
	}
	@Autowired
	private UserRepository userRepository;
	@Override
	public void run(String...args) throws Exception {
		User user1 = new User("Paolo", "Desantis", "XXXXXX00X00X000X");
		userRepository.save(user1);
		User user2 = new User("Antonio", "Mariano", "XXXXXX11X11X111X");
		userRepository.save(user2);
		User user3 = new User("Nicola", "Martin", "XXXXXX22X22X222X");
		userRepository.save(user3);
	}

}
