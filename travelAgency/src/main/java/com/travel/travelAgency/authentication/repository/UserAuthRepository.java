package com.travel.travelAgency.authentication.repository;

public interface UserAuthRepository {

	public int validateUsernamePassword(String email, String password);
}
