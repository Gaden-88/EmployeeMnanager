package com.zr.controller;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.model.service.StaffService;

@WebServlet("/DeleteStaffByIDServlet")
public class DeleteStaffByIDServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Integer empId = Integer.parseInt(request.getParameter("empId"));
		
		int res = StaffService.deleStaff(empId);
		System.out.println(res);
		if(res == 1)
		{
			response.sendRedirect("/staffingsystem/jsp_showEmpInfo/right.jsp");
		}else
		{
			System.out.println("É¾³ýÊ§°Ü");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
