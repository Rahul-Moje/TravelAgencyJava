package com.travel.travelAgency.bookings.manager;

import com.travel.travelAgency.bookings.exceptions.FlightBookingException;
import com.travel.travelAgency.bookings.interfaces.FlightBookingRequestMapperInterface;
import com.travel.travelAgency.bookings.model.FlightBookingRequest;
import com.travel.travelAgency.bookings.model.MealType;
import com.travel.travelAgency.search.models.JourneyType;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 * @author rahulmoje
 */
@Service
public class FlightBookingIRequestMapperImplementation implements FlightBookingRequestMapperInterface {


    @Override
    public FlightBookingRequest mapToFlightBookingRequest(HttpServletRequest request) {
        FlightBookingRequest.FlightBookingRequestBuilder flightBookingRequestBuilder = new FlightBookingRequest.FlightBookingRequestBuilder();
        flightBookingRequestBuilder.withJourneyType(JourneyType.mapToJourneyType((String) request.getSession().getAttribute("journeyType")));
        flightBookingRequestBuilder.withFromFlightScheduleId((Integer) request.getSession().getAttribute("fromFlightScheduleId"));
        flightBookingRequestBuilder.withUserName((String) request.getSession().getAttribute("name"));
        flightBookingRequestBuilder.withUserEmail((String) request.getSession().getAttribute("email"));
        try {
            flightBookingRequestBuilder.withNumOfBaggages(Integer.parseInt(request.getParameter("numBaggages")));
        } catch (NumberFormatException e) {
            throw new FlightBookingException("Invalid number of baggages. Retry entire process");
        }
        flightBookingRequestBuilder.withMealType(MealType.mapToMealType(request.getParameter("mealType")));
        flightBookingRequestBuilder.withNumOfPassengers((int)request.getSession().getAttribute("numOfPassengers"));
        flightBookingRequestBuilder.withTotalCost((BigDecimal) request.getSession().getAttribute("flightCost"));
        checkAndMapReturnFlight(request, flightBookingRequestBuilder);
        return flightBookingRequestBuilder.build();
    }

    private void checkAndMapReturnFlight(HttpServletRequest request, FlightBookingRequest.FlightBookingRequestBuilder flightBookingRequestBuilder) {
        if(JourneyType.mapToJourneyType((String) request.getSession().getAttribute("journeyType")) == JourneyType.RETURN) {
            flightBookingRequestBuilder.withToFlightScheduleId((Integer) request.getSession().getAttribute("toFlightScheduleId"));
        }
    }

}
