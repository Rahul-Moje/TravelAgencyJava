package com.travel.travelAgency.search.interfaces;

import com.travel.travelAgency.search.models.SearchFlightForm;

import javax.servlet.http.HttpServletRequest;

public interface SearchFlightFormMapperInterface {

    SearchFlightForm mapFormData(HttpServletRequest request);
}
