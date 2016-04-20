package com.robot.viewBean;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;



public class LoginBean
{
		@Size(min=3, max=30)
		@NotNull
		private String username;

		@NotNull
		@Size(min=4, max=12)
		private String password;

		public String getPassword()
		{
				return this.password;
		}

		public String getUsername()
		{
				return this.username;
		}

		public void setUsername(String username)
		{
				this.username = username;
		}

		public void setPassword(String password)
		{
				this.password = password;
		}
}