package com.travel.travelAgency.search.manager;

import com.travel.travelAgency.search.dao.FareIntervalDAO;
import com.travel.travelAgency.search.interfaces.TicketCostCalculator;
import com.travel.travelAgency.search.models.FareInterval;
import com.travel.travelAgency.search.models.OneWayFlightResults;
import com.travel.travelAgency.search.models.ReturnFlightsResults;
import com.travel.travelAgency.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

@Service
public class TicketCostCalculatorImpl implements TicketCostCalculator {

    private static final Integer RETURN_TICKETS_COMBO_PERCENTAGE_DECREASE = 25;

    @Autowired
    private FareIntervalDAO fareIntervalDAO;

    @Override
    public void calculateOneWayCost(List<OneWayFlightResults> flights) throws SQLException {
        List<FareInterval> fareIntervals = fareIntervalDAO.retrieveFareIntervals();
        for(OneWayFlightResults flight : flights) {
            Integer days = DateUtil.calculateNumberOfDaysFromToday(flight.getDepartureTime());
            FareInterval fareInterval = findMatchingInterval(fareIntervals, days);
            if(null != fareInterval) {
                increaseFare(flight, fareInterval);
            }
        }
    }

    @Override
    public void calculateReturnCost(List<ReturnFlightsResults> flights) throws SQLException {
        List<FareInterval> fareIntervals = fareIntervalDAO.retrieveFareIntervals();
        for(ReturnFlightsResults flight : flights) {
            calculateTotalFareForBothWays(flight);
            Integer days = DateUtil.calculateNumberOfDaysFromToday(flight.getFromDepartureTime());
            FareInterval fareInterval = findMatchingInterval(fareIntervals, days);
            if(null != fareInterval) {
                increaseFare(flight, fareInterval);
            }
        }
    }

    private void calculateTotalFareForBothWays(ReturnFlightsResults flight) {
        BigDecimal fromFare = flight.getFromTicketPrice();
        BigDecimal toFare = flight.getToTicketPrice();
        BigDecimal totalFare = fromFare.add(toFare);
        totalFare = totalFare.subtract(totalFare.multiply(new BigDecimal(RETURN_TICKETS_COMBO_PERCENTAGE_DECREASE)).divide(new BigDecimal(100)));
        flight.setTotalTicketPrice(totalFare);
    }

    private void increaseFare(OneWayFlightResults flight, FareInterval fareInterval) {
        BigDecimal baseFare = flight.getTicketPrice();
        Integer percentage = fareInterval.getPercentageIncrease();
        BigDecimal amountToAdd = baseFare.multiply(new BigDecimal(percentage).divide(new BigDecimal(100)));
        BigDecimal newFare = baseFare.add(amountToAdd);
        flight.setTicketPrice(newFare);
    }

    private void increaseFare(ReturnFlightsResults flight, FareInterval fareInterval) {
        BigDecimal baseFare = flight.getTotalTicketPrice();
        Integer percentage = fareInterval.getPercentageIncrease();
        BigDecimal amountToAdd = baseFare.multiply(new BigDecimal(percentage).divide(new BigDecimal(100)));
        BigDecimal newFare = baseFare.add(amountToAdd);
        flight.setTotalTicketPrice(newFare);
    }

    private FareInterval findMatchingInterval(List<FareInterval> fareIntervals, Integer days) {
        for(FareInterval fareInterval : fareIntervals) {
            if(fareInterval.getIntervalStart() <= days && days <= fareInterval.getIntervalEnd()) {
                return fareInterval;
            }
        }
        return null;
    }
}
