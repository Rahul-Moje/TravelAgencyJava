package com.travel.travelAgency.authentication.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	
	@RequestMapping("/", method = RequestMethod.GET)
	String home() {
		return "Hello World!";
	}

}
