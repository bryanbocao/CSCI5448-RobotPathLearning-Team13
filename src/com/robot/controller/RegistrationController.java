package com.robot.controller;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.robot.hibernate.HibernateUtil;
import com.robot.hibernate.User;
 

@Controller
@RequestMapping(value = "/register")
public class RegistrationController{

    @RequestMapping(method = RequestMethod.GET)
    public String viewRegistration(Map<String, Object> model) {
        User userForm = new User();    
        model.put("userForm", userForm);
         
        return "RegisterPage";
    }
     
    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("userForm") User user,
            Map<String, Object> model) {
         
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	
    	session.save(user);
    	
    	session.getTransaction().commit();
    	session.close();
    	sessionFactory.close();
         
        // for testing purpose:
        System.out.println("username: " + user.getUsername());
        System.out.println("password: " + user.getPassword());
         
        return "RegisterSuccessPage";
    }
}


