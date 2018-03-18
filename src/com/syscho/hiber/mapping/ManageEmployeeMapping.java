package com.syscho.hiber.mapping;

import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManageEmployeeMapping {
	private static SessionFactory factory;

	public static void main(String[] args) {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);

		}
		ManageEmployeeMapping ME = new ManageEmployeeMapping();
		/* Let us have a set of certificates for the first EmployeeMapping */
		HashSet set1 = new HashSet();
		set1.add(new Certificate("MCA"));
		set1.add(new Certificate("MBA"));
		set1.add(new Certificate("PMP"));
		/* Add EmployeeMapping records in the database */
		Integer empID1 = ME.addEmployeeMapping("Manoj", "Kumar", 4000, set1);
		/* Another set of certificates for the second EmployeeMapping */
		HashSet set2 = new HashSet();
		set2.add(new Certificate("BCA"));
		set2.add(new Certificate("BA"));
		/* Add another EmployeeMapping record in the database */
		Integer empID2 = ME.addEmployeeMapping("Dilip", "Kumar", 3000, set2);
		/* List down all the EmployeeMappings */
		ME.listEmployeeMappings();
		/* Update EmployeeMapping's salary records */
		//ME.updateEmployeeMapping(empID1, 5000);
		/* Delete an EmployeeMapping from the database */
	//	ME.deleteEmployeeMapping(empID2);
		/* List down all the EmployeeMappings */
	//	ME.listEmployeeMappings();
	}

	/* Method to add an EmployeeMapping record in the database */
	public Integer addEmployeeMapping(String fname, String lname,

	int salary, Set cert) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer EmployeeMappingID = null;
		try {
			tx = session.beginTransaction();
			EmployeeMapping EmployeeMapping = new EmployeeMapping(fname, lname,
					salary);
			EmployeeMapping.setCertificates(cert);
			EmployeeMappingID = (Integer) session.save(EmployeeMapping);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return EmployeeMappingID;
	}

	/* Method to list all the EmployeeMappings detail */
	public void listEmployeeMappings() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List EmployeeMappings = session.createQuery("FROM EmployeeMapping")
					.list();
			for (Iterator iterator1 = EmployeeMappings.iterator(); iterator1
					.hasNext();) {
				EmployeeMapping EmployeeMapping = (EmployeeMapping) iterator1
						.next();
				System.out.print("First Name: "
						+ EmployeeMapping.getFirstName());
				System.out
						.print(" Last Name: " + EmployeeMapping.getLastName());
				System.out.println(" Salary: " + EmployeeMapping.getSalary());
				Set certificates = EmployeeMapping.getCertificates();
				for (Iterator iterator2 = certificates.iterator(); iterator2
						.hasNext();) {

					Certificate certName = (Certificate) iterator2.next();
					System.out.println("Certificate: " + certName.getName());
				}
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

	/* Method to update salary for an EmployeeMapping */
	public void updateEmployeeMapping(Integer EmployeeMappingID, int salary) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			EmployeeMapping EmployeeMapping = (EmployeeMapping) session.get(
					EmployeeMapping.class, EmployeeMappingID);
			EmployeeMapping.setSalary(salary);
			session.update(EmployeeMapping);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to delete an EmployeeMapping from the records */
	public void deleteEmployeeMapping(Integer EmployeeMappingID) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			EmployeeMapping EmployeeMapping = (EmployeeMapping) session.get(
					EmployeeMapping.class, EmployeeMappingID);
			session.delete(EmployeeMapping);
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