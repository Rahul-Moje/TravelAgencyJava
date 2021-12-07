package com.travel.travelAgency.search.manager;

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

/**
 * @author rahulmoje
 */
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
    public List<ReturnFlightsResults> retrieveReturnFlightResults(SearchFlightForm searchFlightForm) throws SQLException, ParseException {
        List<OneWayFlightResults> bothWaysFlights = flightRepository.findBothWayFlights(searchFlightForm);
        List<OneWayFlightResults> fromFlights = extractFlightsForSource(bothWaysFlights, searchFlightForm.getSource());
        List<OneWayFlightResults> toFlights = extractFlightsForSource(bothWaysFlights, searchFlightForm.getDestination());
        fromFlights = removeFlightsExceedingCapacity(fromFlights, searchFlightForm);
        toFlights = removeFlightsExceedingCapacity(toFlights, searchFlightForm);
        checkIfFlightsRemaining(fromFlights);
        checkIfFlightsRemaining(toFlights);
        List<ReturnFlightsResults> flights = mapToReturnFlightsResults(fromFlights, toFlights);
        ticketCostCalculator.calculateReturnCost(flights);
        return flights;
    }

    private List<ReturnFlightsResults> mapToReturnFlightsResults(List<OneWayFlightResults> fromFlights, List<OneWayFlightResults> toFlights) {
        List<ReturnFlightsResults> flights = new ArrayList<>();
        for(OneWayFlightResults fromFlight : fromFlights) {
            for(OneWayFlightResults toFlight : toFlights) {
                ReturnFlightsResults flight = new ReturnFlightsResults();
                flight.setFromFlightCode(fromFlight.getFlightCode());
                flight.setFromAirLine(fromFlight.getAirLine());
                flight.setFromFlightScheduleId(fromFlight.getFlightScheduleId());
                flight.setFromSource(fromFlight.getSource());
                flight.setFromDestination(fromFlight.getDestination());
                flight.setFromDepartureTime(fromFlight.getDepartureTime());
                flight.setFromArrivalTime(fromFlight.getArrivalTime());
                flight.setFromTotalHours(fromFlight.getTotalHours());
                flight.setFromTicketPrice(fromFlight.getTicketPrice());
                flight.setFromSeatsBooked(fromFlight.getSeatsBooked());
                flight.setFromCapacity(fromFlight.getCapacity());
                flight.setToFlightCode(toFlight.getFlightCode());
                flight.setToAirLine(toFlight.getAirLine());
                flight.setToFlightScheduleId(toFlight.getFlightScheduleId());
                flight.setToSource(toFlight.getSource());
                flight.setToDestination(toFlight.getDestination());
                flight.setToDepartureTime(toFlight.getDepartureTime());
                flight.setToArrivalTime(toFlight.getArrivalTime());
                flight.setToTotalHours(toFlight.getTotalHours());
                flight.setToTicketPrice(toFlight.getTicketPrice());
                flight.setToSeatsBooked(toFlight.getSeatsBooked());
                flight.setToCapacity(toFlight.getCapacity());
                flights.add(flight);
            }
        }
        return flights;
    }

    private List<OneWayFlightResults> extractFlightsForSource(List<OneWayFlightResults> bothWaysFlights, String source) {
        List<OneWayFlightResults> oneWayFlightResultsList = new ArrayList<>();
        for(OneWayFlightResults flight : bothWaysFlights) {
            if(flight.getSource().equals(source)) {
                oneWayFlightResultsList.add(flight);
            }
        }
        return oneWayFlightResultsList;
    }

    @Override
    public List<OneWayFlightResults> retrieveOneWayFlightResults(SearchFlightForm searchFlightForm) throws SQLException, ParseException {
        List<OneWayFlightResults> flights =  flightRepository.findOneWayFlights(searchFlightForm);
        flights = removeFlightsExceedingCapacity(flights, searchFlightForm);
        checkIfFlightsRemaining(flights);
        ticketCostCalculator.calculateOneWayCost(flights);
        return flights;
    }

    private void checkIfFlightsRemaining(List<OneWayFlightResults> oneWayFlights) {
        searchFlightsRequestValidator.checkIfFlightsRemaining(oneWayFlights);
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
