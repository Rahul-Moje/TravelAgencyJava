package com.travel.travelAgency.admin.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.travel.travelAgency.admin.interfaces.AdminViewInterface;
import com.travel.travelAgency.admin.repository.AdminViewRepository;

/**
 * @author sowjanyamani
 */

@Controller
public class AdminViewController {

	@Autowired
	AdminViewInterface adminViewInterface;

	@Autowired
	AdminViewRepository adminViewRepository;

	@RequestMapping(value = "/showGrievanceDetails", method = RequestMethod.GET)
	public String showGrievances(ModelMap model) throws Exception {
		List<Map<String, Object>> list = adminViewInterface.viewGrievance();
		if (list == null) {
			model.addAttribute("errorMessage", "No plans available!");
			return "showGrievanceDetails";
		}
		
		model.put("listofGrievance", list);
		return "showGrievanceDetails";
	}

}
