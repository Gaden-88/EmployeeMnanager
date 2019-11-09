<%@ page language="java" contentType="text/html; charset=UTf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
<link rel="stylesheet" type="text/css" href="../css/home.css"/>
</head>
	<div id="div01">
		<frameset rows="10%,*,15%" border="1" >
			<frame src="top.jsp" />
			
			<frameset cols="10%,20%,*,10%" >
				<frame src="1.jsp"  />
				
				<frame src="left.jsp"   />
				<frame src="right.jsp" id="right" name="right"  />
				<frame  src="1.jsp"  />
			</frameset>
			<frame src="bottom.jsp" />
			
		</frameset>
		
	</div>
</html>