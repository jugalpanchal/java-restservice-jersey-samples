package com.jugalpanchal.app.workflows;

import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;

import com.sun.jersey.core.util.Base64;

public class AuthenticationServiceWorkflow {

	/**
	 * @param authCredential Header value format will be "Basic encodedstring" for Basic authentication.
	 * Example "Basic YWRtaW46YWRtaW4="
	 * @return If user is valid or not.
	 * @throws UnsupportedEncodingException
	 * @author @jugalpanchal
	 */
	public boolean authenticate(String authCredential) throws UnsupportedEncodingException {
		boolean authenticationStatus = false;
		if (authCredential != null) {
			final String encodedUserIdAndPassword = authCredential.replaceFirst("Basic" + " ", "");

			byte[] decodedBytes = Base64.decode(encodedUserIdAndPassword);
			// byte[] decodedBytes = Base64.getDecoder().decode(encodedUserIdAndPassword);

			String userIdAndPassword = new String(decodedBytes, "UTF-8");
			final StringTokenizer tokenizer = new StringTokenizer(userIdAndPassword, ":");
			
			@SuppressWarnings("unused")
			final String username = tokenizer.nextToken();
			@SuppressWarnings("unused")
			final String password = tokenizer.nextToken();

			// call some UserService/LDAP here to authenticate user.
			authenticationStatus = true;
		}
		return authenticationStatus;
	}
}