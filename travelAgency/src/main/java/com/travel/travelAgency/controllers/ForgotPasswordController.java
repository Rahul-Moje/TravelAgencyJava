package com.travel.travelAgency.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travel.travelAgency.manager.ForgotPasswordManager;
import com.travel.travelAgency.model.ForgotPassGetEmailRequest;
import com.travel.travelAgency.model.ForgotPassGetEmailResp;

@RestController
public class ForgotPasswordController {

	@Autowired
	ForgotPasswordManager forgotPasswordManager;

	@PostMapping(path = "/forgot-pass-get-email")
	public ForgotPassGetEmailResp getEmail(@RequestBody ForgotPassGetEmailRequest request) throws Exception {

		return forgotPasswordManager.verifyEmailAndGetSecurityQues(request);

	}

}
