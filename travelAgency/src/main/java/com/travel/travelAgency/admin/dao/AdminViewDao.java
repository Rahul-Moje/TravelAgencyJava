package com.travel.travelAgency.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.travel.travelAgency.admin.repository.AdminViewRepository;
import com.travel.travelAgency.util.DatabaseConnection;

/**
 * @author sowjanyamani
 */

	@Repository
	public class AdminViewDao implements AdminViewRepository {
		Connection con = DatabaseConnection.getSQLConnection();

		public List<Map<String, Object>> getListofGrievances() throws Exception {
			String SQL = "select * from grievance";
			List<Map<String, Object>> val = new ArrayList<>();
			try {
				PreparedStatement ps = con.prepareStatement(SQL);
				ResultSet rs = ps.executeQuery(SQL);
				while (rs.next()) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("user_email",rs.getString("user_email_id"));
					map.put("complaint",rs.getString("complaint"));
					val.add(map);
				
				}

			} catch (DataAccessException e) {
				e.printStackTrace();
			}
			return val;
		}
		
	}

