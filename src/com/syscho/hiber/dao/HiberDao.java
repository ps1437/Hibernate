package com.syscho.hiber.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



import com.syscho.hiber.bean.Employee;

public class HiberDao {

	public int insertObject(Object obj, SessionFactory factory) {
		int result = 0;
		Transaction transaction = null;
		Session session = null;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			result = (Integer) session.save(obj);

			transaction.commit();

		} catch (HibernateException HibernateException) {
			if (transaction != null)
				transaction.rollback();
			HibernateException.printStackTrace();
		} finally {

			if (session != null) {
				session.close();
			}

		}

		return result;

	}

	public void deleteObjbyId(Integer EmployeeId, SessionFactory factory) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class,
					EmployeeId);
			session.delete(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public int deleteObject(Object obj, SessionFactory factory) {
		int result = 0;
		Transaction transaction = null;
		Session session = null;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.delete(obj);

			transaction.commit();
			result = 1;
		} catch (HibernateException HibernateException) {
			if (transaction != null)
				transaction.rollback();
			HibernateException.printStackTrace();
		} finally {

			if (session != null) {
				session.close();
			}

		}

		return result;

	}

	public int updateObject(Object obj, SessionFactory factory) {
		int result = 0;
		Transaction transaction = null;
		Session session = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();

			Employee employee = (Employee) session.get(Employee.class,
					((Employee) obj).getId());
			employee.setFirstName(((Employee) obj).getFirstName());
			session.update(employee);
			transaction.commit();
			result = 1;
		} catch (HibernateException HibernateException) {
			if (transaction != null)
				transaction.rollback();
		} finally {

			if (session != null) {
				session.close();
			}

		}
		return result;

	}

	
	
	public Object getObject(Integer Id, SessionFactory factory) {
		Object employee = null ;
		Transaction transaction = null;
		Session session = null;
		try {
			
			session = factory.openSession();
			transaction = session.beginTransaction();

			 employee = (Object) session.get(Employee.class,
					Id);
			
			
		} catch (HibernateException HibernateException) {
			if (transaction != null)
				transaction.rollback();
		} finally {

			if (session != null) {
				session.close();
			}

		}
		return employee;

	}

	public Object findById(int id, SessionFactory factory) {

		Transaction transaction = null;
		Session session = null;
		try {
		} catch (HibernateException HibernateException) {
			if (transaction != null)
				transaction.rollback();
		} finally {

			if (session != null) {
				session.close();
			}

		}
		return 0;

	}

	public int deleteById(Object obj, SessionFactory factory, int id) {
		int result = 0;
		Transaction transaction = null;
		Session session = null;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.delete(String.valueOf(id), obj);

			transaction.commit();
			result = 1;
		} catch (HibernateException HibernateException) {
			if (transaction != null)
				transaction.rollback();
			HibernateException.printStackTrace();
		} finally {

			if (session != null) {
				session.close();
			}

		}

		return result;
	}

	public void getListObject(SessionFactory conn) {
		Transaction transaction = null;
		Session session = null;

		try {
			session = conn.openSession();
			transaction = session.beginTransaction();
			List employees = (List) session.createQuery("FROM Employee").list();
			for (Iterator iterator =employees.iterator(); iterator.hasNext();){
			Employee employee = (Employee) iterator.next();
			System.out.print("First Name: " + employee.getFirstName());
			System.out.print(" Last Name: " + employee.getLastName());
			System.out.println(" Salary: " + employee.getSalary());
			}
			
		} catch (HibernateException HibernateException) {
			if (transaction != null)
				transaction.rollback();
			HibernateException.printStackTrace();
		} finally {

			if (session != null) {
				session.close();
			}

		}
		
	}

}
