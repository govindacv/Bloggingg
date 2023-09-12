package com.blogging.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogging.dto.UserRequest;
import com.blogging.entity.User;
import com.blogging.repository.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;

	public String createUser(UserRequest userRequest) {
		User user = new User();
		user.setUserName(userRequest.getUserName());
		user.setUserPassword(userRequest.getUserPassword());
		userRepo.save(user);
		return "User created Sucessfully";
	}

	public String login(String userName, String userPassword)

	{
		List<User> list = userRepo.findAll();
		for (User user : list) {
			if (user.getUserName().equals(userName) && user.getUserPassword().equals(userPassword)) {
				return "Login Sucessful";
			}

		}
		return "Could't find User";

	}

}
