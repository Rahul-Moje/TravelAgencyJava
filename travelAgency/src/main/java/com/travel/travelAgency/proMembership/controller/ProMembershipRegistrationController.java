package com.travel.travelAgency.proMembership.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.travel.travelAgency.proMembership.interfaces.ProMembershipRegistrationInterface;
import com.travel.travelAgency.proMembership.models.promembershipregistrationrequest;
import com.travel.travelAgency.proMembership.repository.ProMembershipRegistrationRepository;

/**
 * @author sowjanyamani
 */

@Controller
public class ProMembershipRegistrationController {

	@Autowired
	ProMembershipRegistrationInterface promembershipregistrationinterface;

	@Autowired
	ProMembershipRegistrationRepository promembershipregistrationrepository;

	@RequestMapping(value = "/showMemberShipDetails", method = RequestMethod.GET)
	public String showProMembershipPlans(ModelMap model) throws Exception {
		List<Map<String, Object>> list = promembershipregistrationinterface.verifyPlans();
		if (list == null) {
			model.addAttribute("errorMessage", "No plans available!");
			return "showMemberShipDetails";

		}
		model.put("list", list);
		return "showMemberShipDetails";

	}

	@RequestMapping(value = "/registerMemberShipDetails", method = RequestMethod.GET)
	public String showProMembershiRegisterPage(ModelMap model) throws Exception {
		List<Map<String, Object>> list = promembershipregistrationinterface.verifyPlans();
		model.put("list", list);
		return "registerMemberShipDetails";

	}

	@RequestMapping(path = "/registerMemberShipDetails", method = RequestMethod.POST)
	public String updatePlanName(ModelMap model, promembershipregistrationrequest request) throws Exception {

		String value = promembershipregistrationinterface.verifyEmailandUpdatePlan(request,
				promembershipregistrationrepository);
		if (value == "") {
			model.addAttribute("errorMessage", "Input field should not be empty");
		   
			return "registerMemberShipDetails";

		}
        model.put("amount", value);
		return "payment";

	}

}
