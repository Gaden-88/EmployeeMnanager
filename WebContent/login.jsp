<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>登录页面</title>
		<script type="text/javascript" src="js/jquery-1.8.3.min.js" ></script>
		<script type="text/javascript" src="js/login.js" ></script>
		<link rel="stylesheet" type="text/css" href="css/login.css"/>
		
	</head>
	<body >
		<div id="main">		
		
			<div class="main"><img src="img/登录.jpg" />
			<h3>管理员登录界面</h3>
			<form action="/staffingsystem/LoginServlet" method="post">
				<div class="login">					
					账号：<input type="text" name="user"  required="required" placeholder="请输入账号"/><br />
					密码：<input type="password" name="pwd" required="required" placeholder="请输入密码" pattern="^.{6,}$"/><br />
					&nbsp;<input type="checkbox" value="re_pwd" name="re_pwd"/><span>记住密码</span>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" value="auto_login"  name="auto_login"/><span>自动登录</span><br />
					<input type="submit" value="登&nbsp;&nbsp;&nbsp;录" /><br />
					<span><a href="regist.jsp">注册账号</a></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span><a href="forgetPwd.jsp">忘记密码？</a></span>
				</div>
			</form>
			</div>
		</div>
  	
  	
  	<%
		Cookie[] cs = request.getCookies();

		for (int i=0; cs!=null && i<cs.length; i++){
			String name = cs[i].getName();
			if (name.equals("pwdSave")){
				response.sendRedirect("/project/loginsuccess.jsp");
				return;
			}
		}
	%>

	
	</body>
</html>
