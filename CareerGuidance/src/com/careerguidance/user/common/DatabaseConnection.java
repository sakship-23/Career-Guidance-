package com.careerguidance.user.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection  implements IDatabaseConnection{
	public String dburl = "jdbc:mysql://localhost:3306/db_career_guidance";
	public String dbuname = "root";
	public String dbpasswd = "root";
    public String dbdriver = "com.mysql.jdbc.Driver";


    @Override
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(dbdriver);
			con = DriverManager.getConnection(dburl, dbuname, dbpasswd);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

}
