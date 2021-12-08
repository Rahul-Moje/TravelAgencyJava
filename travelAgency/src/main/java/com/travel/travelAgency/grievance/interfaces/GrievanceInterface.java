package com.travel.travelAgency.grievance.interfaces;

import com.travel.travelAgency.grievance.model.Grievancerequest;
import com.travel.travelAgency.grievance.repository.GrievanceRepository;

/**
 * @author sowjanyamani
 */

public interface GrievanceInterface {

	public Boolean registerGrievanceComplaint(Grievancerequest request, GrievanceRepository repo) throws Exception;

}
