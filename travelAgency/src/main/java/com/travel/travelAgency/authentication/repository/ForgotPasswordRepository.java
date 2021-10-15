package com.travel.travelAgency.authentication.repository;

public interface ForgotPasswordRepository {

	public Boolean isEmailValid(String email) throws Exception;

	public String getSecurityQues(String email) throws Exception;

	public Boolean isSecurityAnswerValid(String security_answer, String email) throws Exception;
	
	public int updatePassword(String email, String newPassword) throws Exception;

}
