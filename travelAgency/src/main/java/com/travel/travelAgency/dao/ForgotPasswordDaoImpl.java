package com.travel.travelAgency.dao;

import org.springframework.stereotype.Repository;

@Repository
public class ForgotPasswordDaoImpl implements ForgotPasswordDao {

	@Override
	public Boolean isEmailValid(String email) throws Exception {

		return Boolean.FALSE;
	}

	@Override
	public String getSecurityQues(String email) throws Exception {

		return "Some question!";
	}

}
