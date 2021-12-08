package com.travel.travelAgency.adminTest;

import static org.junit.Assert.assertNotNull;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.travel.travelAgency.admin.interfaces.AdminViewInterface;
import com.travel.travelAgency.admin.manager.AdminViewImplementation;

/**
 * @author sowjanyamani
 */

@SpringBootTest
public class AdminViewImplementationTest {

	@Autowired
	AdminViewInterface adminViewInterface;
	
	@Test
	public void adminViewImplementationClassExist() {
		AdminViewImplementation adminViewImplementation = new AdminViewImplementation();
		assertNotNull(adminViewImplementation);

	}
	
	@Test
	public void viewGrievanceTest() throws Exception {
		String SQL = "select * from grievance";
		Connection conn = Mockito.mock(Connection.class);

		ResultSet resultSet = Mockito.mock(ResultSet.class);
		PreparedStatement statement = Mockito.mock(PreparedStatement.class);
		try {
			Mockito.when(statement.executeQuery(SQL)).thenReturn(resultSet);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
