package com.travel.travelAgency.repository;

public interface ForgotPasswordRepository {

	public Boolean isEmailValid(String email) throws Exception;

	public String getSecurityQues(String email) throws Exception;

	public Boolean isSecurityAnswerValid(String security_answer, String email) throws Exception;
	
	public void updatePassword(String email, String newPassword) throws Exception;

}
