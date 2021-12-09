package com.travel.travelAgency.beforePayment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.travel.travelAgency.beforePayment.repository.BeforePaymentsRepository;
import com.travel.travelAgency.util.DatabaseConnection;

/**
 * @author ruchishinde
 */

@Repository
public class BeforePaymentsDAO implements BeforePaymentsRepository{

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
		String query = "select plan_cost from pro_membership where  plan_name  = (select plan_name from subscriptions_works where user_email_id = '"+emailId+"')";
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

	@Override
	public int updateFinalCost(float finalCost, int bookingId, float baggageWeight) {
		String query = "UPDATE USERBOOKING SET BAGGAGECOST="+baggageWeight+", FINALCOST="+finalCost+ "where ID="+bookingId;
		int updatedRecord = 0;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(query);
			updatedRecord = ps.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRecord;
	}

	@Override
	public float getDiscountPercentOnPromoCode(String promoCode) {
		promoCode = promoCode.toUpperCase();
		String query = "select discount_percent from promo_codes pc where UPPER(pc.code) = '"+promoCode+"' and pc.valid_until_date > NOW(); ";
		float discount = 0.0f;
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery(query);
			while(rs.next()) {
				discount = rs.getFloat("discount_percent");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return discount;
	}

}
