package com.travel.travelAgency.search.interfaces;

import com.travel.travelAgency.search.models.SearchFlightForm;

public interface SearchFlightsRequestValidator {
    void validateSearchRequest(SearchFlightForm searchFlightForm);
}
