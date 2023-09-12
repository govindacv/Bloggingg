package com.blogging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogging.dto.LoginRequest;
import com.blogging.dto.UserRequest;
import com.blogging.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController 
{
	@Autowired
	private UserService userService;
	
	
	@PostMapping
	public String createUser(@RequestBody UserRequest userRequest)
	{
		return userService.createUser(userRequest);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody LoginRequest loginRequest)
	{
		return userService.login(loginRequest.getUserName(),loginRequest.getUserPassword());
	}
	
	
	
	

}
