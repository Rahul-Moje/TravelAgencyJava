package com.travel.travelAgency.bookings.repository;

import com.travel.travelAgency.bookings.model.FlightBookingRequest;

import java.sql.SQLException;

public interface FlightBookingRepository {

    Integer saveUserBooking(FlightBookingRequest flightBooking) throws SQLException;

    void updateSeatsFilled(Integer fromFlightScheduleId, Integer numOfPassengers) throws SQLException;

    void updateUserBookingWithReturnJourney(Integer toFlightScheduleId, Integer id) throws SQLException;
    
}
