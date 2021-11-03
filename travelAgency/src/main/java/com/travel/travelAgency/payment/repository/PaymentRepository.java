package com.travel.travelAgency.payment.repository;

public interface PaymentRepository {

	public void savePaymentDetails(float amount, int userId);
}
