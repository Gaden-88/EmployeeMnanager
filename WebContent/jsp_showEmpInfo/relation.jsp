<%@ page language="java" contentType="text/html; charset=UTf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style type="text/css">
			*{
				padding: 0px;
				margin: 0px;
			}
			#div02{
				border: 1px red solid;
				width: 800px;
				margin-top:100px ;
				margin-left: 80px;
			}
			#table01{
				width: 100%;
				text-align: center;
			}
			#div01{
				margin-top: 50px;
				margin-left: 80px;
				height:50px;
				width: 800px;
			}
			[type="text"] {
				width: 150px;
				height: 25px;
			}
			[type="button"]
			{
				width: 50px;
				height: 25px;
			}
			#div01_01{
				line-height: 50px;
			}
			#btn1{
				margin-left: 520px;
			}
			body {
				background-image: url(../img/Light-Skin-Background.png);
				background-color: rgb(200, 200, 200);
				background-size: cover;
			}
		</style>
		<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="../js/persondp.js"></script>
	</head>
	<body>
			
		<div id="div02">
			<h1>公关部员工信息：</h1>
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
			<input type="button" value="上一页" onclick="showPrevPage()">
			<input type="button" value="下一页" onclick="showNextPage()">
			第<input type="text" name="page" id="page">页<input type="button" value="go" onclick="showGoPage()">
			<input type="button" value="首页" onclick="showFirstPage()">
			<input type="button" value="末页" onclick="showLastPage()">
		</div>
	</body>
</html>
