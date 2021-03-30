package com.careerguidance.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.careerguidance.user.bean.Course;
import com.careerguidance.user.bean.User;
import com.careerguidance.user.common.DatabaseConnection;

public class CourseDaoImpl {
	public List<Course> getCourses() 
	{
		List<Course> list=new ArrayList<Course>();

		DatabaseConnection databaseCon=new DatabaseConnection();


		//load the database driver
		databaseCon.loadDriver();
		
		//create connection to database with parameter
		Connection con = databaseCon.getConnection();
		
		//Query
		StringBuilder builder=new StringBuilder();
		builder.append("select c.id,c1.id as parentId,c.name,c1.name as parentCourseName,i.name as instituteName,i.id as instituteId,c.duration ");
		builder.append(" from Course c inner join Institute i on c.instituteid=i.id ");
		builder.append("  inner join Course c1 on c.id=c1.parentid;");
		String sql = builder.toString();
		try {
					
			PreparedStatement ps = con.prepareStatement(sql);
			
			
			ResultSet rs=ps.executeQuery();  
			while(rs.next())
			{
				//get select parameter
				Course course=new Course();
				int id = rs.getInt("id");
				int parentId = rs.getInt("parentId");
			    String name = rs.getString("name");
			    String parentCourseName = rs.getString("parentCourseName");
			    int instituteId = rs.getInt("instituteId");
			    String instituteName = rs.getString("instituteName");
			    String duration = rs.getString("duration");

			    course.setId(id);
			    course.setParentId(parentId);
			    course.setInstituteId(instituteId);
			    course.setName(name);
			    course.setParentCourseName(parentCourseName);
			    course.setInstitutename(instituteName);
			    course.setDuration(duration);
			    list.add(course);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
