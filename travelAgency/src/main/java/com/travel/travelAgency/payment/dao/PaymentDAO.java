package com.travel.travelAgency.payment.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.travel.travelAgency.payment.repository.PaymentRepository;

@Repository
public class PaymentDAO implements PaymentRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void savePaymentDetails(float amount, int userId) {
		String query = "insert into user_payments (user_id, date_of_payment, paid_amt) values (1, 1, '11/03/2021 00:00:00', 1000)";
		jdbcTemplate.update(query);
	}

}
