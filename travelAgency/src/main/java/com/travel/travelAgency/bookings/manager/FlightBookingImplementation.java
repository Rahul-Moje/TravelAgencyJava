package com.travel.travelAgency.bookings.manager;

import com.travel.travelAgency.bookings.interfaces.FlightBookingInterface;
import com.travel.travelAgency.bookings.model.FlightBookingRequest;
import com.travel.travelAgency.bookings.repository.FlightBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * @author rahulmoje
 */
@Service
public class FlightBookingImplementation implements FlightBookingInterface {

    @Autowired
    private FlightBookingRepository flightBookingRepository;

    @Override
    public Integer saveFlightBooking(FlightBookingRequest flightBooking) throws SQLException {
        Integer id = flightBookingRepository.saveUserBooking(flightBooking);
        flightBookingRepository.updateSeatsFilled(flightBooking.getFromFlightScheduleId(), flightBooking.getNumOfPassengers());
        checkAndUpdateReturnJourneyBookingDetails(flightBooking, id);
        return id;
    }

    private void checkAndUpdateReturnJourneyBookingDetails(FlightBookingRequest flightBooking, Integer id) throws SQLException {
        if(flightBooking.isReturnJourney()) {
            flightBookingRepository.updateUserBookingWithReturnJourney(flightBooking.getToFlightScheduleId(), id);
            flightBookingRepository.updateSeatsFilled(flightBooking.getToFlightScheduleId(), flightBooking.getNumOfPassengers());
        }
    }
}
