package com.travel.travelAgency.authentication.interfaces;

public interface SignUpInterface {
	

	public String signUp(String username, String password, String email, String SecurityQuestionId, String securityAnswer);
}
