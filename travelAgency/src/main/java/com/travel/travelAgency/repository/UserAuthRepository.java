package com.travel.travelAgency.repository;

import com.travel.travelAgency.models.UserAuth;

public interface UserAuthRepository {

	public int validateUsernamePassword(String username, String password);
}
