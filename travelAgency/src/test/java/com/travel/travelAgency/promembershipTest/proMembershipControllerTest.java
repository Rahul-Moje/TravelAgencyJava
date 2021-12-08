package com.travel.travelAgency.promembershipTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.travel.travelAgency.proMembership.controller.ProMembershipRegistrationController;

/**
 * @author sowjanyamani
 */

@SpringBootTest
public class proMembershipControllerTest {

	@Autowired
	ProMembershipRegistrationController promembershipcontroller;
	
	@Test
	public void testPromembershipController() {
		assertNotNull(promembershipcontroller);
	}
	
}
