package com.careerguidance.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.careerguidance.user.bean.Course;
import com.careerguidance.user.bean.Institute;
import com.careerguidance.user.bean.Location;
import com.careerguidance.user.dao.CourseDaoImpl;
import com.careerguidance.user.dao.InstituteDaoImpl;
import com.careerguidance.user.dao.LocationDaoImpl;

public class AddInstituteController  extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	 String institutename=req.getParameter("cname");
	

	 InstituteDaoImpl instituteDaoImpl=new InstituteDaoImpl();
	 int id=instituteDaoImpl.fetchMaxInstituteId();
	 Institute institute=new Institute();
	 institute.setInstituteName(institutename);
	 boolean isAdd=instituteDaoImpl.insertInstitute(institute);
	 
	 if(isAdd) {
		 req.setAttribute("successAddInstitute","Institute Added Successfully.");
	 }else {
		 req.setAttribute("errorAddInstitute","Institute Not Added.");
	 }
	 new InstituteController().doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	

}
