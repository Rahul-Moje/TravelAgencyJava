package com.travel.travelAgency.authenticationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.travel.travelAgency.authentication.dao.UserAuthDAO;
import com.travel.travelAgency.authentication.interfaces.LoginInterface;
import com.travel.travelAgency.authentication.manager.LoginImplementation;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class LoginImplementationTest {

	@Mock
	JdbcTemplate jdbc;
	
	@Autowired
	LoginInterface loginInterface;
	
	@Test
	void loginImplementationTest() {
		String email = "admin@dal.ca";
		String password = "admin";
		String queryStr = "select count(*) from user_auth where email_id='"+email+"'"+" and password='"+password+"'";
		Mockito.when(jdbc.queryForObject(queryStr, Integer.class)).thenReturn(1);
		assertEquals("Success", loginInterface.login(email, password));
	}

}
