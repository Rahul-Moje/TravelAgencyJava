package com.travel.travelAgency.beforePayment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.travel.travelAgency.beforePayment.repository.ProMembershipSubscriptionRepository;
import com.travel.travelAgency.util.DatabaseConnection;

@Repository
public class ProMembershipSubscriptionDAO implements ProMembershipSubscriptionRepository{

	Connection con = DatabaseConnection.getSQLConnection();
	
	@Override
	public String getEmailId(int userId) {
		String query = "SELECT email_id from user_auth WHERE user_id = "+userId;
		String emailId = "";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery(query);
			while(rs.next()) {
				emailId = rs.getString("email_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emailId;
	}

	@Override
	public int getPlanCost(String emailId) {
		String query = "select plan_cost  from pro_membership where  plan_name  = (select plan_name from subscriptions_works where user_email_id = '"+emailId+"')";
		int planCost = 0;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery(query);
			while(rs.next()) {
				planCost = rs.getInt("plan_cost");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return planCost;
	}

}
