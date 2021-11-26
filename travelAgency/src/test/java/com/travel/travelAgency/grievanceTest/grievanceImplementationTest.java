package com.travel.travelAgency.grievanceTest;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.travel.travelAgency.grievance.interfaces.GrievanceInterface;
import com.travel.travelAgency.grievance.manager.GrievanceImplementation;
import com.travel.travelAgency.grievance.repository.GrievanceRepository;

@SpringBootTest
public class grievanceImplementationTest {

	@Autowired
	GrievanceInterface grievanceinterface;
	
	@Mock
	GrievanceRepository repo;
	
	@Test
	public void grievanceClassExist() {
		GrievanceImplementation grievancemanager = new GrievanceImplementation();
		assertNotNull(grievancemanager);


	}
	@Test
	public void RegisterGrievanceComplaintTest() throws Exception {
		String email = "user1@dal.ca";
		String complaint = "clean the flight";
		doNothing().when(repo).registerGrievance(email, complaint);
	
	
	
//	@Test
//	public void RegisterGrievanceComplaintTest() throws Exception {
//		String email = "user1@dal.ca";
//		String complaint = "clean the flight";
//		String SQL = "INSERT INTO grievance (user_email_id,complaint) VALUES ('" + email
//				+ "','" + complaint + "')";
//		//Connection conn = Mockito.mock(Connection.class);
//		ResultSet resultSet = Mockito.mock(ResultSet.class);
//		PreparedStatement statement = Mockito.mock(PreparedStatement.class);
//		try {
//			Mockito.when(statement.executeUpdate(SQL)).thenReturn(Mockito.anyInt());
//			} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
//
//	}
	
	
}
}
