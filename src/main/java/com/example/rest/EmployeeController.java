package com.example.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import com.example.dto.Employee;
import com.example.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	/*
	 * @Autowired private JdbcTemplate jdbcTemplateObject;
	 */

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	@GetMapping("/fetchall")
	public List<Employee> listEmployees() {
		/*
		 * String SQL = "select * from employee"; // List<Employee> employees =
		 * jdbcTemplateObject.query(SQL, new EmployeeMapper());
		 */ List<Employee> employees = employeeServiceImpl.listEmployeesService();
		return employees;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/details/{id}")
	public Employee getEmployee(@PathVariable("id") Integer id) {
		logger.debug("in id fetch", id);
		return employeeServiceImpl.getEmployeeService(id);
	}
	
	
	@RequestMapping( method = RequestMethod.DELETE,  value = "/delete/{id}")
	@ResponseBody
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id)
	{
	try
	{
	employeeServiceImpl.deleteEmployeeService(id);
	return ResponseEntity.ok().build();
	}
	catch(ResourceAccessException e)
	{
	return ResponseEntity.notFound().build();
	}
	}

	/*
	 * @RequestMapping(value="/particularID/{id}",method=RequestMethod.GET) public
	 * Employee getEmployeeById(@PathVariable("id") Integer id) {
	 * logger.debug("Id of employee is **********", id); return
	 * employeeServiceImpl.getEmployeeService(id);
	 * 
	 * }
	 */

	/*
	 * This code is for version 8 and below version of java
	 * 
	 * @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET) public
	 * ResponseEntity getEmployeebyId(@PathVariable("id") Integer id) {
	 * 
	 * Employee employee = employeeServiceImpl.getEmployeeService(id); if (employee
	 * == null) { return new ResponseEntity("No Customer found for ID " + id,
	 * HttpStatus.NOT_FOUND); }
	 * 
	 * return new ResponseEntity(employee, HttpStatus.OK); }
	 */

}
