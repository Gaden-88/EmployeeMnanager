<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
	Cookie c =  new Cookie("pwdSave","1");
	c.setMaxAge(0);
	c.setPath("/");
	response.addCookie(c);
	
%>
已退出，请<a href="/project/login.jsp">重新登录</a>
</body>
</html>