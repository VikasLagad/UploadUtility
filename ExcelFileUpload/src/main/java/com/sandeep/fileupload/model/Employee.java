package com.sandeep.fileupload.model;

public class Employee {
	private int id;
	private String name;
	private String department;
	private String phone;
	
	public Employee() {
		
	}

	public Employee(int id, String name, String department, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.phone = phone;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", phone=" + phone + "]";
	}

	
}
