package com.travel.travelAgency.payment.controller;

import java.sql.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.travel.travelAgency.payment.dao.PaymentDAO;
import com.travel.travelAgency.payment.interfaces.PaymentInterface;
import com.travel.travelAgency.payment.manager.PaymentManager;
import com.travel.travelAgency.payment.models.PaymentModel;

@Controller
public class PaymentController {

	@Autowired
	PaymentInterface paymentManager;
		
	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String showPaymentsPage(Model model) {
		return "payment";
	}

	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public String payment(PaymentModel payment) {
		float displayAmount = payment.getDisplayAmount();
		int userId = payment.getUserId();
		String response = paymentManager.processPayment(displayAmount, userId);
		if(response.equalsIgnoreCase("Success")) {
			return "welcome"; 
		}else {
			return "login";
		}
	}

}
