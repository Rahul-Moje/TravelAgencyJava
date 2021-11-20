package com.travel.travelAgency.grievance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.travel.travelAgency.authentication.models.SecurityAnswerRequest;
import com.travel.travelAgency.authentication.models.UpdatePasswordReponse;
import com.travel.travelAgency.grievance.interfaces.GrievanceInterface;
import com.travel.travelAgency.grievance.model.Grievancerequest;
import com.travel.travelAgency.grievance.repository.GrievanceRepository;

@Controller
public class GrievanceController {

	@Autowired
	GrievanceInterface grievanceInterface;

	@Autowired
	GrievanceRepository grievanceRepository;
	
	@RequestMapping(value = "/grievance", method = RequestMethod.GET)
	public String show(ModelMap model) throws Exception {

		return "grievance";

	}
	

	@RequestMapping(value = "/grievance", method = RequestMethod.POST)
	public String getSecurityAnswer(ModelMap model, Grievancerequest request) throws Exception {
		String value = grievanceInterface.RegisterGrievanceComplaint(request, grievanceRepository);
		if (value == "Complaint not Filed!!") {
			model.addAttribute("errorMessage", "Error submitting the grievance!!");
			return "welcome";
		}
		model.put("status", value);
		return "welcome";

	}

}