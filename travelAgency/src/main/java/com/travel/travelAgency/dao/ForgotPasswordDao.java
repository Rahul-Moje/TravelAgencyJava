package com.travel.travelAgency.dao;

public interface ForgotPasswordDao {

	public Boolean isEmailValid(String email) throws Exception;

	public String getSecurityQues(String email) throws Exception;

	public Boolean isSecurityAnswerValid(String security_answer, String email) throws Exception;
	
	public void updatePassword(String email, String newPassword) throws Exception;

}
