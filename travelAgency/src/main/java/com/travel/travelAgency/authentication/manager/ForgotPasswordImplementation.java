package com.travel.travelAgency.authentication.manager;

import org.springframework.stereotype.Service;

import com.travel.travelAgency.authentication.interfaces.ForgotPasswordInterface;
import com.travel.travelAgency.authentication.models.ForgotPassGetEmailRequest;
import com.travel.travelAgency.authentication.models.ForgotPassGetEmailResp;
import com.travel.travelAgency.authentication.models.SecurityAnswerRequest;
import com.travel.travelAgency.authentication.models.UpdatePasswordReponse;
import com.travel.travelAgency.authentication.repository.ForgotPasswordRepository;

@Service
public class ForgotPasswordImplementation implements ForgotPasswordInterface {

	@Override
	public ForgotPassGetEmailResp verifyEmailAndGetSecurityQues(ForgotPassGetEmailRequest request,
			ForgotPasswordRepository repo) throws Exception {
		ForgotPassGetEmailResp resp = new ForgotPassGetEmailResp();
		try {
			String email = request.getEmail();

			if (request.checkEmailValid(email)) {

				if (repo.isEmailValid(email)) {

					String securityQues = repo.getSecurityQues(email);

					resp.setSecurity_question(securityQues);

					return resp;
				}

				throw new Exception("Invalid Email ID !");
			}

			throw new Exception("Email does not meet the criteria!");

		} catch (Exception e) {

		}
		return resp;
	}

	@Override
	public UpdatePasswordReponse verifySecurityAnswerandUpdatePass(SecurityAnswerRequest request,
			ForgotPasswordRepository repo) throws Exception {
		UpdatePasswordReponse response = new UpdatePasswordReponse();
		try {

			String security_answer = request.getSecurity_answer();
			String email = request.getEmail();
			String newPassword = request.getNew_password();
			// check if the Security Answer is Valid;
			if (repo.isSecurityAnswerValid(security_answer, email)) {

				if (request.checkPassword(newPassword)) {

					if (!request.getNew_password().equalsIgnoreCase(request.getUpdate_password())) {
						throw new Exception("check if the password are same");
					}
					// Update the new password in database;
					repo.updatePassword(email, request.getNew_password());

					response.setStatus("Password Updated");
					return response;
				} else {
					throw new Exception("The password must have atlest one character, integer and special character");
				}
			}
			throw new Exception("Invalid answer");
		} catch (Exception e) {

		}
		return response;
	}

}
