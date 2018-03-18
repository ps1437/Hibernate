package com.syscho.hiber.dao;

import org.hibernate.SessionFactory;

import com.syscho.hiber.bean.Employee;
import com.syscho.hiber.dbutil.DbConn;

public class HiberDaoService {
	
	public void insertObject(Object obj){
		SessionFactory conn = new DbConn().getConnection();
		HiberDao dao = new HiberDao();
		int result = dao.insertObject(obj, conn);
		if(result>0){
			System.out.println("Inserted Sucessfully");
		}else
		{
			System.out.println("Failed to insert..!!");
		}
	}
	
	
	public void deleteObject(Object obj){
		SessionFactory conn = new DbConn().getConnection();
		HiberDao dao = new HiberDao();
		int result = dao.deleteObject(obj, conn);
		if(result>0){
			System.out.println("Deleted Sucessfully");
		}else
		{
			System.out.println("Failed to Delete..!!");
		}
	}

	

	public void updateObject(Object obj){
		SessionFactory conn = new DbConn().getConnection();
		HiberDao dao = new HiberDao();
		int result = dao.updateObject(obj, conn);
		if(result>0){
			System.out.println("Updated Sucessfully");
		}else
		{
			System.out.println("Failed to Updated..!!");
		}
	}
	
	
	public void getObject(int id){
		SessionFactory conn = new DbConn().getConnection();
		HiberDao dao = new HiberDao();
		 Employee object =(Employee) dao.getObject(id, conn);
		if(object != null){
			System.out.println(object.getId() +":"+object.getFirstName()+":"+object.getLastName()+":"+object.getSalary());
		}else
		{
			System.out.println("User not found");
			
		}
	}


	public void getListObject() {
		
		SessionFactory conn = new DbConn().getConnection();
		HiberDao dao = new HiberDao();
		dao.getListObject(conn);
	}


	
	
}
