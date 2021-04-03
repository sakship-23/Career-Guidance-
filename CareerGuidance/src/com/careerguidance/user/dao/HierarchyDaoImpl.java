package com.careerguidance.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.careerguidance.user.bean.Hierarchy;
import com.careerguidance.user.common.DatabaseConnection;

public class HierarchyDaoImpl {
	
	public Hierarchy fetchSSCHierarchy() {
		Hierarchy sscHierarchy=new Hierarchy();
		DatabaseConnection databaseCon = new DatabaseConnection();

		// load the database driver
		

		// create connection to database with parameter
		Connection con = databaseCon.getConnection();

		// Query
		StringBuilder builder = new StringBuilder();
		builder.append(
				"select c1.id,c.id as parentId,c1.name,c1.duration,c.name as parentCourseName,l.name as locationName,l.id as locationId,i.name as instituteName,i.id as instituteId,c1.duration   from Course c inner join Course c1 on c.id=c1.parentid  inner join Institute i on c1.instituteid=i.id   inner join Location l on c1.locationid=l.id where c.name='SSC' ");
		
		String sql = builder.toString();
		List<Hierarchy> list = new ArrayList<Hierarchy>();

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// get select parametere
				Hierarchy child=new Hierarchy();
				String name = rs.getString("name");
				String duration = rs.getString("duration");

				String title=rs.getString("instituteName")+" , "+rs.getString("locationName");
				child.setFname(name);
				Hierarchy child1=new Hierarchy();
				child1.setFname(title);
				child1.setTitle(duration);

				List<Hierarchy> listVal=new ArrayList<Hierarchy>();
				listVal.add(child1);
				child.setChildren(listVal);
				
				list.add(child);
			}
			
			
			
			sscHierarchy.setTitle("SSC, Mumbai University");
			sscHierarchy.setChildren(list);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sscHierarchy;
	}
	
	public Hierarchy fetchHSCHierarchy() {
		List<Hierarchy> scienceList=fetchScienceHSCHierarchy();
		List<Hierarchy> commerceList=fetchCommerceHSCHierarchy();
		List<Hierarchy> artsHierarchy=fetchArtsHSCHierarchy();
		
		
		
		Hierarchy hierarchy=new Hierarchy();
		hierarchy.setTitle("HSC, Mumbai University");
		List<Hierarchy> list=new ArrayList<Hierarchy>();
		Hierarchy hierarchy1=new Hierarchy();
		hierarchy1.setTitle("HSC science");
		hierarchy1.setChildren(scienceList);
		Hierarchy hierarchy2=new Hierarchy();
		hierarchy2.setTitle("HSC commerce");
		hierarchy2.setChildren(commerceList);

		Hierarchy hierarchy3=new Hierarchy();
		hierarchy3.setTitle("HSC arts");
		hierarchy3.setChildren(artsHierarchy);

		list.add(hierarchy1);
		list.add(hierarchy2);
		list.add(hierarchy3);
		hierarchy.setChildren(list);

		
		return hierarchy;
		
	}
	
	public List<Hierarchy> fetchScienceHSCHierarchy() {
		DatabaseConnection databaseCon = new DatabaseConnection();

		// load the database driver
		

		// create connection to database with parameter

		// Query
		StringBuilder builder = new StringBuilder();
		builder.append(
				"select c1.id,c.id as parentId,c1.name,c1.duration,c.name as parentCourseName,l.name as locationName,l.id as locationId,i.name as instituteName,i.id as instituteId,c1.duration   from Course c inner join Course c1 on c.id=c1.parentid  inner join Institute i on c1.instituteid=i.id   inner join Location l on c1.locationid=l.id where c.name='HSC science' ");
		
		String sql = builder.toString();
		List<Hierarchy> sciencelist = new ArrayList<Hierarchy>();

		try (Connection con = databaseCon.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// get select parametere
				Hierarchy child=new Hierarchy();
				String name = rs.getString("name");
				String duration = rs.getString("duration");

				String title=rs.getString("instituteName")+" , "+rs.getString("locationName");
				child.setFname(name);
				Hierarchy child1=new Hierarchy();
				child1.setFname(title);
				child1.setTitle(duration);

				List<Hierarchy> listVal=new ArrayList<Hierarchy>();
				listVal.add(child1);
				child.setChildren(listVal);
				
				sciencelist.add(child);
			}
			
			
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sciencelist;
	}
	
	public List<Hierarchy> fetchCommerceHSCHierarchy() {
		DatabaseConnection databaseCon = new DatabaseConnection();

		// load the database driver
		

		// create connection to database with parameter

		// Query
		StringBuilder builder = new StringBuilder();
		builder.append(
				"select c1.id,c.id as parentId,c1.name,c1.duration,c.name as parentCourseName,l.name as locationName,l.id as locationId,i.name as instituteName,i.id as instituteId,c1.duration   from Course c inner join Course c1 on c.id=c1.parentid  inner join Institute i on c1.instituteid=i.id   inner join Location l on c1.locationid=l.id where c.name='HSC commerce' ");
		
		String sql = builder.toString();
		List<Hierarchy> commercelist = new ArrayList<Hierarchy>();

		try (Connection con = databaseCon.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// get select parametere
				Hierarchy child=new Hierarchy();
				String name = rs.getString("name");
				String duration = rs.getString("duration");

				String title=rs.getString("instituteName")+" , "+rs.getString("locationName");
				child.setFname(name);
				Hierarchy child1=new Hierarchy();
				child1.setFname(title);
				child1.setTitle(duration);

				List<Hierarchy> listVal=new ArrayList<Hierarchy>();
				listVal.add(child1);
				child.setChildren(listVal);
				
				commercelist.add(child);
			}
			
			
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commercelist;
	}
	
	public List<Hierarchy> fetchArtsHSCHierarchy() {
		DatabaseConnection databaseCon = new DatabaseConnection();

		// load the database driver
		

		// create connection to database with parameter

		// Query
		StringBuilder builder = new StringBuilder();
		builder.append(
				"select c1.id,c.id as parentId,c1.name,c1.duration,c.name as parentCourseName,l.name as locationName,l.id as locationId,i.name as instituteName,i.id as instituteId,c1.duration   from Course c inner join Course c1 on c.id=c1.parentid  inner join Institute i on c1.instituteid=i.id   inner join Location l on c1.locationid=l.id where c.name='HSC arts' ");
		
		String sql = builder.toString();
		List<Hierarchy> artsList = new ArrayList<Hierarchy>();

		try (Connection con = databaseCon.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// get select parametere
				Hierarchy child=new Hierarchy();
				String name = rs.getString("name");
				String duration = rs.getString("duration");

				String title=rs.getString("instituteName")+" , "+rs.getString("locationName");
				child.setFname(name);
				Hierarchy child1=new Hierarchy();
				child1.setFname(title);
				child1.setTitle(duration);

				List<Hierarchy> listVal=new ArrayList<Hierarchy>();
				listVal.add(child1);
				child.setChildren(listVal);
				
				artsList.add(child);
			}
			
			
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return artsList;
	}
	
	


}
