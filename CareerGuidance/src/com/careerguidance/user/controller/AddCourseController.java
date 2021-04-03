package com.careerguidance.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.careerguidance.user.bean.Course;
import com.careerguidance.user.dao.CourseDaoImpl;

public class AddCourseController  extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	 String coursename=req.getParameter("cname");
	 int parentcourseid=Integer.parseInt(req.getParameter("parentcourseid"));
	 int instituteid=Integer.parseInt(req.getParameter("instituteid"));
	 String duration=req.getParameter("duration");
	 int locationid=Integer.parseInt(req.getParameter("locationid"));
	 CourseDaoImpl courseDaoImpl=new CourseDaoImpl();
	 int id=courseDaoImpl.fetchMaxCourseId();
	 Course course=new Course();
	 course.setId(id);
	 course.setName(coursename);
	 course.setInstituteId(instituteid);
	 course.setParentId(parentcourseid);
	 course.setDuration(duration);
	 course.setLocationId(locationid);
	 boolean isAdd=courseDaoImpl.insertCourse(course);
	 
	 if(isAdd) {
		 req.setAttribute("successAddCourse","Course Added Successfully.");
	 }else {
		 req.setAttribute("errorAddCourse","Course Not Added.");
	 }
	 new CourseController().doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	

}
