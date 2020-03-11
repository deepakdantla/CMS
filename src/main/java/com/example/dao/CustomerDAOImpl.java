package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private JdbcTemplate jdbcTemplateObject;
	
	public void setupDB() {
		
		jdbcTemplateObject.execute("DROP TABLE IF EXISTS customer ");
		
		jdbcTemplateObject.
		execute("CREATE TABLE customer"
				+ "(" + "name VARCHAR(255), age INT, id SERIAL)");
	}

	@Override
	@Transactional
	public void create(String name, Integer age) {

		String SQL = "insert into customer (name, age) values (?, ?)";

		jdbcTemplateObject.update(SQL, name, age);
		System.out.println("Created Record Name = " + name + " Age = " + age);

		return;

	}

	@Override
	public Customer getCustomer(Integer id) {
		String SQL = "select * from customer where id = ?";
		Customer customer = jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new CustomerMapper());
		return customer;
	}

	@Override
	public List<Customer> listCustomers() {
		String SQL = "select * from customer";
		List<Customer> customers = jdbcTemplateObject.query(SQL, new CustomerMapper());
//	    	      logger.debug("in debug");
		return customers;
	}

	@Override
	@Transactional
	public void delete(Integer id) {

		String SQL = "delete from customer where id = ?";
		jdbcTemplateObject.update(SQL, id);
	}

	@Override
	@Transactional
	public void update(Integer id, Integer age) {

		String SQL = "update customer set age ? where id = ?";
		jdbcTemplateObject.update(SQL, age, id);
		return;
	}

}
