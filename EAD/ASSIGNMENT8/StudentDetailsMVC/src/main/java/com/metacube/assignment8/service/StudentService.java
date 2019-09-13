package com.metacube.assignment8.service;

import java.util.List;

import com.metacube.assignment8.model.Student;

/**
 * @author krishan
 * interface StudentService provides service methods for student  
 *
 */
public interface StudentService
{
	/**
	 * @return list of all the students
	 */
	public List<Student> getAllStudent();

	/**
	 * @param student
	 * adds student to the list
	 */
	public void addStudent(Student student);

}
