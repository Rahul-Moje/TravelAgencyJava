package com.travel.travelAgency.payment.models;

public class PaymentModel {
	Float displayAmount;
	Integer userId;

	public void setUserId(Integer userId) {
		this.userId = userId;

	}

	
	public int getUserId() {
		return userId;
	}

	
	public void setDisplayAmount(Float amount) {
		this.displayAmount = amount;
	}
	
	public float getDisplayAmount() {
		return displayAmount;
	}
}
