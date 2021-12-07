package com.travel.travelAgency.bookings.controller;

import com.travel.travelAgency.bookings.exceptions.FlightBookingException;
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
        try {
            Integer fromScheduleId = Integer.parseInt(request.getParameter("fromFlightScheduleId"));
            BigDecimal totalCost = new BigDecimal(request.getParameter("flightCost"));
            request.getSession().setAttribute("fromFlightScheduleId", fromScheduleId);
            request.getSession().setAttribute("flightCost", totalCost);
            checkAndSetReturnFlightAttributes(request);
            return "flightBooking";
        } catch (FlightBookingException e) {
            e.printStackTrace();
            modelMap.addAttribute("errorMessage", e.getMessage());
            return "bookFlightsErrors";
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.addAttribute("errorMessage", "Error occurred while booking flights");
            return "bookFlightsErrors";
        }

    }

    private void checkAndSetReturnFlightAttributes(HttpServletRequest request) {
        if(request.getSession().getAttribute("journeyType").equals(JourneyType.RETURN.getDescription())) {
            request.getSession().setAttribute("toFlightScheduleId", Integer.parseInt(request.getParameter("toFlightScheduleId")));
        }
    }

    @RequestMapping(value = "/bookFlight", method = RequestMethod.POST)
    public String bookFlights(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            FlightBookingRequest flightBooking = mapToFlightBookingRequest(request);
            Integer bookingId = flightBookingInterface.saveFlightBooking(flightBooking);
            request.getSession().setAttribute("bookingId", bookingId);
            return "checkoutToPayment";
        } catch (FlightBookingException e) {
            e.printStackTrace();
            modelMap.addAttribute("errorMessage", e.getMessage());
            return "bookFlightsErrors";
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.addAttribute("errorMessage", "Error occurred while booking flights");
            return "bookFlightsErrors";
        }

    }

    private FlightBookingRequest mapToFlightBookingRequest(HttpServletRequest request) {
        FlightBookingRequest flightBookingRequest = new FlightBookingRequest();
        flightBookingRequest.setJourneyType(JourneyType.mapToJourneyType((String) request.getSession().getAttribute("journeyType")));
        flightBookingRequest.setFromFlightScheduleId((Integer) request.getSession().getAttribute("fromFlightScheduleId"));
        flightBookingRequest.setUserName((String) request.getSession().getAttribute("name"));
        flightBookingRequest.setUserEmail((String) request.getSession().getAttribute("email"));
        try {
        	int noOfBags = Integer.parseInt(request.getParameter("numBaggages"));
            flightBookingRequest.setNumOfBaggages(Integer.parseInt(request.getParameter("numBaggages")));
            request.getSession().setAttribute("numBaggages", noOfBags);
        } catch (NumberFormatException e) {
            throw new FlightBookingException("Invalid number of baggages. Retry entire process");
        }

        flightBookingRequest.setMealType(MealType.mapToMealType(request.getParameter("mealType")));
        flightBookingRequest.setNumOfPassengers((int)request.getSession().getAttribute("numOfPassengers"));
        flightBookingRequest.setTotalCost((BigDecimal) request.getSession().getAttribute("flightCost"));
        checkAndMapReturnFlight(request, flightBookingRequest);
        return flightBookingRequest;
    }

    private void checkAndMapReturnFlight(HttpServletRequest request, FlightBookingRequest flightBookingRequest) {
        if(flightBookingRequest.getJourneyType() == JourneyType.RETURN) {
            flightBookingRequest.setToFlightScheduleId((Integer) request.getSession().getAttribute("toFlightScheduleId"));
        }
    }

    private void checkIfUserLoggedIn(HttpServletRequest request) {
        if(null == request.getSession().getAttribute("name")) {
            throw new SearchFlightsException("User must be logged in to book flights");
        }
    }
}
