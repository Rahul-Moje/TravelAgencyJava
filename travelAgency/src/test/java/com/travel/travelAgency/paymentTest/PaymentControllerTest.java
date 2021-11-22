package com.travel.travelAgency.paymentTest;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.travel.travelAgency.payment.controller.PaymentController;

@SpringBootTest
public class PaymentControllerTest {

	@Autowired
	PaymentController paymentController;
	
	@Test
	public void testPaymentControllerNotNull() {
		assertNotNull(paymentController);
	}
}
