package com.travel.travelAgency.manager;

import com.travel.travelAgency.model.ForgotPassGetEmailRequest;
import com.travel.travelAgency.model.ForgotPassGetEmailResp;

public interface ForgotPasswordManager {

	public ForgotPassGetEmailResp verifyEmailAndGetSecurityQues(ForgotPassGetEmailRequest request) throws Exception;

}
