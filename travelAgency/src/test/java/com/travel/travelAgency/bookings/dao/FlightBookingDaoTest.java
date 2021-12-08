package com.travel.travelAgency.bookings.dao;

import com.travel.travelAgency.bookings.model.FlightBookingRequest;
import com.travel.travelAgency.bookings.repository.FlightBookingRepository;
import com.travel.travelAgency.bookings.util.TestDataUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

/**
 * @author rahulmoje
 */
public class FlightBookingDaoTest {

    private FlightBookingRepository flightBookingRepository = new FlightBookingDao();

    @Test
    public void testSaveUserBooking() throws SQLException {
        FlightBookingRequest testFlightBookingRequest = buildTestBookingRequest();
        Assertions.assertNotNull(flightBookingRepository.saveUserBooking(testFlightBookingRequest));
    }

    @Test
    public void testUpdateSeatsFilled() throws SQLException {
        FlightBookingRequest testFlightBookingRequest = buildTestBookingRequest();
        flightBookingRepository.updateSeatsFilled(testFlightBookingRequest.getFromFlightScheduleId(), 3);
    }

    @Test
    public void testUpdateUserBookingWithReturnJourney() throws SQLException {
        FlightBookingRequest testFlightBookingRequest = buildTestBookingRequest();
        Integer id = flightBookingRepository.saveUserBooking(testFlightBookingRequest);
        Assertions.assertNotNull(id);
        flightBookingRepository.updateUserBookingWithReturnJourney(testFlightBookingRequest.getToFlightScheduleId(), id);
    }

    private FlightBookingRequest buildTestBookingRequest() {
        return TestDataUtil.buildTestFlightBookingRequest();

    }

}
