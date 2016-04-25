package com.robot.controller;

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
	public ModelAndView map(HttpSession session) {

		User user = (User) session.getAttribute("USER");
		if (user != null) {
			System.out.println("current user name: " + user.getUsername() + " id: " + user.getId());
		}else{
			// has not logged in yet
			return new ModelAndView("redirect:/login");
		}

		ModelAndView model = new ModelAndView("views/ProfilePage");
		
		model.getModel().put("userType", user.getUserType());
		
		if(user.getUserType() == "admin"){
			// also send all the other users to the view
			model.getModel().put("users", User.getAllUsers());
		}

		return model;
	}

}
