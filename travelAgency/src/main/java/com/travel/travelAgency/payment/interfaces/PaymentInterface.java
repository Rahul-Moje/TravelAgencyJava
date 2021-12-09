package com.travel.travelAgency.payment.interfaces;

/**
 * @author ruchishinde
 */

public interface PaymentInterface {

	public void setUserId(int userId);
	public void setDisplayAmount(float amount);
	public int getUserId();
	public float getDisplayAmount();
	public String processPayment(float displayAmount, String userEmail);
}
