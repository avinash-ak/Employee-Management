package com.crud.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Employee;
import com.crud.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	private EmployeeService empl;
	
	public EmployeeController(EmployeeService empl) {
		this.empl=empl;
	}
	
	@GetMapping("/all")
	public List<Employee> getAllEmployees(){
		return empl.getAllEmployee();
	}
	
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		
		return new ResponseEntity<Employee>(empl.saveEmployee(employee),HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable("id") Integer eid) {
		return empl.getEmployeeById(eid);
	}
	
	@PutMapping("{id}")
	public Employee updateEmployee(@PathVariable("id") Integer id,@RequestBody Employee obj){
		
		return empl.updateEmployee(obj, id);
		
	}

	@DeleteMapping("{id}")
	public void deleteEmployee(@PathVariable("id") Integer id) {
		empl.deleteEmployee(id);
	}
//	@GetMapping("/{id}")
//	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer eid){
//		return new ResponseEntity<Employee>(empl.getEmployeeById(eid),HttpStatus.OK);
//	}
	
//	@PostMapping()
//	public Employee saveEmployee(@RequestBody Employee obj) {
//		return empl.saveEmployee(obj);
//	}
}
