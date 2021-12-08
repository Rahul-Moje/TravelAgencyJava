package com.travel.travelAgency.proMembership.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.travel.travelAgency.proMembership.repository.ProMembershipRegistrationRepository;
import com.travel.travelAgency.util.DatabaseConnection;

/**
 * @author sowjanyamani
 */

@Repository
public class ProMembershipRegistrationDao implements ProMembershipRegistrationRepository {
	Connection con = DatabaseConnection.getSQLConnection();

	@Override
	public List<Map<String, Object>> getListofMembership() throws Exception {
		String SQL = "select * from pro_membership";
		List<Map<String, Object>> val = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery(SQL);
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("plan_name",rs.getString("plan_name"));
				map.put("plan_validity_in_years",rs.getString("plan_validity_in_years"));
				map.put("plan_cost",rs.getString("plan_cost"));
				map.put("plan_discount_in_percentage",rs.getString("plan_discount_in_percentage"));
				val.add(map);
			
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return val;
	}
	

	@Override
	public void updateMembership(String email, String plan_name, String date) throws Exception {

		String SQL = "INSERT INTO subscriptions_works (user_email_id,plan_name,date_of_purchase) VALUES ('" + email
				+ "','" + plan_name + "',curdate())";
		try {
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.executeUpdate();
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public String returnPlanAmount(String plan_name) throws Exception {
        String amount = "";
		String SQL = "SELECT plan_cost from pro_membership where plan_name='" + plan_name + "'";
		try {
			PreparedStatement ps = con.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery(SQL);
			while (rs.next()) {
				amount = rs.getString("plan_cost");
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return amount;
		}
	}
	
	

