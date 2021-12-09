package com.travel.travelAgency.cancellations.dao;

import com.travel.travelAgency.cancellations.repository.BookingCancellationRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

/**
 * @author rahulmoje
 */
public class BookingCancellationDaoTest {

    private BookingCancellationRepository bookingCancellationRepository = new BookingCancellationDao();

    @Test
    public void testIsBookingCancelledForBookingIdWhenTrue() throws SQLException {
        Assert.assertTrue(bookingCancellationRepository.isBookingCancelledForBookingId(1));
    }

    @Test
    public void testIsBookingCancelledForBookingIdWhenFalse() throws SQLException {
        Assert.assertTrue(bookingCancellationRepository.isBookingCancelledForBookingId(-1));
    }


}
