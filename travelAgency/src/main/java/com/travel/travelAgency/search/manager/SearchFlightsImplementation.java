package com.travel.travelAgency.search.manager;

import com.travel.travelAgency.search.interfaces.SearchFlightsInterface;
import com.travel.travelAgency.search.interfaces.SearchFlightsRequestValidator;
import com.travel.travelAgency.search.models.SearchFlightForm;
import com.travel.travelAgency.search.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class SearchFlightsImplementation implements SearchFlightsInterface {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private SearchFlightsRequestValidator searchFlightsRequestValidator;


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
}
