package com.travel.travelAgency.search.manager;

import com.travel.travelAgency.search.dao.FareIntervalDAO;
import com.travel.travelAgency.search.interfaces.TicketCostCalculator;
import com.travel.travelAgency.search.models.FareInterval;
import com.travel.travelAgency.search.models.OneWayFlightResults;
import com.travel.travelAgency.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

@Service
public class TicketCostCalculatorImpl implements TicketCostCalculator {

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

    private void increaseFare(OneWayFlightResults flight, FareInterval fareInterval) {
        BigDecimal baseFare = flight.getTicketPrice();
        Integer percentage = fareInterval.getPercentageIncrease();
        BigDecimal amountToAdd = baseFare.multiply(new BigDecimal(percentage).divide(new BigDecimal(100)));
        BigDecimal newFare = baseFare.add(amountToAdd);
        flight.setTicketPrice(newFare);
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
