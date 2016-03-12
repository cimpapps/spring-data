package com.cimpapps.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.cimpapps.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{

	JdbcTemplate jdbcTemplate;

	@Override
	public void saveEmployee(Employee employee) {
		jdbcTemplate.update(employee_insert, new Object[]{employee.getFirstName(),
				employee.getLastName(), employee.getDepartment()});
	}

	@Override
	public void updateEmployee(Employee employee) {
		jdbcTemplate.update(employee_update, new Object[]{employee.getFirstName(),
				employee.getLastName(), employee.getDepartment(), employee.getId()});
		
	}

	@Override
	public Employee getEmployee(int id) {
		Employee e = jdbcTemplate.queryForObject(employee_Select, new Object[]{new Integer(id)},
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
			}
		);
		return e;
	}
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private final String employee_Select = "SELECT * FROM angajati WHERE id= ?";
	private final String employee_insert = "INSERT INTO angajati( firstName, lastName, department) VALUES(?,?,?)";
	private final String employee_update = "UPDATE angajati SET firstName=?, lastName=?,department=? WHERE id = ?" ;
	
}
