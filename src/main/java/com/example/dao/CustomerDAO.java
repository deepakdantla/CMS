package com.example.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.example.dto.Customer;

 

public interface CustomerDAO {
	public void create(String name, Integer age);

	public Customer getCustomer(Integer id);

	public List<Customer> listCustomers();

	public void delete(Integer id);

	
	public void update(Integer id, Integer age);
}
