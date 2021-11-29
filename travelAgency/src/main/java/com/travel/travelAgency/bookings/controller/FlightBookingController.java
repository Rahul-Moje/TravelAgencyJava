package com.travel.travelAgency.bookings.controller;

import com.travel.travelAgency.bookings.interfaces.FlightBookingInterface;
import com.travel.travelAgency.bookings.model.FlightBookingRequest;
import com.travel.travelAgency.bookings.model.MealType;
import com.travel.travelAgency.search.exceptions.SearchFlightsException;
import com.travel.travelAgency.search.models.JourneyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.sql.SQLException;

@Controller
public class FlightBookingController {

    @Autowired
    private FlightBookingInterface flightBookingInterface;

    @RequestMapping(value = "/bookFlight", method = RequestMethod.GET)
    public String initialiseFlightBooking(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        Integer fromScheduleId = Integer.parseInt(request.getParameter("fromFlightScheduleId"));
        BigDecimal totalCost = new BigDecimal(request.getParameter("flightCost"));
        request.getSession().setAttribute("fromFlightScheduleId", fromScheduleId);
        request.getSession().setAttribute("flightCost", totalCost);
        return "flightBooking";
    }

    @RequestMapping(value = "/bookFlight", method = RequestMethod.POST)
    public String bookFlights(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) throws SQLException {
        FlightBookingRequest flightBooking = mapToFlightBookingRequest(request);
        Integer bookingId = flightBookingInterface.saveFlightBooking(flightBooking);
        request.getSession().setAttribute("bookingId", bookingId);
        return "payment";
    }

    private FlightBookingRequest mapToFlightBookingRequest(HttpServletRequest request) {
        FlightBookingRequest flightBookingRequest = new FlightBookingRequest();
        flightBookingRequest.setJourneyType(JourneyType.mapToJourneyType((String) request.getSession().getAttribute("journeyType")));
        flightBookingRequest.setFromFlightScheduleId((Integer) request.getSession().getAttribute("fromFlightScheduleId"));
        if(flightBookingRequest.getJourneyType() == JourneyType.RETURN) {

        }
        flightBookingRequest.setUserName((String) request.getSession().getAttribute("name"));
        flightBookingRequest.setUserEmail("testemail@gmail.com"/*(String) request.getSession().getAttribute("email")*/);
        flightBookingRequest.setNumOfBaggages(Integer.parseInt(request.getParameter("numBaggages")));
        flightBookingRequest.setMealType(MealType.mapToMealType(request.getParameter("mealType")));
        flightBookingRequest.setNumOfPassengers((int)request.getSession().getAttribute("numOfPassengers"));
        flightBookingRequest.setTotalCost((BigDecimal) request.getSession().getAttribute("flightCost"));
        return flightBookingRequest;
    }

    private void checkIfUserLoggedIn(HttpServletRequest request) {
        if(null == request.getSession().getAttribute("name")) {
            throw new SearchFlightsException("User must be logged in to book flights");
        }
    }
}
