package com.travel.travelAgency.grievance.repository;

public interface GrievanceRepository {

	public void registerGrievance(String email, String complaint) throws Exception;
}
