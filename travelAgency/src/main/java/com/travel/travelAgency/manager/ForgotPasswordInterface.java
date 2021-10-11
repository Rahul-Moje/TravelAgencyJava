package com.travel.travelAgency.manager;

import com.travel.travelAgency.model.ForgotPassGetEmailRequest;
import com.travel.travelAgency.model.ForgotPassGetEmailResp;
import com.travel.travelAgency.model.SecurityAnswerRequest;
import com.travel.travelAgency.model.UpdatePasswordReponse;

public interface ForgotPasswordInterface {

	public ForgotPassGetEmailResp verifyEmailAndGetSecurityQues(ForgotPassGetEmailRequest request) throws Exception;
	
	public UpdatePasswordReponse verifySecurityAnswerandUpdatePass(SecurityAnswerRequest request) throws Exception;

}
