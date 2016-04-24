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
import com.robot.hibernate.User;


@Controller
@RequestMapping("/profile")
public class ProfileController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView profile() {
		String message = "Cornwell";
		ModelAndView model = new ModelAndView("views/ProfilePage","message", message);
		return model;
	}

}
