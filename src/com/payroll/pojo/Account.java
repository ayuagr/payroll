package com.payroll.pojo;

public class Account {
	private long accid;
	private String bank;
	private long acc_no;
	private Employee employee;
	
	public long getaccid(){
		return accid;
	}
	
	public String getbank(){
		return bank;
	}
	public long getaccno(){
		return acc_no;
	}
	
	public Employee getemp(){
		return employee;
	}
	
	public Account(long accid,String bank,long acc_no,Employee employee){
		this.accid = accid;
		this.bank = bank;
		this.acc_no = acc_no;
		this.employee = employee;
	}
	
	public Account(String bank,long acc_no,Employee employee){
		this.bank = bank;
		this.acc_no = acc_no;
		this.employee = employee;
	}
	
	@Override
	public String toString(){
		return employee + "\nAccount ID :" + accid + "\nBank : " + bank + "\nAccount number : " + acc_no;
	}
}
