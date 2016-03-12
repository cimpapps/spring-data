package com.cimapps.GUI;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cimpapps.DAO.EmployeeDAO;
import com.cimpapps.DAO.EmployeeDAOImpl;
import com.cimpapps.model.Employee;

public class GUI extends JPanel{
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		EmployeeDAO dao = (EmployeeDAOImpl) context.getBean("employeeDAO");
		
		Employee e = new Employee();
		e.setFirstName("Catalin");
		e.setLastName("Cimpoeru");
		e.setDepartment("IT");
		
		dao.saveEmployee(e);
	}
	
	public GUI(){
		initComponents();
	}

	private void initComponents() {
		
		
		
	}
}
