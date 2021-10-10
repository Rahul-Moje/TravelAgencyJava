package com.travel.travelAgency.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.travel.travelAgency.dao.UserAuthDAO;
import com.travel.travelAgency.models.UserAuth;

@RestController
public class LoginController {
	
	@Autowired
	UserAuthDAO userDAO;

	@RequestMapping(value="/login")
	public ResponseEntity<Object> login(@RequestParam(defaultValue = "admin") String username, @RequestParam(defaultValue = "admin") String password){
		UserAuth user = new UserAuth();
		int user_id = userDAO.validateUsernamePassword(username, password);
		if(user != null) {
			return new ResponseEntity<Object>("Success",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Object>("Login Failed!",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
