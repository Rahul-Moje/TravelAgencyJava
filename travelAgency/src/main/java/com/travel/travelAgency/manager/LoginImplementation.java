package com.travel.travelAgency.manager;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travel.travelAgency.dao.UserAuthDAO;
import com.travel.travelAgency.interfaces.LoginInterface;
import com.travel.travelAgency.models.UserAuth;
import com.travel.travelAgency.repository.UserAuthRepository;

@Component
public class LoginImplementation implements LoginInterface{

	@Autowired
	UserAuthRepository userDAO;
	
	@Override
	public String login(String username, String password) {

		int user_id = userDAO.validateUsernamePassword(username, password);
		if(user_id != 0) {
			return "Success";
		}
		else {
			return "Failed to login";
		}
	}

}
