package com.travel.travelAgency.beforePaymentsTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.travel.travelAgency.beforePayment.repository.BeforePaymentsRepository;

@SpringBootTest
public class BeforePaymentsDAOTest {

	@Autowired
	BeforePaymentsRepository beforePaymentsRepository;

	@Test
	public void  checkClassExists() {
		assertNotNull(beforePaymentsRepository);
	}
	@Test
	public void getEmailIdTest() {
		int userId = 1;
		assertEquals(beforePaymentsRepository.getEmailId(userId),"admin@dal.ca");
	}

	@Test
	public void getPlanCostTest() {
		int planCost = 5000;
		assertEquals(beforePaymentsRepository.getPlanCost("user1@dal.ca"), planCost);
	}
	
	
	@Test
	public void updateFinalCostTest() {
		float finalCost = 200000.0f;
		int bookingId = 1;
		float baggageWeight = 1500.0f;
		assertEquals(beforePaymentsRepository.updateFinalCost(finalCost, bookingId, baggageWeight), 1);
	}
	
	@Test
	public void getDiscountPercentOnPromoCodeTest() {
		String promoCode = "DISCOUNT10";
		assertEquals(beforePaymentsRepository.getDiscountPercentOnPromoCode(promoCode), 10.0f);
	}
}
