/*
 * Utility Class
 */
package com.metacube.Student.utils;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.metacube.Student.dao.StudentDAO;
import com.metacube.Student.model.Student;

public class UseDAO {
	
	private static UseDAO use = new UseDAO();
	
	Resource r = new ClassPathResource("ApplicationContext.xml");
	BeanFactory factory = new XmlBeanFactory(r);
	StudentDAO s = (StudentDAO)factory.getBean("d");
	DataSource d = (DataSource)factory.getBean("dataSource1");
	
	private UseDAO(){}
	
	/**
	 * Singleton Class
	 * @return instance
	 */
	public static UseDAO getInstance(){
		return use;
	}
	
	public  DataSource getDataSource(){
		return d;
	}
	
	/**
	 * Adds Student
	 * @param s to be added
	 * @return no of rows
	 */
	public int add(Student student){
		return s.add(student);
	}
	
	/**
	 * Gets All the Students
	 * @return list of students
	 */
	public List<Student> getAll(){
		return s.getAll();
	}
}
