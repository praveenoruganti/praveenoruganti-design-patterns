package com.praveen.designpatterns.creational.builder;

public class Employee {
	//All final attributes
	private final int empId;
	private final String empName;
	private final double empSalary;
	private final String empAddress;

	private Employee(EmployeeBuilder builder) {
		this.empId = builder.empId;
		this.empName = builder.empName;
		this.empSalary = builder.empSalary;
		this.empAddress = builder.empAddress;
	}

	//All getter, and NO setter to provde immutability
	public int getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public static class EmployeeBuilder {
		private int empId;
		private String empName;
		private double empSalary;
		private String empAddress;

		EmployeeBuilder() {

		}

		public EmployeeBuilder empId(int empId) {
			this.empId = empId;
			return this;
		}

		public EmployeeBuilder empName(String empName) {
			this.empName = empName;
			return this;
		}

		public EmployeeBuilder empSalary(double empSalary) {
			this.empSalary = empSalary;
			return this;
		}

		public EmployeeBuilder empAddress(String empAddress) {
			this.empAddress = empAddress;
			return this;
		}
		 //Return the finally constructed  Employee object
		public Employee build() {
			Employee emp = new Employee(this);
			return emp;
		}
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", empAddress="
				+ empAddress + "]";
	}

	public static void main(String args[]) {
		Employee emp = new Employee.EmployeeBuilder().empId(149903).empName("Praveen").empSalary(1000000d)
				.empAddress("Hyderabad").build();
		System.out.println(emp);
	}

}
