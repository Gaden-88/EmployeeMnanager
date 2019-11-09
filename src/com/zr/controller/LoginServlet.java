package com.zr.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.model.service.MangerService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");



		Integer mangerID = Integer.parseInt(request.getParameter("user"));
		String pwd = request.getParameter("pwd");
		System.out.println(mangerID+" "+pwd);
		String[] auto_login = request.getParameterValues("auto_login");

		int res = 0; 
		try {
			res = MangerService.getRegisterInfo(mangerID, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("mangerID", mangerID);

		String  mangerName = MangerService.getMangerName(mangerID);
		request.getSession().setAttribute("mangerName", mangerName);
		
		if(res==mangerID) {
			if(auto_login != null && auto_login.length==1) {
				System.out.println("auto_login");
				response.sendRedirect("/staffingsystem/jsp_showEmpInfo/home.jsp?auto_login=1");
			}else {
				response.sendRedirect("/staffingsystem/jsp_showEmpInfo/home.jsp");
			}	
			
			
		}else {
			response.sendRedirect("/project/login2.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
