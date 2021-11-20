package com.travel.travelAgency.proMembership.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.travel.travelAgency.proMembership.interfaces.ProMembershipRegistrationInterface;
import com.travel.travelAgency.proMembership.models.promembershipregistrationrequest;
import com.travel.travelAgency.proMembership.repository.ProMembershipRegistrationRepository;

@Controller
public class ProMembershipRegistrationController {

	@Autowired
	ProMembershipRegistrationInterface promembershipregistrationinterface;

	@Autowired
	ProMembershipRegistrationRepository promembershipregistrationrepository;

	@RequestMapping(value = "/showMemberShipDetails", method = RequestMethod.GET)
	public String showRegistration(ModelMap model) throws Exception {
		List<Map<String, Object>> list = promembershipregistrationinterface.verifyPlans();
		if (list == null) {
			model.addAttribute("errorMessage", "No plans available!");
			return "showMemberShipDetails";

		}
		model.put("list", list);
		return "showMemberShipDetails";

	}

	@RequestMapping(value = "/registerMemberShipDetails", method = RequestMethod.GET)
	public String show(ModelMap model) throws Exception {
		
		return "registerMemberShipDetails";

	}

	@RequestMapping(path = "/registerMemberShipDetails", method = RequestMethod.POST)
	public String UpdatePlanname(ModelMap model, promembershipregistrationrequest request) throws Exception {

		String value = promembershipregistrationinterface.verifyEmailandUpdatePlan(request,
				promembershipregistrationrepository);
		if (!(value == "updated")) {
			model.addAttribute("errorMessage", "error");
			return "welcome";

		}

		return "welcome";

	}

}
