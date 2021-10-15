package com.travel.travelAgency.interfaces;

public interface SignUpInterface {
	

	public String signUp(String username, String password, String email, int SecurityQuestionId, String securityAnswer);
}
