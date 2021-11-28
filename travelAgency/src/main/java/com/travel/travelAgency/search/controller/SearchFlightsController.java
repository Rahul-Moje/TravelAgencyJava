package com.travel.travelAgency.search.controller;

import com.travel.travelAgency.search.interfaces.SearchFlightsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SearchFlightsController {

    @Autowired
    private SearchFlightsInterface searchFlightsInterface;

    @RequestMapping(value="/searchFlights", method = RequestMethod.GET)
    public String displaySearchFlight(ModelMap model){
        try {
            model.put("sources", searchFlightsInterface.findSourceAirports());
            model.put("destinations", searchFlightsInterface.findDestinationAirports());
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error occurred while searching flights");
            e.printStackTrace();
        }

        return "searchFlights";
    }

    @RequestMapping(value = "/searchFlights", method = RequestMethod.POST)
    public String login(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");

        return "login";



    }
}
