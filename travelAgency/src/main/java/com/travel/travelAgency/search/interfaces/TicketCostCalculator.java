package com.travel.travelAgency.search.interfaces;

import com.travel.travelAgency.search.models.OneWayFlightResults;

import java.sql.SQLException;
import java.util.List;

public interface TicketCostCalculator {

    public void calculateOneWayCost(List<OneWayFlightResults> flights) throws SQLException;

}
