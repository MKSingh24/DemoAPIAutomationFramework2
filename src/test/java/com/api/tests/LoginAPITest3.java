package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)

public class LoginAPITest3 {

	@Test(description = "verify if Login API is Working ...")
	public void loginTest() {

		// end point (login) belong to Authentication service so we create object of
		// AuthService class

		AuthService authservice = new AuthService();

		// create object of Pojo class(LoginRequest)

		LoginRequest loginrequest = new LoginRequest("banti24", "Banti@123");

		// Response response = authservice.login("{ \"username\": \"banti24\",
		// \"password\": \"Banti@123\"}");
		// we will pass payload using pajoclass
		Response response = authservice.login(loginrequest);

		System.out.println(response.asPrettyString());

		// Deserialization

		System.out.println("****************Deserialization***********************");

		LoginResponse loginResponse = response.as(LoginResponse.class);

		System.out.println(loginResponse.getToken());
		System.out.println(loginResponse.getType());
		System.out.println(loginResponse.getId());
		System.out.println(loginResponse.getUsername());
		System.out.println(loginResponse.getEmail());
		System.out.println(loginResponse.getRoles());

		Assert.assertTrue(loginResponse.getToken() != null);
		Assert.assertEquals(loginResponse.getType(), "Bearer");
		Assert.assertEquals(loginResponse.getId(), 493);
		Assert.assertEquals(loginResponse.getUsername(), "banti24");

	}

}
