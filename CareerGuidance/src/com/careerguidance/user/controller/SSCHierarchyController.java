package com.careerguidance.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

import com.careerguidance.user.bean.Hierarchy;
import com.careerguidance.user.dao.HierarchyDaoImpl;

public class SSCHierarchyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HierarchyDaoImpl hierarchyDaoImpl=new HierarchyDaoImpl();
		Hierarchy hierarchy=hierarchyDaoImpl.fetchSSCHierarchy();
		
		ObjectMapper mapper=new ObjectMapper();
		String sscHierarchy=mapper.writeValueAsString(hierarchy);
		
		 //set Course
		HttpSession session=request.getSession();
	      session.setAttribute("sscHierarchy", sscHierarchy);

		 RequestDispatcher rd=request.getRequestDispatcher("hierarchy.jsp");  
	     rd.forward(request,response);  		
		
	}

	

}
