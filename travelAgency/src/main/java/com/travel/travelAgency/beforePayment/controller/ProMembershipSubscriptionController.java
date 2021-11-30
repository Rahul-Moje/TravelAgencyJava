package com.travel.travelAgency.beforePayment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.travel.travelAgency.beforePayment.interfaces.ProMembershipSubscriptionInterface;
import com.travel.travelAgency.beforePayment.manager.BeforePaymentModel;

@Controller
public class ProMembershipSubscriptionController {

	@Autowired
	ProMembershipSubscriptionInterface proMembership;

	@RequestMapping(value = "/checkoutBooking", method = RequestMethod.POST)
	public String calculateTotalCost(BeforePaymentModel paymentChecks, ModelMap model) {
		float finalCost = proMembership.calculateFinalCost();
		model.addAttribute("displayAMount", finalCost);
		return "payment";
	}

}
