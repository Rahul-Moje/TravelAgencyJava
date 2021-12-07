package com.travel.travelAgency.bookings.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author rahulmoje
 */
@SpringBootTest
public class FlightBookingControllerTest {

    @Autowired
    private FlightBookingController flightBookingController;

    @Test
    public void testFlightBookingControllerExists() {
        assertNotNull(flightBookingController);
    }
}
