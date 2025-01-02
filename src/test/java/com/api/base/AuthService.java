package com.api.base;

import java.util.HashMap;

import com.api.models.request.LoginRequest;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AuthService extends BaseService {

	// http://64.227.160.186:8080/api/auth/login- for login
	// BaseURI-http://64.227.160.186:8080
	// BasePath-/api/auth/
	// method-login
	// For signup=http://64.227.160.186:8080/api/auth/signup'
	// forgetpassword=http://64.227.160.186:8080/api/auth/forgot-password

	private static final String BASE_PATH = "/api/auth/";

	public Response login(LoginRequest payload) {
		// call postRequest method from BaseService class
		return postRequest(payload, BASE_PATH + "login");

	}

	public Response signup(SignUpRequest payload) {
		// call postRequest method from BaseService class
		return postRequest(payload, BASE_PATH + "signup");

	}

	public Response forgotPassword(String emailAddress) {
		HashMap<String, String> payload = new HashMap<String, String>();
		payload.put("email", emailAddress);
		// call postRequest method from BaseService class
		return postRequest(payload, BASE_PATH + "forgot-password");

	}
}
