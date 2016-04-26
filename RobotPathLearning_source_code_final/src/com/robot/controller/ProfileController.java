package com.robot.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.robot.hibernate.User;

@Controller
@RequestMapping("/profile")
public class ProfileController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView profile(HttpSession session) {

		User user = (User) session.getAttribute("USER");
		if (user != null) {
			System.out.println("current user name: " + user.getUsername() + " id: " + user.getId());
		}else{
			// has not logged in yet
			return new ModelAndView("redirect:/login");
		}

		ModelAndView model = new ModelAndView("views/ProfilePage");
		
		model.getModel().put("user", user);

		if(user.getUserType().compareTo("admin") == 0){
			// also send all the other users to the view
			List<User> users =  User.getAllUsers();
			System.out.println("Sending " + users.size() + " users to the view.");
			model.getModel().put("allUsers", users);
		}

		return model;
	}

}
