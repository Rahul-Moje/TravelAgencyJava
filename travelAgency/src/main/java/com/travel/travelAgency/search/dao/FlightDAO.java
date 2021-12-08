package com.travel.travelAgency.search.dao;

import com.travel.travelAgency.search.models.OneWayFlightResults;
import com.travel.travelAgency.search.models.SearchFlightForm;
import com.travel.travelAgency.search.repository.FlightRepository;
import com.travel.travelAgency.util.DatabaseConnection;
import com.travel.travelAgency.util.DateUtil;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rahulmoje
 */
@Repository
public class FlightDAO implements FlightRepository {



    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
    private Connection dbConnection = DatabaseConnection.getSQLConnection();

    @Override
    public List<String> findSourceAirports() throws SQLException {
        String query = "SELECT DISTINCT SOURCE FROM FLIGHTS";
        PreparedStatement ps = dbConnection.prepareStatement(query);
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
        PreparedStatement ps = dbConnection.prepareStatement(query);
        ResultSet rs = ps.executeQuery(query);
        List<String> destinationAirports = new ArrayList<>();
        while (rs.next()) {
            destinationAirports.add(rs.getString("DESTINATION"));
        }
        return destinationAirports;
    }

    @Override
    public List<OneWayFlightResults> findOneWayFlights(SearchFlightForm searchFlightForm) throws SQLException, ParseException {
        String query = "SELECT \n" +
                "FL.FLIGHTCODE,FL.AIRLINE, FLSCH.ID, FL.SOURCE, FL.DESTINATION,\n" +
                "FLSCH.DEPARTURETIME, FLSCH.ARRIVALTIME,FLSCH.TOTALHOURS,FLSCH.TICKETPRICE,FLSCH.SEATSBOOKED,FLSCH.CAPACITY\n" +
                "FROM FLIGHTS FL,\n" +
                "FLIGHTSCHEDULES FLSCH\n" +
                "WHERE FL.FLIGHTCODE = FLSCH.FLIGHTCODE\n" +
                "AND FL.SOURCE=? AND FL.DESTINATION=?\n" +
                "AND FLSCH.DEPARTURETIME>=? \n" +
                "AND FLSCH.DEPARTURETIME<=?";
        PreparedStatement oneWaySearchStatement = dbConnection.prepareStatement(query);
        oneWaySearchStatement.setString(1,searchFlightForm.getSource());
        oneWaySearchStatement.setString(2, searchFlightForm.getDestination());
        oneWaySearchStatement.setString(3, DATE_FORMATTER.format(DateUtil.calculateStartOfDay(searchFlightForm.getFromDate())));
        oneWaySearchStatement.setString(4, DATE_FORMATTER.format(DateUtil.calculateEndOfDay(searchFlightForm.getFromDate())));
        ResultSet rs = oneWaySearchStatement.executeQuery();
        List<OneWayFlightResults> oneWayFlightResultsList = new ArrayList<>();
        while (rs.next()) {
            OneWayFlightResults oneWayFlightResults = new OneWayFlightResults();
            oneWayFlightResults.setFlightCode(rs.getString("FLIGHTCODE"));
            oneWayFlightResults.setAirLine(rs.getString("AIRLINE"));
            oneWayFlightResults.setFlightScheduleId(rs.getInt("ID"));
            oneWayFlightResults.setSource(rs.getString("SOURCE"));
            oneWayFlightResults.setDestination(rs.getString("DESTINATION"));
            oneWayFlightResults.setDepartureTime(DATE_FORMATTER.parse(rs.getString("DEPARTURETIME")));
            oneWayFlightResults.setArrivalTime(DATE_FORMATTER.parse(rs.getString("ARRIVALTIME")));
            oneWayFlightResults.setTotalHours(rs.getLong("TOTALHOURS"));
            oneWayFlightResults.setTicketPrice(rs.getBigDecimal("TICKETPRICE"));
            oneWayFlightResults.setSeatsBooked(rs.getInt("SEATSBOOKED"));
            oneWayFlightResults.setCapacity(rs.getInt("CAPACITY"));
            oneWayFlightResultsList.add(oneWayFlightResults);
        }
        return oneWayFlightResultsList;
    }

