package com.travel.travelAgency.authentication.manager;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.travel.travelAgency.authentication.dao.UserAuthDAO;
import com.travel.travelAgency.authentication.interfaces.LoginInterface;
import com.travel.travelAgency.authentication.models.UserAuth;
import com.travel.travelAgency.authentication.repository.UserAuthRepository;

@Service
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
