package com.careerguidance.user.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.careerguidance.user.bean.User;
import com.careerguidance.user.common.DatabaseConnection;

public class LoginDaoImpl { 
	
	
	
	public String insert(User user) 
	{
		DatabaseConnection databaseCon=new DatabaseConnection();
		
		String result = "Data entered successfully";
		String sql = "insert into user values(null,?,?,?,?)";
		try (Connection con = databaseCon.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, user.getUname());
			ps.setString(2, user.getPasswd());
			ps.setString(3, user.getFirstname());
			ps.setString(4, user.getLastname());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			result = "Data not entered";
		}
		return result;
	}
	
	public User getUser(String username,String password) 
	{
		DatabaseConnection databaseCon=new DatabaseConnection();

		User user=null;

		//load the database driver
		
		
		//create connection to database with parameter
		
		//Query
		String sql = "select username,passwd,firstname,lastname from User where Username=? and Passwd=? "  ;
		try (Connection con = databaseCon.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
					
			
			//set where parameter
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();  
			while(rs.next())
			{
				//get select parameter
				user=new User();
				String usern = rs.getString("username");
				String pass = rs.getString("passwd");
			    String firstname = rs.getString("firstname");
			    String lastname = rs.getString("lastname");
			    user.setFirstname(firstname);
			    user.setLastname(lastname);
			    user.setUname(usern);
			    user.setPasswd(pass);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	
}
