package com.robot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.robot.hibernate.Cell;
import com.robot.hibernate.Path;
import com.robot.hibernate.User;

@Controller
@RequestMapping("/map")
public class MapController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView map(HttpSession session) {

	    User user = (User) session.getAttribute("USER");
	    if(user!=null){
	    	System.out.println("current user name: " + user.getUsername() + " id: " + user.getId());
	    	System.out.println(user.getUsername() + "has " + user.getPaths().size() + " paths with " + 
	    	user.getPaths().get(0).getCells().size() + " cells");
	    }

		ModelAndView model = new ModelAndView("views/MapPage");
		return model;
	}

	@RequestMapping(value = "save", method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String post(HttpSession session, @RequestBody Path path) {
		System.out.println("Recieved request to save a path with :" + path.getCells().size() + " cells.");
		for (Cell c : path.getCells()) {
			System.out.println("Cell: ( " + c.getX() + "," + c.getY() + " )");
		}
	    User user = (User) session.getAttribute("USER");
	    if(user != null){
	    	path.setUser(user);
	    	user.getPaths().add(path);
	    	path.save();
	    }
		
		return "{\"status\": \"success\"}";
	}

}
