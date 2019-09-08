package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import POJO.Student;

/**
 * @author krishan
 * UpdateExistingStudentDao class to update student details in the database if the particular student exists.
 */
public class UpdateExistingStudentDao
{
	Connection con;

	/**
	 * constructor to establish connection.
	 */
	public UpdateExistingStudentDao()
	{
		con = DBConnectionDao.getDBConnection();
	}

	/**
	 * @param stu is a object of student that have the values to be updated.
	 * @return no. of rows updated if successfully updated else return -1.
	 * UpdateById method updates the student details according to the student id.
	 */
	public int UpdateById(Student stu)
	{
		String sqlQuery = "UPDATE studentDetails SET firstName=?, lastName=?, fatherName=?, email=?, className=?, age=? where studentId=?";
		try
		{
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setString(1, stu.getFirstName());
			ps.setString(2, stu.getLastName());
			ps.setString(3, stu.getFatherName());
			ps.setString(4, stu.getEmail());
			ps.setString(5, stu.getClassName());
			ps.setString(6, stu.getAge());
			ps.setInt(7, stu.getStudentId());
			int result = ps.executeUpdate();
			return result;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return -1;
	}
}
