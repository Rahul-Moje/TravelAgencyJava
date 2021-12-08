package com.travel.travelAgency.proMembership.manager;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.travelAgency.proMembership.interfaces.ProMembershipRegistrationInterface;
import com.travel.travelAgency.proMembership.models.promembershipregistrationrequest;
import com.travel.travelAgency.proMembership.repository.ProMembershipRegistrationRepository;

/**
 * @author sowjanyamani
 */

@Service
public class ProMembershipRegistrationImplementation implements ProMembershipRegistrationInterface {

	@Autowired
	ProMembershipRegistrationRepository repo;

	@Override
	public List<Map<String, Object>> verifyPlans() throws Exception {

		List<Map<String, Object>> list = repo.getListofMembership();

		return list;

	}

	@Override
	public String verifyEmailandUpdatePlan(promembershipregistrationrequest request,
			ProMembershipRegistrationRepository repo) throws Exception {

		String plan_name = request.getPlan_name();
		String email = request.getEmail();
		String date = request.getDate();
		String amount = "";
		if (request.isPlanNameNull(plan_name)) {
			repo.updateMembership(email, plan_name, date);
			amount = repo.returnPlanAmount(plan_name);
		}

		return amount;

	}

}
