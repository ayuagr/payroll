package com.payroll.tests;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

import com.payroll.dao.AttendanceDAO;
import com.payroll.dao.DBAdmin;
import com.payroll.pojo.Attendance;
import com.payroll.pojo.Employee;
import org.junit.BeforeClass;
import org.junit.Test;

public class AttTest {

	static AttendanceDAO at;
	static long id;

	@BeforeClass
	public static void setup(){
		System.out.println("======================================");
		System.out.println("Testing ATTENDANCE DAO");
		at = new AttendanceDAO();
	}

	@Test
	public void crudTest() throws Exception{
		System.out.println("------------------------------");
		System.out.println("Testing CRUD OPS");
		System.out.println("Testing create");
		createTest();
		System.out.println("Testing update");
		updateTest();
		System.out.println("Testing get");
		getByID();
		getByDate();
		getByIDAndDate();
		System.out.println("Testing delete");
		deleteTest();
	}
	
	public void getByID() throws Exception{
		List<Attendance> att = at.getAttById(1);
		for(int i = 0; i < att.size() ; i++){
			Attendance attendance = att.get(i);
			System.out.println(attendance);
			System.out.println("-------------------");
		}
	}


	public void getByDate() throws Exception{
		Date d1 = Date.valueOf("2019-12-22");
		System.out.println(d1);
		Date d2 = Date.valueOf("2019-12-25");
		List<Attendance> att = at.getAttByDate(d1,d2);
		for(int i = 0; i < att.size() ; i++){
			Attendance attendance = att.get(i);
			System.out.println(attendance);
			System.out.println("-------------------");
		}	
	}
	
	public void getByIDAndDate() throws Exception{
		Date d1 = Date.valueOf("2019-12-22");
		System.out.println(d1);
		Date d2 = Date.valueOf("2019-12-25");
		List<Attendance> att = at.getAttByDateAndEmp(d1, d2, 1);
		for(int i = 0; i < att.size() ; i++){
			Attendance attendance = att.get(i);
			System.out.println(attendance);
			System.out.println("-------------------");
		}
	}
	
	public void createTest() throws Exception {
		Attendance att = new Attendance(Date.valueOf("1800-12-23"),6,new Employee(2,null,null,0));
		at.createAtt(att);
		ResultSet rs = DBAdmin.getConnection().createStatement().executeQuery("select attid from attendance where date='1800-12-23'");
		rs.next();
		id = rs.getLong("attid");

	}
	
	public void updateTest() throws Exception {
		Attendance att = new Attendance(id,Date.valueOf("2019-12-26"),6,new Employee(2,null,null,0));
		at.updateAtt(att);
	}
	
	public void deleteTest() throws ClassNotFoundException, SQLException{
		at.deleteAtt(id);
	}
}
