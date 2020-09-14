package com.itorg.rest.webservices.demoHateoas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

public class EmployeeList extends RepresentationModel implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Employee> employees = new ArrayList<Employee>();
	
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}	
}
