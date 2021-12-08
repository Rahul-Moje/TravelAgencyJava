package com.travel.travelAgency.search.interfaces;

import com.travel.travelAgency.search.models.OneWayFlightResults;
import com.travel.travelAgency.search.models.SearchFlightForm;

import java.util.List;

/**
 * @author rahulmoje
 */
public interface SearchFlightsRequestValidator {

    void validateSearchRequest(SearchFlightForm searchFlightForm);

    void checkIfFlightsRemaining(List<OneWayFlightResults> oneWayFlights);
}
