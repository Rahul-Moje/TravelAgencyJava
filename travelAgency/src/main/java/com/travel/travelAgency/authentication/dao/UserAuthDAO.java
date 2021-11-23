package com.travel.travelAgency.authentication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.travel.travelAgency.authentication.repository.UserAuthRepository;
import com.travel.travelAgency.util.DatabaseConnection;

@Repository
public class UserAuthDAO implements UserAuthRepository{

	Connection con = DatabaseConnection.getSQLConnection();
	
	@Override
	public int validateUsernamePassword(String username, String password) {
		int user_id = 0;
		String queryStr = "select count(*) as total from user_auth where username='"+username+"'"+" and password='"+password+"'";
		Statement stmt;
		try {
			PreparedStatement ps = con.prepareStatement(queryStr);
			ResultSet rs = ps.executeQuery(queryStr);
			while(rs.next()) {
				user_id = rs.getInt(1);

			}
			//con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user_id;
	}

}
