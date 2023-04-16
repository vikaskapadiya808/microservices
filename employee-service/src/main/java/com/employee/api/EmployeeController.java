package com.employee.api;

import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	private static final Logger logger = Logger.getLogger(EmployeeController.class.getName());

	@GetMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getAllEmployee() {

		logger.log(Level.INFO, "inside the EmployeeController within fetchEmployee method");

		Employee employee = new Employee();

		employee.setEmployeeId(new SecureRandom().nextInt());
		employee.setEmployeeName("Nishant");
		employee.setContactNo("9876549032");

		return employee;
	}

}
