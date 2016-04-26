package com.robot.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.robot.hibernate.Path;

@Controller
@RequestMapping("/api")
public class LearningController {
	
	@RequestMapping(value = "allPaths", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Path> post(HttpSession session) {
		List<Path> paths = Path.getAllPaths();

		
		return paths;
	
	}
}
