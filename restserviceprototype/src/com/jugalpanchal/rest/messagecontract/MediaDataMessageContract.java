package com.jugalpanchal.rest.messagecontract;

public class MediaDataMessageContract {
	private byte[] genericBlob;
	private String type;
	private String extension;

	public MediaDataMessageContract() {
		
	}
	
	public MediaDataMessageContract(byte[] genericBlob, String type, String extension) {
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
