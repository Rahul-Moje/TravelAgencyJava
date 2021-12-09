package com.travel.travelAgency.payment.repository;

/**
 * @author ruchishinde
 */

public interface PaymentRepository {

	public int savePaymentDetails(float amount, String email);
}
