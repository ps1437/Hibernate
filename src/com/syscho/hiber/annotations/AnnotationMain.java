package com.syscho.hiber.annotations;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class AnnotationMain {

	private static SessionFactory factory;

	public static void main(String[] args) {
		try {
			AnnotationConfiguration annotationConfiguration = new AnnotationConfiguration();
			Properties properties = new Properties();
			
			Map<String ,String> map = new HashMap<String,String>();
			map.put("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver");
			map.put("hibernate.connection.url", "jdbc:oracle:thin:@localhost:1521:xe");
			map.put("hibernate.connection.username", "system");
			map.put("hibernate.connection.password", "1437");
			map.put("hibernate.hbm2ddl.auto", "create");
			map.put("hibernate.show_sql", "true");
			map.put("hibernate.dialect", "org.hibernate.dialect.Oracle9iDialect");
			properties.putAll(map);
			annotationConfiguration.addProperties(properties);
			factory = annotationConfiguration.
		
					addAnnotatedClass(ManageEmployee.class)
					.buildSessionFactory();

		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		AnnotationMain ME = new AnnotationMain();
		/* Add few ManageEmployee records in database */
		Integer empID1 = ME.addManageEmployee("Zara", "Ali", 1000);
		Integer empID2 = ME.addManageEmployee("Daisy", "Das", 5000);
		Integer empID3 = ME.addManageEmployee("John", "Paul", 10000);
		/* List down all the ManageEmployees */
		ME.listManageEmployees();
		
		ME.getByQuery();
	}

	private void getByQuery() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Criteria createCriteria = session.createCriteria("FROM EMPANNOTATION");
			createCriteria.add(Restrictions.gt("salary", 2000));
					List results = createCriteria.list();
			for (Iterator iterator = results.iterator(); iterator
					.hasNext();) {
				ManageEmployee ManageEmployee = (ManageEmployee) iterator
						.next();
				System.out
						.print("First Name: " + ManageEmployee.getFirstName());
				System.out.print(" Last Name: " + ManageEmployee.getLastName());
				System.out.println(" Salary: " + ManageEmployee.getSalary());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

	/* Method to CREATE an ManageEmployee in the database */
	public Integer addManageEmployee(String fname, String lname, int salary) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer ManageEmployeeID = null;
		try {
			tx = session.beginTransaction();
			ManageEmployee ManageEmployee = new ManageEmployee();
			ManageEmployee.setFirstName(fname);
			ManageEmployee.setLastName(lname);
			ManageEmployee.setSalary(salary);
			ManageEmployeeID = (Integer) session.save(ManageEmployee);

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return ManageEmployeeID;
	}

	/* Method to READ all the ManageEmployees */
	public void listManageEmployees() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List ManageEmployees = session.createQuery("FROM ManageEmployee")
					.list();
			for (Iterator iterator = ManageEmployees.iterator(); iterator
					.hasNext();) {
				ManageEmployee ManageEmployee = (ManageEmployee) iterator
						.next();
				System.out
						.print("First Name: " + ManageEmployee.getFirstName());
				System.out.print(" Last Name: " + ManageEmployee.getLastName());
				System.out.println(" Salary: " + ManageEmployee.getSalary());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
