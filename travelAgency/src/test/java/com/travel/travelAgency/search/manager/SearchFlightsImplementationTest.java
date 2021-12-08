package com.travel.travelAgency.search.manager;

import com.travel.travelAgency.search.interfaces.SearchFlightsInterface;
import com.travel.travelAgency.search.interfaces.SearchFlightsRequestValidator;
import com.travel.travelAgency.search.interfaces.TicketCostCalculator;
import com.travel.travelAgency.search.models.SearchFlightForm;
import com.travel.travelAgency.search.repository.FlightRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static com.travel.travelAgency.search.util.TestDataUtil.buildFormForTest;


/**
 * @author rahulmoje
 */
@RunWith(MockitoJUnitRunner.class)
public class SearchFlightsImplementationTest {

    @Mock
    private FlightRepository flightRepository;

    @Mock
    private SearchFlightsRequestValidator searchFlightsRequestValidator;

    @Mock
    private TicketCostCalculator ticketCostCalculator;

    @InjectMocks
    private SearchFlightsInterface searchFlightsInterface = new SearchFlightsImplementation();

    @Test
    public void testFindSourceAirports() throws SQLException {
        List<String> expectedSources = Arrays.asList("BOM", "YYZ");
        Mockito.when(flightRepository.findSourceAirports()).thenReturn(expectedSources);
        List<String> actualSources = searchFlightsInterface.findSourceAirports();
        Assert.assertNotNull(actualSources);
        Assert.assertEquals(2, actualSources.size());
        Assert.assertTrue(actualSources.containsAll(expectedSources));
    }


    @Test
    public void testFindDestinationAirports() throws SQLException {
        List<String> expectedDestinations = Arrays.asList("BOM", "YYZ");
        Mockito.when(flightRepository.findDestinationAirports()).thenReturn(expectedDestinations);
        List<String> actualDestinations = searchFlightsInterface.findDestinationAirports();
        Assert.assertNotNull(actualDestinations);
        Assert.assertEquals(2, actualDestinations.size());
        Assert.assertTrue(actualDestinations.containsAll(expectedDestinations));
    }

    @Test
    public void testValidateSearchRequest() {
        SearchFlightForm testForm = buildFormForTest();
        searchFlightsInterface.validateSearchRequest(testForm);
        Mockito.verify(searchFlightsRequestValidator).validateSearchRequest(testForm);
        Mockito.verifyNoMoreInteractions(ticketCostCalculator, flightRepository, searchFlightsRequestValidator);
    }
}
