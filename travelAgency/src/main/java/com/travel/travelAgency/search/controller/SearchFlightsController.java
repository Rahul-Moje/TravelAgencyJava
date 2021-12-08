package com.travel.travelAgency.search.controller;

import com.travel.travelAgency.search.exceptions.SearchFlightsException;
import com.travel.travelAgency.search.interfaces.SearchFlightFormMapperInterface;
import com.travel.travelAgency.search.interfaces.SearchFlightsInterface;
import com.travel.travelAgency.search.models.JourneyType;
import com.travel.travelAgency.search.models.OneWayFlightResults;
import com.travel.travelAgency.search.models.ReturnFlightsResults;
import com.travel.travelAgency.search.models.SearchFlightForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * @author rahulmoje
 */
@Controller
public class SearchFlightsController {

    @Autowired
    private SearchFlightsInterface searchFlightsInterface;

    @Autowired
    private SearchFlightFormMapperInterface searchFlightFormMapperInterface;

    @RequestMapping(value="/searchFlights", method = RequestMethod.GET)
    public String initialisePage(ModelMap model, HttpServletRequest request, HttpServletResponse response){
        try {
            response.setContentType("text/html");
            model.put("sources", searchFlightsInterface.findSourceAirports());
            model.put("destinations", searchFlightsInterface.findDestinationAirports());
            return "searchFlights";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Error occurred while displaying search flights page");
            return "searchFlightsErrors";
        }
    }

    @RequestMapping(value = "/searchFlights", method = RequestMethod.POST)
    public String searchFlights(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            SearchFlightForm searchFlightForm = mapFormData(request);
            validateSearchRequest(searchFlightForm);
            if(isOneWayRequest(searchFlightForm)) {
                return retrieveOneWayFlightRequestData(searchFlightForm, request, model);
            } else {
                return retrieveReturnFlightRequestData(searchFlightForm, request, model);
            }
        } catch (SearchFlightsException e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", e.getMessage());
            return "searchFlightsErrors";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Error occurred while searching flights");
            return "searchFlightsErrors";
        }
    }

    private String retrieveReturnFlightRequestData(SearchFlightForm searchFlightForm, HttpServletRequest request, ModelMap model) throws SQLException, ParseException {
        List<ReturnFlightsResults> returnFlightsResultsList = retrieveReturnFlightResults(searchFlightForm);
        model.put("flights", returnFlightsResultsList);
        request.getSession().setAttribute("numOfPassengers", searchFlightForm.getNumOfPassengers());
        request.getSession().setAttribute("journeyType", JourneyType.RETURN.getDescription());
        return "returnFlightsResults";
    }

    private String retrieveOneWayFlightRequestData(SearchFlightForm searchFlightForm, HttpServletRequest request, ModelMap model) throws SQLException, ParseException {
        List<OneWayFlightResults> oneWayFlightResultsList = retrieveOneWayFlightResults(searchFlightForm);
        model.put("flights", oneWayFlightResultsList);
        request.getSession().setAttribute("numOfPassengers", searchFlightForm.getNumOfPassengers());
        request.getSession().setAttribute("journeyType", JourneyType.ONE_WAY.getDescription());
        return "oneWayFlightsResults";
    }


    private List<ReturnFlightsResults> retrieveReturnFlightResults(SearchFlightForm searchFlightForm) throws SQLException, ParseException {
        return searchFlightsInterface.retrieveReturnFlightResults(searchFlightForm);
    }

    private List<OneWayFlightResults> retrieveOneWayFlightResults(SearchFlightForm searchFlightForm) throws SQLException, ParseException {
        return searchFlightsInterface.retrieveOneWayFlightResults(searchFlightForm);

    }

    private boolean isOneWayRequest(SearchFlightForm searchFlightForm) {
        return searchFlightForm.isOneWayRequest();
    }

    private void validateSearchRequest(SearchFlightForm searchFlightForm) {
        searchFlightsInterface.validateSearchRequest(searchFlightForm);
    }

    private SearchFlightForm mapFormData(HttpServletRequest request) {
        return searchFlightFormMapperInterface.mapFormData(request);
    }
}
