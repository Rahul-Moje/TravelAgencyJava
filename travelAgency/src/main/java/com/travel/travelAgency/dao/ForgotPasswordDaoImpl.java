package com.travel.travelAgency.dao;

import org.springframework.stereotype.Repository;

@Repository
public class ForgotPasswordDaoImpl implements ForgotPasswordDao {

	@Override
	public Boolean isEmailValid(String email) throws Exception {

		return Boolean.TRUE;
	}

	@Override
	public String getSecurityQues(String email) throws Exception {

		return "Some question!";
	}

	@Override
	public Boolean isSecurityAnswerValid(String security_answer, String email) throws Exception {

		return Boolean.TRUE;
	}

	@Override
	public void updatePassword(String email, String newPassword) throws Exception {
		
		
	}
}
