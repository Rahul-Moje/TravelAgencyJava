package com.travel.travelAgency.proMembership.repository;

import java.util.List;
import java.util.Map;

public interface ProMembershipRegistrationRepository {

	public List<Map<String,Object>> getListofMembership() throws Exception;
	
}
