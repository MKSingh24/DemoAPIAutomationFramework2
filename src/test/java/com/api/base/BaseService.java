package com.api.base;

import static io.restassured.RestAssured.given;

import com.api.filters.LoggingFilter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService { // Wrapping for RestAssured

	// Base URI
	// CREATING REAUEST
	// Handling REsponse

	private static final String BASE_URL = "http://64.227.160.186:8080";

	private RequestSpecification requestspecification;

	// Filter
	static {
		RestAssured.filters(new LoggingFilter());
	}

	// default constructor=job of constructor is to initialize the instance variable

	public BaseService() {

		requestspecification = given().baseUri(BASE_URL);

	}

	// method to provide token

	protected void setToken(String token) {
		requestspecification.header("Authorization", "Bearer " + token);
	}

	// POST METHOD
	protected Response postRequest(Object payload, String endpoint) {

		return requestspecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}

	// GET METHOD
	protected Response getRequest(String endpoint) {
		return requestspecification.get(endpoint);
	}

	// PUT METHOD
	protected Response putRequest(Object payload, String endpoint) {
		return requestspecification.contentType(ContentType.JSON).body(payload).put(endpoint);

	}

}
