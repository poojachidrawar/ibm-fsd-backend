package com.java.spring.core.autowire.xmlconfig;

import java.time.LocalDate;
import java.util.List;


public class Employee {
	int id;
	String name;
	LocalDate dob;
	String designation;
	double salary;
	List skills;
	
	Address address;
	boolean fulltime;
	
	//AddressEx adr = new AddressEx();
	
//	public Employee(int id, String name, Address address ) {
//		this.id = id;
//		this.name = name;
//	    this.address = address;
//	}
    public Employee() {
    	
    }
    public Employee(Address address) {
    	this.address= address;
    }
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDesignation() {
		return designation;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public List getSkills() {
		return skills;
	}
	
	public void setSkills(List skills) {
		this.skills = skills;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public boolean isFulltime() {
		return fulltime;
	}
	
	public void setFulltime(boolean fulltime) {
		this.fulltime = fulltime;
	}
	
	
	public void printDetails() {
		System.out.println("Employee details are :\n");
		//System.out.format("Id\t Name\t DOB\t Designation\t Salary\t Skills\t Fulltime\t Address\t \n\n");
		
		System.out.println("id :"+getId());
		System.out.println("name :"+getName());
		System.out.println("dob :"+getDob());
		System.out.println("designation :"+getDesignation());
		System.out.println("salary :"+getSalary());
		System.out.println("skills :"+getSkills());
		System.out.println("fulltime :"+isFulltime());
		System.out.println("address :"+address);
		
		//System.out.format("%d\t %s\t %s\t %s\t %s\t %s\t %s\t %s\t", id,name,dob,designation,salary,skills,fulltime,address);
		
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
}
