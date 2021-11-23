package com.travel.travelAgency.beforePayment.repository;

public interface ProMembershipSubscriptionRepository {

	public String getEmailId(int userId);
	public int getPlanCost(String emailId);
}
