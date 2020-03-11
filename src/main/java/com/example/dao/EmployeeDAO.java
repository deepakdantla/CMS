package com.example.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.example.dto.Employee;

public interface EmployeeDAO {
	public void create(String name, Integer age);

	public Employee getEmployee(Integer id);

	public List<Employee> listEmployees();

	public void delete(Integer id);

	public void update(Integer id, Integer age);
}
