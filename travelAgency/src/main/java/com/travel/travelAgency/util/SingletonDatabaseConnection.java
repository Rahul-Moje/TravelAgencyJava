package com.travel.travelAgency.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

//Singleton pattern
public class SingletonDatabaseConnection {
	
	@Autowired
	Environment env;
	
//	@Value( "${spring.datasource.url}" )
	static String url="jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_21_DEVINT";
//	@Value( "${spring.datasource.username}" )
    static String user="CSCI5308_21_DEVINT_USER";
//	@Value( "${spring.datasource.password}" )
    static String pass="eiBiequeir8Ukofi";
    
	private static SingletonDatabaseConnection instance;
	private static Connection con = null;
	
	static
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
      
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
	
	public static Connection getSQLConnection() {
		return con;
	}
	
	public static SingletonDatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new SingletonDatabaseConnection();
        }

        return instance;
    }
}
