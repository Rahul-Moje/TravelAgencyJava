package com.travel.travelAgency.authenticationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.travel.travelAgency.authentication.interfaces.ForgotPasswordInterface;
import com.travel.travelAgency.authentication.models.ForgotPassGetEmailRequest;
import com.travel.travelAgency.authentication.models.ForgotPassGetEmailResp;
import com.travel.travelAgency.authentication.models.SecurityAnswerRequest;
import com.travel.travelAgency.authentication.models.UpdatePasswordReponse;
import com.travel.travelAgency.authentication.repository.ForgotPasswordRepository;

/**
 * @author sowjanyamani
 */

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ForgotPasswordImplementationTest {

	@Autowired
	ForgotPasswordInterface forgotPasswordService;

	@Mock
	ForgotPasswordRepository repo;

	@Test
	public void verifyEmailAndGetSecurityQuestest() throws Exception {

		ForgotPassGetEmailRequest req = new ForgotPassGetEmailRequest();
		req.setEmail("user1@dal.ca");

		Mockito.when(repo.isEmailValid(req.getEmail())).thenReturn(Boolean.TRUE);
		Mockito.when(repo.getSecurityQuestion(req.getEmail())).thenReturn("Some question");

		ForgotPassGetEmailResp resp = forgotPasswordService.verifyEmailAndGetSecurityQuestion(req, repo);
		assertEquals("Some question", resp.getSecurity_question());

	}

	@Test
	public void verifySecurityAnswerandUpdatePasstest() throws Exception {

		SecurityAnswerRequest req = new SecurityAnswerRequest();
		req.setEmail("user1@dal.ca");
		req.setSecurity_answer("Some Answer");
		req.setNew_password("Albetros@9");
		req.setUpdate_password("Albetros@9");

		UpdatePasswordReponse response = new UpdatePasswordReponse();
		response.setStatus("Password Updated");

		Mockito.when(repo.isSecurityAnswerValid(req.getSecurity_answer(), req.getEmail())).thenReturn(Boolean.TRUE);
		doNothing().when(repo).updatePassword(req.getEmail(), req.getNew_password());
		response = forgotPasswordService.verifySecurityAnswerandUpdatePassword(req, repo);
		assertEquals("Password Updated", response.getStatus());

	}

}
