package com.travel.travelAgency.payment.interfaces;

import java.sql.Date;

public interface PaymentInterface {

	public void setUserId(int userId);
	public void setDisplayAmount(float amount);
	public int getUserId();
	public float getDisplayAmount();
	public String processPayment(float displayAmount, int userId);
}