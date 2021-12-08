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

import com.travel.travelAgency.authentication.interfaces.SignUpInterface;

@Controller
public class SignUpController {

	@Autowired
	SignUpInterface signUpObj;
	
	@RequestMapping(value="/signup", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return "signup";
    }

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String SignUp(ModelMap model, @RequestParam String username, @RequestParam String password,
			@RequestParam String email, @RequestParam String securityQuestionId ,
			@RequestParam String securityAnswer, HttpServletRequest request,HttpServletResponse response) {
	response.setContentType("text/html");
	String setusername =request.getParameter("username");
	String setpassword =request.getParameter("password");
	String setemail =request.getParameter("email");
	String setsecurityQuestionId =request.getParameter("securityQuestionId");
	String setsecurityAnswer =request.getParameter("securityAnswer");
		String message = signUpObj.signUp(username, password, email, securityQuestionId, securityAnswer);
		if(message.equals("Failed to signup")) {
			model.addAttribute("errorMessage", "Sign up failed. Please try again.");
			return "login";
	}
		model.put("name", username);
        model.put("password", password);
        model.put("email", email);
        model.put("securityQuestionId", securityQuestionId);
        model.put("securityAnswer",securityAnswer);
        HttpSession session=request.getSession();  
        session.setAttribute("name",setusername);
        session.setAttribute("password",setpassword);
        session.setAttribute("email",setemail);
        session.setAttribute("securityQuestionId",setsecurityQuestionId);
        session.setAttribute("securityAnswer",setsecurityAnswer);
        session.setAttribute("currentdate", java.time.LocalDate.now()); 
		
        return "login";
}
}