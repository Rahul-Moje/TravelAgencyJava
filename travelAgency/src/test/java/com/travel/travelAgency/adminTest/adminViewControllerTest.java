package com.travel.travelAgency.adminTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.travel.travelAgency.admin.controller.AdminViewController;

/**
 * @author sowjanyamani
 */

@SpringBootTest
public class adminViewControllerTest {

	@Autowired
	AdminViewController adminViewController;
	@Test
	public void testAdminViewController() {
		assertNotNull(adminViewController);
	}
	
}
