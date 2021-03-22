package com.careerguidance.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

import com.careerguidance.user.bean.User;

public class LoginDaoImpl {
	private String dburl = "jdbc:mysql://localhost:3306/careerguidance";
	private String dbuname = "root";
	private String dbpassword = "root";
	private String dbdriver = "com.mysql.jdbc.Driver";

	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(dburl, dbuname, dbpassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public void login() {

	}

	public String insert(User user) 
	{
		loadDriver(dbdriver);
		Connection con = getConnection();
		String result = "Data entered successfully";
		String sql = "insert into user values(null,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUname());
			ps.setString(2, user.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			result = "Data not entered";
		}
		return result;
	}
	
	public boolean validate(User user) 
	{
		boolean status=false;  
		loadDriver(dbdriver);
		Connection con = getConnection();
		String sql = "select * from User where Username=? and Password=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUname());
			ps.setString(2, user.getPassword());
			ResultSet rs=ps.executeQuery();  
			status=rs.next();  
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
	
}
