package com.payroll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.payroll.pojo.Account;
import com.payroll.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AccountDAO {

    @Autowired
	EmployeeDAO empdao;

    @Autowired
    DBAdmin db;
    public Account getAccount(long id) throws SQLException, ClassNotFoundException{
		Connection conn = db.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from account where accid = " + id);
		rs.next();
		Account acc = createObjectFromRs(rs);
		return acc;
	}
	
    public List<Account> getAll() throws ClassNotFoundException, SQLException{
		Connection conn = db.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from account");
		List<Account> accounts = new ArrayList<Account>();
		while(rs.next()){
			Account acc = createObjectFromRs(rs);
			accounts.add(acc);
		}
		return accounts;
	}

	private Account createObjectFromRs(ResultSet rs) throws SQLException, ClassNotFoundException {
		long accid = rs.getLong("accid");
		String bank = rs.getString("bank");
		long acc_no = rs.getLong("acc_no");
		long empid = rs.getLong("empid");
		Employee emp = empdao.getEmployee(empid);
		return new Account(accid,bank,acc_no,emp);
	}

    public void createAccount(Account acc) throws ClassNotFoundException, SQLException{
		Connection conn = db.getConnection();
		PreparedStatement stmt = conn.prepareStatement("insert into account(bank,acc_no,empid) values (?,?,?)");
		stmt.setString(1, acc.getbank());
		stmt.setLong(2, acc.getaccno());
		stmt.setDouble(3,acc.getemp().getEmpid());
		stmt.execute();
	}
	
    public void updateAccount(Account acc) throws ClassNotFoundException, SQLException{
		Connection conn = db.getConnection();
		PreparedStatement stmt = conn.prepareStatement("update account set bank = ?,acc_no=?,empid=? where accid=?");
		stmt.setString(1, acc.getbank());
		stmt.setLong(2, acc.getaccno());
		stmt.setDouble(3,acc.getemp().getEmpid());
		stmt.setLong(4, acc.getaccid());
		stmt.execute();
	}
	
    public void deleteAccount(long id) throws ClassNotFoundException, SQLException{
		Connection conn = db.getConnection();
		PreparedStatement stmt = conn.prepareStatement("delete from account where accid = ?");
		stmt.setLong(1,id);
		stmt.execute();
	}
}
