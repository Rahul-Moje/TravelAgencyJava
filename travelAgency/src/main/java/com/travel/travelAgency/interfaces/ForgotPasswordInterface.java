package com.travel.travelAgency.interfaces;

import com.travel.travelAgency.models.ForgotPassGetEmailRequest;
import com.travel.travelAgency.models.ForgotPassGetEmailResp;
import com.travel.travelAgency.models.SecurityAnswerRequest;
import com.travel.travelAgency.models.UpdatePasswordReponse;

public interface ForgotPasswordInterface {

	public ForgotPassGetEmailResp verifyEmailAndGetSecurityQues(ForgotPassGetEmailRequest request) throws Exception;
	
	public UpdatePasswordReponse verifySecurityAnswerandUpdatePass(SecurityAnswerRequest request) throws Exception;

}
