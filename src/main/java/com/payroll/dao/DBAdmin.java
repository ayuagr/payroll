package com.payroll.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBAdmin {
	public static Connection conn = null;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("db driver error");
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/payroll","root","1234");
		} catch (SQLException e) {
			System.out.println("db connection error");
			e.printStackTrace();
		}		
	}
	public static Connection getConnection() throws ClassNotFoundException, SQLException{		
		return conn;
	}
}
