package com.travel.travelAgency.search.manager;

import com.travel.travelAgency.search.exceptions.SearchFlightsException;
import com.travel.travelAgency.search.interfaces.SearchFlightsRequestValidator;
import com.travel.travelAgency.search.models.JourneyType;
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
        if(isReturnOptionSelected(searchFlightForm)
                && searchFlightForm.getToDate().compareTo(searchFlightForm.getFromDate()) <= 0) {
            throw new SearchFlightsException("To date must be greater than from date");
        }
    }

    private void checkForSameSourceAndDestination(SearchFlightForm searchFlightForm) {
        if(isReturnOptionSelected(searchFlightForm)
                && searchFlightForm.getSource().equals(searchFlightForm.getDestination())) {
            throw new SearchFlightsException("Flight source and destination cannot be same");
        }
    }

    private boolean isReturnOptionSelected(SearchFlightForm searchFlightForm) {
        return searchFlightForm.getJourneyType().equals(JourneyType.RETURN);
    }
}
