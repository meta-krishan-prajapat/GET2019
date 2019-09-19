package com.metacube.assignment9_10.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.assignment9_10.model.EmployeeVehicle;

/**
 * @author krishan
 *EmpVehicleMapper class is mapper class for Employee Vehicle class
 */
public class EmpVehicleMapper implements RowMapper<EmployeeVehicle>
{

	/**
	 *EmployeeVehicle method is to map result set to its corresponding class
	 */
	@Override
	public EmployeeVehicle mapRow(ResultSet rs, int rowNum) throws SQLException
	{

		EmployeeVehicle employeeVehicle = new EmployeeVehicle();
		employeeVehicle.setVehicleName(rs.getString("vehicleName"));
		employeeVehicle.setVehicleType(rs.getString("vehicleType"));
		employeeVehicle.setVehicleNumber(rs.getString("vehicleNumber"));
		employeeVehicle.setPassPriceDetail(rs.getString("PassPriceDetail"));
		return employeeVehicle;
	}

}
