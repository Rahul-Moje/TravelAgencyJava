package com.travel.travelAgency.bookings.manager;

import com.travel.travelAgency.bookings.dao.FlightBookingDao;
import com.travel.travelAgency.bookings.interfaces.FlightBookingInterface;
import com.travel.travelAgency.bookings.model.FlightBookingRequest;
import com.travel.travelAgency.search.models.JourneyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class FlightBookingImplementation implements FlightBookingInterface {

    @Autowired
    private FlightBookingDao flightBookingDao;

    @Override
    public void saveFlightBooking(FlightBookingRequest flightBooking) throws SQLException {
        Integer id = flightBookingDao.saveUserBooking(flightBooking);
        flightBookingDao.updateSeatsFilled(flightBooking.getFromFlightScheduleId(), flightBooking.getNumOfPassengers());
        checkAndUpdateReturnJourneyBookingDetails(flightBooking, id);
    }

    private void checkAndUpdateReturnJourneyBookingDetails(FlightBookingRequest flightBooking, Integer id) throws SQLException {
        if(flightBooking.getJourneyType() == JourneyType.RETURN) {
            flightBookingDao.updateUserBookingWithReturnJourney(flightBooking.getToFlightScheduleId(), id);
            flightBookingDao.updateSeatsFilled(flightBooking.getToFlightScheduleId(), flightBooking.getNumOfPassengers());
        }
    }
}
