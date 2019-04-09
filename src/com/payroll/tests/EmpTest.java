package com.payroll.tests;

import java.sql.SQLException;
import java.util.List;

import com.payroll.dao.EmployeeDAO;
import com.payroll.pojo.Employee;

public class EmpTest {
	
	EmployeeDAO ed = new EmployeeDAO();
	
	public static void main(String args[]) throws Exception{
		EmpTest obj = new EmpTest();
	//	obj.getAllTest();
	//	System.out.println("now updating");
	//	obj.updateTest();
	//	System.out.println("new data");
	//	obj.getAllTest();
	//	System.out.println("now deleting");
	//	obj.deleteTest();
	//	System.out.println("new data");
		obj.getAllTest();
	}
	
	public void getTest() throws ClassNotFoundException, SQLException{
		Employee emp = ed.getEmployee(2);
		System.out.println(emp);
	}
	
	public void getAllTest() throws ClassNotFoundException, SQLException{
		List<Employee> employees = ed.getAll();
		for(int i = 0; i < employees.size() ; i++){
			Employee emp = employees.get(i);
			System.out.println(emp);
			System.out.println("-------------------");
		}
	}
	
	public void createTest() throws ClassNotFoundException, SQLException {
		Employee emp = new Employee("hitesh","mumbai",100);
		ed.createEmployee(emp);
	}
	
	public void updateTest() throws ClassNotFoundException, SQLException{
		Employee emp = new Employee(2,"hitesh","mumbai",105000);
		ed.updateEmployee(emp);
	}
	
	public void deleteTest() throws ClassNotFoundException, SQLException{
		ed.deleteEmployee(3);
	}
}
