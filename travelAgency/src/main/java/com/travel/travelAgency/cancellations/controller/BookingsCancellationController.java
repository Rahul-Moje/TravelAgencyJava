package com.travel.travelAgency.cancellations.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author rahulmoje
 */
@Controller
public class BookingsCancellationController {

    @RequestMapping(value = "/cancelBooking", method = RequestMethod.POST)
    public String cancelBooking(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        System.out.println(request.getParameter("bookingId"));
        return "cancelBooking";
    }
}
