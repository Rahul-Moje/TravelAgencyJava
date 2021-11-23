package com.travel.travelAgency.beforePayment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.travel.travelAgency.beforePayment.interfaces.ProMembershipSubscriptionInterface;

@Controller
public class ProMembershipSubscriptionController {

	@Autowired 
	ProMembershipSubscriptionInterface proMembership;
	
	

	
}
