package com.travel.travelAgency.commissions.DAO;

import com.travel.travelAgency.commissions.models.Commission;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.travel.travelAgency.commissions.repository.CommissionRepository;
import com.travel.travelAgency.util.DatabaseConnection;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.ResultSet;

import static com.travel.travelAgency.commissions.DAO.CommissionCons.*;


@Repository
public class CommissionDAO implements CommissionRepository {

    static Connection conn = DatabaseConnection.getSQLConnection();

     CommissionCons[] cons = CommissionCons.values();

    public static List<Commission> fetchData() throws SQLException {
        List<Commission> list = null;
        try {
            String queryStr = "Select * from user_payments";
            PreparedStatement ps = conn.prepareStatement(queryStr);
            ResultSet rs = ps.executeQuery(queryStr);
            list = new ArrayList<>();

            while (rs.next()) {

                Commission c = new Commission();
                c.setuserId(rs.getString(1));
                c.setDateTime(rs.getString(2));
                c.setTicketAmount( rs.getFloat(3));

                double commission=0;

                if(rs.getFloat(3) <= 10000) {
                    commission = first.label*rs.getFloat(3);
                }
                else if(rs.getFloat(3)>10000 && rs.getFloat(3)<=50000)
                {
                    commission= second.label*rs.getFloat(3);
                }
                else if(rs.getFloat(3)>50000)
                {
                    commission= third.label*rs.getFloat(3);
                }
                c.setCommissionAmount(commission);
                list.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static boolean putData(List<Commission> list){

        StringBuilder br = new StringBuilder();

        br.append("INSERT into Commissions(userId, dateTime , ticketAmount, comm_amt) values");

        list.forEach( c -> {


            br.append("(" ).
                    append("'").append(c.getuserId()).append("'").append(",").
                    append("'").append(c.getDateTime()).append("'").append(",").
                    append(c.getTicketAmount()).append(",").
                    append(c.getCommissionAmount()).append(")");

            br.append(",");
        });

        br.replace(br.lastIndexOf(","),br.lastIndexOf(",") + 1,";");

        try {
            PreparedStatement insertStmt = conn.prepareStatement(br.toString());
            insertStmt.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }

        return true;

    }
    public static List<Commission> displayData() throws SQLException {
        List<Commission> display = null;
        try {
            String queryStr = "Select * from Commissions";
            PreparedStatement ps = conn.prepareStatement(queryStr);
            ResultSet rs = ps.executeQuery(queryStr);
            display= new ArrayList<>();

            while (rs.next()) {

                Commission c = new Commission();
                c.setuserId(rs.getString(1));
                c.setDateTime(rs.getString(2));
                c.setTicketAmount( rs.getFloat(3));
                c.setCommissionAmount(rs.getDouble(4));
                display.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            //conn.close();
        }
        return display;
    }

}
