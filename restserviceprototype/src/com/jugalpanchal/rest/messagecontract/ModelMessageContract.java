package com.jugalpanchal.rest.messagecontract;

public class ModelMessageContract extends MessageContract {
	private String name;
	private CompanyMessageContract company;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CompanyMessageContract getCompany() {
		return company;
	}
	public void setCompany(CompanyMessageContract company) {
		this.company = company;
	}
}
