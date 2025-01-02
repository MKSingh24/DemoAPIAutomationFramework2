package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPITest {

	@Test(description = "verify if Login API is Working ...")
	public void loginTest() {

		RequestSpecification x = RestAssured.given();
		x.baseUri("http://64.227.160.186:8080");
		x.basePath("/api/auth/login");
		RequestSpecification y = x.header("Content-Type", "application/json");
		RequestSpecification z = y.body("{ \"username\": \"banti24\", \"password\": \"Banti@123\"}");

		Response response = z.post();

		System.out.println(response.asPrettyString());

		Assert.assertEquals(response.getStatusCode(), 200);

	}

}
