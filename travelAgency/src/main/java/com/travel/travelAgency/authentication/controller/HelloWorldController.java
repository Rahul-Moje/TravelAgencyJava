package com.travel.travelAgency.authentication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloWorldController {


	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
		return "welcome";
	}

}
