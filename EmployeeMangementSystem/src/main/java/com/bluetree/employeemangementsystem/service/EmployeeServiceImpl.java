package com.bluetree.employeemangementsystem.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluetree.employeemangementsystem.entity.Employee;
import com.bluetree.employeemangementsystem.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public boolean addDetails(Employee employee) {
		log.info(employee.toString());
		System.out.println(employee);
		employee.setEmployeeStatus(true);
		Period age = Period.between(employee.getEmployeeDob(), LocalDate.now());
		employee.setEmployeeAge(age.getYears());
		employeeRepository.save(employee);
		return true;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> findAll = employeeRepository.findAll();

//		return findAll.stream().filter(emp -> emp.getEmployeeStatus() == Boolean.TRUE).collect(Collectors.toList());

		/**
		 * for displaying filtered based on location and active employees from the
		 * database with unmodifiable (unchangeable)
		 */
		return findAll.stream().filter((emp -> emp.getEmployeeStatus() == Boolean.TRUE))
				.filter(emp -> emp.getEmployeeLocation().equalsIgnoreCase("Bangalore"))
				.collect(Collectors.toUnmodifiableList());
	}

	@Override
	public Employee getEmployeeById(Long empId) {
		Optional<Employee> findById = employeeRepository.findById(empId);
		if (findById.isPresent()) {
			return findById.get();
		} else {
			throw new RuntimeException("Employee Not Found!!");
		}
	}

	@Override
	public void removeEmployee(Long id) {
		Optional<Employee> findById = employeeRepository.findById(id);
		if (findById.isPresent()) {
			Employee employee = findById.get();
			employee.setEmployeeStatus(false);
			employeeRepository.save(employee);

		}
	}

}
