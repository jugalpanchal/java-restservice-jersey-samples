package com.jugalpanchal.rest.test;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import com.jugalpanchal.rest.messagecontracts.MediaDataMessageContract;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.multipart.BodyPart;
import com.sun.jersey.multipart.MultiPart;

public class MediaDataTest {

	@Test
	public void getMediaByIdTest() {
		String path = "http://localhost:8080/restserviceprototype/rest/mediadataservice/getmediadata";
		try {

			Client client = Client.create();
			WebResource webResource = client.resource(path + "/2");
			ClientResponse response = webResource.type("application/json").get(ClientResponse.class);

			String mediaDataJson = response.getEntity(String.class);
			// jsonData = jsonData.substring(13, jsonData.length() - 2);

			ObjectMapper mapper = new ObjectMapper();
			MediaDataMessageContract mediaData = mapper.readValue(mediaDataJson, MediaDataMessageContract.class);

			byte[] mediaBlob = mediaData.getGenericBlob();
			ByteArrayInputStream bis = new ByteArrayInputStream(mediaBlob);

			BufferedImage bi = ImageIO.read(bis);
			File file = new File("D:/ClientExample/test.jpg");
			ImageIO.write(bi, "jpg", file);

			// if (response.getStatus() != 200) {
			// response.getStatus()
			// }
		} catch (Exception ex) {
		}
	}

	@Test
	public void uploadImageTest() {
		String path = "http://localhost:8080/restserviceprototype/rest/mediadataservice/uploadmediadata";
		try {
			// ClientBuilder.newBuilder().register(MultiPartFeature.class)
			Client client = Client.create();
			WebResource service = client.resource(path);

			File fileToUpload = new File("D:/ClientExample/Albert.png");
			if (fileToUpload != null) {
				MultiPart multiPart = new MultiPart().bodyPart(new BodyPart("image", MediaType.TEXT_PLAIN_TYPE))
						// type - image or audio
						.bodyPart(new BodyPart("png", MediaType.TEXT_PLAIN_TYPE))
						// ext - image or audio
						.bodyPart(new BodyPart(fileToUpload, MediaType.APPLICATION_OCTET_STREAM_TYPE)); // fileToUpload can be bytes

				ClientResponse response = service.type("multipart/mixed").post(ClientResponse.class, multiPart);
				System.out.println("Response Status : " + response.getEntity(String.class));
			}
			client.destroy();

		} catch (Exception ex) {
		}
	}

	@Test
	public void uploadedImageInInputStreamTest() {
		String BASE_URI = "http://localhost:8080/restserviceprototype/rest/mediadataservice/upload";
		try {
			Client client = Client.create();
			WebResource service = client.resource(BASE_URI);

			InputStream in = service.get(InputStream.class);
			BufferedImage bi = ImageIO.read(in);
			File file = new File("D:/ClientExample/test.jpg");
			ImageIO.write(bi, "jpg", file);
		} catch (Exception ex) {
		}
	}
}
