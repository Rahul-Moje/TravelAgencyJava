package com.travel.travelAgency.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travel.travelAgency.authentication.interfaces.ForgotPasswordInterface;
import com.travel.travelAgency.authentication.models.ForgotPassGetEmailRequest;
import com.travel.travelAgency.authentication.models.ForgotPassGetEmailResp;
import com.travel.travelAgency.authentication.models.SecurityAnswerRequest;
import com.travel.travelAgency.authentication.models.UpdatePasswordReponse;
import com.travel.travelAgency.authentication.repository.ForgotPasswordRepository;

@RestController
public class ForgotPasswordController {

	@Autowired
	ForgotPasswordInterface forgotPasswordInterface;

	@Autowired
	ForgotPasswordRepository forgotPasswordRepository;

	@PostMapping(path = "/forgot-pass-get-email")
	public ForgotPassGetEmailResp getEmail(@RequestBody ForgotPassGetEmailRequest request) throws Exception {

		return forgotPasswordInterface.verifyEmailAndGetSecurityQues(request, forgotPasswordRepository);

	}

	@PostMapping(path = "/updatepass")
	public UpdatePasswordReponse getSecurityAnswer(@RequestBody SecurityAnswerRequest request) throws Exception {

		return forgotPasswordInterface.verifySecurityAnswerandUpdatePass(request, forgotPasswordRepository);
	}

}
