package com.restapi.laborstats;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponse {
	
	@JsonProperty("status")
	private String status;
	@JsonProperty("data")
	private List<EmployeeInfo> data;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<EmployeeInfo> getData() {
		return data;
	}
	public void setData(List<EmployeeInfo> data) {
		this.data = data;
	}
	
	

}
