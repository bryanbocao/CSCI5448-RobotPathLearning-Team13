package com.robot.service;

import java.sql.SQLException;

import com.robot.hibernate.User;

public class UserService
{

		private User user;

		public User getUser()
		{
				return this.user;
		}

		public void setUser(User user)
		{
				this.user = user;
		}

		public boolean isValidUser(String username, String password) throws SQLException
		{
				return user.isValidUser(username, password);
		}

}
