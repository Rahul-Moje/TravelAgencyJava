package com.travel.travelAgency.authentication.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.travel.travelAgency.authentication.repository.SignUpRepository;


@Repository
public class SignUpDAO implements SignUpRepository{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public void signUpUser(String username, String password, String email, int securityQuestionId, String securityAnswer, String roleName)
	{
		String queryStr = "Insert into user_auth(username, password , email_id, security_question_id, security_answer) values ('"+username+"','"+password+"','"+email+"',"+securityQuestionId+",'"+securityAnswer+"')";
		System.out.println(queryStr);
		jdbcTemplate.update(queryStr);
		
					
	}

}
