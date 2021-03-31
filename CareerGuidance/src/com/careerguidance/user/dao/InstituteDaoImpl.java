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
		builder.append("select i.id as instituteId,i.name as instituteName from Institute i  ");
		String sql = builder.toString();
		try {
					
			PreparedStatement ps = con.prepareStatement(sql);
			
			
			ResultSet rs=ps.executeQuery();  
			while(rs.next())
			{
				//get select parameter
				Institute institute=new Institute();
				int instituteId = rs.getInt("instituteId");
			    String instituteName = rs.getString("instituteName");
			   

			  
			    institute.setInstituteId(instituteId);
			    institute.setInstituteName(instituteName);
			    list.add(institute);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Institute> getParentInstitute() 
	{
		List<Institute> list=new ArrayList<Institute>();

		DatabaseConnection databaseCon=new DatabaseConnection();


		//load the database driver
		databaseCon.loadDriver();
		
		//create connection to database with parameter
		Connection con = databaseCon.getConnection();
		
		//Query
		StringBuilder builder=new StringBuilder();
		builder.append("select i.id as instituteId,i.name as instituteName from Institute i;");
		
		String sql = builder.toString();
		try {
					
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();  
			while(rs.next())
			{
				//get select parameter
				Institute institute=new Institute();
				int id = rs.getInt("id");
			    String name = rs.getString("name");

			    institute.setInstituteId(id);
			    institute.setInstituteName(name);
			    list.add(institute);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean insertInstitute(Institute institute) {
		DatabaseConnection databaseCon=new DatabaseConnection();
		//load the database driver
		databaseCon.loadDriver();
		
		//create connection to database with parameter
		Connection con = databaseCon.getConnection();
		StringBuilder builder=new StringBuilder();
		int id=fetchMaxInstituteId();
		builder.append("insert into Institute values(?, ?);");
		String sql = builder.toString();
		try {
					
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			ps.setString(2, institute.getInstituteName());
		

			ps.executeUpdate();  
		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}	

	public int fetchMaxInstituteId() {

		DatabaseConnection databaseCon=new DatabaseConnection();


		//load the database driver
		databaseCon.loadDriver();
		
		//create connection to database with parameter
		Connection con = databaseCon.getConnection();
		StringBuilder builder=new StringBuilder();
		builder.append("select max(id) as id from Institute;");
		int id = 0;
		String sql = builder.toString();
		try {
					
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();  
			while(rs.next())
			{
				//get select parameter
				Institute institute=new Institute();
				id = rs.getInt("id");
				id=id+1;

			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	public boolean deleteParentInstitute(int id) {
		DatabaseConnection databaseCon=new DatabaseConnection();
		//load the database driver
		databaseCon.loadDriver();
		
		//create connection to database with parameter
		Connection con = databaseCon.getConnection();
		StringBuilder builder=new StringBuilder();
		builder.append("Delete from Institute where id=?");
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

	public boolean modifyInstitute(String institute) {
		DatabaseConnection databaseCon=new DatabaseConnection();
		//load the database driver
		databaseCon.loadDriver();
		
		//create connection to database with parameter
		Connection con = databaseCon.getConnection();
		StringBuilder builder=new StringBuilder();
		builder.append("update Institute set name=? where id=?");
		String sql = builder.toString();
		try {
					
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, institute);
			
	        ps.executeUpdate();  
		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;			}
	}