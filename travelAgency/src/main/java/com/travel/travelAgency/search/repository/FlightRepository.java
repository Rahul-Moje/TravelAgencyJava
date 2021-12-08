package com.travel.travelAgency.search.repository;

import com.travel.travelAgency.search.models.OneWayFlightResults;
import com.travel.travelAgency.search.models.SearchFlightForm;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * @author rahulmoje
 */
public interface FlightRepository {

    List<String> findSourceAirports() throws SQLException;

    List<String> findDestinationAirports() throws SQLException;

    List<OneWayFlightResults> findOneWayFlights(SearchFlightForm searchFlightForm) throws SQLException, ParseException;

    List<OneWayFlightResults> findBothWayFlights(SearchFlightForm searchFlightForm) throws SQLException, ParseException;
}
