<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>注册页面</title>
		<link rel="stylesheet" href="css/registTest.css" />
		<script type="text/javascript" src="js/jquery-1.8.3.min.js" ></script>
		<script type="text/javascript" src="js/regist.js" ></script>
	</head>
	<body>
		<div class="main">
			
			<div class="regist1">
				<img src="img/regist.jpg" />
			</div>
			<h2>管理员注册界面</h1>
			<div class="regist2">
				
				<form action="/staffingsystem/MangerRegistServlet" method="post">	
					<p>管理员ID：<input type="number" name="managerId" required="required" placeholder="管理员ID(例：1010002，前三位不变)"/></p>
					<p>姓&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" name="managerName"  required="required" placeholder="请输入姓名"/></p>
					<p>密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="managerPwd" required="required" placeholder="请输入密码" pattern="^.{6,}$" /></p>		
					<!--<p>电子邮箱：<input type="email" name="email" <!--pattern="^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$"--</p>-->					
					<p>手机号码：<input type="text" name="telephone" required="required" placeholder="请输入手机" pattern="1[358]\d{9}"/></p><br />
					<p>年&nbsp;&nbsp;&nbsp;&nbsp;龄：<input type="number" name="userAge" max="150" min="18" step="1" required="required" placeholder="请输入您的年龄"/></p><br />
					<p>生&nbsp;&nbsp;&nbsp;&nbsp;日：<input type="date" name="birthday" /> </p>					
					<span><input id="nan" type="radio" name="userSex" value="男" required="required" checked="checked"/>男
					<input id="nv" type="radio" name="userSex" value="女" required="required" />女	</span>
					<input id="regist" type="submit" value="点&nbsp;击&nbsp;注&nbsp;册"  />
					
				</form>	
				<div>
					<h5>已注册，点此~<a href="login.html">登录</a></h6>
				</div>
		</div>
		</div>
	</body>
</html>
