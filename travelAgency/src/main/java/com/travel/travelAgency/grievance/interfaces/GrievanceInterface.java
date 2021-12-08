package com.travel.travelAgency.grievance.interfaces;

import com.travel.travelAgency.grievance.model.Grievancerequest;
import com.travel.travelAgency.grievance.repository.GrievanceRepository;

public interface GrievanceInterface 
{
	
	public  Boolean RegisterGrievanceComplaint(Grievancerequest request,
			GrievanceRepository repo) throws Exception;
	
}
