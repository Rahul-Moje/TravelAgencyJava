package com.travel.travelAgency.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.travel.travelAgency.authentication.interfaces.ForgotPasswordInterface;
import com.travel.travelAgency.authentication.models.ForgotPassGetEmailRequest;
import com.travel.travelAgency.authentication.models.ForgotPassGetEmailResp;
import com.travel.travelAgency.authentication.models.SecurityAnswerRequest;
import com.travel.travelAgency.authentication.models.UpdatePasswordReponse;
import com.travel.travelAgency.authentication.repository.ForgotPasswordRepository;

@Controller
public class ForgotPasswordController {

	@Autowired
	ForgotPasswordInterface forgotPasswordInterface;

	@Autowired
	ForgotPasswordRepository forgotPasswordRepository;

	@RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
	public String show(ModelMap model) throws Exception {

		return "forgotpassword";

	}

	@RequestMapping(value = "/forgotpassword", method = RequestMethod.POST)
	public String getEmail(ModelMap model, ForgotPassGetEmailRequest request) throws Exception {
		ForgotPassGetEmailResp getEmailResp = forgotPasswordInterface.verifyEmailAndGetSecurityQues(request,
				forgotPasswordRepository);
		String value1 = request.getEmail();
		String value2 = getEmailResp.getSecurity_question();
		if (value2 == null) {
			model.addAttribute("errorMessage", "Invalid email id!!");
			return "forgotpassword";
		}
		model.put("email", value1);
		model.put("securityquestion", value2);
		return "verifysecurityandupdatepass";

	}

	@RequestMapping(value = "/verifysecurityandupdatepass", method = RequestMethod.POST)
	public String getSecurityAnswer(ModelMap model, SecurityAnswerRequest request) throws Exception {
		UpdatePasswordReponse getSecurityansResp = forgotPasswordInterface.verifySecurityAnswerandUpdatePass(request,
				forgotPasswordRepository);
		String value1 = getSecurityansResp.getStatus();
		if (value1 == "Password not Updated") {
			model.addAttribute("errorMessage", "Invalid security answer!!");
			return "welcome";
		}
		model.put("status", value1);
		return "login";

	}
}
