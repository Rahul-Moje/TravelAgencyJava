package com.travel.travelAgency.search.manager;

import com.travel.travelAgency.search.exceptions.SearchFlightsException;
import com.travel.travelAgency.search.interfaces.SearchFlightsRequestValidator;
import com.travel.travelAgency.search.models.SearchFlightForm;
import org.springframework.stereotype.Service;

@Service
public class SearchFlightsRequestValidatorImpl implements SearchFlightsRequestValidator {
    
    @Override
    public void validateSearchRequest(SearchFlightForm searchFlightForm) {
        
        checkForSameSourceAndDestination(searchFlightForm);
        
        checkForReturnDatePriorToStartDate(searchFlightForm);
        
    }

    private void checkForReturnDatePriorToStartDate(SearchFlightForm searchFlightForm) {
    }

    private void checkForSameSourceAndDestination(SearchFlightForm searchFlightForm) {
        if(searchFlightForm.getSource().equals(searchFlightForm.getDestination())) {
            throw new SearchFlightsException("Flight source and destination cannot be same");
        }
    }
}
