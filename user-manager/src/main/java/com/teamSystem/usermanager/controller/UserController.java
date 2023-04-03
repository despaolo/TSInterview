package com.teamSystem.usermanager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.teamSystem.usermanager.entity.User;

import com.teamSystem.usermanager.service.UserService;

@Controller
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	private UserService userService;


	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/")
	public String homePage(Model model) {
		logger.info("Redirecting to Home Page...");
		model.addAttribute("home", userService.getAllUsers());
		return "home";
	}
	
	@GetMapping("/users")
	public String usersList(Model model) {
		logger.info("Retrieving all users from the db...");
		model.addAttribute("users", userService.getAllUsers());
		return "users";
	}
	
	@GetMapping("/users/new")
	public String createNewUser(Model model) {
		logger.info("Preparing to create a new user...");
		User user = new User();
		model.addAttribute("user", user);
		return "createUser";
	}
	
	@PostMapping("/users")
	public String addUser(@ModelAttribute("user") User user) {
		User userCheck = userService.getUserByFiscalCode(user.getFiscalCode().toUpperCase());
		if(userCheck != null) {
			logger.error("Fiscal code already present in table.");
			return "errorFiscalCode";
		}
		if(!user.isValidUser()) {
			logger.error("Inserted data are not valid.");
			return "error/400";
		}
		logger.info("Adding the new user: " + user.toString() + ".");
		userService.addUser(user);
		logger.info("User successfully created.");
		return "redirect:/users";
	}
	
	@GetMapping("/users/update/{id}")
	public String updateUser(@PathVariable Long id, Model model) {
		logger.info("Preparing to update user with id: " + id);
		model.addAttribute("user", userService.getUserById(id));
		return "updateUser";
	}
	
	@GetMapping("/users/search")
	public String showUser(User user, Model model, Long keyword) {
		if(keyword != null) {
			User selectedUser = userService.getUserById(keyword);
			if(selectedUser == null) {
				logger.error("Invalid keyword: " + keyword);
				logger.info("Redirecting to users list...");
				return "redirect:/users";
			}
			model.addAttribute("user", selectedUser);
			logger.info("User with id: " + keyword + " found. Preparing user view...");
			return "showUser";
		}else {
			logger.info("Empty keyword.");
			return "redirect:/users";
		}
	}
	
	@PostMapping("/users/{id}")
	public String editUser(@PathVariable Long id, @ModelAttribute("user") User user, Model model) {
		User selectedUser = userService.getUserById(id);
		selectedUser.setId(id);
		if(!user.isValidUser()) {
			logger.error("Inserted data are not valid.");
			return "error/400";
		}
		selectedUser.setName(user.getName());
		selectedUser.setSurname(user.getSurname());
		selectedUser.setFiscalCode(user.getFiscalCode());		
		User userCheck = userService.getUserByFiscalCode(user.getFiscalCode().toUpperCase());
		if(userCheck != null) {
			logger.error("Fiscal Code alredy present in table.");
			return "errorFiscalCode";
		}
		logger.info("Updating user: "+ user.toString() + ".");
		userService.updateUser(selectedUser);
		logger.info("User successfully updated. User: " + selectedUser.toString());
		logger.info("Redireting to users list...");
		return "redirect:/users";
	}
	
	@GetMapping("/users/{id}")
	public String deleteUser(@PathVariable Long id) {
		logger.info("Preparing to delete user with id: " + id);
		userService.deleteUser(id);
		logger.info("User with id: " + id + " successfully deleted.");
		logger.info("Redireting to users list...");
		return "redirect:/users";
	}
	
}
