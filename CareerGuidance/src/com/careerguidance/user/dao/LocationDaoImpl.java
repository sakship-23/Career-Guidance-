package com.careerguidance.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.careerguidance.user.bean.Course;
import com.careerguidance.user.bean.Institute;
import com.careerguidance.user.bean.Location;
import com.careerguidance.user.bean.User;
import com.careerguidance.user.common.DatabaseConnection;

public class LocationDaoImpl {
	public List<Location> getLocations() 
	{
		List<Location> list=new ArrayList<Location>();

		DatabaseConnection databaseCon=new DatabaseConnection();


		//load the database driver
		databaseCon.loadDriver();
		
		//create connection to database with parameter
		Connection con = databaseCon.getConnection();
		
		//Query
		StringBuilder builder=new StringBuilder();
		builder.append("select l.id,l.name from Location l ");
		String sql = builder.toString();
		try {
					
			PreparedStatement ps = con.prepareStatement(sql);
			
			
			ResultSet rs=ps.executeQuery();  
			while(rs.next())
			{
				//get select parameter
				Location location=new Location();
				int locationId = rs.getInt("id");
			    String locationName = rs.getString("name");
		
			    location.setId(locationId);
			    location.setName(locationName);
			    list.add(location);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}