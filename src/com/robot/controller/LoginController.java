package com.robot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 

@Controller
public class LoginController{

	@RequestMapping("/login")
	public ModelAndView login(){
		
		ModelAndView model = new ModelAndView("LoginPage");
		
		return model;
		
		
	}
}


