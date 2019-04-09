package com.payroll.tests;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

import com.payroll.dao.AttendanceDAO;
import com.payroll.pojo.Attendance;
import com.payroll.pojo.Employee;

public class AttTest {
	AttendanceDAO at = new AttendanceDAO();
	public static void main(String[] args) throws Exception{
		AttTest obj = new AttTest();
		obj.getByDate();
		obj.updateTest();
		System.out.println("updated");
		obj.getByDate();
		obj.deleteTest();
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
		Attendance att = new Attendance(Date.valueOf("2019-12-23"),6,new Employee(2,null,null,0));
		at.createAtt(att);
	}
	
	public void updateTest() throws Exception {
		Attendance att = new Attendance(2,Date.valueOf("2019-12-26"),6,new Employee(2,null,null,0));
		at.updateAtt(att);
	}
	
	public void deleteTest() throws ClassNotFoundException, SQLException{
		at.deleteAtt(3);
	}
}
