package com.syscho.hiber.dbutil;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.syscho.hiber.bean.Employee;

public class DbConnProp {
public static void main(String[] args) {
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
 Configuration configuration = new Configuration();
 SessionFactory buildSessionFactory = configuration.addProperties(properties).buildSessionFactory();

}
}
