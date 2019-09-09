package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import POJO.Student;

/**
 * @author krishan
 * RetrieveStudentData class is a database connector class that will retrieve Students data.
 *
 */
public class RetrieveStudentData
{
	Connection con;
	List<Student> allStudents;

	/**
	 * constructor to initialise List of all the students and connection with the database. 
	 */
	public RetrieveStudentData()
	{
		con = DBConnectionDao.getDBConnection();
		allStudents = new ArrayList<Student>();
	}

	/**
	 * @return list of all the students in the database
	 * collectAllStudentsData method  retrieves data of all the students and assigns set the values 
	 * to a POJO class student.
	 */
	public List<Student> collectAllStudentsData()
	{
		String sqlQuery = "select firstName,lastName,fatherName,email,className,age,studentId from studentDetails";
		try
		{
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				Student s = new Student();
				s.setFirstName(rs.getString(1));
				s.setLastName(rs.getString(2));
				s.setFatherName(rs.getString(3));
				s.setEmail(rs.getString(4));
				s.setClassName(rs.getString(5));
				s.setAge(rs.getString(6));
				s.setStudentId(rs.getInt(7));
				allStudents.add(s);

			}
			con.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return allStudents;
	}

	/**
	 * @param searchBy parameter defines that either user will search student by first name or last name.
	 * @param value is the string that is to be searched in the database
	 * @return
	 */
	public List<Student> collectStudentsDataByName(String searchBy, String value)
	{
		String sqlQuery = "select firstName,lastName,fatherName,email,className,age,studentId from studentDetails where lastName = ? order by className DESC";
		if ("firstName".equals(searchBy))
		{
			sqlQuery = "select firstName,lastName,fatherName,email,className,age,studentId from studentDetails where firstName = ? order by className DESC";
		}
		try
		{
			PreparedStatement ps = con.prepareStatement(sqlQuery);

			ps.setString(1, value);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				Student s = new Student();
				s.setFirstName(rs.getString(1));
				s.setLastName(rs.getString(2));
				s.setFatherName(rs.getString(3));
				s.setEmail(rs.getString(4));
				s.setClassName(rs.getString(5));
				s.setAge(rs.getString(6));
				s.setStudentId(rs.getInt(7));
				allStudents.add(s);
			}
		}

		catch (Exception e)
		{
			e.printStackTrace();
		}
		return allStudents;
	}

	/**
	 * @param id is the student id
	 * @return the student with the particular id.
	 */
	public Student collectStudentsData(int id)
	{
		Student s = null;

		String sqlQuery = "select firstName,lastName,fatherName,email,className,age,studentId from studentDetails where studentId=?";
		try
		{

			s = new Student();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				s.setFirstName(rs.getString(1));
				s.setLastName(rs.getString(2));
				s.setFatherName(rs.getString(3));
				s.setEmail(rs.getString(4));
				s.setClassName(rs.getString(5));
				s.setAge(rs.getString(6));
				s.setStudentId(rs.getInt(7));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return s;
	}
}
