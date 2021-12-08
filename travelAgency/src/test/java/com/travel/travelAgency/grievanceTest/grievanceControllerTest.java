package com.travel.travelAgency.grievanceTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.travel.travelAgency.grievance.controller.GrievanceController;

/**
 * @author sowjanyamani
 */

@SpringBootTest
public class grievanceControllerTest {

	@Autowired
	GrievanceController grievancecontroller;

	@Test
	public void testgrievanceController() {
		assertNotNull(grievancecontroller);
	}

}
