package com.robot.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Size(min=3, max=30)
	@NotNull
	private String username;
	
	@NotNull
	@Size(min=4, max=12)
	private String password;
	
	private String userType;
	
	public User(String username, String password){
		this.username = username;
		this.password = password;
	}
	
	public User() {
	}

	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public boolean isValidUser(String username, String password) {
		boolean result = false;
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select count(1) from User where password= :passwd and username= :name");
		query.setString("passwd", password);
		query.setString("name", username);
		if( query.uniqueResult() != null ){
			// user found
			System.out.println("Found user.");
			result = true;
		}
		return result;
	}

	public void registerUser(String username, String password) {
		
		User new_user = new User(username, password);
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(new_user);
		session.getTransaction().commit();
		
	}
}
