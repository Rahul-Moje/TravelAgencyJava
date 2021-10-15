package com.travel.travelAgency.repository;

public interface SignUpRepository {

	public void signUpUser(String username, String password, String email, int SecurityQuestionId, String securityAnswer, String roleName);

}
