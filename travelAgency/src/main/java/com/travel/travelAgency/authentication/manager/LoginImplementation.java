package com.travel.travelAgency.authentication.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.travelAgency.authentication.interfaces.LoginInterface;
import com.travel.travelAgency.authentication.repository.UserAuthRepository;

/**
 * @author ruchishinde
 */

@Service
public class LoginImplementation implements LoginInterface{

	@Autowired
	UserAuthRepository userDAO;
	
	@Override
	public String login(String email, String password) {

		int user_id = userDAO.validateUsernamePassword(email, password);
		if(user_id != 0) {
			return "Success";
		}
		else {
			return "Failed to login";
		}
	}

}
