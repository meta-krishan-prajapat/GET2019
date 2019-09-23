package com.metacube.Student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.Student.model.Student;
import com.metacube.Student.repo.StudentRepo;

/**
 * @author krishan
 * Service class
 *
 */
@Service("service")
public class StudentService
{

	@Autowired
	private StudentRepo studentRepo;

	/**
	 * Adds a student
	 * @param student
	 */
	@Transactional
	public void add(Student student)
	{
		try
		{
			if (student != null)
			{
				studentRepo.save(student);
			}
			else
			{
				throw new Exception("null not accepted");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	/**
	 * Gets All the Students
	 * @return list of students
	 */
	@Transactional
	public List<Student> getAll()
	{
		return (List<Student>) studentRepo.findAll();
	}

	/**
	 * Searches a student
	 * @param name search keyword
	 * @return list of students
	 */
	@Transactional
	public List<Student> get(String name)
	{
		try
		{
			if (name != null)
			{
				return studentRepo.findByfirstNameContainingIgnoreCase(name);
			}
			else
			{
				throw new Exception("null not accepted");
			}
		}
		catch (Exception e)
		{

			e.printStackTrace();
			return null;
		}

	}
}
