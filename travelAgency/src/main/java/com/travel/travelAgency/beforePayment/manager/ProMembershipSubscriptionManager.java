package com.travel.travelAgency.beforePayment.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.travelAgency.beforePayment.interfaces.ProMembershipSubscriptionInterface;
import com.travel.travelAgency.beforePayment.repository.ProMembershipSubscriptionRepository;

@Service
public class ProMembershipSubscriptionManager implements ProMembershipSubscriptionInterface{

	@Autowired
	ProMembershipSubscriptionRepository proMembershipSubsciption;
	
	@Override
	public boolean isProMember(int userId) {
		String emailId = proMembershipSubsciption.getEmailId(userId);
		int planCost = proMembershipSubsciption.getPlanCost(emailId);
		boolean isPro = false;
		if(planCost != 0) {
			isPro = true;
		}
		return isPro;
	}

}
