package com.travel.travelAgency.authentication.interfaces;

import com.travel.travelAgency.authentication.models.ForgotPassGetEmailRequest;
import com.travel.travelAgency.authentication.models.ForgotPassGetEmailResp;
import com.travel.travelAgency.authentication.models.SecurityAnswerRequest;
import com.travel.travelAgency.authentication.models.UpdatePasswordReponse;
import com.travel.travelAgency.authentication.repository.ForgotPasswordRepository;

/**
 * @author sowjanyamani
 */

public interface ForgotPasswordInterface 
{

	public ForgotPassGetEmailResp verifyEmailAndGetSecurityQuestion(ForgotPassGetEmailRequest request,
			ForgotPasswordRepository repo) throws Exception;

	public UpdatePasswordReponse verifySecurityAnswerandUpdatePassword(SecurityAnswerRequest request,
			ForgotPasswordRepository repo) throws Exception;

}
