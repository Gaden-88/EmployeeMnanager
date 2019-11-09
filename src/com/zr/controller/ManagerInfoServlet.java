package com.zr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.model.entity.Manger;
import com.zr.model.service.MangerService;


@WebServlet("/ManagerInfoServlet")
public class ManagerInfoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int managerID =(int)request.getSession().getAttribute("mangerID");
		Manger manger = MangerService.showManageInfo(managerID);
		
		request.getSession().setAttribute("manger", manger);
		
		response.sendRedirect("/staffingsystem/jsp_showEmpInfo/admininfo.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
