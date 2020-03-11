package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dto.Employee;

@Service
public interface EmployeeService {

	public void createEmployeeService(String name, Integer age);

	public Employee getEmployeeService(Integer id);

	public List<Employee> listEmployeesService();

	public void deleteEmployeeService(Integer id);

	public void updateEmployeeService(Integer id, Integer age);
}
