package com.cimpapps.DAO;

import java.util.List;

import com.cimpapps.model.Employee;

public interface EmployeeDAO {
	
	void saveEmployee(Employee employee);
	void updateEmployee(Employee employee);
	Employee getEmployee(int id);
	List<Employee> getAllEmployees();
	
}
