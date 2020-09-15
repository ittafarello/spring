package com.itorg.rest.webservices.demoHateoas.api;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itorg.rest.webservices.demoHateoas.dao.EmployeeDB;
import com.itorg.rest.webservices.demoHateoas.model.Employee;
import com.itorg.rest.webservices.demoHateoas.model.EmployeeList;
import com.itorg.rest.webservices.demoHateoas.model.EmployeeReport;

@RestController
public class EmployeeRESTController {
	
	@GetMapping("/employees")
	public EmployeeList getAllEmployees() {
		EmployeeList employeesList  = new EmployeeList();
		for(Employee employee : EmployeeDB.getEmployeeList()) {
			
			ResponseEntity<Employee> methodLink1 = methodOn(EmployeeRESTController.class)
					.getEmployeById(employee.getEmployeeId());
			
			Link link = linkTo(methodLink1)
					.withRel("employee");
			
			employee.add(link);
			
			
			ResponseEntity<EmployeeReport> methodLink = methodOn(EmployeeRESTController.class)
					.getReportByEmployeById(employee.getEmployeeId());
			
			link = linkTo(methodLink)
					.withRel("employee-report");
			
			employee.add(link);
			
			employeesList.getEmployees().add(employee);
		}
		
		Link link = linkTo(methodOn(EmployeeRESTController.class)
				.getAllEmployees())
				.withSelfRel();
		
		employeesList.add(link);
		
		
		return employeesList;
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeById(@PathVariable("id") int id ){
		if (id <3) {
			Employee employee = EmployeeDB.getEmployeeList().get(id-1);
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		}
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/employee/{id}/report")
	public ResponseEntity<EmployeeReport> getReportByEmployeById(@PathVariable("id") int id ){
		return null;
	}
	
}
