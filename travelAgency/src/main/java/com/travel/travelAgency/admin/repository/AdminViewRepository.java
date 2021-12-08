package com.travel.travelAgency.admin.repository;

import java.util.List;
import java.util.Map;

/**
 * @author sowjanyamani
 */

public interface AdminViewRepository {

	public List<Map<String, Object>> getListofGrievances() throws Exception;
	
	
}
