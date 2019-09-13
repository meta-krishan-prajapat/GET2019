package com.metacube.assignment8.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.metacube.assignment8.model.Student;

/**
 * @author krishan
 * Repository class for student details
 *
 */
@Repository
public class InsertAndFetchStudents
{
	static List<Student> studentsList = new ArrayList<Student>();;

	/**
	 * @param student
	 * Insert student to a list
	 */
	public static void insert(Student student)
	{
		try
		{
			if (student.getFirstName() != null && student.getLastName() != null && student.getFatherName() != null
					&& student.getEmail() != null && student.getClassName() != null && student.getAge() != null)
			{
				studentsList.add(student);
			}
			else
			{
				throw new NullPointerException("null student details are not accepted");
			}
		}
		catch (NullPointerException e)
		{
			e.getMessage();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @return list of all the students
	 */
	public static List<Student> fetchAll()
	{
		return studentsList;
	}

}
