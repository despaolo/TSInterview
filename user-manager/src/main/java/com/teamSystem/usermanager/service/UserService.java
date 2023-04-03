package com.teamSystem.usermanager.service;

import java.util.List;

import com.teamSystem.usermanager.entity.User;

public interface UserService {

	List<User> getAllUsers();
	
	User addUser(User user);
	
	User getUserById(Long id);
	
	User updateUser(User user);
	
	void deleteUser(Long id);

	User getUserByFiscalCode(String fiscalCode);
}
