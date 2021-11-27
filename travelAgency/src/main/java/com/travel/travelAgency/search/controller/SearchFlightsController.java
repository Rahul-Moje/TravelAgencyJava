package com.travel.travelAgency.search.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SearchFlightsController {

    @RequestMapping(value="/searchFlights", method = RequestMethod.GET)
    public String displaySearchFlight(ModelMap model){
        return "searchFlights";
    }

    @RequestMapping(value = "/searchFlights", method = RequestMethod.POST)
    public String login(ModelMap model, @RequestParam String from,
                        @RequestParam String to, HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        return "login";



    }
}