    @Override
    public List<OneWayFlightResults> findBothWayFlights(SearchFlightForm searchFlightForm) throws SQLException, ParseException {
        String query = "SELECT \n" +
                "FL.FLIGHTCODE,FL.AIRLINE, FLSCH.ID, FL.SOURCE, FL.DESTINATION, \n" +
                "FLSCH.DEPARTURETIME, FLSCH.ARRIVALTIME,FLSCH.TOTALHOURS,FLSCH.TICKETPRICE,FLSCH.SEATSBOOKED,FLSCH.CAPACITY \n" +
                "FROM FLIGHTS FL, \n" +
                "FLIGHTSCHEDULES FLSCH \n" +
                "WHERE FL.FLIGHTCODE = FLSCH.FLIGHTCODE \n" +
                "AND FL.SOURCE=? AND FL.DESTINATION=? \n" +
                "AND FLSCH.DEPARTURETIME>=? \n" +
                "AND FLSCH.DEPARTURETIME<=? \n" +
                "UNION \n" +
                "SELECT \n" +
                "FL.FLIGHTCODE,FL.AIRLINE, FLSCH.ID, FL.SOURCE, FL.DESTINATION, \n" +
                "FLSCH.DEPARTURETIME, FLSCH.ARRIVALTIME,FLSCH.TOTALHOURS,FLSCH.TICKETPRICE,FLSCH.SEATSBOOKED,FLSCH.CAPACITY \n" +
                "FROM FLIGHTS FL, \n" +
                "FLIGHTSCHEDULES FLSCH \n" +
                "WHERE FL.FLIGHTCODE = FLSCH.FLIGHTCODE \n" +
                "AND FL.SOURCE=? AND FL.DESTINATION=? \n" +
                "AND FLSCH.DEPARTURETIME>=? \n" +
                "AND FLSCH.DEPARTURETIME<=? ";
        PreparedStatement oneWaySearchStatement = dbConnection.prepareStatement(query);
        oneWaySearchStatement.setString(1,searchFlightForm.getSource());
        oneWaySearchStatement.setString(2, searchFlightForm.getDestination());
        oneWaySearchStatement.setString(3, DATE_FORMATTER.format(DateUtil.calculateStartOfDay(searchFlightForm.getFromDate())));
        oneWaySearchStatement.setString(4, DATE_FORMATTER.format(DateUtil.calculateEndOfDay(searchFlightForm.getFromDate())));
        oneWaySearchStatement.setString(5,searchFlightForm.getDestination());
        oneWaySearchStatement.setString(6, searchFlightForm.getSource());
        oneWaySearchStatement.setString(7, DATE_FORMATTER.format(DateUtil.calculateStartOfDay(searchFlightForm.getToDate())));
        oneWaySearchStatement.setString(8, DATE_FORMATTER.format(DateUtil.calculateEndOfDay(searchFlightForm.getToDate())));
        ResultSet rs = oneWaySearchStatement.executeQuery();
        List<OneWayFlightResults> oneWayFlightResultsList = new ArrayList<>();
        while (rs.next()) {
            OneWayFlightResults oneWayFlightResults = new OneWayFlightResults();
            oneWayFlightResults.setFlightCode(rs.getString("FLIGHTCODE"));
            oneWayFlightResults.setAirLine(rs.getString("AIRLINE"));
            oneWayFlightResults.setFlightScheduleId(rs.getInt("ID"));
            oneWayFlightResults.setSource(rs.getString("SOURCE"));
            oneWayFlightResults.setDestination(rs.getString("DESTINATION"));
            oneWayFlightResults.setDepartureTime(DATE_FORMATTER.parse(rs.getString("DEPARTURETIME")));
            oneWayFlightResults.setArrivalTime(DATE_FORMATTER.parse(rs.getString("ARRIVALTIME")));
            oneWayFlightResults.setTotalHours(rs.getLong("TOTALHOURS"));
            oneWayFlightResults.setTicketPrice(rs.getBigDecimal("TICKETPRICE"));
            oneWayFlightResults.setSeatsBooked(rs.getInt("SEATSBOOKED"));
            oneWayFlightResults.setCapacity(rs.getInt("CAPACITY"));
            oneWayFlightResultsList.add(oneWayFlightResults);
        }
        return oneWayFlightResultsList;
    }

}
