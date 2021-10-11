package com.travel.travelAgency.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.travel.travelAgency.repository.ForgotPasswordRepository;

@Repository
public class ForgotPasswordRepositoryDAO implements ForgotPasswordRepository {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Boolean isEmailValid(String email) throws Exception {

		try {
			String SQL = "select email_id from user_auth where email_id= :email ";

			MapSqlParameterSource parameterSource = new MapSqlParameterSource();
			parameterSource.addValue("email", email);
			
			namedParameterJdbcTemplate.queryForObject(SQL, parameterSource, String.class);

			return Boolean.TRUE;
		} catch (DataAccessException e) {
			return Boolean.FALSE;
		}

	}

	@Override
	public String getSecurityQues(String email) throws Exception {

		 String SQL = "select sq.question from user_auth ua join security_questions sq on ua.security_question_id = sq.question_id where email_id= :email ";
		 
         MapSqlParameterSource parameterSource = new MapSqlParameterSource();
         parameterSource.addValue("email", email);
         
         String question =namedParameterJdbcTemplate.queryForObject(SQL, parameterSource, String.class);

		return question;
	}

	@Override
	public Boolean isSecurityAnswerValid(String security_answer, String email) throws Exception {
         
		try {
        String SQL= "select security_answer from user_auth  where email_id= :email";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("email", email);
        
        String answer = namedParameterJdbcTemplate.queryForObject(SQL, parameterSource, String.class);
        if (answer == security_answer) {
		
	    }
        return Boolean.TRUE;
        
		}catch (DataAccessException e) {
			return Boolean.FALSE;
		}
	}

	@Override
	public void updatePassword(String email, String newPassword) throws Exception {
//        String SQL = "UPDATE user_auth SET password = 'myuser1' where email_id='user1@dal.ca'";
//        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
//        parameterSource.addValue("email", email);
//        
//        String pass = namedParameterJdbcTemplate.update(SQL, parameterSource);
//        
	
        
	}

}
