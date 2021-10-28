package com.travel.travelAgency.authentication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class HelloWorldController {

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	String home() {
		return "Hello World!";
	}

}
