package com.travel.travelAgency.authenticationTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.travel.travelAgency.authentication.controller.LoginController;

@SpringBootTest
public class LoginControllerTest {

	@Autowired
	private LoginController loginController;
	
	@Test
	public void testLoginController() {
		assertNotNull(loginController);
	}
}
