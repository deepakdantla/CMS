package com.example.rest;

import java.util.List;

//import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.CustomerMapper;
import com.example.dao.EmployeeDAOImpl;
import com.example.dto.Customer;
//import javax.ws.rs.core.MediaType;
@RestController
public class CustomerController
{
Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplateObject;
	//@Override
//	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/details")
//	@ResponseBody
	@GetMapping("/customers")
	public List<Customer> listCustomer()
	{
		String SQL="select * from customer";
		List<Customer> customers=jdbcTemplateObject.query(SQL, new CustomerMapper());
		logger.debug("in debug");
		// TODO Auto-generated method stub
		return customers;
	}
	
	
	

}
