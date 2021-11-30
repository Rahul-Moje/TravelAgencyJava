package com.travel.travelAgency.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.travel.travelAgency.payment.interfaces.PaymentInterface;
import com.travel.travelAgency.payment.manager.PaymentManager;

@Controller
public class PaymentController {

	@Autowired
	PaymentInterface paymentManager;
		
	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String showPaymentsPage(Model model, float displayAmount) {
		model.addAttribute("displayAmount", displayAmount);
		return "payment";
	}

	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public String payment(PaymentManager payment) {
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
