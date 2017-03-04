package com.jugalpanchal.rest.resources;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jugalpanchal.rest.messagecontract.MediaData;
import com.sun.jersey.core.header.ContentDisposition;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.BodyPart;
import com.sun.jersey.multipart.BodyPartEntity;
import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.FormDataParam;
import com.sun.jersey.multipart.MultiPart;

@Path("/mediadataservice")
public class MediaDataWorkflowResource {

	@GET
	@Path("/getmediadata/{mediadataid}")
	@Produces(MediaType.APPLICATION_JSON)
	public MediaData getMediaDataById(@PathParam("mediadataid") long mediaDataId) throws Exception {
		try {

			MediaData mediaData = null;
			return mediaData;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response uploadMediaData(MediaData mediaData) throws Exception {
		try {
			return Response.status(200).entity("").build();

		} catch (Exception ex) {
			throw ex;
		}
	}

	@POST
	@Path("/uploadmediadata")
	@Consumes("multipart/mixed")
	public Response uploadMediaData(MultiPart multiPart) throws Exception {
		try {
			BodyPart typePart = multiPart.getBodyParts().get(0);
			String mediaType = typePart.getEntityAs(String.class);

			BodyPart extPart = multiPart.getBodyParts().get(1);
			String mediaExt = extPart.getEntityAs(String.class);

			BodyPart blobPart = multiPart.getBodyParts().get(2);
			BodyPartEntity blobPartEntity = (BodyPartEntity) blobPart
					.getEntity();

			InputStream uploadedInputStream = blobPartEntity.getInputStream();

			/*MediaDataWorkflow workflow = new MediaDataWorkflow();
			byte[] genericBlob = workflow.convertToByteArray(uploadedInputStream);
			MediaData mediaData = new MediaData(null, 0L, genericBlob,
					mediaType, mediaExt);
			long id = workflow.saveMediaData(mediaData);*/

			multiPart.cleanup();
			return Response.status(200).entity("" + 0).build();

		} catch (Exception ex) {
			throw ex;
		}
	}
	
	/* name="file" must be same in HTML */
	// Final upload single image
	@POST
	@Path("/uploadmediadatafile")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadMediaData(
			@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail,
			@FormDataParam("type") String type, @FormDataParam("ext") String ext)
			throws Exception {
		try {
			String fileName = fileDetail.getFileName();
			String mediaType = type;
			String mediaExt = ext;

			/*MediaDataWorkflow workflow = new MediaDataWorkflow();
			byte[] genericBlob = workflow.convertToByteArray(uploadedInputStream);
			MediaData mediaData = new MediaData(null, 0L, genericBlob, mediaType, mediaExt);
			long id = workflow.saveMediaData(mediaData);*/

			return Response.status(200).entity("" + 0).build();
		} catch (Exception ex) {
			throw ex;
		}
	}

	// uploading multiple images

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Path("/multipleFiles")
	public Response uploadMediaData(
			@FormDataParam("files[]") List<FormDataBodyPart> files)
			throws Exception {

		String ids = null;
		for (FormDataBodyPart formDataBodyPart : files) {

			ContentDisposition headerOfFilePart = formDataBodyPart
					.getContentDisposition();
			InputStream uploadedInputStream = formDataBodyPart
					.getValueAs(InputStream.class);

			String fileName = headerOfFilePart.getFileName();

			/*MediaDataWorkflow workflow = new MediaDataWorkflow();
			byte[] genericBlob = workflow.convertToByteArray(uploadedInputStream);
			MediaData mediaData = new MediaData(null, 0L, genericBlob, null, null);
			long id = workflow.saveMediaData(mediaData);*/
		}
		return Response.status(200).entity("" + ids).build();

	}

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/multipleFiles1")
	public String uploadMediaData(FormDataMultiPart formParams) {
		formParams.getFields();

		for (BodyPart bodyPart : formParams.getBodyParts()) {

		}
		return null;
	}

	@POST
	@Path("/uploadmultiplemediadatafile")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	String uploadMediaData(
			@FormDataParam("file") InputStream[] uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition[] fileDetail,
			@FormDataParam("type") String[] type,
			@FormDataParam("ext") String[] ext) throws Exception {

		return null;

	}
}
