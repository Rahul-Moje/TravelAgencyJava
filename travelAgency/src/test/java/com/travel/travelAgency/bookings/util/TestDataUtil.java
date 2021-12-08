package com.travel.travelAgency.bookings.util;

import com.travel.travelAgency.bookings.model.FlightBookingRequest;
import com.travel.travelAgency.bookings.model.MealType;
import com.travel.travelAgency.search.models.JourneyType;

import java.math.BigDecimal;

/**
 * @author rahulmoje
 */
public final class TestDataUtil {

    private TestDataUtil() {
        throw new RuntimeException("Utility classes should not be instantiated");
    }

    public static FlightBookingRequest buildTestFlightBookingRequest() {
        return new FlightBookingRequest.FlightBookingRequestBuilder()
                .withFromFlightScheduleId(1)
                .withToFlightScheduleId(2)
                .withJourneyType(JourneyType.RETURN)
                .withMealType(MealType.NONVEGETARIAN)
                .withNumOfBaggages(2)
                .withNumOfPassengers(3)
                .withTotalCost(new BigDecimal("47000"))
                .withUserEmail("testemail@gmail.com")
                .withUserName("testuser")
                .build();
    }
}
