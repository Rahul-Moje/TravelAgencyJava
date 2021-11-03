package com.travel.travelAgency.payment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaymentController {

	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String showPaymentsPage(Model model) {
		return "payment";
	}

	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public String payment(ModelMap model, @RequestParam float amount, @RequestParam int userId) {
		// process payment
		return "welcome";
	}

}
