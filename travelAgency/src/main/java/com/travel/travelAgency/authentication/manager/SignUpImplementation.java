package com.travel.travelAgency.authentication.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travel.travelAgency.authentication.interfaces.SignUpInterface;
import com.travel.travelAgency.authentication.repository.SignUpRepository;

@Component
public class SignUpImplementation implements SignUpInterface{

		@Autowired
		SignUpRepository signUpDAO;
		
		@Override
		public String signUp(String username, String password, String email, String SecurityQuestionId, String securityAnswer) {

			signUpDAO.signUpUser(username, password, email, SecurityQuestionId, securityAnswer, securityAnswer);

				return "Sign Up Successful";

		}

}
