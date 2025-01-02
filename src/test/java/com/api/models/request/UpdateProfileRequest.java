package com.api.models.request;

public class UpdateProfileRequest {

	private String email;
	private String firstName;
	private String lastName;
	private String mobileNumber;

	public UpdateProfileRequest(String email, String firstName, String lastName, String mobileNumber) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "UpdateProfileRequest [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobileNumber=" + mobileNumber + "]";
	}

	// Builder class

	public static class Builder {

		private String email;
		private String firstName;
		private String lastName;
		private String mobileNumber;

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder mobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
			return this;
		}

		public UpdateProfileRequest build() {
			UpdateProfileRequest updateProfileRequest = new UpdateProfileRequest(email, firstName, lastName,
					mobileNumber);
			return updateProfileRequest;
		}

	}

}
