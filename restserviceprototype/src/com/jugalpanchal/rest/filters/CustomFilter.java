package com.jugalpanchal.rest.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.HttpMethod;
import com.jugalpanchal.app.workflows.AuthenticationServiceWorkflow;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import com.sun.jersey.spi.container.ResourceFilter;

public class CustomFilter implements ResourceFilter, ContainerRequestFilter, ContainerResponseFilter, javax.servlet.Filter {
	
	public static final String AUTHENTICATION_HEADER = "Authorization";
	
	/**
	 * Action with the outgoing response here.
	 */
	@Override
	public ContainerResponse filter(ContainerRequest request, ContainerResponse response) {
		int status = response.getStatus();
		if (status == 200) {
			// 'Access-Control-Allow-Origin' 'http://<myeshost1>:9200 http://<myeshost2>:9200';
			response.getHttpHeaders().add("Access-Control-Allow-Origin", "*");
			response.getHttpHeaders().add("Access-Control-Allow-Credentials", "true");
			response.getHttpHeaders().add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");
			response.getHttpHeaders()
				.add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
		}
		if (status == 404) {
			// add to message body? log it?
		}
		return response;
	}

	/**
	 * Action with the incoming request here
	 */
	@Override
	public ContainerRequest filter(ContainerRequest containerRequest) {
		/*
		 * SecurityContext context = containerRequest.getSecurityContext();
		 * String authenticationScheme = context.getAuthenticationScheme(); 
		 * Principal principal = containerRequest.getUserPrincipal();
		 */
		return containerRequest;
	}

	@Override
	public ContainerRequestFilter getRequestFilter() {
		return this;
	}

	@Override
	public ContainerResponseFilter getResponseFilter() {
		return this;
	}

	@Override
	public void destroy() {
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter) 
			throws IOException, ServletException {
		if (request instanceof HttpServletRequest) {
			
			boolean isAnonymousPost = false;
			//String httpPostConst = HttpMethod.POST;
			
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			String requestUrl = httpServletRequest.getRequestURI();
			String httpMethodType = httpServletRequest.getMethod();
			String authCredential = httpServletRequest.getHeader(AUTHENTICATION_HEADER);
			
			String url = requestUrl.substring(requestUrl.lastIndexOf("rest/") + 5);

			AuthenticationServiceWorkflow authServiceWorkflow = new AuthenticationServiceWorkflow();
		    boolean authenticationStatus = authServiceWorkflow.authenticate(authCredential);
		    
			//services which does not require authentication like enquiryservice/save or registrationservice/save
			List<String> allowURL = new ArrayList<String>(); 
			allowURL.add("<Service which needs to be passed>");
			allowURL.add("<Service which needs to be passed>");
			if (allowURL.contains(url)) {
				isAnonymousPost = true;
			}
			
			if (HttpMethod.POST.equals(httpMethodType) || HttpMethod.PUT.equals(httpMethodType) || HttpMethod.DELETE.equals(httpMethodType))
			{
				if (isAnonymousPost || authenticationStatus) {
					filter.doFilter(request, response);
				} else {
					if (response instanceof HttpServletResponse) {
						HttpServletResponse httpServletResponse = (HttpServletResponse) response;
						httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
					}
				}
			}
			else
			{
				filter.doFilter(request, response);
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}