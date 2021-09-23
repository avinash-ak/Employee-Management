package com.crud.service;

import java.util.List;

import com.crud.entity.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee e);
	List<Employee> getAllEmployee();
	Employee getEmployeeById(Integer i);
	Employee updateEmployee(Employee emp,Integer id);
	void deleteEmployee(Integer id);
}
