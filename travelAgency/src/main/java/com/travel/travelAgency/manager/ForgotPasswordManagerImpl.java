package com.travel.travelAgency.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.travelAgency.dao.ForgotPasswordDao;
import com.travel.travelAgency.model.ForgotPassGetEmailRequest;
import com.travel.travelAgency.model.ForgotPassGetEmailResp;

@Service
public class ForgotPasswordManagerImpl implements ForgotPasswordManager {

	@Autowired
	ForgotPasswordDao forgotPasswordDao;

	@Override
	public ForgotPassGetEmailResp verifyEmailAndGetSecurityQues(ForgotPassGetEmailRequest request) throws Exception {

		String email = request.getEmail();

		if (forgotPasswordDao.isEmailValid(email)) {

			// Email is valid - Fetch the security question
			String securityQues = forgotPasswordDao.getSecurityQues(email);

			ForgotPassGetEmailResp resp = new ForgotPassGetEmailResp();
			resp.setSecurity_question(securityQues);
			resp.setStatus("success");

			return resp;

		}

		// Email is invalid - throw exception
		throw new Exception("Invalid Email ID !");

	}

}
