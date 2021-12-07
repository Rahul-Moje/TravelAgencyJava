package com.travel.travelAgency.payment.repository;

public interface PaymentRepository {

	public int savePaymentDetails(float amount, String email);
}
