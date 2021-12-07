package com.travel.travelAgency.userprofile.dao;

import com.travel.travelAgency.userprofile.model.User;
import com.travel.travelAgency.userprofile.model.UserBooking;
import com.travel.travelAgency.userprofile.repository.UserProfileRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * @author rahulmoje
 */
public class UserProfileDaoTest {

    UserProfileRepository userProfileRepository = new UserProfileDao();

    @Test
    public void testRetrieveUserDetail() throws SQLException {
        User actualUser = userProfileRepository.retrieveUserDetail("user@dal.ca");
        Assertions.assertNotNull(actualUser);
        Assertions.assertNotNull(actualUser.getUserName());
        Assertions.assertNotNull(actualUser.getUserEmail());
    }

    @Test
    public void retrieveUserBookings() throws SQLException {
        List<UserBooking> userBookingList = userProfileRepository.retrieveUserBookings("user@dal.ca");
        Assertions.assertNotNull(userBookingList);
        Assertions.assertFalse(userBookingList.isEmpty());
        for(UserBooking booking : userBookingList) {
            Assertions.assertNotNull(booking.getBookingId());
            Assertions.assertNotNull(booking.getBookingDate());
            Assertions.assertNotNull(booking.getSource());
            Assertions.assertNotNull(booking.getDestination());
            Assertions.assertNotNull(booking.getFinalCost());
            Assertions.assertNotNull(booking.getFromDate());
        }
    }
}
