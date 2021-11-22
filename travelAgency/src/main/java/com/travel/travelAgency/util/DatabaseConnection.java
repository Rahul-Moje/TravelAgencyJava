package com.travel.travelAgency.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static Connection con = null;
	static
    {
        String url = "jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_21_DEVINT";
        String user = "CSCI5308_21_DEVINT_USER";
        String pass = "eiBiequeir8Ukofi";
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
