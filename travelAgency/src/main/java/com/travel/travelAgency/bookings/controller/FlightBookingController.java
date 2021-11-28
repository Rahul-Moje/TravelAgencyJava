package com.travel.travelAgency.bookings.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class FlightBookingController {

    @RequestMapping(value = "/bookFlights", method = RequestMethod.POST)
    public String bookFlights(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        return "payment";
    }
}
