package com.cimapps.GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cimpapps.DAO.EmployeeDAO;
import com.cimpapps.DAO.EmployeeDAOImpl;
import com.cimpapps.model.Employee;

public class GUI extends JPanel{
	JTextField firstNameText;
	JTextField lastNameText;
	JTextField departmentText;
	static EmployeeDAO dao;
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		dao = (EmployeeDAOImpl) context.getBean("employeeDAO");
		
		JFrame window = new JFrame("Insert new employee: ");
		window.setContentPane(new GUI());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setVisible(true);
		
		
	}
	
	public GUI(){
		initComponents();
	}

	private void initComponents() {
		firstNameText =  new JTextField();
		lastNameText =  new JTextField();
		departmentText =  new JTextField();
		setLayout(new GridLayout(4, 2));
		
		add(new JLabel("First Name: "));
		add(firstNameText);
		add(new JLabel("Last Name: "));
		add(lastNameText);
		add(new JLabel("Department: "));
		add(departmentText);
		
		JButton button = new JButton("Insert Employee");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Employee employee = new Employee();
			
				employee.setFirstName(firstNameText.getText());
				employee.setLastName(lastNameText.getText());
				employee.setDepartment(departmentText.getText());
				dao.saveEmployee(employee);
				System.out.println(dao.getAllEmployees());
				
			}
		});
		add(button);
	}
}
