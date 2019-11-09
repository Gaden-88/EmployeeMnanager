<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTf-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<style type="text/css">
			#div1 {
				position: absolute;
				height: 500px;
				width: 600px;
			}
			
			#div02 {
				width: 800px;
				margin-left: 40px;
			}
			
			#table01 {
				width: 100%;
				text-align: center;
			}
			
			#div01 {
				margin-top: 0px;
				margin-left: 40px;
				height: 50px;
				width: 800px;
			}
			
			[type="text"] {
				width: 175px;
				height: 25px;
			}
			
			[type="button"] {
				width: 50px;
				height: 25px;
			}
			[name="page"] {
				width: 30px;
			}
			[name="btns"] {
				margin-left: 220px;
			}
			#div01_01 {
				line-height: 50px;
			}
			
			#btn1 {
				margin-left: 500px;
			}
			body {
				background-image: url(../img/Light-Skin-Background.png);
				background-color: rgb(200, 200, 200);
				background-size: cover;
			}
			
			#div02_1 {
				border: dashed blue 1px;
				height: 50px;
				line-height: 50px;
			}
			
			span {
				font-family: "微软雅黑";
				font-size: 20px;
			}
			
			body {
				background-image: url(../img/Light-Skin-Background.png);
				background-color: rgb(200, 200, 200);
				background-size: cover;
			}
		</style>
		<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="../js/right.js"></script>
	</head>

	<body>
		<div id="div1">
			<div id="div2">
				<table border="0" style="margin-top: 10px;" height="80">
					<tr>
				<%
					String name = (String)request.getSession().getAttribute("mangerName");
				%>
						<td><img src="../img/user.png"></td>
						<td style="font-weight: bold; font-size: 18px; padding-left: 10px;">
							<%=name %>您好！欢迎登录本系统。</td>
					</tr>
					<tr>
						<td><img src="../img/time.png"></td>
						<%--<% response.setIntHeader("Refresh", 1); %>--%>
						<td style="color: #777; padding-left: 10px;">现在时刻：
							<%=new Date()%>
						</td>
					</tr>
				</table>

				<fieldset style="padding:20px; border:2px solid blue;">
					<legend style="margin-left:20px; font-size:30px;">员工信息：</legend>

					<div id="div01">
						<div id="div01_01">

							<input type="text" name="text01" placeholder="输入名字(支持非全名)查询"/>
							<input type="button" value="查询"  onclick="sendSelectRequest();" />
							<input type="button" value="添加" id="btn1" onclick="window.location='addStaff.jsp'"/>
						</div>
					</div>
					<div id="div02">
						<table id="table01" border="1" cellspacing="0" cellpadding="0">
							<tr>
								<th>员工ID</th>
								<th>姓名</th>
								<th>性别</th>
								<th>年龄</th>
								<th>电话号码</th>
								<th>出生日期</th>
								<th>QQ号码</th>
								<th>部门Id</th>
								<th>操作</th>
							</tr>
						</table>
						<div name="btns">
							<input type="button" value="上一页" onclick="showPrevPage()">
							<input type="button" value="下一页" onclick="showNextPage()">
							第<input type="text" name="page" id="page" placeholder="页码">页<input type="button" value="go" onclick="showGoPage()">
							<input type="button" value="首页" onclick="showFirstPage()">
							<input type="button" value="末页" onclick="showLastPage()">
						</div>
					</div>
				</fieldset>
			</div>
		</div>
	</body>
	<% 
		String month = request.getParameter("auto_login");
		if (month != null){
			Cookie c = new Cookie("pwdSave", "1"); 
			c.setMaxAge(10*24*3600);
			c.setPath("/");
			response.addCookie(c);
		}
	%>
</html>
