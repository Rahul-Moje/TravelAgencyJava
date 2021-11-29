package com.travel.travelAgency.search.manager;

import com.travel.travelAgency.search.exceptions.SearchFlightsException;
import com.travel.travelAgency.search.interfaces.SearchFlightsInterface;
import com.travel.travelAgency.search.interfaces.SearchFlightsRequestValidator;
import com.travel.travelAgency.search.interfaces.TicketCostCalculator;
import com.travel.travelAgency.search.models.OneWayFlightResults;
import com.travel.travelAgency.search.models.ReturnFlightsResults;
import com.travel.travelAgency.search.models.SearchFlightForm;
import com.travel.travelAgency.search.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SearchFlightsImplementation implements SearchFlightsInterface {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private SearchFlightsRequestValidator searchFlightsRequestValidator;

    @Autowired
    private TicketCostCalculator ticketCostCalculator;


    @Override
    public List<String> findSourceAirports() throws SQLException {
        return flightRepository.findSourceAirports();
    }

    @Override
    public List<String> findDestinationAirports() throws SQLException {
        return flightRepository.findDestinationAirports();
    }

    @Override
    public void validateSearchRequest(SearchFlightForm searchFlightForm) {
        searchFlightsRequestValidator.validateSearchRequest(searchFlightForm);
    }

    @Override
    public List<ReturnFlightsResults> retrieveReturnFlightResults(SearchFlightForm searchFlightForm) throws SQLException {
        List<ReturnFlightsResults> oneWayFlightResultsList = flightRepository.findReturnFlights(searchFlightForm);
        return null;
    }

    @Override
    public List<OneWayFlightResults> retrieveOneWayFlightResults(SearchFlightForm searchFlightForm) throws SQLException, ParseException {
        List<OneWayFlightResults> oneWayFlights =  flightRepository.findOneWayFlights(searchFlightForm);
        oneWayFlights = removeFlightsExceedingCapacity(oneWayFlights, searchFlightForm);
        checkIfFlightsRemaining(oneWayFlights);
        ticketCostCalculator.calculateOneWayCost(oneWayFlights);
        return oneWayFlights;
    }

    private void checkIfFlightsRemaining(List<OneWayFlightResults> oneWayFlights) {
        if(oneWayFlights.size() == 0) {
            throw new SearchFlightsException("No flights matching your search. Try again with different criterias");
        }
    }

    private List<OneWayFlightResults> removeFlightsExceedingCapacity(List<OneWayFlightResults> oneWayFlights, SearchFlightForm searchFlightForm) {
        List<OneWayFlightResults> filteredFlights = new ArrayList<>();
        for(OneWayFlightResults flight : oneWayFlights) {
            int maxCapacity = flight.getCapacity();
            int currentlyBooked = flight.getSeatsBooked();
            int remaining = maxCapacity - currentlyBooked;
            if(remaining>=searchFlightForm.getNumOfPassengers()) {
                filteredFlights.add(flight);
            }
        }
        return filteredFlights;
    }
}
