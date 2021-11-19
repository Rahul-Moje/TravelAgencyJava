package com.travel.travelAgency.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.travel.travelAgency.payment.dao.PaymentDAO;

@Controller
public class PaymentController {

	@Autowired
	PaymentDAO paymentDAO;
	
	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String showPaymentsPage(Model model) {
		return "payment";
	}

	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public String payment(ModelMap model, @RequestParam float amount, @RequestParam int userId) {
		paymentDAO.savePaymentDetails(amount, userId);
		return "welcome"; 
	}

}
