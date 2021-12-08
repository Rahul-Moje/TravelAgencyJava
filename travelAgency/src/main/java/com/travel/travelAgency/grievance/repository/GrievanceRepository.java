package com.travel.travelAgency.grievance.repository;

/**
 * @author sowjanyamani
 */

public interface GrievanceRepository {

	public void registerGrievance(String email, String complaint) throws Exception;
}
