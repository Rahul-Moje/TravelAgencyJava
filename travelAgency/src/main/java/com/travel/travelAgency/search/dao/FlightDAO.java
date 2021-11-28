package com.travel.travelAgency.search.dao;

import com.travel.travelAgency.search.repository.FlightRepository;
import com.travel.travelAgency.util.DatabaseConnection;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FlightDAO implements FlightRepository {

    Connection con = DatabaseConnection.getSQLConnection();

    @Override
    public List<String> findSourceAirports() throws SQLException {
        String query = "SELECT DISTINCT SOURCE FROM FLIGHTS";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery(query);
        List<String> sourceAirports = new ArrayList<>();
        while (rs.next()) {
            sourceAirports.add(rs.getString("SOURCE"));
        }
        return sourceAirports;
    }

    @Override
    public List<String> findDestinationAirports() throws SQLException {
        String query = "SELECT DISTINCT DESTINATION FROM FLIGHTS";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery(query);
        List<String> destinationAirports = new ArrayList<>();
        while (rs.next()) {
            destinationAirports.add(rs.getString("DESTINATION"));
        }
        return destinationAirports;
    }
}
