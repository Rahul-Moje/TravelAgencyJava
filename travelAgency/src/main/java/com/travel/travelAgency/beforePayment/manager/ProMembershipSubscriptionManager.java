package com.travel.travelAgency.beforePayment.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.travelAgency.beforePayment.interfaces.ProMembershipSubscriptionInterface;
import com.travel.travelAgency.beforePayment.repository.ProMembershipSubscriptionRepository;

@Service
public class ProMembershipSubscriptionManager implements ProMembershipSubscriptionInterface{

	String email;
	float initialCost;
	String promoCode;
	boolean isTravelInsuranceChecked;
	float weightOfAdditionalBaggage;
	
	@Autowired
	ProMembershipSubscriptionRepository proMembershipSubsciption;
	
	@Override
	public int getPlanCostForProMember(String emailId) {
		int planCost = proMembershipSubsciption.getPlanCost(emailId);
		return planCost;
	}

	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public float getInitialCost() {
		return this.initialCost;
	}
	
	public String getPromoCode() {
		return this.promoCode;
	}
	
	public boolean getIsTravelInsuranceChecked() {
		return this.isTravelInsuranceChecked;
	}
	
	public float weightOfAdditionalBaggage() {
		return this.weightOfAdditionalBaggage;
	}
	
	@Override
	public float calculateFinalCost() {
		String emailId = this.email;
		float insuranceFees = 0.0f;
		if(this.isTravelInsuranceChecked) {
			insuranceFees = Float.parseFloat(AddOns.valueOf("INSURANCE_CHARGES").toString());
		}
		float addOnBaggageCharge = this.weightOfAdditionalBaggage * Float.parseFloat(AddOns.valueOf("CHARGE_PER_KG").toString()) ;
		int planCost = getPlanCostForProMember(emailId);
		float finalAmount = (this.initialCost - planCost) + insuranceFees + addOnBaggageCharge;
		return finalAmount;
	}
	
	

	
}
