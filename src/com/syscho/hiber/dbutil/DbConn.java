package com.syscho.hiber.dbutil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class DbConn {

	private SessionFactory factory;

	public SessionFactory getConnection() {

		factory = new AnnotationConfiguration().configure()
				.buildSessionFactory();
		return factory;
	}

	public void closeConnection() {
		try {
			if (factory != null)
				factory.close();
		} catch (Exception exception) {

		}
	}

}
