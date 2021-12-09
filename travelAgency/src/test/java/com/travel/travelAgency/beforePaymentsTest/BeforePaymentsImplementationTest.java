package com.travel.travelAgency.beforePaymentsTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import com.travel.travelAgency.beforePayment.interfaces.BeforePaymentsInterface;
import com.travel.travelAgency.beforePayment.manager.BeforePaymentsManager;

@SpringBootTest
public class BeforePaymentsImplementationTest {
	
	@Autowired
	BeforePaymentsInterface beforePayments;
	
	@Autowired
	Environment env;

	@Test
	public void calculateFinalCostTest() {
		beforePayments.setBookingId(11);
		beforePayments.setEmail("admin@dal.ca");
		beforePayments.setIsTravelInsuranceChecked(true);
		beforePayments.setNoOfBags(2);
		beforePayments.setNoOfPassengers(2);
		beforePayments.setPromoCode("DISCOUNT10");
		float insuranceFess = 0.0f;
		float chargesPerBag = 0.0f;
		float promoDicount = 0.0f;
		BeforePaymentsManager beforePaySetVariables = Mockito.spy(new BeforePaymentsManager());
		doReturn(insuranceFess).when(beforePaySetVariables).getInsuranceFess();
		doReturn(chargesPerBag).when(beforePaySetVariables).getChargesPerBag();
		doReturn(promoDicount).when(beforePaySetVariables).getDiscountOnPromoCode();
		BigDecimal initialCost = new BigDecimal("100000");
		beforePayments.setInitialCost(initialCost);
		float finalCost = beforePayments.calculateFinalCost();
		assertEquals(finalCost, 184494.0f);
	}
	
}
