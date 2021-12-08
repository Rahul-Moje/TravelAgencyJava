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
	
	
	static String url="jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_21_DEVINT";
    static String user="CSCI5308_21_DEVINT_USER";
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
	
}
