package com.travel.travelAgency.authenticationTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.travel.travelAgency.authentication.dao.UserAuthDAO;
import com.travel.travelAgency.authentication.interfaces.LoginInterface;
import com.travel.travelAgency.authentication.repository.UserAuthRepository;

/**
 * @author ruchishinde
 */

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class LoginImplementationTest {

	@Autowired
	LoginInterface loginInterface;

	UserAuthRepository userAuthRepository = Mockito.mock(UserAuthDAO.class);

	@Test
	public void checkClassNotNull() {
		assertNotNull(loginInterface);
	}

	@Test
	void loginImplementationTest() {
		String email = "admin@dal.ca";
		String password = "admin";
		// Mockito.when(jdbc.queryForObject(queryStr, Integer.class)).thenReturn(1);
		when(userAuthRepository.validateUsernamePassword(email, password)).thenReturn(1);
		assertEquals("Success", loginInterface.login(email, password));
	}

}
