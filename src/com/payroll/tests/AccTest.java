package com.payroll.tests;

import java.sql.SQLException;
import java.util.List;

import com.payroll.dao.AccountDAO;
import com.payroll.pojo.Account;
import com.payroll.pojo.Employee;

public class AccTest {

	AccountDAO ac = new AccountDAO();
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		AccTest obj = new AccTest();
		obj.getTest();
		System.out.println("create 1");
		obj.createTest();
		System.out.println("create 2");
		obj.createTest();
		System.out.println("new data");
		obj.getAllTest();
		System.out.println("update");
		obj.updateTest();
		System.out.println("new");
		obj.getAllTest();
		System.out.println("delete");
		obj.deleteTest();
		System.out.println("data");
		obj.getAllTest();
		
	}
	
	public void getTest() throws ClassNotFoundException, SQLException{
		Account acc = ac.getAccount(1);
		System.out.println(acc);
	}
	
	public void getAllTest() throws ClassNotFoundException, SQLException{
		List<Account> accounts = ac.getAll();
		for(int i = 0; i < accounts.size() ; i++){
			Account acc = accounts.get(i);
			System.out.println(acc);
			System.out.println("-------------------");
		}
	}
	
	
	public void createTest() throws ClassNotFoundException, SQLException {
		Account acc = new Account("hdfc mumbai",100420,new Employee(2,null,null,0));
		ac.createAccount(acc);
	}
	
	public void updateTest() throws ClassNotFoundException, SQLException{
		Account acc = new Account(3,"hdfc indore",100420,new Employee(2,null,null,0));
		ac.updateAccount(acc);
	}
	
	public void deleteTest() throws ClassNotFoundException, SQLException{
		ac.deleteAccount(4);
	}
}
