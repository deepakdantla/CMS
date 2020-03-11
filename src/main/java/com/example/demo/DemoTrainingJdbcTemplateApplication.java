package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.dao.CustomerDAOImpl;
import com.example.dao.EmployeeDAOImpl;
import com.example.dto.Customer;
import com.example.dto.Employee;

@EnableWebMvc
@SpringBootApplication
public class DemoTrainingJdbcTemplateApplication {

	public static void main(String[] args) {
		// SpringApplication.run(DemoTrainingKoeingJdbcTemplateApplication.class, args);

		/* ApplicationContext context = SpringApplication.run(AppConfig.class, args); */

		SpringApplication.run(AppConfig.class, args);
		/*
		 * // remaining code will write after the break
		 * 
		 * // perform operation @Employee
		 * 
		 * EmployeeDAOImpl employeeJDBCTemplate =
		 * context.getBean(EmployeeDAOImpl.class);
		 * 
		 * // method call here
		 * 
		 * runEmployeeCRUD(employeeJDBCTemplate);
		 * 
		 * CustomerDAOImpl customerJDBCTemplate =
		 * context.getBean(CustomerDAOImpl.class);
		 * runCustomerCRUD(customerJDBCTemplate);
		 */

	}

	/*
	 * private static void runCustomerCRUD(CustomerDAOImpl customerJDBCTemplate) {
	 * // create the customer data
	 * 
	 * customerJDBCTemplate.setupDB();
	 * 
	 * System.out.println("-----===-------------===------------------===========");
	 * customerJDBCTemplate.create("Deepak", 21);
	 * customerJDBCTemplate.create("Barath", 21); customerJDBCTemplate.create("Sai",
	 * 19); customerJDBCTemplate.create("deepak", 19);
	 * 
	 * System.out.println("-------Records Creation---------"); List<Customer>
	 * customers = customerJDBCTemplate.listCustomers();
	 * 
	 * for (Customer record : customers) { System.out.println("ID : " +
	 * record.getId()); System.out.println("ID : " + record.getName());
	 * System.out.println("ID : " + record.getAge()); } }
	 * 
	 * public static void runEmployeeCRUD(EmployeeDAOImpl employeeJDBCTemplate) {
	 * 
	 * // create the employee data
	 * 
	 * employeeJDBCTemplate.setupDB();
	 * 
	 * System.out.println("------Records Creation--------");
	 * employeeJDBCTemplate.create("deepaksingh", 21);
	 * employeeJDBCTemplate.create("barathsingh", 20);
	 * employeeJDBCTemplate.create("saisingh", 19);
	 * 
	 * System.out.println("------Listing Multiple Records--------"); List<Employee>
	 * employees = employeeJDBCTemplate.listEmployees(); for (Employee record :
	 * employees) { System.out.print("ID : " + record.getId());
	 * System.out.print(", Name : " + record.getName());
	 * System.out.println(", Age : " + record.getAge()); }
	 * 
	 * System.out.println("----Updating Record with ID = 2 -----");
	 * employeeJDBCTemplate.update(2, 30);
	 * 
	 * 
	 * System.out.println("----Listing Record with ID = 2 -----"); Employee employee
	 * = employeeJDBCTemplate.getEmployee(2); System.out.print("ID : " +
	 * employee.getId()); System.out.print(", Name : " + employee.getName());
	 * System.out.println(", Age : " + employee.getAge());
	 * 
	 * 
	 * }
	 */
}
