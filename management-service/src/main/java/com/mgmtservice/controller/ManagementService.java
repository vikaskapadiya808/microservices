package com.mgmtservice.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.employee.dto.Employee;

@RestController
@RequestMapping("/management")
public class ManagementService {

	private static final Logger LOGGER = Logger.getLogger(ManagementService.class.getName());

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployee() {
		LOGGER.log(Level.INFO, "invoking the employee service ");

		HttpHeaders headers = new HttpHeaders();
		headers.add("content-type", MediaType.APPLICATION_JSON_VALUE);

		return restTemplate.exchange("http://localhost:8086/api/employee", HttpMethod.GET,
				new HttpEntity<String>(headers), Employee.class).getBody();

	}

}
