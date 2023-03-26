package com.csi.model;

import java.util.Date;

public class Employee {

	private int empId;

	private String empName;

	private String empAddress;

	private long empContactNumber;

	private int empAge;

	private double empSalary;

	private String empGender;

	private Date empDOB;

	private String empEmailId;

	private String empPassword;

	

	public Employee(int empId, String empName, String empAddress, long empContactNumber, int empAge, double empSalary,
			String empGender, Date empDOB, String empEmailId, String empPassword) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
		this.empContactNumber = empContactNumber;
		this.empAge = empAge;
		this.empSalary = empSalary;
		this.empGender = empGender;
		this.empDOB = empDOB;
		this.empEmailId = empEmailId;
		this.empPassword = empPassword;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public long getEmpContactNumber() {
		return empContactNumber;
	}

	public void setEmpContactNumber(long empContactNumber) {
		this.empContactNumber = empContactNumber;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public String getEmpGender() {
		return empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}

	public Date getEmpDOB() {
		return empDOB;
	}

	public void setEmpDOB(Date empDOB) {
		this.empDOB = empDOB;
	}

	public String getEmpEmailId() {
		return empEmailId;
	}

	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAddress=" + empAddress
				+ ", empContactNumber=" + empContactNumber + ", empAge=" + empAge + ", empSalary=" + empSalary
				+ ", empGender=" + empGender + ", empDOB=" + empDOB + ", empEmailId=" + empEmailId + ", empPassword="
				+ empPassword + "]";
	}

}
