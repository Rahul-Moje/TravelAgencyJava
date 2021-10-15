package com.travel.travelAgency.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.travel.travelAgency.interfaces.SignUpInterface;
import com.travel.travelAgency.repository.SignUpRepository;

@Component
public class SignUpImplementation implements SignUpInterface{

		@Autowired
		SignUpRepository signUpDAO;
		
		@Override
		public String signUp(String username, String password, String email, int SecurityQuestionId, String securityAnswer) {

			signUpDAO.signUpUser(username, password, email, SecurityQuestionId, securityAnswer, securityAnswer);
			//if(user_id != 0) {
				return "Sign Up Successful";
			//}
			/*else {
				return "Failed to Sign up";
			}*/
		}

}
