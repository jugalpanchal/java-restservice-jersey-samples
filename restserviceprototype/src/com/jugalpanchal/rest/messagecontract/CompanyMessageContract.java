package com.jugalpanchal.rest.messagecontract;

import java.util.ArrayList;
import java.util.Collection;

public class CompanyMessageContract extends MessageContract {
	private String name;
	private Collection<ModelMessageContract> models = new ArrayList<ModelMessageContract>();
	
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
