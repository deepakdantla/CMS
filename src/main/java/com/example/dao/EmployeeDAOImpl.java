package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.Employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	// create the reference of logger here

	Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);

	// DI injection of JDBCTemplate

	@Autowired
	private JdbcTemplate jdbcTemplateObject;

	public void setupDB() {

		jdbcTemplateObject.execute("DROP TABLE IF EXISTS employee ");

		jdbcTemplateObject.execute("CREATE TABLE employee" + "(" + "name VARCHAR(255), age INT, id SERIAL)");
	}

	@Override
	@Transactional
	public void create(String name, Integer age) {
		// TODO Auto-generated method stub

		String SQL = "insert into employee (name, age) values (?, ?)";

		jdbcTemplateObject.update(SQL, name, age);
		// System.out.println("Created Record Name = " + name + " Age = " + age);
		logger.debug("Created Record Name = " + name + " Age = " + age);

		return;

	}

	@Override
	public Employee getEmployee(Integer id) {
		// TODO Auto-generated method stub

		String SQL = "select * from employee where id = ?";
		Employee employee = jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new EmployeeMapper());
		logger.debug("value", jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new EmployeeMapper()));
		logger.debug("value of emp->>" + employee.toString());

		return employee;
	}

	@Override

	public List<Employee> listEmployees() {
		// TODO Auto-generated method stub
		String SQL = "select * from employee";
		List<Employee> employees = jdbcTemplateObject.query(SQL, new EmployeeMapper());
		logger.debug("in debug");
		return employees;
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		// TODO Auto-generated method stub

		/*
		 * String SQL = "delete from employee where id = ?";
		 * logger.debug("In Dao  class delete method"); jdbcTemplateObject.update(SQL,
		 * id); // System.out.println("Deleted Record with ID = " + id );
		 * logger.debug("Deleted Record with ID = " + id); return;
		 */
		
		String sql="DELETE from employee where id=?;";
		logger.debug("In DAO class delete method");
		jdbcTemplateObject.update(sql, id);
		logger.debug("After deleting in DAO CLass");

	}

	@Override
	@Transactional
	public void update(Integer id, Integer age) {
		// TODO Auto-generated method stub
		String SQL = "update employee set age = ? where id = ?";
		jdbcTemplateObject.update(SQL, age, id);
		// System.out.println("Updated Record with ID = " + id );
		logger.debug("Updated Record with ID = " + id);
		return;
	}

}