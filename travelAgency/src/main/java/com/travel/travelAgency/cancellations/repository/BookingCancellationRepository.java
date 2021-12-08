package com.travel.travelAgency.cancellations.repository;

import java.sql.SQLException;

/**
 * @author rahulmoje
 */
public interface BookingCancellationRepository {

    Boolean isBookingCancelledForBookingId(Integer bookingId) throws SQLException;

    void updateBookingToCancelled(Integer bookingId) throws SQLException;

    void updateSeatsForOneWayCancelledBooking(Integer bookingId) throws SQLException;

    void updateSeatsForReturnCancelledBooking(Integer bookingId) throws SQLException;
}
