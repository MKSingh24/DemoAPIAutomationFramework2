package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.UpdateProfileRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class UpdateProfileAPITest {

	@Test(description = "Verifying PUT API Request.........")
	public void updateProfileTest() {

		// before update frst we do login

		AuthService AuthService = new AuthService();
		Response response = AuthService.login(new LoginRequest("banti24", "Banti@123"));
		System.out.println(response.asPrettyString());
		// Deserialization
		LoginResponse loginResponse = response.as(LoginResponse.class);

		System.out.println("**********GetUser Details*******");

		UserProfileManagementService UserProfileManagementService = new UserProfileManagementService();
		response = UserProfileManagementService.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());

		System.out.println("**********update Details*******");

		// create object of UpdateProfileRequest pojo class for payload

		/*
		 * UpdateProfileRequest updateProfileRequest = new
		 * UpdateProfileRequest("mukeshk2@gmail.com", "mukesh Kumar", "singh",
		 * "9876543210");
		 */
		// Also access through Builder class
		UpdateProfileRequest updateProfileRequest = new UpdateProfileRequest.Builder().firstName("mukesh Kumar")
				.email("mukeshk2@gmail.com").mobileNumber("9876543210").lastName("singh").build();

		response = UserProfileManagementService.update(loginResponse.getToken(), updateProfileRequest);
		System.out.println(response.asPrettyString());

	}

}
