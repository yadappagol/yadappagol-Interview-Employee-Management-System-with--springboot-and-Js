package com.example.interview;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bluetree.employeemangementsystem.entity.Employee;
import com.bluetree.employeemangementsystem.repository.EmployeeRepository;

@SpringBootTest
class EmployeeManaagementApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	void testAddEmployee() {
		Employee employee = new Employee();
		employee.setEmployeeId(1L);
		employee.setEmployeeName("Dundappa");
		employee.setEmployeeMailId("dby@gmail.com");
		employee.setEmployeeSalary(15000.0);
		
		employeeRepository.save(employee);
		assertNotNull(employeeRepository.findById(1L).get());

	}
}
