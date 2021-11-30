package com.travel.travelAgency.bookings.interfaces;

import com.travel.travelAgency.bookings.model.FlightBookingRequest;

import java.sql.SQLException;

public interface FlightBookingInterface {

    Integer saveFlightBooking(FlightBookingRequest flightBooking) throws SQLException;
}
