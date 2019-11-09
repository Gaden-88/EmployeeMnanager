package com.zr.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.model.service.StaffService;


@WebServlet("/LikeSelectEmpNameServlet")
public class LikeSelectEmpNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/text; charset=utf-8");
		int pageLine, pageNo, pageTotal;
		String likeName;
		
		pageLine = Integer.parseInt(request.getParameter("pageLine"));
		pageNo = Integer.parseInt(request.getParameter("pageNo"));
		likeName = request.getParameter("likeName");
		
		pageTotal = StaffService.getSelectTotalPage(pageLine, likeName);
		String jsonData = StaffService.listToJson(pageLine, pageNo, pageTotal, likeName);
		
		PrintWriter out = response.getWriter();
		out.write(jsonData);
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
