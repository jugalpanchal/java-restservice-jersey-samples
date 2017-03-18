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

	public byte[] convert(InputStream inputStream) throws IOException {
		byte[] genericBlob = null;
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		int nRead;
		byte[] data = new byte[16384];
		
		while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
			buffer.write(data, 0, nRead);
		}
		buffer.flush();
		genericBlob = buffer.toByteArray();
		return genericBlob;
	}

	public byte[] convert(File fileToUpload) throws IOException {
		// URL url = new URL("https://google.com/images/Jersey_yellow.png");
		// BufferedImage bi = ImageIO.read(url);

		BufferedImage bi = ImageIO.read(fileToUpload);
		ByteArrayOutputStream bas = new ByteArrayOutputStream();
		ImageIO.write(bi, "png", bas);
		return bas.toByteArray();
	}

	public void save(InputStream inputStream, File fileLocation) throws IOException {
		int read = 0;
		byte[] bytes = new byte[1024];

		OutputStream out = new FileOutputStream(fileLocation);
		while ((read = inputStream.read(bytes)) != -1) {
			out.write(bytes, 0, read);
		}
		out.flush();
		out.close();
	}
}