package com.travel.travelAgency.proMembership.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.travel.travelAgency.proMembership.repository.ProMembershipRegistrationRepository;

@Repository
public class ProMembershipRegistrationDAO implements ProMembershipRegistrationRepository {

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	 //System.out.println(namedParameterJdbcTemplate.queryForList("select * from pro_membership;", parameterSource));
	public List<Map<String, Object>> getListofMembership() throws Exception {

		String SQL = "select * from pro_membership ";

		MapSqlParameterSource parameterSource = new MapSqlParameterSource();

		return namedParameterJdbcTemplate.queryForList(SQL, parameterSource);

	}

}
