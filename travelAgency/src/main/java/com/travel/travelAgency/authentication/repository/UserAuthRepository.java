package com.travel.travelAgency.authentication.repository;

import com.travel.travelAgency.authentication.models.UserAuth;

public interface UserAuthRepository {

	public int validateUsernamePassword(String email, String password);
}
