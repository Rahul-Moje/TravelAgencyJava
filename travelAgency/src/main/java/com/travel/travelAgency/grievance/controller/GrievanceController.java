package com.travel.travelAgency.grievance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.travel.travelAgency.grievance.interfaces.GrievanceInterface;
import com.travel.travelAgency.grievance.model.Grievancerequest;
import com.travel.travelAgency.grievance.repository.GrievanceRepository;

/**
 * @author sowjanyamani
 */

@Controller
public class GrievanceController {

	@Autowired
	GrievanceInterface grievanceInterface;

	@Autowired
	GrievanceRepository grievanceRepository;
	
	@RequestMapping(value = "/grievance", method = RequestMethod.GET)
	public String showGrievancePage(ModelMap model) throws Exception 
	{
		return "grievance";
	}
	

	@RequestMapping(value = "/grievance", method = RequestMethod.POST)
	public String registerGrievancePage(ModelMap model, Grievancerequest request) throws Exception 
	{
		Boolean value = grievanceInterface.registerGrievanceComplaint(request, grievanceRepository);
		if (value != true) 
		{
			model.addAttribute("errorMessage", "Error submitting the grievance!!");
			return "grievance";
		}
		model.put("status", value);
		return "welcome";
	}

}