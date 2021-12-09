package com.travel.travelAgency.beforePaymentsTest;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.travel.travelAgency.beforePayment.controller.BeforePaymentsController;

@SpringBootTest
public class BeforePaymentsControllerTest {

	@Autowired
	BeforePaymentsController beforePaymentsController;
	@Test
	public void calculateTotalCostTest() {
		assertNotNull(beforePaymentsController);
	}
}
