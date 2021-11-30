package com.travel.travelAgency.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.travelAgency.authentication.interfaces.LoginInterface;

@Controller
public class LoginController {

	@Autowired
	LoginInterface loginObj;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return "login";
    }

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(ModelMap model, @RequestParam String email,
			@RequestParam String password) {
		String message = loginObj.login(email, password);
		if(message.equals("Failed to login")) {
			model.addAttribute("errorMessage", "Login Failed. Please check your credentials and try again");
			return "login";
		}
		
		return "welcome";

	}
}
