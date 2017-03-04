package com.jugalpanchal.rest.messagecontract;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class CompanyMessageContract {
	private long id;

	private Date creationDate;
	private Date updationDate;
	//private User createdByUser;
	//private User updatedByUser;
	private boolean isActive;
	private String name;
	//private Collection<Model> models = new ArrayList<Model>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getUpdationDate() {
		return updationDate;
	}
	public void setUpdationDate(Date updationDate) {
		this.updationDate = updationDate;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
