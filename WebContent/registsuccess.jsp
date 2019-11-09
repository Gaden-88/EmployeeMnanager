<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>注册成功</title>
		<style>
			img{
				margin: 0px auto;
				width: 100%;
				height: 100%;
				position: relative;
			}
			span{
				position: absolute;
				top: 2%;
				right: 2%;
				float: right;
				font-family: "楷体";
				font-size: 25px;
				color: darkslategray;
			}
			#cat{
				border-radius: 80px;
			}
			#p{
				position: absolute;
				top: 23%;
				left: 40%;
				width: 400px;
				height: 500px;		
				border-radius: 80px;
			}			
			#p>#lin{
				position: absolute;
				top: 48%;
				left: 38%;
				width: 200px;
				height: 200px;				
				text-align: center;
				font-family: "楷体";
				font-size: 30px;
				line-height: 20px;
			}				
			#p:hover{
				transition: all 0.6s ease-in-out;
           		-webkit-transition: all 0.6s ease-in-out;
            	-moz-transition: all 0.6s ease-in-out;
            	-o-transition: all 0.6s ease-in-out;
				box-shadow:5px 5px 5px 5px darkgrey;
				transform: rotate(5deg) scale(1.5);
			}
			
			
			a{
				color:rgb(51,138,234);
				text-decoration: none;
			}
				
			

		</style>
	</head>
	<body>
		<div>
			<img src="img/regist.jpg" />
			<div id="p">
				<img id="cat" src="img/cat.jpg"/>
				<div id="lin">
					<p>注册成功</p>
					<p>3秒后将返回</p>
					<p>登录页面</p>
				</div>					
			</div>
			<span>也可点此<a href="login.jsp">登录</a>呦！</span>
			</div>
			<%
				int second;
				Date date = new Date();
				second = date.getSeconds();
				response.setHeader("refresh", "5;url=/project/login.jsp");
			%>
		
	</body>
</html>