package com.travel.travelAgency.beforePayment.manager;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.travel.travelAgency.beforePayment.interfaces.BeforePaymentsInterface;
import com.travel.travelAgency.beforePayment.repository.BeforePaymentsRepository;

/**
 * @author ruchishinde
 */

@Service
public class BeforePaymentsManager implements BeforePaymentsInterface {

	String email;
	BigDecimal initialCost;
	String promoCode;
	boolean isTravelInsuranceChecked;
	int noOfBags;
	int bookingId;
	int noOfPassengers;

	@Autowired
	BeforePaymentsRepository beforePaymentsRepository;
	
	@Autowired
	Environment env;

	@Override
	public int getPlanCostForProMember(String emailId) {
		int planCost = beforePaymentsRepository.getPlanCost(emailId);
		return planCost;
	}
	
	@Override
	public String getEmail() {
		return this.email;
	}
	
	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public BigDecimal getInitialCost() {
		return this.initialCost;
	}
	
	@Override
	public void setInitialCost(BigDecimal initialCost) {
		this.initialCost = initialCost;
	}
	
	@Override
	public String getPromoCode() {
		return this.promoCode;
	}
	
	@Override
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}
	
	@Override
	public boolean getIsTravelInsuranceChecked() {
		return this.isTravelInsuranceChecked;
	}
	
	@Override
	public void setIsTravelInsuranceChecked(boolean isTravelInsuranceChecked) {
		this.isTravelInsuranceChecked = isTravelInsuranceChecked;
	}
	
	@Override
	public void setNoOfBags(int noOfBags) {
		this.noOfBags = noOfBags;
		
	}

	@Override
	public int getNoOfBags() {
		return this.noOfBags;
	}

	@Override
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
		
	}

	@Override
	public int getBookingId() {
		return this.bookingId;
	}

	@Override
	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	@Override
	public int getNoOfPassengers() {
		return this.noOfPassengers;
	}
	
	@Override
	public float getInsuranceFess() {
		return Float.parseFloat(env.getProperty("insuranceCost"));
		
	}
	
	@Override
	public float getChargesPerBag() {
		return Float.parseFloat(env.getProperty("costPerAdditionalBag"));
		
	}
	
	@Override
	public float getDiscountOnPromoCode() {
		String promoCode = getPromoCode();
		float discount =  beforePaymentsRepository.getDiscountPercentOnPromoCode(promoCode);
		return discount;
	}
	
	@Override
	public float calculateFinalCost() {
		String emailId = this.email;
		float insuranceFees = getInsuranceFess();
		float chargesPerBag = getChargesPerBag();
		float addOnBaggageCharge = 0.0f;
		float totalInsuranceCharges = 0.0f;
		float promoDicount = getDiscountOnPromoCode();
		if (this.isTravelInsuranceChecked) {
			totalInsuranceCharges = insuranceFees;
		}
		if (this.noOfBags!=0.0f) {
			addOnBaggageCharge = this.noOfBags * chargesPerBag;
		}
		int planCost = getPlanCostForProMember(emailId);
		float initialFlightCost = initialCost.floatValue();
		initialFlightCost = initialFlightCost - ((initialFlightCost*promoDicount)/100);
		float finalAmount = ((initialFlightCost * noOfPassengers) + ((totalInsuranceCharges * noOfPassengers) + addOnBaggageCharge)) - planCost ;
		beforePaymentsRepository.updateFinalCost(finalAmount, bookingId, addOnBaggageCharge);
		return finalAmount;
	}
	
}
