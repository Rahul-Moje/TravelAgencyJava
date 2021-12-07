package com.travel.travelAgency.userprofile.interfaces;

import com.travel.travelAgency.userprofile.model.User;
import com.travel.travelAgency.userprofile.model.UserBooking;

import java.sql.SQLException;
import java.util.List;

/**
 * @author rahulmoje
 */
public interface UserProfileInterface {

    User retrieveUserDetail(String email) throws SQLException;

    List<UserBooking> retrieveUserBookings(String email) throws SQLException;
}
