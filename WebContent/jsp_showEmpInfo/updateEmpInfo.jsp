<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="../css/update.css" />
		<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="../js/update.js"></script>
	</head>
	<body>
		<div class="main">
			
			<div class="regist1">
				<img src="../img/timg (2).jpg" />
			</div>
			<h3>修改员工信息</h3>
			<div class="regist2">
				<!---->
				<form action="/staffingsystem/UpdateStaffInfoServlet" method="post">
					<p>员工编号：<input type="number" name="ID" required="required" placeholder="请输入员工编号(例1010002,前三位不变)"/></p>
					<p>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" name="name"  required="required" placeholder="请输入姓名"/></p>
					<p>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄：<input type="number" name="age" required="required" placeholder="" min="0" max="150"/></p>
					<p>联系方式：<input type="number" name="phone" required="required" placeholder="请输入手机号码(例：15011122233)"/></p>	
					<p>qq&nbsp;号&nbsp;码：<input type="number" name="qq" required="required" placeholder="请输入qq号码"/></p>
					<p>入职部门：<input type="text" name="department" placeholder="人事部，财务部，公关部三选一" /></p><br />
					<p>出生日期：<input type="text" name="birthday"/></p><br />
					<span>
						<input id="nan" type="radio" name="sex" value="男" required="required" checked="checked"/>男
						<input id="nv" type="radio" name="sex" value="女" required="required" />女	
					</span>
					
					<p><input type="submit"  name="tel"  pattern="1[358]\d{9}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" name="tel"  pattern="1[358]\d{9}"/>
					</p>
			</div>
		</div>
	</body>
</html>


