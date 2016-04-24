package com.robot.controller;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
			String message = user.getUsername();
			//String message = "Cornwell";
			ModelAndView model = new ModelAndView("views/ProfilePage","message", message);
			return model;
		}else{
			// has not logged in yet
			return new ModelAndView("redirect:/login");
		}
		
		
	}

}
