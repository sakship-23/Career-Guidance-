package com.careerguidance.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.careerguidance.user.bean.Course;
import com.careerguidance.user.dao.CourseDaoImpl;

public class DeleteCourseController  extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session=req.getSession();
	if(session.getAttribute("username")!=null ) {
	 int courseId=Integer.parseInt(req.getParameter("id"));
	 CourseDaoImpl courseDaoImpl=new CourseDaoImpl();
	 boolean isCourseDelete=courseDaoImpl.deleteCourse(courseId);
	 boolean isParentCourseDelete=courseDaoImpl.deleteParentCourse(courseId);
	 
	 if(isCourseDelete&&isParentCourseDelete) {
		 req.setAttribute("successDeleteCourse","Course Deleted Successfully.");
	 }else {
		 req.setAttribute("errorDeleteCourse","Course Not Deleted.");
	 }
	 new CourseController().doGet(req, resp);
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
