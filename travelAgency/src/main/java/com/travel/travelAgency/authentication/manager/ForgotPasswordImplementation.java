package com.travel.travelAgency.authentication.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.travelAgency.authentication.interfaces.ForgotPasswordInterface;
import com.travel.travelAgency.authentication.models.ForgotPassGetEmailRequest;
import com.travel.travelAgency.authentication.models.ForgotPassGetEmailResp;
import com.travel.travelAgency.authentication.models.SecurityAnswerRequest;
import com.travel.travelAgency.authentication.models.UpdatePasswordReponse;
import com.travel.travelAgency.authentication.repository.ForgotPasswordRepository;

@Service
public class ForgotPasswordImplementation implements ForgotPasswordInterface {

	@Autowired
	ForgotPasswordRepository forgotPasswordRepository;

	@Override
	public ForgotPassGetEmailResp verifyEmailAndGetSecurityQues(ForgotPassGetEmailRequest request) throws Exception {

		String email = request.getEmail();

		if (forgotPasswordRepository.isEmailValid(email)) {

			// Email is valid - Fetch the security question
			String securityQues = forgotPasswordRepository.getSecurityQues(email);

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
		//check if the Security Answer is Valid;
		if(forgotPasswordRepository.isSecurityAnswerValid(security_answer, email))
		{
			
			
			if(!request.getNew_password().equalsIgnoreCase(request.getUpdate_password()))
			{
				throw new Exception("check if the password are same");
			}
			//Update the new password in database;
			forgotPasswordRepository.updatePassword(email, request.getNew_password());
			
			UpdatePasswordReponse response = new UpdatePasswordReponse();
			response.setStatus("Password Updated");
			return response;
		}
		
		throw new Exception("Invalid answer");
	}

}
