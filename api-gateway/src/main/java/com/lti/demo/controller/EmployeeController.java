package com.lti.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.demo.model.Employee;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeInterface employeeClient;
	
	@GetMapping("/employee")
	@HystrixCommand(fallbackMethod = "fallBack", commandKey = "fallBack")
	public ResponseEntity<Object> getEmployee() {

		List<Employee> list = employeeClient.getEmployee();
		List<Employee> newList = list.stream().filter(x -> x.getPassword() != null).collect(Collectors.toList());
		return new ResponseEntity<Object>(newList, HttpStatus.OK);
	}
	
	@GetMapping("/port")
	public ResponseEntity<String> getPort() {

		String port = employeeClient.getPort();
		return new ResponseEntity<String>(port, HttpStatus.OK);
	}
	
	
    @SuppressWarnings("unused")
    private ResponseEntity<Object> fallBack() {
 
        return new ResponseEntity<Object>("CIRCUIT BREAKER ENABLED!!! No Response From Employee Service at this moment. " +
                " Service will be back shortly - " + new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
