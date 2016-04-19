package com.robot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 

@Controller
public class RegistrationController{

	@RequestMapping("/register")
	public ModelAndView register(){
		
		ModelAndView model = new ModelAndView("RegisterPage");
		
		return model;
		
		
	}
}


