package com.metacube.assignment9_10.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.assignment9_10.model.Employee;

/**
 * @author krishan
 *EmpDetailsMapper class is mapper class for Employee class
 */
public class EmpDetailsMapper implements RowMapper<Employee>
{

	/**
	 * mapRow method is to map result set to its corresponding class
	 */
	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		Employee e = new Employee();
		e.setEmpId(rs.getInt("empId"));
		e.setEmpName(rs.getString("empName"));
		e.setEmpEmail(rs.getString("empEmail"));
		e.setEmpContact(rs.getString("empContact"));
		e.setEmpGender(rs.getString("empGender"));
		e.setEmpPassword(rs.getString("empPassword"));
		e.setEmpOrganization(rs.getString("empOrganization"));
		return e;
	}

}
