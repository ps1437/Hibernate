package com.syscho.hiber.test;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.syscho.hiber.bean.Employee;
import com.syscho.hiber.bean.UserRegister;
import com.syscho.hiber.dbutil.DbConn;

public class Test {
	static Transaction transaction  = null; 
	 static Session session = null;

	public static void main(String[] args) {
 	DbConn conn = new DbConn();
	SessionFactory connection = conn.getConnection();
	System.out.println(connection.isClosed());
	if(connection !=null){
		UserRegister bean = new UserRegister();
		  session = connection.openSession();
		  transaction = session.beginTransaction();
		
		  session.save(bean);
		 transaction.commit();
  
	}
}
}
