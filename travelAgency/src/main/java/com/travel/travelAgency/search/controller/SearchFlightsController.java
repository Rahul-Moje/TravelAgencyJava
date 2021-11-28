package com.travel.travelAgency.search.controller;

import com.travel.travelAgency.search.interfaces.SearchFlightsInterface;
import com.travel.travelAgency.search.models.JourneyType;
import com.travel.travelAgency.search.models.SearchFlightForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@Controller
public class SearchFlightsController {

    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private SearchFlightsInterface searchFlightsInterface;

    @RequestMapping(value="/searchFlights", method = RequestMethod.GET)
    public String initialisePage(ModelMap model, HttpServletRequest request){
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
    public String searchFlights(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            SearchFlightForm searchFlightForm = mapFormData(request);
            validateSearchRequest(searchFlightForm);
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            e.printStackTrace();
        }


        return "searchFlighstResult";

    }

    private void validateSearchRequest(SearchFlightForm searchFlightForm) {
        searchFlightsInterface.validateSearchRequest(searchFlightForm);
    }

    private SearchFlightForm mapFormData(HttpServletRequest request) throws ParseException {
        SearchFlightForm searchFlightForm = new SearchFlightForm();
        searchFlightForm.setSource(request.getParameter("sources"));
        searchFlightForm.setDestination(request.getParameter("destinations"));
        searchFlightForm.setFromDate(DATE_FORMATTER.parse(request.getParameter("fromDate")));
        searchFlightForm.setToDate(DATE_FORMATTER.parse(request.getParameter("toDate")));
        searchFlightForm.setJourneyType(JourneyType.mapToJourneyType(request.getParameter("oneWayOrReturn")));
        return searchFlightForm;
    }
}
