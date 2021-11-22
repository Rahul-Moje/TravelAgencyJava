package com.travel.travelAgency.payment.manager;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.travelAgency.payment.dao.PaymentDAO;
import com.travel.travelAgency.payment.interfaces.PaymentInterface;

@Service
public class PaymentManager implements PaymentInterface {

	float displayAmount;
	int userId;

	@Autowired
	PaymentDAO paymentDao;

	@Override
	public void setUserId(int userId) {
		this.userId = userId;

	}

	@Override
	public int getUserId() {
		return this.userId;
	}

	
	@Override
	public void setDisplayAmount(float amount) {
		this.displayAmount = amount;
	}
	
	@Override
	public float getDisplayAmount() {
		return this.displayAmount;
	}

	@Override
	public String processPayment(float displayAmount, int userId) {
		int n = paymentDao.savePaymentDetails(displayAmount, userId);
		String response = "";
		if (n != 0) {
			response = "Success";
		} else {
			response = "Failed";
		}
		return response;
	}

}
