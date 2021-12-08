package com.travel.travelAgency.cancellations.interfaces;

import java.sql.SQLException;

/**
 * @author rahulmoje
 */
public interface BookingCancellationInterface {

    void cancelBooking(Integer bookingId) throws SQLException;
}
