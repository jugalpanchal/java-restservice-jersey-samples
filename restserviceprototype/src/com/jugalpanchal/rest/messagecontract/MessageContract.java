package com.jugalpanchal.rest.messagecontract;

import java.util.Date;

public abstract class MessageContract {	
	private long id;
	private Date creationDate;
	private Date updationDate;
	private long createdByUser;
	private long updatedByUser;
	private boolean isActive;

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
	public long getCreatedByUser() {
		return createdByUser;
	}
	public void setCreatedByUser(long createdByUser) {
		this.createdByUser = createdByUser;
	}
	public long getUpdatedByUser() {
		return updatedByUser;
	}
	public void setUpdatedByUser(long updatedByUser) {
		this.updatedByUser = updatedByUser;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
