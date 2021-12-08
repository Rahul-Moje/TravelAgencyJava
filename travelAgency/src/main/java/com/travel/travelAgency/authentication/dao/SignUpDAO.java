package com.travel.travelAgency.authentication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.travel.travelAgency.authentication.repository.SignUpRepository;
import com.travel.travelAgency.util.DatabaseConnection;


@Repository
public class SignUpDAO implements SignUpRepository{
	
	Connection con = DatabaseConnection.getSQLConnection();
	
	@Override
	public void signUpUser(String username, String password, String email, String securityQuestionId, String securityAnswer, String roleName) {
		String queryStr = "Insert into user_auth(username, password , email_id, security_question_id, security_answer) values ('"+username+"','"+password+"','"+email+"',"+securityQuestionId+",'"+securityAnswer+"')";
		try {
			PreparedStatement ps = con.prepareStatement(queryStr);
			ps.executeUpdate(queryStr);

			//con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
					
	}

}
