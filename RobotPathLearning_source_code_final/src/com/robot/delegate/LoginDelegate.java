package com.robot.delegate;

import java.sql.SQLException;

import com.robot.hibernate.User;
import com.robot.service.UserService;

public class LoginDelegate {
	private UserService userService;

	public UserService getUserService() {
		return this.userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public boolean isValidUser(String username, String password) throws SQLException {
		return userService.isValidUser(username, password);
	}
	
	public User getUserByUsername(String username) throws SQLException {
		return userService.getUserByUsername(username);
	}
}