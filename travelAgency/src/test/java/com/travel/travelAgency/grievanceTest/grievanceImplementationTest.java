package com.travel.travelAgency.grievanceTest;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.travel.travelAgency.grievance.interfaces.GrievanceInterface;
import com.travel.travelAgency.grievance.manager.GrievanceImplementation;

/**
 * @author sowjanyamani
 */

@SpringBootTest
public class grievanceImplementationTest {

	@Autowired
	GrievanceInterface grievanceinterface;

	@Test
	public void grievanceClassExist() {
		GrievanceImplementation grievancemanager = new GrievanceImplementation();
		assertNotNull(grievancemanager);

	}

	@Test
	public void registerGrievanceComplaintTest() throws Exception 
	{
		String email = "user1@dal.ca";
		String complaint = "clean the flight";
		String SQL = "INSERT INTO grievance (user_email_id,complaint) VALUES ('" + email + "','" + complaint + "')";
		Connection conn = Mockito.mock(Connection.class);
		ResultSet resultSet = Mockito.mock(ResultSet.class);
		PreparedStatement statement = Mockito.mock(PreparedStatement.class);
		try 
		{
		  Mockito.when(statement.executeUpdate(SQL)).thenReturn(1);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
