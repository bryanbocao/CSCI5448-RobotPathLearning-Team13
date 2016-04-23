package com.robot.controller;

import java.sql.SQLException;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.robot.delegate.RegistrationDelegate;
import com.robot.hibernate.User;

@Controller
@RequestMapping(value = "/register")
public class RegistrationController {

	@Autowired
	private RegistrationDelegate registrationDelegate;

	@RequestMapping(method = RequestMethod.GET)
	public String viewRegistration(Map<String, Object> model) {
		User userForm = new User();
		model.put("userForm", userForm);

		return "RegisterPage";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processRegistration(@Valid @ModelAttribute("userForm") User user, BindingResult bindingResult) {

		System.out.println("testing...");
		if (bindingResult.hasErrors()) {
			System.out.println("Validation errors...");
			return new ModelAndView("RegisterPage");
		}

		try {
			registrationDelegate.registerUser(user.getUsername(), user.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/map");

	}
}
