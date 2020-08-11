package com.lti.demo.controller;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;

import com.lti.demo.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient("BOOT-MONGODB")
@RibbonClient("BOOT-MONGODB")
public interface EmployeeInterface {
	
	@GetMapping("employee")
	public List<Employee> getEmployee();
	
	@GetMapping("port")
	public String getPort();
}
