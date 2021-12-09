package com.travel.travelAgency.authentication.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.travel.travelAgency.authentication.interfaces.LoginInterface;

/**
 * @author ruchishinde
 */

@Controller
public class LoginController {

	@Autowired
	LoginInterface loginObj;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return "login";
    }

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(ModelMap model, @RequestParam String emailId,
			@RequestParam String password,HttpServletRequest request,HttpServletResponse response) {
	response.setContentType("text/html");
	String email = request.getParameter("emailId");	
	request.getSession().setAttribute("setusername", email);
	String message = loginObj.login(email, password);
		if(message.equals("Failed to login")) {
			model.addAttribute("errorMessage", "Login Failed. Please check your credentials and try again");
			return "login";
		}

		model.put("name", email);
        model.put("password", password);
        model.put("setusername", email);
        HttpSession session=request.getSession();  
        session.setAttribute("name",email);
        session.setAttribute("email",email);
        session.setAttribute("currentdate", java.time.LocalDate.now());
		return "user";
 
	}
}
