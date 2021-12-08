package com.travel.travelAgency.search.repository;

import com.travel.travelAgency.search.models.FareInterval;

import java.sql.SQLException;
import java.util.List;

/**
 * @author rahulmoje
 */
public interface FareIntervalRepository {

    List<FareInterval> retrieveFareIntervals() throws SQLException;
}
