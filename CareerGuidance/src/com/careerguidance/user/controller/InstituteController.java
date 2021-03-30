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
import com.careerguidance.user.bean.User;
import com.careerguidance.user.dao.CourseDaoImpl;
import com.careerguidance.user.dao.InstituteDaoImpl;
import com.careerguidance.user.dao.LoginDaoImpl;
import com.careerguidance.user.service.LoginServiceImpl;

/**
 * Servlet implementation class LoginController
 */
public class InstituteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		InstituteDaoImpl instituteDaoImpl=new InstituteDaoImpl();
		List<Institute> list=instituteDaoImpl.getInstitutes();
		 //set Course
		HttpSession session=request.getSession();
	      session.setAttribute("institutes", list);
	     
		 RequestDispatcher rd=request.getRequestDispatcher("institute.jsp");  
	        rd.forward(request,response);  		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
