package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetProfileAPITest {

	@Test
	public void getProfileTest() {

		// Before going to getprofile we need token and we get token from authsevice
		// login method
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("banti24", "Banti@123"));
		// cnovert json object into class object(Deserialization)
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());

		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		response = userProfileManagementService.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());

		// Deserialization
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		System.out.println(userProfileResponse.getUsername());
	}

}
