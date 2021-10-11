package com.travel.travelAgency.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.travelAgency.dao.ForgotPasswordDao;
import com.travel.travelAgency.model.ForgotPassGetEmailRequest;
import com.travel.travelAgency.model.ForgotPassGetEmailResp;
import com.travel.travelAgency.model.SecurityAnswerRequest;
import com.travel.travelAgency.model.UpdatePasswordReponse;

@Service
public class ForgotPasswordImplementation implements ForgotPasswordInterface {

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

	@Override
	public UpdatePasswordReponse verifySecurityAnswerandUpdatePass(SecurityAnswerRequest request) throws Exception {
		
		String security_answer = request.getSecurity_answer();
		String email = request.getEmail();
		
		if(forgotPasswordDao.isSecurityAnswerValid(security_answer, email))
		{
			//Security Answer is Valid;
			//Update the new pass in database;
			if(!request.getNew_password().equalsIgnoreCase(request.getUpdate_password()))
			{
				throw new Exception("check if the password are same");
			}
			forgotPasswordDao.updatePassword(email, request.getNew_password());
			
			UpdatePasswordReponse response = new UpdatePasswordReponse();
			response.setStatus("ok");
			return response;
		}
		
		throw new Exception("Invalid answer");
	}

}
