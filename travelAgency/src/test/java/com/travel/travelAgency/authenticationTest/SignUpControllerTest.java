package com.travel.travelAgency.authenticationTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.travel.travelAgency.authentication.controller.SignUpController;

@SpringBootTest
public class SignUpControllerTest {

	@Autowired
	private SignUpController SignUpController;
	
	@Test
	public void testLoginController() {
		assertNotNull(SignUpController);
	}
}

