package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {

	@Test(description = "verify if Login API is Working ...")

	public void createAccountTest() {

		SignUpRequest signUpRequest = new SignUpRequest.Builder().username("mukesh213")
				.email("singh.mukesh.18529@gmail.com").password("Mukesh@123").firstName("Mukesh").lastName("singh")
				.mobileNumber("7070890890").build();

		AuthService authService = new AuthService();
		Response response = authService.signup(signUpRequest);
		System.out.println(response.asPrettyString());

		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
	}

}
