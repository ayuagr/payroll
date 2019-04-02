package com.payroll.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.payroll.pojo.Account;
import com.payroll.pojo.Employee;

public class AccountDAO {
	
	EmployeeDAO empdao = new EmployeeDAO();
	
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/payroll","root","1234");
		return conn;
	}
	
	public Account getAccount(long id) throws SQLException, ClassNotFoundException{
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from account where empid = " + id);
		rs.next();
		long accid = rs.getLong("accid");
		String bank = rs.getString("bank");
		long acc_no = rs.getLong("acc_no");
		long empid = rs.getLong("empid");
		Employee emp = empdao.getEmployee(empid);
		Account acc = new Account(accid,bank,acc_no,emp);
		return acc;
	
	}
	
	public List<Account> getAll() throws ClassNotFoundException, SQLException{
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from account");
		List<Account> accounts = new ArrayList<Account>();
		while(rs.next()){
			long accid = rs.getLong("accid");
			String bank = rs.getString("bank");
			long acc_no = rs.getLong("acc_no");
			long empid = rs.getLong("empid");
			Employee emp = empdao.getEmployee(empid);
			Account acc = new Account(accid,bank,acc_no,emp);
			accounts.add(acc);
		}
		return accounts;
	}
	
	public void createAccount(Account acc) throws ClassNotFoundException, SQLException{
		Connection conn = getConnection();
		PreparedStatement stmt = conn.prepareStatement("insert into account(bank,acc_no,empid) values (?,?,?)");
		stmt.setString(1, acc.getbank());
		stmt.setLong(2, acc.getaccno());
		stmt.setDouble(3,acc.getemp().getEmpid());
		stmt.execute();
	}
	
	public void updateAccount(Account acc) throws ClassNotFoundException, SQLException{
		Connection conn = getConnection();
		PreparedStatement stmt = conn.prepareStatement("update account set bank = ?,acc_no=?,empid=? where accid=?");
		stmt.setString(1, acc.getbank());
		stmt.setLong(2, acc.getaccno());
		stmt.setDouble(3,acc.getemp().getEmpid());
		stmt.setLong(4, acc.getaccid());
		stmt.execute();
	}
	
	public void deleteAccount(long id) throws ClassNotFoundException, SQLException{
		Connection conn = getConnection();
		PreparedStatement stmt = conn.prepareStatement("delete from account where accid = ?");
		stmt.setLong(1,id);
		stmt.execute();
	}
}
