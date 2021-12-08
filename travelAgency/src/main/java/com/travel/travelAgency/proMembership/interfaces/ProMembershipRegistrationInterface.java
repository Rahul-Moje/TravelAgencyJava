package com.travel.travelAgency.proMembership.interfaces;

import java.util.List;
import java.util.Map;

import com.travel.travelAgency.proMembership.models.promembershipregistrationrequest;
import com.travel.travelAgency.proMembership.repository.ProMembershipRegistrationRepository;

/**
 * @author sowjanyamani
 */

public interface ProMembershipRegistrationInterface {

	public List<Map<String, Object>> verifyPlans() throws Exception;

	public String verifyEmailandUpdatePlan(promembershipregistrationrequest request,
			ProMembershipRegistrationRepository repo) throws Exception;

}
