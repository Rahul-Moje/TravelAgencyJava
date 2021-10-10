package com.travel.travelAgency.implementations;

import org.apache.catalina.User;

import com.travel.travelAgency.dao.UserAuthDAO;
import com.travel.travelAgency.interfaces.LoginInterface;
import com.travel.travelAgency.models.UserAuth;

public class LoginImplementation implements LoginInterface{

	@Override
	public String login(String username, String password) {

		UserAuthDAO userDAO = new UserAuthDAO();
		UserAuth user = new UserAuth();
		int user_id = userDAO.validateUsernamePassword(username, password);
		if(user_id != 0) {
			return "Success";
		}
		else {
			return "Failed to login";
		}
	}

}
