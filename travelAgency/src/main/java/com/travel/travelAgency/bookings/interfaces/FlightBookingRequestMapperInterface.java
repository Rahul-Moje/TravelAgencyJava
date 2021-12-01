package com.travel.travelAgency.bookings.interfaces;

import com.travel.travelAgency.bookings.model.FlightBookingRequest;

import javax.servlet.http.HttpServletRequest;

public interface FlightBookingRequestMapperInterface {

    FlightBookingRequest mapToFlightBookingRequest(HttpServletRequest request);
}
