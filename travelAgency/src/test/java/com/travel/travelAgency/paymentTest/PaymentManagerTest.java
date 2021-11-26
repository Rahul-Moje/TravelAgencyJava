package com.travel.travelAgency.paymentTest;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.travel.travelAgency.payment.interfaces.PaymentInterface;
import com.travel.travelAgency.payment.manager.PaymentManager;

@SpringBootTest
public class PaymentManagerTest {

	@Autowired
	PaymentInterface paymentManager;
	
	@Test
	public void paymentExistClassExist() {
		PaymentManager paymentmanager = new PaymentManager(); 
		assertNotNull(paymentmanager);
	}
	
	@Test
	public void processTransactionTest() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		int userId =1;
		float displayAmount = 1000.0f;
		String datetime = now.toString();
		String query = "insert into user_payments (user_id, date_of_payment, paid_amt) values (" + userId + ",'"
				+ datetime + "', " + displayAmount + ")";
		Connection conn = Mockito.mock(Connection.class);
	    ResultSet resultSet = Mockito.mock(ResultSet.class);
	    PreparedStatement statement = Mockito.mock(PreparedStatement.class);
	    try {
			Mockito.when(statement.executeUpdate(query)).thenReturn(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		}
	
}
