package com.travel.travelAgency.bookings.interfaces;

import com.travel.travelAgency.bookings.model.FlightBookingRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author rahulmoje
 */
public interface FlightBookingRequestMapperInterface {

    FlightBookingRequest mapToFlightBookingRequest(HttpServletRequest request);
}
