package com.travel.travelAgency.payment.repository;

import java.sql.Date;

public interface PaymentRepository {

	public int savePaymentDetails(float amount, int userId);
}
