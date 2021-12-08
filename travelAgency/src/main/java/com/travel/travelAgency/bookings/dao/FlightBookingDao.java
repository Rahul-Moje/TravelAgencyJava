package com.travel.travelAgency.bookings.dao;

import com.travel.travelAgency.bookings.model.FlightBookingRequest;
import com.travel.travelAgency.bookings.repository.FlightBookingRepository;
import com.travel.travelAgency.util.DatabaseConnection;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author rahulmoje
 */
@Repository
public class FlightBookingDao implements FlightBookingRepository {

    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
    Connection con = DatabaseConnection.getSQLConnection();

    @Override
    public Integer saveUserBooking(FlightBookingRequest flightBooking) throws SQLException {
        String query = "INSERT INTO USERBOOKING(USERNAME, BOOKINGDATE, TICKETCOST, \n" +
                "NUMBAGGAGES, MEALPLAN, JOURNEYTYPE, FROMSCHEDULEID, NUMPASSENGERS, USEREMAIL) VALUES(\n" +
                "?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, flightBooking.getUserName());
        preparedStatement.setString(2, DATE_FORMATTER.format(new Date()));
        preparedStatement.setBigDecimal(3, new BigDecimal(flightBooking.getTotalCost().setScale(15).toPlainString()));
        preparedStatement.setInt(4, flightBooking.getNumOfBaggages());
        preparedStatement.setString(5, flightBooking.getMealType().name());
        preparedStatement.setString(6, flightBooking.getJourneyType().name());
        preparedStatement.setInt(7, flightBooking.getFromFlightScheduleId());
        preparedStatement.setInt(8, flightBooking.getNumOfPassengers());
        preparedStatement.setString(9, flightBooking.getUserEmail());
        preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        resultSet.next();
        return resultSet.getInt(1);
    }

    @Override
    public void updateSeatsFilled(Integer scheduleId, Integer numOfPassengers) throws SQLException {
        String query = "UPDATE FLIGHTSCHEDULES SET SEATSBOOKED = SEATSBOOKED + ? WHERE ID = ?";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setInt(1, numOfPassengers);
        preparedStatement.setInt(2, scheduleId);
        preparedStatement.executeUpdate();
    }

    @Override
    public void updateUserBookingWithReturnJourney(Integer toFlightScheduleId, Integer id) throws SQLException {
        String query = "UPDATE USERBOOKING SET TOSCHEDULEID = ? WHERE ID = ?";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setInt(1, toFlightScheduleId);
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
    }
}
