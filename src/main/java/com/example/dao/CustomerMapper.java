package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.dto.Customer;

public class CustomerMapper implements RowMapper<Customer>{

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		  Customer customer = new Customer();
		  customer.setName(rs.getString("name"));
		  customer.setAge(rs.getInt("age"));
	      return customer;
		
	}

}
