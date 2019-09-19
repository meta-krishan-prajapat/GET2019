package com.metacube.assignment9_10.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.metacube.assignment9_10.model.Employee;
import com.metacube.assignment9_10.model.EmployeeVehicle;

/**
 * @author krishan
 * AppConfig is a configuration class for beans
 */
@Configuration
public class AppConfig
{
	/**
	 * @return the reference of Employee
	 */
	@Bean
	public Employee employeeRef()
	{
		return new Employee();
	}

	/**
	 * @return the reference of EmployeeVehicle
	 */
	@Bean
	public EmployeeVehicle employeeVehicleRef()
	{
		return new EmployeeVehicle();
	}
}
