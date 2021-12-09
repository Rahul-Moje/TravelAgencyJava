package com.travel.travelAgency.payment.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.travel.travelAgency.payment.interfaces.PaymentInterface;
import com.travel.travelAgency.payment.manager.PaymentManager;

/**
 * @author ruchishinde
 */

@Controller
public class PaymentController {

	@Autowired
	PaymentInterface paymentManager;
		
	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String showPaymentsPage(Model model) {
		return "payment";
	}

	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public String payment(HttpServletRequest request) {
		Float displayAmount = Float.parseFloat(request.getParameter("displayAmount").toString());
		String userEmail =  (String) request.getSession().getAttribute("email");
		String response = paymentManager.processPayment(displayAmount, userEmail);
		if(response.equalsIgnoreCase("Success")) {
			return "paymentSuccess"; 
		}else {
			return "paymentFailure";
		}
	}

}
