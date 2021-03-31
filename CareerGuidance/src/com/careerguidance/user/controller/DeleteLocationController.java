package com.careerguidance.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.careerguidance.user.bean.Course;
import com.careerguidance.user.dao.CourseDaoImpl;
import com.careerguidance.user.dao.LocationDaoImpl;

public class DeleteLocationController  extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	 int locationId=Integer.parseInt(req.getParameter("id"));
	 
	 LocationDaoImpl locationDaoImpl=new LocationDaoImpl();
	 boolean isLocationDelete=locationDaoImpl.deleteParentLocation(locationId);
	 
	 if(isLocationDelete) 
	 {
		 req.setAttribute("successDeleteLocation","Location Deleted Successfully.");
	 }else {
		 req.setAttribute("errorDeleteLocation","Location Not Deleted.");
	 }
	 new LocationController().doGet(req, resp);
	
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	

}

