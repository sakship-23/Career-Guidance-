package com.careerguidance.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.careerguidance.user.bean.Course;
import com.careerguidance.user.bean.Institute;
import com.careerguidance.user.bean.Location;
import com.careerguidance.user.bean.ParentCourse;
import com.careerguidance.user.bean.User;
import com.careerguidance.user.dao.CourseDaoImpl;
import com.careerguidance.user.dao.InstituteDaoImpl;
import com.careerguidance.user.dao.LocationDaoImpl;
import com.careerguidance.user.dao.LoginDaoImpl;

/**
 * Servlet implementation class LoginController
 */
public class CourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession();
		 if(session.getAttribute("username")!=null ) {
		CourseDaoImpl courseDaoImpl=new CourseDaoImpl();
		List<Course> list=courseDaoImpl.getCourses();
		List<ParentCourse> parentCourselist=courseDaoImpl.getParentCourse();
		
		InstituteDaoImpl instituteDaoImpl=new InstituteDaoImpl();
		List<Institute> institutes=instituteDaoImpl.getInstitutes();
		
		LocationDaoImpl locationDaoImpl=new LocationDaoImpl();
		List<Location> locations=locationDaoImpl.getLocations();
		
		 //set Course
	      session.setAttribute("courses", list);
	      session.setAttribute("parentcourses", parentCourselist);
	      session.setAttribute("institutes", institutes);
	      session.setAttribute("locations", locations);

		 RequestDispatcher rd=request.getRequestDispatcher("course.jsp");  
	     rd.forward(request,response);  
		 }
		 else {
			    response.sendRedirect("login.jsp");  

		 }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
