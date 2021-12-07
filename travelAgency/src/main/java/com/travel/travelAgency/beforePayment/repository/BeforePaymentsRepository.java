package com.travel.travelAgency.beforePayment.repository;

public interface BeforePaymentsRepository {

	public String getEmailId(int userId);

	public int getPlanCost(String emailId);

	int updateFinalCost(float finalCost, int bookingId, float baggageWeight);

	float getDiscountPercentOnPromoCode(String promoCode);

}
