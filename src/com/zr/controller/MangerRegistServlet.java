package com.zr.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.model.service.MangerService;

@WebServlet("/MangerRegistServlet")
public class MangerRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Integer managerId = Integer.parseInt(request.getParameter("managerId"));
		String managerName  = request.getParameter("managerName");
		String managerPwd  = request.getParameter("managerPwd");
		String userSex  = request.getParameter("userSex");
		Integer userAge  = Integer.parseInt(request.getParameter("userAge"));
		String birth = request.getParameter("birthday");
		Date birthday = Date.valueOf(birth);
		Long telephone  = Long.parseLong(request.getParameter("telephone"));
		
		Object[] data = {managerId, managerName, managerPwd, userSex, userAge, birthday, telephone};
		
		int res = 0;
		res = MangerService.getInsertMangerInfo(data);
		
		if(res == 1 )
		{
			response.sendRedirect("/staffingsystem/login.jsp");
		}else
		{
			response.sendRedirect("/staffingsystem/registTest.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
