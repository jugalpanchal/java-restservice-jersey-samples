package com.jugalpanchal.rest.messagecontract;

import java.util.Date;

public class MediaData {
	
	private byte[] genericBlob;
	private String type;
	private String extension;

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
