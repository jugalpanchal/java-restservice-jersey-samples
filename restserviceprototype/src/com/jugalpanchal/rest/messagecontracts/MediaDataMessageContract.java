package com.jugalpanchal.rest.messagecontracts;

import java.util.Date;

public class MediaDataMessageContract extends MessageContract {
	
	private byte[] genericBlob;
	private String type;
	private String extension;
	
	public MediaDataMessageContract(long id, Date creationDate, Date updationDate, long createdByUser,
			long updatedByUser, boolean isActive, byte[] genericBlob, String type, String extension) {
		super(id, creationDate, updationDate, createdByUser, updatedByUser, isActive);
		this.genericBlob = genericBlob;
		this.type = type;
		this.extension = extension;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public byte[] getGenericBlob() {
		return genericBlob;
	}

	public void setGenericBlob(byte[] genericBlob) {
		this.genericBlob = genericBlob;
	}
}
