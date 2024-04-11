package com.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.entity.EmployeeTaxDeduction;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee addEmployee(Employee employee) {

		validateEmployee(employee);

		return employeeRepository.save(employee);
	}

	public List<EmployeeTaxDeduction> calculateTaxDeductionForCurrentFinancialYear() {

		List<Employee> employees = employeeRepository.findAll();
		List<EmployeeTaxDeduction> deductions = new ArrayList<>();
		for (Employee employee : employees) {

			EmployeeTaxDeduction deduction = calculateTaxDeduction(employee);
			deductions.add(deduction);
		}
		return deductions;
	}

	private EmployeeTaxDeduction calculateTaxDeduction(Employee employee) {

		return null;
	}

	private void validateEmployee(Employee employee) {
		if (employeeRepository.existsByEmail(employee.getEmail())) {
			throw new IllegalArgumentException("Email already exists");
		}

	}

}