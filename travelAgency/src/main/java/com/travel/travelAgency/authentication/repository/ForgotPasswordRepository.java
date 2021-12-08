package com.travel.travelAgency.authentication.repository;

/**
 * @author sowjanyamani
 */

public interface ForgotPasswordRepository 
{

	public Boolean isEmailValid(String email) throws Exception;

	public String getSecurityQuestion(String email) throws Exception;

	public Boolean isSecurityAnswerValid(String security_answer, String email) throws Exception;
	
	public void updatePassword(String email, String newPassword) throws Exception;

}
