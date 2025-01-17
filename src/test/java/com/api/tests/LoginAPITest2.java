package com.api.tests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class LoginAPITest2 {

	@Test(description = "verify if Login API is Working ...")
	public void loginTest() {

		Response response = given().baseUri("http://64.227.160.186:8080").header("Content-Type", "application/json")
				.body("{ \"username\": \"banti24\", \"password\": \"Banti@123\"}").post("/api/auth/login");

		System.out.println(response.asPrettyString());

		Assert.assertEquals(response.getStatusCode(), 200);

	}

}
