package com.robot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		
		session.removeAttribute("USER");

		ModelAndView model = new ModelAndView("redirect:/login");
		
		return model;

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView executeLogin(HttpSession session, HttpServletRequest request, HttpServletResponse response, 
			@ModelAttribute("loginBean")LoginBean loginBean) {

		ModelAndView model = null;
		try{
			boolean isValidUser = loginDelegate.isValidUser(loginBean.getUsername(), loginBean.getPassword());
			if(isValidUser)
			{
					System.out.println("User Login Successful.");
					request.setAttribute("success", loginBean.getUsername());
					session.setAttribute("USER", (Object)loginDelegate.getUserByUsername(loginBean.getUsername()));
					model = new ModelAndView("redirect:/map");
			}
			else
			{
					System.out.println("User Login Failed.");
					model = new ModelAndView("LoginPage");
					request.setAttribute("error", "Invalid credentials.");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return model;
	}
}
