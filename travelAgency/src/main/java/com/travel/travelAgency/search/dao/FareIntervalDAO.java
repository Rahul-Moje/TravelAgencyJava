package com.travel.travelAgency.search.dao;

import com.travel.travelAgency.search.models.FareInterval;
import com.travel.travelAgency.search.repository.FareIntervalRepository;
import com.travel.travelAgency.util.DatabaseConnection;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rahulmoje
 */
@Repository
public class FareIntervalDAO implements FareIntervalRepository {

    Connection con = DatabaseConnection.getSQLConnection();

    @Override
    public List<FareInterval> retrieveFareIntervals() throws SQLException {
        String query = "SELECT * FROM FAREINTERVALS";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery(query);
        List<FareInterval> fareIntervals = new ArrayList<>();
        while (rs.next()) {
            FareInterval.FareIntervalBuilder fareIntervalBuilder = new FareInterval.FareIntervalBuilder();
            fareIntervalBuilder.withIntervalStart(rs.getInt("INTERVALSTART"));
            fareIntervalBuilder.withIntervalEnd(rs.getInt("INTERVALEND"));
            fareIntervalBuilder.withPercentageIncrease(rs.getInt("PERCENTAGEINCREASE"));
            fareIntervals.add(fareIntervalBuilder.build());
        }
        return fareIntervals;
    }
}
