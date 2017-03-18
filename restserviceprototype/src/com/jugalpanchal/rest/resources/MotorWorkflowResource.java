package com.jugalpanchal.rest.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jugalpanchal.rest.messagecontracts.CompanyMessageContract;

/**
 * http://localhost:8080/restserviceprototype/rest/motorservice 
 * @author @jugalpanchal
 */
@Path("/motorservice")
public class MotorWorkflowResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHelloToTest() {
		try {
			//return Response.status(200).entity("Hello Jugal!").build();
			return "Now " + new Date();
		} catch (Exception ex) {
			throw ex;
		}
	}

	@GET
	@Path("/companiescount")
	@Produces(MediaType.APPLICATION_JSON)
	public Long getCount() throws Exception {
		try {
			Long count = 10L;
			return count;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@GET
	@Path("/company/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	public CompanyMessageContract getById(@PathParam("companyId") long companyId) throws Exception {
		try {
			//Get company from persistent context and convert to message contract. 
			return null;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@GET
	@Path("/company")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CompanyMessageContract> get() throws Exception {
		List<CompanyMessageContract> CompanyMessageContracts = null;
		try { 
			// CompanyWorkflow workflow = new CompanyWorkflow();
			// List<Company> companies = workflow.getCompanies();
			// CompanyMessageContracts = CompanyExchange.convert(companies);
			return CompanyMessageContracts;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@GET
	@Path("/company/deactive/{companyId}/{deactive}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deactiveById(@PathParam("companyId") long companyId, @PathParam("deactive") int deactive)
			throws Exception {
		boolean isUpdated = false;
		try {
			return Response.status(200).entity("" + isUpdated).build();
		} catch (Exception ex) {
			throw ex;
		}
	}

	@GET
	@Path("/companies")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CompanyMessageContract> getCompaniesByIdList(@QueryParam("companyids") List<Long> classNameIds)
			throws Exception {
		try {
			// Integer Long String
			List<CompanyMessageContract> classNameMessageContracts = new ArrayList<CompanyMessageContract>();
			return classNameMessageContracts;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@POST
	@Path("check")
	// @Consumes(MediaType.APPLICATION_JSON)
	public Response Check() {
		try {
			return Response.status(200).entity("true").build();
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(CompanyMessageContract companyMessageContract) throws Exception {
		boolean isSaved = false;
		try {
			//Response response = Response.ok("" + isSaved).header("Access-Control-Allow-Origin", "*").build();
			
			// CompanyWorkflow workflow = new CompanyWorkflow();
			// Company company = CompanyExchange.convert(companyMessageContract);
			// isSaved = workflow.save(company);
			return Response.status(200).entity("" + isSaved).build();
		} catch (Exception ex) {
			throw ex;
		}
	}

	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String saveId(@FormParam("companyId") String companyId,
			@FormParam("name") String name) throws IOException {

		return "Done";
	}

	@PUT
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(CompanyMessageContract company) throws Exception {
		boolean isUpdated = false;
		try {
			//Convert message contract to persistent class and update it and change isUpdated flag.
			return Response.status(200).entity("" + isUpdated).build();
		} catch (Exception ex) {
			throw ex;
		}
	}
}