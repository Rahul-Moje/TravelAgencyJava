package com.travel.travelAgency.search.manager;

import com.travel.travelAgency.search.exceptions.SearchFlightsException;
import com.travel.travelAgency.search.interfaces.SearchFlightsRequestValidator;
import com.travel.travelAgency.search.models.JourneyType;
import com.travel.travelAgency.search.models.OneWayFlightResults;
import com.travel.travelAgency.search.models.SearchFlightForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.travel.travelAgency.search.util.TestDataUtil.buildFormForTest;

/**
 * @author rahulmoje
 */
@RunWith(MockitoJUnitRunner.class)
public class SearchFlightsRequestValidatorImplTest {

    @InjectMocks
    private SearchFlightsRequestValidator searchFlightsRequestValidator = new SearchFlightsRequestValidatorImpl();

    @Test
    public void testValidateSearchRequestOneWay() {
        SearchFlightForm testForm = buildFormForTest();
        searchFlightsRequestValidator.validateSearchRequest(testForm);
    }

    @Test(expected = SearchFlightsException.class)
    public void testCheckForSameSourceAndDestination() {
        SearchFlightForm testForm = new SearchFlightForm.SearchFlightFormBuilder("BOM", "BOM")
                .withJourneyType(JourneyType.RETURN).build();
        searchFlightsRequestValidator.validateSearchRequest(testForm);
    }

    @Test(expected = SearchFlightsException.class)
    public void testCheckForReturnDatePriorToStartDate() {
        Date todaysDate = new Date();

        Calendar endDateCalendar = Calendar.getInstance();
        endDateCalendar.setTime(todaysDate);
        endDateCalendar.add(Calendar.DATE, -1);

        SearchFlightForm testForm = new SearchFlightForm.SearchFlightFormBuilder("BOM", "BOM")
                .withJourneyType(JourneyType.RETURN).withFromDate(todaysDate).withFromDate(endDateCalendar.getTime())
                .build();
        searchFlightsRequestValidator.validateSearchRequest(testForm);

    }

    @Test
    public void testCheckIfFlightsRemainingWhenFlightsPresent() {
        List<OneWayFlightResults> testFlights = new ArrayList<>();
        testFlights.add(new OneWayFlightResults());
        searchFlightsRequestValidator.checkIfFlightsRemaining(testFlights);
    }

    @Test(expected = SearchFlightsException.class)
    public void testCheckIfFlightsRemainingWhenNoFlightsPresent() {
        searchFlightsRequestValidator.checkIfFlightsRemaining(new ArrayList<OneWayFlightResults>());
    }
}
