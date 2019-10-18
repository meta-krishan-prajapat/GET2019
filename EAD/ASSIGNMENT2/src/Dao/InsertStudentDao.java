package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import POJO.Student;

/**
 * @author krishan 
 * InsertStudentDao is a class that inserts student details to the database
 *
 */
public class InsertStudentDao
{
	Connection con;

	/**
	 * constructor to initialise the connection
	 */
	public InsertStudentDao()
	{
		con = DBConnectionDao.getDBConnection();
	}

	/**
	 * @param student
	 * @return true if the student details are successfully inserted into the database else return false.
	 */
	public boolean InsertStudent(Student student)
	{
		String sqlQuery = "INSERT INTO studentDetails(firstName,lastName,fatherName,email,className,age) VALUES(?,?,?,?,?,?)";
		try
		{
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setString(1, student.getFirstName());
			ps.setString(2, student.getLastName());
			ps.setString(3, student.getFatherName());
			ps.setString(4, student.getEmail());
			ps.setString(5, student.getClassName());
			ps.setString(6, student.getAge());
			int result = ps.executeUpdate();
			if (result == 1)
			{
				con.close();
				return true;

			}
			else
			{
				con.close();
				return false;
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
