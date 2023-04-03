package com.teamSystem.usermanager.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.teamSystem.usermanager.entity.User;
import com.teamSystem.usermanager.repository.UserRepository;
import com.teamSystem.usermanager.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getAllUsers() {		
		return userRepository.findAll();
	}
	
	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).get();
	}
	
	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
	@Override
	public User getUserByFiscalCode(String fiscalCode) {
		return userRepository.findByFiscalCode(fiscalCode);
	}
}
