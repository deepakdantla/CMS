package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.EmployeeDAOImpl;
import com.example.dto.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAOImpl employeeDaoImpl;

	@Override
	public void createEmployeeService(String name, Integer age) {
		employeeDaoImpl.create(name, age);

	}

	@Override
	public Employee getEmployeeService(Integer id) {
		return employeeDaoImpl.getEmployee(id);
		
	}

	@Override
	public List<Employee> listEmployeesService() {
		return employeeDaoImpl.listEmployees();
	}

	@Override
	public void deleteEmployeeService(Integer id) {
		employeeDaoImpl.delete(id);

	}

	@Override
	public void updateEmployeeService(Integer id, Integer age) {
		employeeDaoImpl.update(id, age);

	}
	
	public void setUpDb() {
		
	}

}
