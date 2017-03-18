package com.jugalpanchal.rest.messagecontracts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class CompanyMessageContract extends MessageContract {

	private String name;
	private Collection<ModelMessageContract> models = new ArrayList<ModelMessageContract>();

	public CompanyMessageContract(long id, Date creationDate, Date updationDate, 
			long createdByUser, long updatedByUser, boolean isActive, 
			String name, Collection<ModelMessageContract> models) {
		super(id, creationDate, updationDate, createdByUser, updatedByUser, isActive);
		this.name = name;
		this.models = models;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Collection<ModelMessageContract> getModels() {
		return models;
	}
	
	public void setModels(Collection<ModelMessageContract> models) {
		this.models = models;
	}
}