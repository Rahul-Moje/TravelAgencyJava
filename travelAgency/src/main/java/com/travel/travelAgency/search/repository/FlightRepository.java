package com.travel.travelAgency.search.repository;

import java.sql.SQLException;
import java.util.List;

public interface FlightRepository {

    List<String> findSourceAirports() throws SQLException;

    List<String> findDestinationAirports() throws SQLException;
}
