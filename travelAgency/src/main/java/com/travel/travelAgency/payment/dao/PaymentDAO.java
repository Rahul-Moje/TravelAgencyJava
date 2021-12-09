package com.travel.travelAgency.payment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Repository;

import com.travel.travelAgency.payment.repository.PaymentRepository;
import com.travel.travelAgency.util.DatabaseConnection;

/**
 * @author ruchishinde
 */

@Repository
public class PaymentDAO implements PaymentRepository {

	Connection con = DatabaseConnection.getSQLConnection();

	@Override
	public int savePaymentDetails(float amount, String email) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String datetime = now.toString();
		String query = "insert into user_payments (user_email, date_of_payment, paid_amt) values ('" + email + "','"
				+ datetime + "', " + amount + ")";
		int n = 0;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}

}
