package com.travel.travelAgency.cancellations.controller;

import com.travel.travelAgency.cancellations.exceptions.BookingCancellationException;
import com.travel.travelAgency.cancellations.interfaces.BookingCancellationInterface;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private BookingCancellationInterface bookingCancellationInterface;

    @RequestMapping(value = "/cancelBooking", method = RequestMethod.POST)
    public String cancelBooking(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        try {
            bookingCancellationInterface.cancelBooking(Integer.parseInt(request.getParameter("bookingId")));
            return "cancelBooking";
        } catch (BookingCancellationException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error occurred");
            return "error";
        }

    }
}
