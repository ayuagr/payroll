package com.payroll.tests;

import com.payroll.dao.AccountDAO;
import com.payroll.dao.DBAdmin;
import com.payroll.pojo.Account;
import com.payroll.pojo.Employee;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Service
public class AccTest {

	@Autowired
	AccountDAO ac;

	@Autowired
	DBAdmin dbAdmin;

	long id;

	public void crudTest() throws ClassNotFoundException, SQLException{
		System.out.println("------------------------------");
		System.out.println("Testing CRUD OPS");
		System.out.println("Testing create");
		createTest();
		System.out.println("Testing update");
		updateTest();
		System.out.println("Testing get");
		getTest();
		System.out.println("Testing delete");
		deleteTest();
		System.out.println("Testing getAll");
		getAllTest();
		System.out.println("------------------------------");
	}

	public void getTest() throws ClassNotFoundException, SQLException{
		Account acc = ac.getAccount(id);
		Assert.assertEquals(acc.getaccno(),100420);
		Assert.assertEquals(acc.getbank(),"hdfc indore");
		Assert.assertEquals(acc.getemp().getEmpid(),1);
	}

	public void getAllTest() throws ClassNotFoundException, SQLException{
		System.out.println("------------------------------");
		System.out.println("Testing getAll");
		List<Account> accounts = ac.getAll();
		for(int i = 0; i < accounts.size() ; i++){
			Account acc = accounts.get(i);
			System.out.println(acc);
			System.out.println("-------------------");
		}
	}
	
	public void createTest() throws ClassNotFoundException, SQLException {
		Account acc = new Account("hdfc mumbai",100420,new Employee(1,null,null,0));
		ac.createAccount(acc);
		ResultSet rs = dbAdmin.getConnection().createStatement().executeQuery("select accid from account where acc_no=100420");
		rs.next();
		id = rs.getLong("accid");
	}

	public void updateTest() throws ClassNotFoundException, SQLException{
		Account acc = new Account(id,"hdfc indore",100420,new Employee(1,null,null,0));
		ac.updateAccount(acc);
	}


	public void deleteTest() throws ClassNotFoundException, SQLException{
		ac.deleteAccount(id);
	}
}
