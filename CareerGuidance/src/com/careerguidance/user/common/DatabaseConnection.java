package com.careerguidance.user.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	public String dburl = "jdbc:mysql://localhost:3306/db_career_guidance";
	public String dbuname = "root";
	public String dbpasswd = "root";
    public String dbdriver = "com.mysql.jdbc.Driver";

	public void loadDriver() {
		try {
			Class.forName(dbdriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(dburl, dbuname, dbpasswd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
