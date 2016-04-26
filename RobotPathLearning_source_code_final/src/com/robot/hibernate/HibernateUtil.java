package com.robot.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	private static SessionFactory buildSessionFactory() {

		try {

			serviceRegistry = new StandardServiceRegistryBuilder()
					.configure() // configures settings from hibernate.cfg.xml
					.build();

			return new MetadataSources( serviceRegistry ).buildMetadata().buildSessionFactory();

		} catch (Throwable ex) {

			StandardServiceRegistryBuilder.destroy( serviceRegistry );
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
			
		}
	}

	public static SessionFactory getSessionFactory() {

		if(sessionFactory == null){
			sessionFactory = buildSessionFactory();
		}
		return sessionFactory;
	}
}
