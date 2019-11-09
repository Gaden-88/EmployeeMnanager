package com.zr.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.model.service.StaffService;

@WebServlet("/GetStaffPageServlet")
public class GetStaffPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		int pageLine, pageNo, pageTotal;
		
		pageLine = Integer.parseInt(request.getParameter("pageLine"));
		pageNo = Integer.parseInt(request.getParameter("pageNo"));
		
		pageTotal = StaffService.getTotalPage(pageLine);
		
		String jsonData = StaffService.listToJson(pageLine, pageNo, pageTotal);
		
		PrintWriter out = response.getWriter();
		out.write(jsonData);
		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
