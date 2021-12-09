package com.travel.travelAgency.beforePayment.interfaces;

/**
 * @author ruchishinde
 */

import java.math.BigDecimal;

public interface BeforePaymentsInterface {

	public float calculateFinalCost();

	public int getPlanCostForProMember(String emailId);

	public String getEmail();

	public void setEmail(String email);

	public BigDecimal getInitialCost();

	public void setInitialCost(BigDecimal initialCost);

	public String getPromoCode();

	public void setPromoCode(String promoCode);

	public boolean getIsTravelInsuranceChecked();

	public void setIsTravelInsuranceChecked(boolean isTravelInsuranceChecked);

	public void setNoOfBags(int noOfBags);

	public int getNoOfBags();

	public void setBookingId(int bookingId);

	public int getBookingId();

	public void setNoOfPassengers(int noOfPassengers);

	public int getNoOfPassengers();

	public float getInsuranceFess();

	public float getChargesPerBag();
	
	public float getDiscountOnPromoCode();
}
