package com.payroll.tests;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.payroll.dao.DBAdmin;
import com.payroll.dao.EmployeeDAO;
import com.payroll.pojo.Employee;
import org.junit.Test;

public class EmpTest {
	
	static EmployeeDAO ed = new EmployeeDAO();
	static long id;
	@Test
	public void crudTest() throws Exception{
		System.out.println("testing crud ops");
		System.out.println("testing create");
		createTest();
		getTest();
		System.out.println("testing update");
		updateTest();
		getTest();
		System.out.println("testing delete");
		deleteTest();
	}
	
	public void getTest() throws ClassNotFoundException, SQLException{
		Employee emp = ed.getEmployee(id);
		System.out.println(emp);
	}
	@Test
	public void getAllTest() throws ClassNotFoundException, SQLException{
		List<Employee> employees = ed.getAll();
		for(int i = 0; i < employees.size() ; i++){
			Employee emp = employees.get(i);
			System.out.println(emp);
			System.out.println("-------------------");
		}
	}
	
	public void createTest() throws ClassNotFoundException, SQLException {
		Employee emp = new Employee("hitesh","mumbai",8);
		ed.createEmployee(emp);
		ResultSet rs = DBAdmin.getConnection().createStatement().executeQuery("select empid from employee where salary = 8");
		rs.next();
		id = rs.getLong("empid");
	}
	
	public void updateTest() throws ClassNotFoundException, SQLException{
		Employee emp = new Employee(id,"hitesh","mumbai",108);
		ed.updateEmployee(emp);
	}
	
	public void deleteTest() throws ClassNotFoundException, SQLException{
		ed.deleteEmployee(id);
	}
}
