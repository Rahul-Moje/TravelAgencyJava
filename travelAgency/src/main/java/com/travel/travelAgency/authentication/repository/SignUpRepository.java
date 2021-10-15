package com.travel.travelAgency.authentication.repository;

public interface SignUpRepository {

	public void signUpUser(String username, String password, String email, int SecurityQuestionId, String securityAnswer, String roleName);

}
