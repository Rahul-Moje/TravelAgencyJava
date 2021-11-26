package com.travel.travelAgency.grievance.manager;

import org.springframework.stereotype.Service;

import com.travel.travelAgency.grievance.interfaces.GrievanceInterface;
import com.travel.travelAgency.grievance.model.Grievancerequest;
import com.travel.travelAgency.grievance.repository.GrievanceRepository;

@Service
public class GrievanceImplementation implements GrievanceInterface {

	@Override
	public String RegisterGrievanceComplaint(Grievancerequest request, GrievanceRepository repo) throws Exception {
		String email = request.getEmail();
		String complaint = request.getComplaint();
		repo.registerGrievance(email, complaint);

		return "Complaint Filed!!";

	}
}