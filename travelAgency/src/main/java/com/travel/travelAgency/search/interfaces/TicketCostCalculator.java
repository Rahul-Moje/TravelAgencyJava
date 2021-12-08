package com.travel.travelAgency.search.interfaces;

import com.travel.travelAgency.search.models.OneWayFlightResults;
import com.travel.travelAgency.search.models.ReturnFlightsResults;

import java.sql.SQLException;
import java.util.List;

/**
 * @author rahulmoje
 */
public interface TicketCostCalculator {

    void calculateOneWayCost(List<OneWayFlightResults> flights) throws SQLException;

    void calculateReturnCost(List<ReturnFlightsResults> flights) throws SQLException;
}
