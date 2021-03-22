package com.careerguidance.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.careerguidance.user.bean.User;
import com.careerguidance.user.dao.LoginDaoImpl;
import com.careerguidance.user.service.LoginServiceImpl;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		
		System.out.print("--- username "+uname);
		System.out.print("--- password "+password);

		User user=new User();
		user.setUname(uname);
		user.setPassword(password);
		LoginDaoImpl rDao= new LoginDaoImpl();
		boolean result=rDao.validate(user);
		
		 if(result){  
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
