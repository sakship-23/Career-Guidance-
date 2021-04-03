package com.careerguidance.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.careerguidance.user.bean.Course;
import com.careerguidance.user.bean.ParentCourse;
import com.careerguidance.user.bean.User;
import com.careerguidance.user.common.DatabaseConnection;

public class CourseDaoImpl {
	public List<Course> getCourses() {
		List<Course> list = new ArrayList<Course>();

		DatabaseConnection databaseCon = new DatabaseConnection();

		// load the database driver
		

		// create connection to database with parameter
		Connection con = databaseCon.getConnection();

		// Query
		StringBuilder builder = new StringBuilder();
		builder.append(
				"select c1.id,c.id as parentId,c1.name,c.name as parentCourseName,l.name as locationName,l.id as locationId,i.name as instituteName,i.id as instituteId,c1.duration   from Course c inner join Course c1 on c.id=c1.parentid  inner join Institute i on c1.instituteid=i.id   inner join Location l on c1.locationid=l.id ");
		builder.append("union all ");
		builder.append(
				"select c.id,c.parentid as parentId,c.name,null,l.name as locationName,l.id as locationId,i.name as instituteName,i.id as instituteId,c.duration   from Course c inner join Institute i on c.instituteid=i.id inner join Location l on c.locationid=l.id where c.parentid IS NULL; ");

		String sql = builder.toString();
		try {

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// get select parameter
				Course course = new Course();
				int id = rs.getInt("id");
				int parentId = rs.getInt("parentId");
				String name = rs.getString("name");
				String parentCourseName = rs.getString("parentCourseName");

				if (parentCourseName == null) {
					parentCourseName = "-";
				}
				int instituteId = rs.getInt("instituteId");
				String instituteName = rs.getString("instituteName");
				String duration = rs.getString("duration");
				int locationid = rs.getInt("locationId");
				String locationname = rs.getString("locationName");
				course.setId(id);
				course.setParentId(parentId);
				course.setInstituteId(instituteId);
				course.setName(name);
				course.setParentCourseName(parentCourseName);
				course.setInstitutename(instituteName);
				course.setDuration(duration);
				course.setLocationId(locationid);
				course.setLocationname(locationname);
				list.add(course);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<ParentCourse> getParentCourse() {
		List<ParentCourse> list = new ArrayList<ParentCourse>();

		DatabaseConnection databaseCon = new DatabaseConnection();

		// load the database driver
		

		// create connection to database with parameter
		

		// Query
		StringBuilder builder = new StringBuilder();
		builder.append(
				"select distinct c.id,c.name from course c ;");

		String sql = builder.toString();
		try (Connection con = databaseCon.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);)
		{

			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// get select parameter
				ParentCourse course = new ParentCourse();
				int id = rs.getInt("id");
				String name = rs.getString("name");

				course.setId(id);
				course.setName(name);
				list.add(course);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean insertCourse(Course course) {
		DatabaseConnection databaseCon = new DatabaseConnection();
		// load the database driver
		

		// create connection to database with parameter
		StringBuilder builder = new StringBuilder();
		builder.append("insert into Course values(?,?,?,?,?,?);");
		String sql = builder.toString();
		try (Connection con = databaseCon.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, course.getId());
			ps.setString(2, course.getName());
			ps.setInt(3, course.getParentId());
			ps.setInt(4, course.getInstituteId());
			ps.setString(5, course.getDuration());
			ps.setInt(6, course.getLocationId());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public int fetchMaxCourseId() {

		DatabaseConnection databaseCon = new DatabaseConnection();

		// load the database driver
		

		// create connection to database with parameter
		StringBuilder builder = new StringBuilder();
		builder.append("select max(id) as id from Course;");
		int id = 0;
		String sql = builder.toString();
		try (Connection con = databaseCon.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// get select parameter
				ParentCourse course = new ParentCourse();
				id = rs.getInt("id");
				id = id + 1;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public boolean deleteCourse(int id) {
		DatabaseConnection databaseCon = new DatabaseConnection();
		// load the database driver
		

		// create connection to database with parameter
		StringBuilder builder = new StringBuilder();
		builder.append("Delete from Course where id=?");
		String sql = builder.toString();
		try (Connection con = databaseCon.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean deleteParentCourse(int id) {
		DatabaseConnection databaseCon = new DatabaseConnection();
		// load the database driver
		

		// create connection to database with parameter
		StringBuilder builder = new StringBuilder();
		builder.append("Delete from Course where parentid=?");
		String sql = builder.toString();
		try (Connection con = databaseCon.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean modifyCourse(int id, int parentId, int instituteId, String name, String duration, String location) {
		DatabaseConnection databaseCon = new DatabaseConnection();
		// load the database driver
		

		// create connection to database with parameter
		StringBuilder builder = new StringBuilder();
		builder.append("update Course set name=?,parentid=?,instituteid=?,duration=?,location=? where id=?");
		String sql = builder.toString();
		try (Connection con = databaseCon.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, name);
			ps.setInt(2, parentId);
			ps.setInt(3, instituteId);
			ps.setString(4, duration);
			ps.setString(5, location);

			ps.setInt(6, id);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
}
