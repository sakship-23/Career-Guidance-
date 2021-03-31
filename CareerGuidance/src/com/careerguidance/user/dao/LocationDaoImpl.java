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
import com.careerguidance.user.bean.ParentCourse;
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
	
public List<Location> getParentLocation() 
{
	List<Location> list=new ArrayList<Location>();

	DatabaseConnection databaseCon=new DatabaseConnection();


	//load the database driver
	databaseCon.loadDriver();
	
	//create connection to database with parameter
	Connection con = databaseCon.getConnection();
	
	//Query
	StringBuilder builder=new StringBuilder();
	builder.append("select l.id,l.name from Location l;");
	
	String sql = builder.toString();
	try {
				
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();  
		while(rs.next())
		{
			//get select parameter
			Location location=new Location();
			int id = rs.getInt("id");
		    String name = rs.getString("name");

		    location.setId(id);
		    location.setName(name);
		    list.add(location);
		}
	
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
}

public boolean insertLocation(Location location) {
	DatabaseConnection databaseCon=new DatabaseConnection();
	//load the database driver
	databaseCon.loadDriver();
	
	//create connection to database with parameter
	Connection con = databaseCon.getConnection();
	StringBuilder builder=new StringBuilder();
	int id=fetchMaxLocationId();
	builder.append("insert into Location values(?, ?);");
	String sql = builder.toString();
	try {
				
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,id);
		ps.setString(2, location.getName());
	

		ps.executeUpdate();  
	
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
	return true;
}	

public int fetchMaxLocationId() {

	DatabaseConnection databaseCon=new DatabaseConnection();


	//load the database driver
	databaseCon.loadDriver();
	
	//create connection to database with parameter
	Connection con = databaseCon.getConnection();
	StringBuilder builder=new StringBuilder();
	builder.append("select max(id) as id from Location;");
	int id = 0;
	String sql = builder.toString();
	try {
				
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();  
		while(rs.next())
		{
			//get select parameter
			Location location=new Location();
			id = rs.getInt("id");
			id=id+1;

		}
	
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return id;
}
public boolean deleteParentLocation(int id) {
	DatabaseConnection databaseCon=new DatabaseConnection();
	//load the database driver
	databaseCon.loadDriver();
	
	//create connection to database with parameter
	Connection con = databaseCon.getConnection();
	StringBuilder builder=new StringBuilder();
	builder.append("Delete from Location where id=?");
	String sql = builder.toString();
	try {
				
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();  
	
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
	return true;		
}

public boolean modifyLocation(String location) {
	DatabaseConnection databaseCon=new DatabaseConnection();
	//load the database driver
	databaseCon.loadDriver();
	
	//create connection to database with parameter
	Connection con = databaseCon.getConnection();
	StringBuilder builder=new StringBuilder();
	builder.append("update Location set name=? where id=?");
	String sql = builder.toString();
	try {
				
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, location);
		
        ps.executeUpdate();  
	
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
	return true;			}
}

	
