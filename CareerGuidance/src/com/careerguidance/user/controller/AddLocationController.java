package com.careerguidance.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.careerguidance.user.bean.Course;
import com.careerguidance.user.bean.Location;
import com.careerguidance.user.dao.CourseDaoImpl;
import com.careerguidance.user.dao.LocationDaoImpl;

public class AddLocationController  extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 HttpSession session=req.getSession();
		 if(session.getAttribute("username")!=null ) {
	 String locationname=req.getParameter("cname");
	

	 LocationDaoImpl locationDaoImpl=new LocationDaoImpl();
	 int id=locationDaoImpl.fetchMaxLocationId();
	 Location location=new Location();
	 location.setName(locationname);
	 boolean isAdd=locationDaoImpl.insertLocation(location);
	 
	 if(isAdd) {
		 req.setAttribute("successAddLocation","Location Added Successfully.");
	 }else {
		 req.setAttribute("errorAddLocation","Location Not Added.");
	 }
	 new LocationController().doGet(req, resp);
		 }
		 else {
			    resp.sendRedirect("login.jsp");  
 
		 }
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	

}

