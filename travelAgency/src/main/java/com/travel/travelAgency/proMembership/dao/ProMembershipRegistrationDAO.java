package com.travel.travelAgency.proMembership.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.travel.travelAgency.proMembership.repository.ProMembershipRegistrationRepository;

@Repository
public class ProMembershipRegistrationDAO implements ProMembershipRegistrationRepository {

	@Autowired
	JdbcTemplate jdbctemplate;

	@Override
	public List<Map<String, Object>> getListofMembership() throws Exception {

		String SQL = "select * from pro_membership";

		return jdbctemplate.queryForList(SQL);

	}

	@Override
	public void updateMembership(String email, String plan_name, String date) throws Exception {

		String SQL = "INSERT INTO subscriptions_works (user_email_id,plan_name,date_of_purchase) VALUES ('" + email
				+ "','" + plan_name + "','" + date + "')";
		jdbctemplate.update(SQL);

	}
}
