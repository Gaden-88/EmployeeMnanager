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
	String user = request.getParameter("user");
	%>
	欢迎管理员<%=user %>登录！
	<% 
		String auto_login = request.getParameter("auto_login");
		if (auto_login != null){
			Cookie c = new Cookie("pwdSave", "1"); 
			c.setMaxAge(30*24*3600);
			c.setPath("/");
			response.addCookie(c);
		}
	%>
	<a href="/project/repeat.jsp">退 出</a>
</body>
</html>