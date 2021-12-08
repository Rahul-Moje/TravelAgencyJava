package com.travel.travelAgency.cancellations.manager;

import com.travel.travelAgency.cancellations.exceptions.BookingCancellationException;
import com.travel.travelAgency.cancellations.interfaces.BookingCancellationInterface;
import com.travel.travelAgency.cancellations.repository.BookingCancellationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * @author rahulmoje
 */
@Service
public class BookingCancellationImplementation implements BookingCancellationInterface {

    @Autowired
    private BookingCancellationRepository bookingCancellationRepository;

    @Override
    public void cancelBooking(Integer bookingId) throws SQLException {
        checkIfBookingAlreadyCancelled(bookingId);
        updateBookingToCancelled(bookingId);
        updateSeatsForCancelledBooking(bookingId);
    }

    private void updateSeatsForCancelledBooking(Integer bookingId) throws SQLException {
        bookingCancellationRepository.updateSeatsForOneWayCancelledBooking(bookingId);
        bookingCancellationRepository.updateSeatsForReturnCancelledBooking(bookingId);
    }

    private void updateBookingToCancelled(Integer bookingId) throws SQLException {
        bookingCancellationRepository.updateBookingToCancelled(bookingId);
    }

    private void checkIfBookingAlreadyCancelled(Integer bookingId) throws SQLException {
        Boolean isCancelled = bookingCancellationRepository.isBookingCancelledForBookingId(bookingId);
        if(isCancelled) {
            throw new BookingCancellationException("Booking has already been cancelled. Cannot cancel again");
        }
    }
}
