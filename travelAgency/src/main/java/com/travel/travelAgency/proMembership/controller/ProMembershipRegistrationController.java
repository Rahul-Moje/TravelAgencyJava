package com.travel.travelAgency.proMembership.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travel.travelAgency.proMembership.interfaces.ProMembershipRegistrationInterface;
import com.travel.travelAgency.proMembership.models.promembershipregistrationrequest;
import com.travel.travelAgency.proMembership.repository.ProMembershipRegistrationRepository;


@RestController
public class ProMembershipRegistrationController {
	
	@Autowired
	ProMembershipRegistrationInterface promembershipregistrationinterface;

	@Autowired
	ProMembershipRegistrationRepository promembershipregistrationrepository;
	
	@GetMapping(path = "/listofPlans")
	public List<Map<String, Object>> getAvailablePlans() throws Exception {

		return promembershipregistrationinterface.verifyPlans();

	}

	@PostMapping(path = "/updateplan")
	public String UpdatePlanname(@RequestBody promembershipregistrationrequest request) throws Exception{
		
		return promembershipregistrationinterface.verifyEmailandUpdatePlan(request, promembershipregistrationrepository);
	}

}
