package com.travel.travelAgency.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.travelAgency.authentication.dao.UserAuthDAO;
import com.travel.travelAgency.authentication.interfaces.LoginInterface;
import com.travel.travelAgency.authentication.models.UserAuth;
import com.travel.travelAgency.authentication.repository.UserAuthRepository;

@RestController
public class LoginController {

	@Autowired
	LoginInterface loginObj;

	@RequestMapping(value = "/login")
	public ResponseEntity<Object> login(@RequestParam(defaultValue = "admin") String username,
			@RequestParam(defaultValue = "admin") String password) {
		String message = loginObj.login(username, password);
		return new ResponseEntity<Object>(message, HttpStatus.OK);

	}
}
