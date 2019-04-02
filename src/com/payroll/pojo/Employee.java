package com.payroll.pojo;

public class Employee {
	private long empid;
	private String name;
	private String address;
	private double salary;

	public String getName(){
		return name;
	}

	public String getAddrs(){
		return address;
	}
	
	public Double getSalary(){
		return salary;
	}
	
	public Employee(long empid, String name, String address, double salary){
		this.empid = empid;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}
	
	public Employee(String name, String address, double salary){
		this.name = name;
		this.address = address;
		this.salary = salary;
	}

	@Override
	public String toString(){
		return "Emp ID : " + empid + "\nname : " + name +"\naddress : " + address + "\nsalary : "+salary;
	}

	public long getEmpid() {
		return empid;
	}
}