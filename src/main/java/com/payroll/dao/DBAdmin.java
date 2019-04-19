package com.payroll.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBAdmin {

	private Connection conn = null;

	public DBAdmin(String dbname){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("db driver error");
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/" + dbname,"root","1234");
		} catch (SQLException e) {
			System.out.println("db connection error");
			e.printStackTrace();
		}		
	}

	public Connection getConnection() {
		return conn;
	}
}
