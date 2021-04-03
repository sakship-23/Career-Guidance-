package com.careerguidance.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.careerguidance.user.bean.User;
import com.careerguidance.user.dao.LoginDaoImpl;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String uname=request.getParameter("uname");
				String passwd=request.getParameter("passwd");
				
				
				if(uname.equals("")) {
					request.setAttribute("error","Please Enter Username.");
			        RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
			        rd.forward(request,response);  
				}
				
				if(passwd.equals("")) {
					request.setAttribute("error","Please Enter Password.");
			        RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
			        rd.forward(request,response);  
				}

				LoginDaoImpl rDao= new LoginDaoImpl();
				User result=rDao.getUser(uname,passwd);
				
				 if(result!=null){  
					  HttpSession session=request.getSession();
				      session.setAttribute("name", result.getFirstname()+" "+result.getLastname());
				      //set Course
					 RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");  
				        rd.forward(request,response);  
				    }  
				    else{  
				    	request.setAttribute("error","Invalid Username or Password");
				        RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
				        rd.include(request,response);  
				    }  
					
	}
}
