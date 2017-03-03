package com.jugalpanchal.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/motorservice")
public class MotorWorkflowResource {
	
	@GET
	public Response getMessage() throws Exception {
		try {
			return Response.status(200).entity("Jugal here").build(); 
		} catch (Exception ex) {
			throw ex;
		}
	}
}