package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import POJO.EmployeeVehicle;
import POJO.Friends;
import POJO.Employee;

/**
 * @author krishan 
 * RetrieveEmployeeData class is a database connector class that will retrieve Students data.
 *
 */
public class RetrieveEmployeeData
{
	Connection con;
	List<Friends> allFriendsList;

	/**
	 * Constructor to initialize List of all the Employees and connection with the
	 * database.
	 */
	public RetrieveEmployeeData()
	{
		con = DBConnectionDao.getDBConnection();
		allFriendsList = new ArrayList<Friends>();
	}

	/**
	 * @return list of all the friends of employee in the database
	 *  collectAllEmployeeFriendsData method retrieves data of all the friends of the particular employee
	 */
	public List<Friends> collectAllEmployeeFriendsData(String organization, int id)
	{
		String sqlQuery = "select e.empId,e.empName,e.empEmail, e.empContact, e.empGender,e.empOrganization,v.vehicleName,v.vehicleType,v.vehicleNumber,v.PassPriceDetail from empDetails e INNER JOIN empVehicleDetails v on e.empId=v.empId where e.empOrganization=? AND e.empId<>?";
		try
		{
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setString(1, organization);
			ps.setInt(2, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
				Friends f = new Friends();
				f.getE().setEmpId(rs.getInt(1));
				f.getE().setEmpName(rs.getString(2));
				f.getE().setEmpEmail(rs.getString(3));
				f.getE().setEmpContact(rs.getString(4));
				f.getE().setEmpGender(rs.getString(5));
				f.getE().setEmpOrganization(rs.getString(6));

				f.getV().setVehicleName(rs.getString(7));
				f.getV().setVehicleType(rs.getString(8));
				f.getV().setVehicleNumber(rs.getString(9));
				f.getV().setPassPriceDetail(rs.getString(10));
				allFriendsList.add(f);

			}
			con.close();
			return allFriendsList;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param id is the employee id
	 * @return the list of all the employee data
	 */
	public List<Object> collectEmployeeData(int id)
	{
		List<Object> list = new ArrayList<Object>();

		String sqlQuery = "select e.empName, e.empEmail, e.empContact, e.empGender, e.empPassword, e.empOrganization,v.vehicleName,v.vehicleType,v.vehicleNumber,v.PassPriceDetail from empDetails e INNER JOIN empVehicleDetails v on e.empId=v.empId where e.empId=?";
		try
		{
			Employee e = new Employee();
			EmployeeVehicle v = new EmployeeVehicle();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{

				e.setEmpName(rs.getString(1));
				e.setEmpEmail(rs.getString(2));
				e.setEmpContact(rs.getString(3));
				e.setEmpGender(rs.getString(4));
				e.setEmpPassword(rs.getString(5));
				e.setEmpOrganization(rs.getString(6));

				v.setVehicleName(rs.getString(7));
				v.setVehicleType(rs.getString(8));
				v.setVehicleNumber(rs.getString(9));
				v.setPassPriceDetail(rs.getString(10));

			}
			list.add(e);
			list.add(v);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * @param emp
	 * @return employee id
	 */
	public int collectEmployeeId(Employee emp)
	{
		int id = -1;

		String sqlQuery = "select empId from empDetails where empEmail=? AND empPassword=?";
		try
		{

			PreparedStatement ps = con.prepareStatement(sqlQuery);

			ps.setString(1, emp.getEmpEmail());

			ps.setString(2, emp.getEmpPassword());

			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				emp.setEmpId(rs.getInt(1));
				id = emp.getEmpId();
			}
			return id;
		}
		catch (Exception e)
		{

			e.printStackTrace();
			return id;
		}

	}
}
