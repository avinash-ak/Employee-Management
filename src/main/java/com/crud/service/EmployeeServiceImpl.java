package com.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.crud.entity.Employee;
import com.crud.exception.ResourcenotFoundException;
import com.crud.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository emp;
	 
	public EmployeeServiceImpl(EmployeeRepository emp) {
		this.emp=emp;
	}
	
	@Override
	public Employee saveEmployee(Employee e) {
		return emp.save(e);
	}
	public List<Employee> getAllEmployee(){
		return emp.findAll();
	}
	
	public Employee getEmployeeById(Integer i) {
//		Optional<Employee> e=emp.findById(i);
//		if(e.isPresent()) {
//			return e.get();
//		}
//		else {
//			throw new ResourcenotFoundException("Employee","Id",i);
//		}
//	}
		return emp.findById(i).orElseThrow(()-> new ResourcenotFoundException("Employee","Id",i));
	}

	@Override
	public Employee updateEmployee(Employee employee, Integer id) {
		//check employee with given id exists or not
		Employee existingEmployee=emp.findById(id).orElseThrow(
				()->new ResourcenotFoundException("Employee","Id",id)
				);
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setId(employee.getId());
		emp.save(existingEmployee);
		return existingEmployee;
				
	}

	@Override
	public void deleteEmployee(Integer id) {
		emp.findById(id).orElseThrow(()->
		new ResourcenotFoundException("Employee","Id",id));
		 emp.deleteById(id);
		
	}
	
}
