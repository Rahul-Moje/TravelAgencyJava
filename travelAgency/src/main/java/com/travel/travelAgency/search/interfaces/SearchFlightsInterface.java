package com.travel.travelAgency.search.interfaces;

import com.travel.travelAgency.search.models.OneWayFlightResults;
import com.travel.travelAgency.search.models.ReturnFlightsResults;
import com.travel.travelAgency.search.models.SearchFlightForm;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * @author rahulmoje
 */
public interface SearchFlightsInterface {

    List<String> findSourceAirports() throws SQLException;

    List<String> findDestinationAirports() throws SQLException;

    void validateSearchRequest(SearchFlightForm searchFlightForm);

    List<ReturnFlightsResults> retrieveReturnFlightResults(SearchFlightForm searchFlightForm) throws SQLException, ParseException;

    List<OneWayFlightResults> retrieveOneWayFlightResults(SearchFlightForm searchFlightForm) throws SQLException, ParseException;
}
