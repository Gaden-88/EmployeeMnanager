<%@ page language="java" contentType="text/html; charset=UTf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>left</title>
		<script type="text/javascript" src="../js/jquery-1.8.3.min.js" ></script>
		<script type="text/javascript" src="../js/left.js" ></script>
	
		<style>
			* {
				padding: 0px;
				margin: 0px;
			}
		
			body {
				background-image: url(../img/Light-Skin-Background.png);
				background-color: rgb(200, 200, 200);
			}
			a{
				text-decoration: none;
				font-family: "微软雅黑";
				color: #000000;
				font-size: 25px;
			}
			a:hover{
				
			}
			#div01,#div02,#div03{
				height: 50px;
				line-height: 50px;
			}
			ul>ol{
				display: none;
			}
		</style>
		
	</head>
	<body>
		<div id="div01">
			<a href="right.jsp" target="right">员工信息</a>
			
		</div>
		<div id="div02">
			<a href="/staffingsystem/ManagerInfoServlet" target="right">管理员信息</a>
		</div>
	
		<div id="div03">
			<ul >
				<li><a href="#">部门信息</a></li>
				<ol>
					<li>
						<a href="persondp.jsp?departmentId=1" target="right">人事部员工信息</a>
					</li>
					<li>
						<a href="finanicial.jsp?departmentId=2" target="right">财务部员工信息</a>
					</li>
					<li>
						<a href="relation.jsp?departmentId=3" target="right">公关部员工信息</a>
					</li>
				</ol>
			</ul>
			
		</div>
			
			
			
	
	</body>
</html>