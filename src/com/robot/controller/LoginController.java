package com.robot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.robot.delegate.LoginDelegate;
import com.robot.viewBean.LoginBean;
 
@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginDelegate loginDelegate;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView login() {

		ModelAndView model = new ModelAndView("LoginPage");
		LoginBean loginBean = new LoginBean();
		model.addObject("loginBean", loginBean);
		return model;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, 
			@ModelAttribute("loginBean")LoginBean loginBean) {

		ModelAndView model = null;
		try{
			boolean isValidUser = loginDelegate.isValidUser(loginBean.getUsername(), loginBean.getPassword());
			if(isValidUser)
			{
					System.out.println("User Login Successful.");
					request.setAttribute("loggedInUser", loginBean.getUsername());
					model = new ModelAndView("LoginPage");
			}
			else
			{
					System.out.println("User Login Failed.");
					model = new ModelAndView("LoginPage");
					request.setAttribute("message", "Invalid credentials!!");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return model;
	}
}
