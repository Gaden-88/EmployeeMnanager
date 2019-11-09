package com.zr.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.model.service.DepartmentService;
import com.zr.model.service.StaffService;

@WebServlet("/AddStaffInfoServlet")
public class AddStaffInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Integer empId = Integer.parseInt(request.getParameter("ID"));
		String empName = request.getParameter("name");
		String empSex = request.getParameter("sex");
		Integer empAge = Integer.parseInt(request.getParameter("age"));
		String strBirthday = request.getParameter("birthday");
		Long telephone = Long.parseLong(request.getParameter("phone"));
		Long qq = Long.parseLong(request.getParameter("qq"));
		String departmentName = request.getParameter("department");
		//把字符串格式的日期转化为Date(sql)类型的数据
		Date birthday = Date.valueOf(strBirthday);
		int departmentId = DepartmentService.getDepartmentId(departmentName);
		
		Object[] data = {empId, empName, empSex, empAge, birthday, telephone, qq, departmentId};
		
		int res = 0;
		res = StaffService.addStaff(data);
		
		if(res ==1)
		{
			response.sendRedirect("/staffingsystem/jsp_showEmpInfo/right.jsp");
		}else
		{
			System.out.println("添加失败！");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
