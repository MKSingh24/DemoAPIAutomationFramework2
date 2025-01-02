package com.api.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter {

	public static final Logger logger = LogManager.getLogger(LoggingFilter.class);

	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		// log request
		logRequest(requestSpec);

		// get response
		Response response = ctx.next(requestSpec, responseSpec);// request going to be executed

		// log response
		logResponse(response);
		return response;
	}

	public void logRequest(FilterableRequestSpecification requestSpec) {
		logger.info("BASE URI " + requestSpec.getBaseUri());
		logger.info("BASE PATH " + requestSpec.getBasePath());
		logger.info("Request Header " + requestSpec.getHeaders());
		logger.info("Request Payload " + requestSpec.getBody());
	}

	public void logResponse(Response response) {

		logger.info("Status Code " + response.getStatusCode());
		logger.info("Status Line " + response.getStatusLine());
		logger.info("Response Time " + response.getTime());
		logger.info("Response Headers " + response.getHeaders());
		logger.info("Response Payload " + response.getBody().asPrettyString());

	}

}
