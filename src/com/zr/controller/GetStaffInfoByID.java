package com.zr.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.model.service.StaffService;

@WebServlet("/GetStaffInfoByID")
public class GetStaffInfoByID extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/text; charset=utf-8");
		
		int empID;
		
		empID = Integer.parseInt(request.getParameter("empId"));
		String jsonData = StaffService.getStaffinfoByIDToJson(empID);
		
		PrintWriter out = response.getWriter();
		out.write(jsonData);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
