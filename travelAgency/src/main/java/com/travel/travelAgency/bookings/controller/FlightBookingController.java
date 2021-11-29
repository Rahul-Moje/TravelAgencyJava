package com.travel.travelAgency.bookings.controller;

import com.travel.travelAgency.search.exceptions.SearchFlightsException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class FlightBookingController {

    @RequestMapping(value = "/bookFlight", method = RequestMethod.GET)
    public String initialiseFlightBooking(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("user - " + request.getSession().getAttribute("name"));
        System.out.println("numPassengers - " + request.getSession().getAttribute("numOfPassengers"));
        System.out.println("journeyType - " + request.getSession().getAttribute("journeyType"));
        return "flightBooking";
    }

    @RequestMapping(value = "/bookFlight", method = RequestMethod.POST)
    public String bookFlights(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("user - " + request.getSession().getAttribute("name"));
        System.out.println("numPassengers - " + request.getSession().getAttribute("numOfPassengers"));
        System.out.println("journeyType - " + request.getSession().getAttribute("journeyType"));
        System.out.println("Num bags" + request.getParameter("numBaggages"));
        System.out.println("Meal type" + request.getParameter("mealType"));
        return "payment";
    }

    private void checkIfUserLoggedIn(HttpServletRequest request) {
        if(null == request.getSession().getAttribute("name")) {
            throw new SearchFlightsException("User must be logged in to book flights");
        }
    }
}
