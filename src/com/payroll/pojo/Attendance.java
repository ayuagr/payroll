package com.payroll.pojo;

import java.util.Date;

public class Attendance {
	private long attid;
	private Date date;
	private int hours;
	private Employee employee;
	
	public Attendance(long attid,Date date, int hours, Employee employee) throws Exception{
		if(hours < 0 || hours > 24 ) throw new Exception("kuch bhi entry mt dal");
		this.attid = attid;
		this.date = date;
		this.hours = hours;
		this.employee = employee;
	}
	
	public Attendance(Date date, int hours, Employee employee) throws Exception{
		if(hours < 0 || hours > 24 ) throw new Exception("kuch bhi entry mt dal");
		this.date = date;
		this.hours = hours;
		this.employee = employee;
	}
	
	public long getAttid(){
		return attid;
	}
	
	public Date getDate(){
		return date;
	}
	
	public int getHours(){
		return hours;
	}
	
	public Employee getEmp(){
		return employee;
	}
	
	@Override
	public String toString(){
		return employee + "\nAttendance ID : " + attid + "\nDate : " + date + "    Hours : " + hours ;
	}
}
