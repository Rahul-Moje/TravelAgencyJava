package com.travel.travelAgency.bookings.manager;

import com.travel.travelAgency.bookings.interfaces.FlightBookingInterface;
import com.travel.travelAgency.bookings.model.FlightBookingRequest;
import com.travel.travelAgency.bookings.repository.FlightBookingRepository;
import com.travel.travelAgency.bookings.util.TestDataUtil;
import org.junit.Assert;
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
public class FlightBookingImplementationTest {

    @Mock
    private FlightBookingRepository flightBookingRepository;

    @InjectMocks
    private FlightBookingInterface flightBookingInterface = new FlightBookingImplementation();

    @Test
    public void testSaveFlightBooking() throws SQLException {
        FlightBookingRequest flightBookingRequest = TestDataUtil.buildTestFlightBookingRequest();
        Mockito.when(flightBookingRepository.saveUserBooking(flightBookingRequest)).thenReturn(1);
        int id = flightBookingInterface.saveFlightBooking(flightBookingRequest);
        Assert.assertEquals(1, id);
        Mockito.verify(flightBookingRepository).saveUserBooking(flightBookingRequest);
        Mockito.verify(flightBookingRepository).updateSeatsFilled(flightBookingRequest.getFromFlightScheduleId(), flightBookingRequest.getNumOfPassengers());
        Mockito.verify(flightBookingRepository).updateUserBookingWithReturnJourney(flightBookingRequest.getToFlightScheduleId(), id);
        Mockito.verify(flightBookingRepository).updateSeatsFilled(flightBookingRequest.getToFlightScheduleId(), flightBookingRequest.getNumOfPassengers());
        Mockito.verifyNoMoreInteractions(flightBookingRepository);

    }

}
