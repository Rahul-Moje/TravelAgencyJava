package com.travel.travelAgency.search.manager;

import com.travel.travelAgency.search.interfaces.TicketCostCalculator;
import com.travel.travelAgency.search.models.FareInterval;
import com.travel.travelAgency.search.models.OneWayFlightResults;
import com.travel.travelAgency.search.repository.FareIntervalRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author rahulmoje
 */
@RunWith(MockitoJUnitRunner.class)
public class TicketCostCalculatorImplTest {

    @Mock
    private FareIntervalRepository fareIntervalRepository;

    @InjectMocks
    private TicketCostCalculator ticketCostCalculator = new TicketCostCalculatorImpl();

    @Test
    public void testCalculateOneWayCostWithoutFareIncrease() throws SQLException {
        Date todaysDate = new Date();
        Calendar departureCalendar = Calendar.getInstance();
        departureCalendar.setTime(todaysDate);
        departureCalendar.add(Calendar.DATE, 9);
        List<FareInterval> testFareIntervals = new ArrayList<>();
        testFareIntervals.add(new FareInterval.FareIntervalBuilder()
                .withIntervalStart(0).withIntervalEnd(7).withPercentageIncrease(100).build());
        Mockito.when(fareIntervalRepository.retrieveFareIntervals()).thenReturn(testFareIntervals);
        List<OneWayFlightResults> testFlights = new ArrayList<>();
        testFlights.add(new OneWayFlightResults());
        testFlights.get(0).setTicketPrice(new BigDecimal("100"));
        testFlights.get(0).setDepartureTime(departureCalendar.getTime());
        ticketCostCalculator.calculateOneWayCost(testFlights);
        Assert.assertEquals(0, new BigDecimal("100").compareTo(testFlights.get(0).getTicketPrice()));

    }

    @Test
    public void testCalculateOneWayCostWithFareIncrease() throws SQLException {
        Date todaysDate = new Date();
        Calendar departureCalendar = Calendar.getInstance();
        departureCalendar.setTime(todaysDate);
        departureCalendar.add(Calendar.DATE, 5);
        List<FareInterval> testFareIntervals = new ArrayList<>();
        testFareIntervals.add(new FareInterval.FareIntervalBuilder()
                .withIntervalStart(0).withIntervalEnd(7).withPercentageIncrease(100).build());
        Mockito.when(fareIntervalRepository.retrieveFareIntervals()).thenReturn(testFareIntervals);
        List<OneWayFlightResults> testFlights = new ArrayList<>();
        testFlights.add(new OneWayFlightResults());
        testFlights.get(0).setTicketPrice(new BigDecimal("100"));
        testFlights.get(0).setDepartureTime(departureCalendar.getTime());
        ticketCostCalculator.calculateOneWayCost(testFlights);
        Assert.assertEquals(0, new BigDecimal("200").compareTo(testFlights.get(0).getTicketPrice()));

    }


}
