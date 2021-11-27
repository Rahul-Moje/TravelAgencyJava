package com.travel.travelAgency.authentication.repository;

public interface UserAuthRepository {

	public int validateUsernamePassword(String username, String password);
}
