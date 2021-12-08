package com.travel.travelAgency.grievance.manager;

import org.springframework.stereotype.Service;

import com.travel.travelAgency.grievance.interfaces.GrievanceInterface;
import com.travel.travelAgency.grievance.model.Grievancerequest;
import com.travel.travelAgency.grievance.repository.GrievanceRepository;

/**
 * @author sowjanyamani
 */

@Service
public class GrievanceImplementation implements GrievanceInterface {
	@Override
	public Boolean registerGrievanceComplaint(Grievancerequest request, GrievanceRepository repo) throws Exception {
		String email = request.getEmail();
		String complaint = request.getComplaint();
		if (request.isComplaintNull(complaint)) {
			repo.registerGrievance(email, complaint);
			return true;
		} else {
			return false;
		}

	}
}