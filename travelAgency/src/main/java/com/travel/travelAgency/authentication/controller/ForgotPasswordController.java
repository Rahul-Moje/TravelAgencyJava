package com.travel.travelAgency.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
//	@RequestMapping(value = "/forgot-pass-get-email", method = RequestMethod.POST)
//	public String login(ModelMap model, @RequestParam ForgotPassGetEmailRequest email) throws Exception {
//		ForgotPassGetEmailResp getEmailResp = forgotPasswordInterface.verifyEmailAndGetSecurityQues(email, forgotPasswordRepository);
//		if(!getEmailResp.equals(getEmailResp.getSecurity_question())) {
//			model.addAttribute("errorMessage", "Login Failed. Please check your credentials and try again");
//			return "forgot-pass-get-email";
//		}
//		model.put("email", email);
//		return getEmailResp.getSecurity_question();
//
//	}
//	
	
	

	@PostMapping(path = "/updatepass")
	public UpdatePasswordReponse getSecurityAnswer(@RequestBody SecurityAnswerRequest request) throws Exception {

		return forgotPasswordInterface.verifySecurityAnswerandUpdatePass(request, forgotPasswordRepository);
	}

}
