package com.travel.travelAgency.search.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface SearchFlightsInterface {

    List<String> findSourceAirports() throws SQLException;

    List<String> findDestinationAirports() throws SQLException;
}
