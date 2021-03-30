package com.careerguidance.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.careerguidance.user.bean.Course;
import com.careerguidance.user.bean.Institute;
import com.careerguidance.user.bean.User;
import com.careerguidance.user.common.DatabaseConnection;

public class InstituteDaoImpl {
	public List<Institute> getInstitutes() 
	{
		List<Institute> list=new ArrayList<Institute>();

		DatabaseConnection databaseCon=new DatabaseConnection();


		//load the database driver
		databaseCon.loadDriver();
		
		//create connection to database with parameter
		Connection con = databaseCon.getConnection();
		
		//Query
		StringBuilder builder=new StringBuilder();
		builder.append("select i.id as instituteId,i.name as instituteName,l.id as locationId,l.name as locationName  from Institute i inner join Location l on i.locationid=l.id ");
		String sql = builder.toString();
		try {
					
			PreparedStatement ps = con.prepareStatement(sql);
			
			
			ResultSet rs=ps.executeQuery();  
			while(rs.next())
			{
				//get select parameter
				Institute institute=new Institute();
				int instituteId = rs.getInt("instituteId");
				int locationId = rs.getInt("locationId");
			    String instituteName = rs.getString("instituteName");
			    String locationName = rs.getString("locationName");
			   

			  
			    institute.setInstituteId(instituteId);
			    institute.setLocationId(locationId);
			    institute.setInstituteName(instituteName);
			    institute.setLocationName(locationName);
			    list.add(institute);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}

