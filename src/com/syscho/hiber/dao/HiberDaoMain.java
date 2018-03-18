package com.syscho.hiber.dao;

import com.syscho.hiber.bean.Employee;

public class HiberDaoMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setId(2);
		emp.setFirstName("jaiverr");

		HiberDaoService hiberService = new HiberDaoService();
		// hiberService.insertObject(emp);

		// hiberService.deleteObject(emp);
		// hiberService.updateObject(emp);

		// hiberService.getObject(2);
		hiberService.getListObject();
	}

}
