<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>pwd</title>
</head>
<body>
	<% 
		String month = request.getParameter("auto_login");
		if (month != null){
			Cookie c = new Cookie("pwdSave", "1"); 
			c.setMaxAge(10*24*3600);
			c.setPath("/");
			response.addCookie(c);
		}
	%>
	<a href="/project/loginsuccess.jsp">退出</a>
</body>
</html>