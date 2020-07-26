package com.form.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Employee {
	@NotNull
	@Size(min=5,message = "is required.")
	private String name;
	@Min(value=1,message="Value should be above 0")
    private long id;
	@NotNull
	@Size(min=5,message = "is required.")
    private String contactNumber;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, long id, String contactNumber) {
		super();
		this.name = name;
		this.id = id;
		this.contactNumber = contactNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	
}
