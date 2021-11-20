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
			String email = request.getEmail();
			String security_answer = request.getSecurity_answer();
			String new_password = request.getNew_password();
			String update_password = request.getUpdate_password();

			if (repo.isSecurityAnswerValid(security_answer, email)) {

				if (request.checkPassword(new_password)) {

					if (!request.getNew_password().equalsIgnoreCase(request.getUpdate_password())) {
						response.setStatus("check if the password are same");
					}

					repo.updatePassword(email, request.getNew_password());

					response.setStatus("Password Updated");
					return response;
				} else {
					response.setStatus("The password must have atlest one character, number and special character");
				}
			}else {
				response.setStatus("Invalid answer");
			}
		} catch (Exception e) {

		}
		return response;
	}
}
