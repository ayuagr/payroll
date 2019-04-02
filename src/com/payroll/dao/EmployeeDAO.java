package com.payroll.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.payroll.pojo.Employee;

public class EmployeeDAO {
		
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/payroll","root","1234");
		return conn;
	}
	
	public void createEmployee(Employee emp) throws ClassNotFoundException, SQLException{
		Connection conn = getConnection();
		PreparedStatement stmt = conn.prepareStatement("insert into employee(name,address,salary) values (?,?,?)");
		stmt.setString(1, emp.getName());
		stmt.setString(2, emp.getAddrs());
		stmt.setDouble(3, emp.getSalary());
		stmt.execute();
	}
	
	public Employee getEmployee(long id) throws ClassNotFoundException, SQLException{
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from employee where empid = "+ id);
		rs.next();
		long empid = rs.getLong("empid");
		String name = rs.getString("name");
		String address = rs.getString("address");
		double salary = rs.getDouble("salary");
		Employee empData = new Employee(empid,name,address,salary);
		return empData;
	}
	
	public List<Employee> getAll() throws ClassNotFoundException, SQLException{
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from employee");
		List<Employee> employees = new ArrayList<Employee>();
		while(rs.next()){
			long empid = rs.getLong("empid");
			String name = rs.getString("name");
			String address = rs.getString("address");
			double salary = rs.getDouble("salary");
			Employee emp = new Employee(empid,name,address,salary);
			employees.add(emp);
		}
		return employees;
	}
	
	public void updateEmployee(Employee emp) throws ClassNotFoundException, SQLException{
		Connection conn = getConnection();
		PreparedStatement stmt = conn.prepareStatement("update employee set name=?,address=?,salary=? where empid=?");
		stmt.setString(1, emp.getName());
		stmt.setString(2, emp.getAddrs());
		stmt.setDouble(3, emp.getSalary());
		stmt.setLong(4, emp.getEmpid());
		stmt.execute();
	}
	
	public void deleteEmployee(long id) throws ClassNotFoundException, SQLException{
		Connection conn = getConnection();
		PreparedStatement stmt = conn.prepareStatement("delete from employee where empid = ?");
		stmt.setLong(1,id);
		stmt.execute();
	}
	
}