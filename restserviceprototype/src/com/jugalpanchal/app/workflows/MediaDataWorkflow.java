package com.jugalpanchal.app.workflows;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

public class MediaDataWorkflow {

	/**
	 * Convert InputStream to byte array.
	 */
	public byte[] convertToByteArray(InputStream uploadedInputStream)
			throws Exception {
		byte[] genericBlob = null;
		try {
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			int nRead;
			byte[] data = new byte[16384];
			while ((nRead = uploadedInputStream.read(data, 0, data.length)) != -1) {
				buffer.write(data, 0, nRead);
			}
			buffer.flush();
			genericBlob = buffer.toByteArray();
		} catch (Exception ex) {
			throw ex;
		}
		return genericBlob;
	}

	//As input - new File("D:/ClientExample/Albert.png");
	public byte[] convertToByte(File fileToUpload) throws IOException {
		try {
			// URL url = new URL("https://google.com/images/Jersey_yellow.png");
			// BufferedImage bi = ImageIO.read(url);
			
			BufferedImage bi = ImageIO.read(fileToUpload);
			ByteArrayOutputStream bas = new ByteArrayOutputStream();
			ImageIO.write(bi, "png", bas);
			return bas.toByteArray();
		} catch (Exception ex) {
			throw ex;
		}
	}

	public void saveToFile(InputStream uploadedInputStream, String uploadedFileLocation) throws Exception {

		try {
			int read = 0;
			byte[] bytes = new byte[1024];

			OutputStream out = new FileOutputStream(new File(
					uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (Exception ex) {
			throw ex;
		}
	}
}
