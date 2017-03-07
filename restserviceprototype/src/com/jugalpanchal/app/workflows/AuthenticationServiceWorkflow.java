package com.jugalpanchal.app.workflows;

import java.io.IOException;
import java.util.StringTokenizer;

import com.sun.jersey.core.util.Base64;

public class AuthenticationServiceWorkflow {

	public boolean authenticate(String authCredentials) throws Exception {
		boolean authenticationStatus = false;
		if (null != authCredentials) {
			// header value format will be "Basic encodedstring" for Basic
			// authentication. Example "Basic YWRtaW46YWRtaW4="
			final String encodedUserPassword = authCredentials.replaceFirst("Basic" + " ", "");
			String usernameAndPassword = null;
			try {
				byte[] decodedBytes = Base64.decode(encodedUserPassword);
				//byte[] decodedBytes = Base64.getDecoder().decode(encodedUserPassword);
				usernameAndPassword = new String(decodedBytes, "UTF-8");
				
				final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
				final String username = tokenizer.nextToken();
				final String password = tokenizer.nextToken();
				// call some UserService/LDAP here
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return authenticationStatus;
	}
}