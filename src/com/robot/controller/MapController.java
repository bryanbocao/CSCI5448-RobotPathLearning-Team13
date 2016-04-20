package com.robot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/map")
public class MapController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView login() {

		ModelAndView model = new ModelAndView("views/MapPage");
		return model;
	}

}
