package com.travel.travelAgency.promembershipTest;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.travel.travelAgency.proMembership.interfaces.ProMembershipRegistrationInterface;
import com.travel.travelAgency.proMembership.manager.ProMembershipRegistrationImplementation;

/**
 * @author sowjanyamani
 */

@SpringBootTest
public class ProMembershipRegistrationImplementationTest {

	@Autowired
	ProMembershipRegistrationInterface promembershipService;

	@Test
	public void proMembershipClassExist() {
		ProMembershipRegistrationImplementation promembershipregistrationimplementation = new ProMembershipRegistrationImplementation();
		assertNotNull(promembershipregistrationimplementation);

	}

	@Test
	public void verifyEmailandUpdatePlanTest() throws Exception {
		LocalDateTime now = LocalDateTime.now();
		String plan_name = "Gold";
		String email = "user1@dal.ca";
		String date = now.toString();
		String SQL1 = "insert into subscriptions_works (user_email_id,plan_name,date_of_purchase) VALUES ('" + email
				+ "','" + plan_name + "','" + date + ")";
		String SQL2 = "select plan_cost from pro_membership where plan_name='" + plan_name + "'";
		Connection conn = Mockito.mock(Connection.class);

		ResultSet resultSet = Mockito.mock(ResultSet.class);
		PreparedStatement statement = Mockito.mock(PreparedStatement.class);
		try {
			Mockito.when(statement.executeUpdate(SQL1)).thenReturn(1);
			Mockito.when(statement.executeQuery(SQL2)).thenReturn(resultSet);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Test
	public void verifyPlansTest() throws Exception {
		String SQL = "select * from pro_membership";
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
