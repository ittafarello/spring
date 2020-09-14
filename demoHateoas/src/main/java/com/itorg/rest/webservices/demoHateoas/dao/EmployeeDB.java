package com.itorg.rest.webservices.demoHateoas.dao;

import java.util.ArrayList;
import java.util.List;

import com.itorg.rest.webservices.demoHateoas.model.Employee;

public class EmployeeDB {
	public static List<Employee> getEmployeeList() {
		List<Employee> list = new ArrayList<>();
		
		Employee emp01 = new Employee(1,"Itamar","Tafarello","itamartafarello@gmail.com");
		Employee emp02 = new Employee(2,"Antonio","Tafarello","atafarello@gmail.com");
		Employee emp03 = new Employee(3,"Ismar","Tafarello","istafarello@gmail.com");
		
		list.add(emp01);
		list.add(emp02);
		list.add(emp03);
		
		return list;	
	}
}
