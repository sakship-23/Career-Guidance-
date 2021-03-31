package com.careerguidance.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.careerguidance.user.bean.Course;
import com.careerguidance.user.dao.CourseDaoImpl;
import com.careerguidance.user.dao.InstituteDaoImpl;
import com.careerguidance.user.dao.LocationDaoImpl;

public class DeleteInstituteController  extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	 int instituteId=Integer.parseInt(req.getParameter("id"));
	 
	 InstituteDaoImpl instituteDaoImpl=new InstituteDaoImpl();
	 boolean isInstituteDelete=instituteDaoImpl.deleteParentInstitute(instituteId);
	 
	 if(isInstituteDelete) 
	 {
		 req.setAttribute("successDeleteInstitute","Institute Deleted Successfully.");
	 }else {
		 req.setAttribute("errorDeleteInstitute","Institute Not Deleted.");
	 }
	 new InstituteController().doGet(req, resp);
	
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	

}