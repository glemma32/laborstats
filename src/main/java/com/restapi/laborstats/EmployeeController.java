package com.restapi.laborstats;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@RestController
public class EmployeeController {
	Gson gson = new Gson();
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/allEmployees", method = RequestMethod.GET)
	public EmployeeResponse allEmployeesMethod() {

		EmployeeResponse employeeResponse = new EmployeeResponse();
		HttpHeaders headers = new HttpHeaders();
		String url = "http://dummy.restapiexample.com/api/v1/employees";
		HttpEntity<?> entity = new HttpEntity<>(headers);
		ResponseEntity<String> responseEntity = null;
		String response = null;

		try {
			responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
			response = responseEntity.getBody();
			employeeResponse = gson.fromJson(response, EmployeeResponse.class);
		} catch (Exception e) {

		}

		return employeeResponse;
	}

	@RequestMapping(value="/getSingleEmployee",method=RequestMethod.GET)
	public EmployeeInfo getSingleEmployeeMethod(@RequestParam("id") String id) {
		
		EmployeeResponse data = allEmployeesMethod();
		EmployeeInfo employeeInfo = new EmployeeInfo();
		List<EmployeeInfo> listOfEmp = data.getData();
		for(EmployeeInfo temp: listOfEmp)
		{		
			
			if(id.equalsIgnoreCase(temp.getId()) ) {
				return temp;			
		}
		}
		return employeeInfo;
	}

}
