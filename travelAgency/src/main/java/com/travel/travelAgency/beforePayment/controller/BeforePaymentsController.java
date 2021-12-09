package com.travel.travelAgency.beforePayment.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.travel.travelAgency.beforePayment.interfaces.BeforePaymentsInterface;

/**
 * @author ruchishinde
 */

@Controller
public class BeforePaymentsController {

	@Autowired
	BeforePaymentsInterface proMembership;
	
	@RequestMapping(value = "/checkoutBooking", method = RequestMethod.POST)
	public String calculateTotalCost(HttpServletRequest request, ModelMap model) {
		BigDecimal initialCost = (BigDecimal)(request.getSession().getAttribute("flightCost"));
		int noOfBags = (int) request.getSession().getAttribute("numBaggages");
		boolean isTakingInsurance = Boolean.parseBoolean(request.getParameter("insurance"));
		int bookingId = (int) request.getSession().getAttribute("bookingId");
		int noOfPassengers = (int)request.getSession().getAttribute("numOfPassengers");
		proMembership.setEmail((String) request.getSession().getAttribute("email"));
		proMembership.setInitialCost(initialCost);
		proMembership.setIsTravelInsuranceChecked(isTakingInsurance);
		proMembership.setPromoCode(request.getParameter("promoCode"));
		proMembership.setNoOfBags(noOfBags);
		proMembership.setBookingId(bookingId);
		proMembership.setNoOfPassengers(noOfPassengers);
		float finalCost = proMembership.calculateFinalCost();
		model.addAttribute("amount", finalCost);
		return "payment";
	}
	
	@RequestMapping(value = "/checkoutBooking", method = RequestMethod.GET)
	public String displayPreBookingsPage(HttpServletRequest request, ModelMap model) {
		return "checkoutToPayment";
	}

}
