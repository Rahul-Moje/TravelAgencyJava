package com.travel.travelAgency.authentication.models;

import java.io.Serializable;

public class ForgotPassGetEmailRequest implements Serializable {

	private static final long serialVersionUID = 4169344436150052963L;

	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
