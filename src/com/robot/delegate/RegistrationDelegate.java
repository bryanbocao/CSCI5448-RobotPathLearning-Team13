package com.robot.delegate;

import java.sql.SQLException;

import com.robot.service.UserService;

public class RegistrationDelegate {
	private UserService userService;

	public UserService getUserService() {
		return this.userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void registerUser(String username, String password) throws SQLException {
		userService.registerUser(username, password);
	}
}