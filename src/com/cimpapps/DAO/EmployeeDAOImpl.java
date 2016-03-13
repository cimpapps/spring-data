package com.cimpapps.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.cimpapps.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	
	private String employee_insert;

	private String employee_select;
	
	private String employee_select_all;

	public void setEmployee_select_all(String employee_select_all) {
		this.employee_select_all = employee_select_all;
	}

	public void setEmployee_select(String employee_select) {
		this.employee_select = employee_select;
	}

	private String employee_update;

	JdbcTemplate jdbcTemplate;

	@Override
	public List<Employee> getAllEmployees() {
		List<Map<String, Object>> employeesMap = jdbcTemplate.queryForList(employee_select_all);
		List<Employee> employees = new ArrayList<>();
		for (int i = 0; i < employeesMap.size(); i++) {
			Employee e = new Employee();
			e.setFirstName(employeesMap.get(i).get("firstName").toString());
			e.setDepartment(employeesMap.get(i).get("department").toString());
			e.setLastName(employeesMap.get(i).get("lastName").toString());
			employees.add(e);
		}
		return employees;
	}

	@Override
	public Employee getEmployee(int id) {
		Employee e = jdbcTemplate.queryForObject(employee_select, new Object[] { new Integer(id) },
				new RowMapper<Employee>() {

					@Override
					public Employee mapRow(ResultSet arg0, int id) throws SQLException {
						Employee e = new Employee();
						e.setFirstName(arg0.getString("firstName"));
						e.setLastName(arg0.getString("lastName"));
						e.setDepartment(arg0.getString("department"));
						e.setId(arg0.getInt("id"));

						return e;
					}
				});
		return e;
	}


	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public void saveEmployee(Employee employee) {
		jdbcTemplate.update(employee_insert,
				new Object[] { employee.getFirstName(), employee.getLastName(), employee.getDepartment() });
	}

	public void setEmployee_insert(String employee_insert) {
		this.employee_insert = employee_insert;
	}

	public void setEmployee_Select(String employee_Select) {
		this.employee_select = employee_Select;
	}

	public void setEmployee_update(String employee_update) {
		this.employee_update = employee_update;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void updateEmployee(Employee employee) {
		jdbcTemplate.update(employee_update, new Object[] { employee.getFirstName(), employee.getLastName(),
				employee.getDepartment(), employee.getId() });

	}

}
