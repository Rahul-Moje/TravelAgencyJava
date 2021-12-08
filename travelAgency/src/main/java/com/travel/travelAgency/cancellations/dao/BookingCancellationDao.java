package com.travel.travelAgency.cancellations.dao;

import com.travel.travelAgency.cancellations.exceptions.BookingCancellationException;
import com.travel.travelAgency.cancellations.repository.BookingCancellationRepository;
import com.travel.travelAgency.util.DatabaseConnection;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author rahulmoje
 */
@Repository
public class BookingCancellationDao implements BookingCancellationRepository {

    Connection connection = DatabaseConnection.getSQLConnection();

    @Override
    public Boolean isBookingCancelledForBookingId(Integer bookingId) throws SQLException {
        String query = "SELECT ISCANCELLED FROM USERBOOKING WHERE ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, bookingId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            return resultSet.getBoolean("ISCANCELLED");
        }
        throw new BookingCancellationException("No results found for given booking id");
    }

    @Override
    public void updateBookingToCancelled(Integer bookingId) throws SQLException {
        String query = "UPDATE USERBOOKING SET ISCANCELLED = ? WHERE ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setBoolean(1, Boolean.TRUE);
        preparedStatement.setInt(2, bookingId);
        preparedStatement.executeUpdate();
    }

    @Override
    public void updateSeatsForOneWayCancelledBooking(Integer bookingId) throws SQLException {
        String query = "UPDATE\n" +
                "FLIGHTSCHEDULES FS,\n" +
                "USERBOOKING UB\n" +
                "SET FS.SEATSBOOKED = FS.SEATSBOOKED + UB.NUMPASSENGERS\n" +
                "WHERE\n" +
                "UB.ID = ? AND FS.ID = UB.FROMSCHEDULEID";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, bookingId);
        preparedStatement.executeUpdate();
    }

    @Override
    public void updateSeatsForReturnCancelledBooking(Integer bookingId) throws SQLException {
        String query = "UPDATE\n" +
                "FLIGHTSCHEDULES FS,\n" +
                "USERBOOKING UB\n" +
                "SET FS.SEATSBOOKED = FS.SEATSBOOKED + UB.NUMPASSENGERS\n" +
                "WHERE\n" +
                "UB.ID = ? AND FS.ID = UB.TOSCHEDULEID";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, bookingId);
        preparedStatement.executeUpdate();
    }
}
