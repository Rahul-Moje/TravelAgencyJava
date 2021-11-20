package com.travel.travelAgency.grievance.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.travel.travelAgency.grievance.repository.GrievanceRepository;

@Repository
public class GrievanceDAO implements GrievanceRepository{

	
	
	@Autowired
	JdbcTemplate jdbctemplate;

	@Override
	public void registerGrievance(String email, String complaint) throws Exception {

		String SQL = "INSERT INTO grievance (user_email_id,complaint) VALUES ('" + email
				+ "','" + complaint + "')";
		jdbctemplate.setQueryTimeout(10000);
		jdbctemplate.update(SQL);

	}
}
