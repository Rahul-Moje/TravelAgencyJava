package com.travel.travelAgency.beforePayment.interfaces;

import com.travel.travelAgency.beforePayment.manager.BeforePaymentModel;
import com.travel.travelAgency.beforePayment.manager.ProMembershipSubscriptionManager;
import com.travel.travelAgency.beforePayment.repository.ProMembershipSubscriptionRepository;

public interface ProMembershipSubscriptionInterface {
	
	public float calculateFinalCost();
	public int getPlanCostForProMember(String emailId);
}
