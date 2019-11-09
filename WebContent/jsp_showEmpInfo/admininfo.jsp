<%@page import="com.zr.model.entity.Manger"%>
<%@ page language="java" contentType="text/html; charset=UTf-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<style type="text/css">
			body {
				background-image: url(../img/Light-Skin-Background.png);
				background-color: rgb(200, 200, 200);
				background-size: cover;
			}
			
			#div01 #table01 {
				width: 300px;
				text-align: center;
				margin-left: 150px
			}
			
			#table01 tr {
				height: 50px;
			}
			
			#div01 {
				margin-top: 25px;
				margin-left: 50px;
			}
			td
			{
				width: 200px;
			}
		</style>
	</head>

	<body>
		<fieldset style="padding:20px; border:2px solid blue;">
			<legend style="margin-left:20px; font-size:30px;">管理员信息如下：</legend>
			<%
				Manger manger = (Manger)request.getSession().getAttribute("manger");
			%>
			<div id="div01">
				<table id="table01" border="1" cellspacing="0" cellpadding="0">
					<tr>
						<td>ID</td>
						<td><%=manger.getManagerId() %></td>
					</tr>
					<tr>
						<td>姓名</td>
						<td><%=manger.getManagerName() %></td>
					</tr>
					<tr>
						<td>密码</td>
						<td><%=manger.getManagerPwd() %></td>
					</tr>
					<tr>
						<td>性别</td>
						<td><%=manger.getUserSex() %></td>
					</tr>
					<tr>
						<td>年龄</td>
						<td><%=manger.getUserAge() %></td>
					</tr>
					<tr>
						<td>生日</td>
						<td><%=manger.getBirthday() %></td>
					</tr>
					<tr>
						<td>电话</td>
						<td><%=manger.getTelephone() %></td>
					</tr>

				</table>

			</div>
		</fieldset>
	</body>

</html>
