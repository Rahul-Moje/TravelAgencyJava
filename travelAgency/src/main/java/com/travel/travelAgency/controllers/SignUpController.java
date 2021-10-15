package com.travel.travelAgency.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.travel.travelAgency.interfaces.SignUpInterface;

@RestController
public class SignUpController {

	@Autowired
	SignUpInterface signUpObj;

	@RequestMapping(value = "/signup")
	public ResponseEntity<Object> signUp(@RequestParam(defaultValue = "user_demo") String username,
			@RequestParam(defaultValue = "user_pass_demo") String password, @RequestParam(defaultValue = "user_demo@dal.ca") 
	String email, @RequestParam(defaultValue = "1") int securityQuestionId, @RequestParam(defaultValue = "demo_color") 
	String securityAnswer) {
		String message = signUpObj.signUp(username, password, email, securityQuestionId, securityAnswer);
		return new ResponseEntity<Object>(message, HttpStatus.OK);

	}
}