package com.travel.travelAgency.authenticationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.travel.travelAgency.proMembership.interfaces.ProMembershipRegistrationInterface;
import com.travel.travelAgency.proMembership.models.promembershipregistrationrequest;
import com.travel.travelAgency.proMembership.repository.ProMembershipRegistrationRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PromembershipImplementationTest {
	@Autowired
	ProMembershipRegistrationInterface promembershipregistration;

	@Mock
	ProMembershipRegistrationRepository repo;
	
	
	@Test
	public void updatemembershipTest() throws Exception {
		promembershipregistrationrequest req = new promembershipregistrationrequest();
		req.setEmail("user1@dal.ca");
		req.setPlan_name("Gold");
		req.setDate("2021-11-18");
		doNothing().when(repo).updateMembership(req.getEmail(),req.getPlan_name(),req.getDate());
		String response = "updated";
		assertEquals("updated", response);
	
	
	}
	
	
	
	
	
	
}