package com.travel.travelAgency.dao;

public interface ForgotPasswordDao {

	public Boolean isEmailValid(String email) throws Exception;

	public String getSecurityQues(String email) throws Exception;

}
