package com.travel.travelAgency.authenticationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.travel.travelAgency.authentication.interfaces.SignUpInterface;


@SpringBootTest
public class SignUpImplementationTest {

	@Mock
	JdbcTemplate jdbc;
	
	@Autowired
	SignUpInterface SignUpInterface;
	
	@Test
	void loginImplementationTest() {
		String username = "user";
		String password = "userpass";
		String email= "user@dal.ca";
		String SecurityQuestionId ="1";
		String securityAnswer = "Red";
		String queryStr = "Insert into user_auth(username, password , email_id, security_question_id, security_answer) values ('"+username+"','"+password+"','"+email+"',"+SecurityQuestionId+",'"+securityAnswer+"')";
		Mockito.when(jdbc.update(queryStr)).thenReturn(1);
		assertEquals("Sign Up Successful", SignUpInterface.signUp(username, password, email, SecurityQuestionId, securityAnswer));
	}

}

