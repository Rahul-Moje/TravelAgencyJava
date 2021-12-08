package com.travel.travelAgency.userprofile.dao;

import com.travel.travelAgency.search.models.JourneyType;
import com.travel.travelAgency.userprofile.model.PlanName;
import com.travel.travelAgency.userprofile.model.ProMember;
import com.travel.travelAgency.userprofile.model.User;
import com.travel.travelAgency.userprofile.model.UserBooking;
import com.travel.travelAgency.userprofile.repository.UserProfileRepository;
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
public class UserProfileDao implements UserProfileRepository {

    Connection con = DatabaseConnection.getSQLConnection();

    @Override
    public User retrieveUserDetail(String email) throws SQLException {
        String query = "SELECT \n" +
                "ua.username, ua.email_id, sw.plan_name, sw.date_of_purchase\n" +
                "FROM user_auth ua LEFT JOIN subscriptions_works sw\n" +
                "on ua.email_id = sw.user_email_id\n" +
                "WHERE ua.email_id = ?\n" +
                "LIMIT 1";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1 , email);
        ResultSet resultSet = preparedStatement.executeQuery();
        User user = null;
        while (resultSet.next()) {
            if(null != resultSet.getString("plan_name")) {
                user = new ProMember.ProMemberBuilder()
                        .withUserEmail(resultSet.getString("email_id"))
                        .withUserName(resultSet.getString("username"))
                        .withPlanName(PlanName.mapPlanName(resultSet.getString("plan_name")))
                        .withDateOfPurchase(resultSet.getDate("date_of_purchase"))
                        .build();
            } else {
                user = new User.UserBuilder()
                        .withUserEmail(resultSet.getString("email_id"))
                        .withUserName(resultSet.getString("username"))
                        .withIsProMember(false)
                        .build();
            }
        }
        return user;
    }

    @Override
    public List<UserBooking> retrieveUserBookings(String email) throws SQLException {
        String query = "SELECT \n" +
                "UB.ID, UB.BOOKINGDATE, FFROM.SOURCE, FFROM.DESTINATION,\n" +
                "UB.JOURNEYTYPE, FFROM.FLIGHTCODE FROMFLIGHTCODE, FSFROM.DEPARTURETIME FROMDATE,\n" +
                "FTO.FLIGHTCODE TOFLIGHTCODE, FSTO.DEPARTURETIME TODATE,\n" +
                "UB.FINALCOST, UB.ISCANCELLED\n" +
                "FROM USERBOOKING UB LEFT JOIN FLIGHTSCHEDULES FSFROM ON UB.FROMSCHEDULEID = FSFROM.ID\n" +
                "LEFT JOIN FLIGHTS FFROM ON FSFROM.FLIGHTCODE = FFROM.FLIGHTCODE\n" +
                "LEFT JOIN FLIGHTSCHEDULES FSTO ON UB.TOSCHEDULEID = FSTO.ID\n" +
                "LEFT JOIN FLIGHTS FTO ON FSTO.FLIGHTCODE = FTO.FLIGHTCODE\n" +
                "WHERE UB.USEREMAIL = ?\n";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1 , email);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<UserBooking> userBookings = new ArrayList<>();
        while (resultSet.next()) {
            UserBooking.UserBookingBuilder builder =
                    new UserBooking.UserBookingBuilder(resultSet.getInt("ID"))
                            .withBookingDate(resultSet.getDate("BOOKINGDATE"))
                            .withSource(resultSet.getString("SOURCE"))
                            .withDestination(resultSet.getString("DESTINATION"))
                            .withJourneyType(JourneyType.valueOf(resultSet.getString("JOURNEYTYPE")))
                            .withFromFlightCode(resultSet.getString("FROMFLIGHTCODE"))
                            .withFromDate(resultSet.getDate("FROMDATE"))
                            .withToFlightCode(resultSet.getString("TOFLIGHTCODE"))
                            .withToDate(resultSet.getDate("TODATE"))
                            .withFinalCost(resultSet.getBigDecimal("FINALCOST"))
                            .withCancelled(resultSet.getBoolean("ISCANCELLED"));
            userBookings.add(builder.build());
        }
        return userBookings;
    }
}
