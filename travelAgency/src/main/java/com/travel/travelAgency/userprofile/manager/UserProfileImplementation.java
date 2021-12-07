package com.travel.travelAgency.userprofile.manager;

import com.travel.travelAgency.search.models.JourneyType;
import com.travel.travelAgency.userprofile.interfaces.UserProfileInterface;
import com.travel.travelAgency.userprofile.model.User;
import com.travel.travelAgency.userprofile.model.UserBooking;
import com.travel.travelAgency.userprofile.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * @author rahulmoje
 */
@Service
public class UserProfileImplementation implements UserProfileInterface {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public User retrieveUserDetail(String email) throws SQLException {
        return userProfileRepository.retrieveUserDetail(email);
    }

    @Override
    public List<UserBooking> retrieveUserBookings(String email) throws SQLException {
        List<UserBooking> userBookings = userProfileRepository.retrieveUserBookings(email);
        findAndSetBookingStatuses(userBookings);
        return userBookings;
    }

    private void findAndSetBookingStatuses(List<UserBooking> userBookings) {
        for(UserBooking booking : userBookings) {
           if(JourneyType.ONE_WAY == booking.getJourneyType()) {
               booking.findAndSetStatusForOneWayBooking();
           } else {
               booking.findAndSetStatusForReturnBooking();
           }
        }
    }
}
