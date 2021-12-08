package com.travel.travelAgency.grievance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.travel.travelAgency.grievance.repository.GrievanceRepository;
import com.travel.travelAgency.util.DatabaseConnection;

/**
 * @author sowjanyamani
 */

@Repository
public class GrievanceDao implements GrievanceRepository {

	Connection con = DatabaseConnection.getSQLConnection();

	@Override
	public void registerGrievance(String email, String complaint) throws Exception {

		String SQL = "INSERT INTO grievance (user_email_id,complaint) VALUES ('" + email + "','" + complaint + "')";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(SQL);
			preparedStatement.executeUpdate();

		} catch (DataAccessException e) {
			e.printStackTrace();
		}

	}

}
