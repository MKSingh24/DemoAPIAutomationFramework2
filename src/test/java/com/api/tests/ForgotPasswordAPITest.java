package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class ForgotPasswordAPITest {

	@Test(description = "verify if Forgot Password API is Working ...")
	public void forgotPasswordTest() {

		// ForgetPasswordRequest forgetPasswordRequest = new
		// ForgetPasswordRequest("mukeshksingh242@gmail.com");
		AuthService authService = new AuthService();
		// Response response = authService.forgotpassword(forgetPasswordRequest);
		Response response = authService.forgotPassword("singh.mukesh.18579@gmail.com");

		System.out.println(response.asPrettyString());
		// Assert.assertEquals(response.getStatusCode(), 200);
	}

}
