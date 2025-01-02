package com.api.base;

import com.api.models.request.UpdateProfileRequest;

import io.restassured.response.Response;

public class UserProfileManagementService extends BaseService {

	private static final String BASE_PATH = "/api/users/";

	public Response getProfile(String token) {
		setToken(token);
		return getRequest(BASE_PATH + "profile");
	}

	public Response update(String token, UpdateProfileRequest payload) {
		// call postRequest method from BaseService class
		setToken(token);
		return putRequest(payload, BASE_PATH + "profile");

	}
}
