package com.travel.travelAgency.authenticationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.travel.travelAgency.authentication.interfaces.LoginInterface;


@SpringBootTest
class LoginImplementationTest {

	@Mock
	JdbcTemplate jdbc;
	
	@Autowired
	LoginInterface loginInterface;
	
	@Test
	void loginImplementationTest() {
		String username = "admin";
		String password = "admin";
		String queryStr = "select count(*) from user_auth where username='"+username+"'"+" and password='"+password+"'";
		Mockito.when(jdbc.queryForObject(queryStr, Integer.class)).thenReturn(1);
		assertEquals("Success", loginInterface.login(username, password));
	}

}
