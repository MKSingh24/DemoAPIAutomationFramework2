package com.api.models.request;

public class ForgetPasswordRequest {

	private String email;

	public ForgetPasswordRequest(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ForgetPasswordRequest [email=" + email + "]";
	}

}
