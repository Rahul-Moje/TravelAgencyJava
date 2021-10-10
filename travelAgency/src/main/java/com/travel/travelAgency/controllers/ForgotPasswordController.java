package com.travel.travelAgency.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travel.travelAgency.manager.ForgotPasswordManager;
import com.travel.travelAgency.model.ForgotPassGetEmailRequest;
import com.travel.travelAgency.model.ForgotPassGetEmailResp;
import com.travel.travelAgency.model.SecurityAnswerRequest;
import com.travel.travelAgency.model.UpdatePasswordReponse;

@RestController
public class ForgotPasswordController {

	@Autowired
	ForgotPasswordManager forgotPasswordManager;

	@PostMapping(path = "/forgot-pass-get-email")
	public ForgotPassGetEmailResp getEmail(@RequestBody ForgotPassGetEmailRequest request) throws Exception {

		return forgotPasswordManager.verifyEmailAndGetSecurityQues(request);

	}
	
	@PostMapping(path = "/updatepass")
	public UpdatePasswordReponse getSecurityAnswer(@RequestBody SecurityAnswerRequest request) throws Exception {
		
		return forgotPasswordManager.verifySecurityAnswerandUpdatePass(request);
	}

}
