package com.travel.travelAgency.cancellations.manager;

import com.travel.travelAgency.cancellations.exceptions.BookingCancellationException;
import com.travel.travelAgency.cancellations.interfaces.BookingCancellationInterface;
import com.travel.travelAgency.cancellations.repository.BookingCancellationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.SQLException;

/**
 * @author rahulmoje
 */
@RunWith(MockitoJUnitRunner.class)
public class BookingCancellationImplementationTest {

    @Mock
    private BookingCancellationRepository bookingCancellationRepository;

    @InjectMocks
    private BookingCancellationInterface bookingCancellationInterface = new BookingCancellationImplementation();

    @Test
    public void cancelBooking() throws SQLException {
        Mockito.when(bookingCancellationRepository.isBookingCancelledForBookingId(1)).thenReturn(false);
        bookingCancellationInterface.cancelBooking(1);
        Mockito.verify(bookingCancellationRepository).isBookingCancelledForBookingId(1);
        Mockito.verify(bookingCancellationRepository).updateBookingToCancelled(1);
        Mockito.verify(bookingCancellationRepository).updateSeatsForOneWayCancelledBooking(1);
        Mockito.verify(bookingCancellationRepository).updateSeatsForOneWayCancelledBooking(1);
        Mockito.verify(bookingCancellationRepository).updateSeatsForReturnCancelledBooking(1);

    }

    @Test(expected = BookingCancellationException.class)
    public void cancelBookingWhenBookingAlreadyCancelled() throws SQLException {
        Mockito.when(bookingCancellationRepository.isBookingCancelledForBookingId(1)).thenReturn(true);
        bookingCancellationInterface.cancelBooking(1);
    }
}
