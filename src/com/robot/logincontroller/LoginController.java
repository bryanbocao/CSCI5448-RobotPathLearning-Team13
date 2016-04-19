package com.robot.logincontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 

@Controller
public class LoginController{

	@RequestMapping("/welcome")
	public ModelAndView helloWorld(){
		
		System.out.println("got to hello world..");
		ModelAndView model = new ModelAndView("LoginPage");
		model.addObject("welcomeMessage", "hello world");
		
		return model;
		
		
	}
}


