package com.travel.travelAgency.search.dao;

import com.travel.travelAgency.search.models.OneWayFlightResults;
import com.travel.travelAgency.search.models.SearchFlightForm;
import com.travel.travelAgency.search.repository.FlightRepository;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static com.travel.travelAgency.search.util.TestDataUtil.buildFormForTest;

/**
 * @author rahulmoje
 */
public class FlightDAOTest {


    private FlightRepository flightRepository = new FlightDAO();

    @Test
    public void testFindSourceAirports() throws SQLException {
        Assert.assertNotNull(flightRepository.findSourceAirports());
    }


    @Test
    public void testFindDestinationAirports() throws SQLException {
        Assert.assertNotNull(flightRepository.findDestinationAirports());
    }

    @Test
    public void testFindOneWayFlights() throws SQLException, ParseException {
        SearchFlightForm testForm = buildFormForTest();
        List<OneWayFlightResults> actualResults = flightRepository.findOneWayFlights(testForm);
        Assert.assertNotNull(actualResults);
        Assert.assertFalse(actualResults.isEmpty());
        for(OneWayFlightResults actualResult : actualResults) {
            Assert.assertEquals("BOM", actualResult.getSource());
            Assert.assertEquals("YYZ", actualResult.getDestination());
        }
    }

    @Test
    public void testFindBothWayFlights() throws SQLException, ParseException {
        SearchFlightForm testForm = buildFormForTest();
        List<OneWayFlightResults> actualResults = flightRepository.findBothWayFlights(testForm);
        List<String> expectedSourceAndDestination = new ArrayList<>();
        expectedSourceAndDestination.add("BOM");
        expectedSourceAndDestination.add("YYZ");
        Assert.assertNotNull(actualResults);
        Assert.assertFalse(actualResults.isEmpty());
        for(OneWayFlightResults actualResult : actualResults) {
            Assert.assertTrue(expectedSourceAndDestination.contains(actualResult.getSource()));
            Assert.assertTrue(expectedSourceAndDestination.contains(actualResult.getDestination()));
        }
    }

}
