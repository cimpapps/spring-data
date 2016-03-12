package com.cimpapps.DAO;

import com.cimpapps.model.Employee;

public interface EmployeeDAO {
	
	void saveEmployee(Employee employee);
	void updateEmployee(Employee employee);
	Employee getEmployee(int id);
	
}
