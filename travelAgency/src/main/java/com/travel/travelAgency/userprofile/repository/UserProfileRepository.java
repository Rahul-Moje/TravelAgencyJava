package com.travel.travelAgency.userprofile.repository;

import com.travel.travelAgency.userprofile.model.User;
import com.travel.travelAgency.userprofile.model.UserBooking;

import java.sql.SQLException;
import java.util.List;

/**
 * @author rahulmoje
 */
public interface UserProfileRepository {

    User retrieveUserDetail(String email) throws SQLException;

    List<UserBooking> retrieveUserBookings(String email) throws SQLException;
}
