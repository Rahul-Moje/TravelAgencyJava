package com.travel.travelAgency.paymentTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.travel.travelAgency.payment.dao.PaymentDAO;
import com.travel.travelAgency.payment.interfaces.PaymentInterface;
import com.travel.travelAgency.payment.manager.PaymentManager;
import com.travel.travelAgency.payment.repository.PaymentRepository;

@SpringBootTest
public class PaymentImplementationTest {

	@Autowired
	PaymentInterface paymentManager;

	PaymentRepository paymentRepository = Mockito.mock(PaymentDAO.class);

	@Test
	public void paymentExistClassExist() {
		PaymentManager paymentmanager = new PaymentManager();
		assertNotNull(paymentmanager);
	}

	@Test
	public void processTransactionTest() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String email = "admin@dal.ca";
		float displayAmount = 1000.0f;
		String datetime = now.toString();
		when(paymentRepository.savePaymentDetails(displayAmount, email)).thenReturn(1);
		String response = paymentManager.processPayment(displayAmount, email);
		assertEquals(response, "Success");
	}

}
