package com.travel.travelAgency.authentication.models;

import java.io.Serializable;
import java.util.regex.Pattern;

public class ForgotPassGetEmailRequest implements Serializable {

	private static final long serialVersionUID = 4169344436150052963L;

	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public static Boolean checkEmailValid (String email) {
		
		String emailReg = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
		Pattern p = Pattern.compile(emailReg);
		if (email == null)
			return false;
		return p.matcher(email).matches();
		
		
	}

}
