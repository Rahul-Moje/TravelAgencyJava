package com.travel.travelAgency.dao;

import com.travel.travelAgency.repository.UserAuthRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import com.travel.travelAgency.models.UserAuth;

@Repository
public class UserAuthDAO implements UserAuthRepository{

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public int validateUsernamePassword(String username, String password) {
		int user_id = 0;
		String queryStr = "select count(*) from user_auth where username='"+username+"'"+" and password='"+password+"'";
		user_id = jdbcTemplate.queryForObject(queryStr, Integer.class);
		return user_id;
	}

}
