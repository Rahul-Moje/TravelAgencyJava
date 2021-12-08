package com.travel.travelAgency.admin.manager;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.travelAgency.admin.interfaces.AdminViewInterface;
import com.travel.travelAgency.admin.repository.AdminViewRepository;

/**
 * @author sowjanyamani
 */

@Service
public class AdminViewImplementation implements AdminViewInterface {

	@Autowired
	AdminViewRepository repo;

	@Override
	public List<Map<String, Object>> viewGrievance() throws Exception {
		
		List<Map<String, Object>> listofGrievances = repo.getListofGrievances();

		return listofGrievances;
	}
	
	
	
	
	
}
