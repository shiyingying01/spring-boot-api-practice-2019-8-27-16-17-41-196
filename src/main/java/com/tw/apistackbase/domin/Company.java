package com.tw.apistackbase.domin;

import java.util.List;

public class Company {
	private int id;
	private String companyName;
	private int employeesNumber;
	private List<Employee> employees;

	public Company() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Company(int id,String companyName, int employeesNumber, List<Employee> employees) {
		this.id = id;
		this.companyName = companyName;
		this.employeesNumber = employeesNumber;
		this.employees = employees;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyname(String companyName) {
		this.companyName = companyName;
	}

	public int getEmployeesNumber() {
		return employeesNumber;
	}

	public void setEmployeesNumber(int employeesNumber) {
		this.employeesNumber = employeesNumber;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	

}
