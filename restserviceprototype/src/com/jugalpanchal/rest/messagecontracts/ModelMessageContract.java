package com.jugalpanchal.rest.messagecontracts;

import java.util.Date;

public class ModelMessageContract extends MessageContract {
	
	private String name;
	private CompanyMessageContract company;
	
	public ModelMessageContract(long id, Date creationDate, Date updationDate, 
			long createdByUser, long updatedByUser, boolean isActive, 
			String name, CompanyMessageContract company) {
		super(id, creationDate, updationDate, createdByUser, updatedByUser, isActive);
		this.name = name;
		this.company = company;
	}
	
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
