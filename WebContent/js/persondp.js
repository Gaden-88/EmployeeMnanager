var pageLine, pageNo,pageTotal;
var isEmpty;
var str = window.location.search;
var departmentId = getDepartmentId();
function getDepartmentId()
{
	var departmentId = str.split("?");
	str = departmentId[1];
	var departmentId2 =str.split("=");
	return departmentId = departmentId2[1];
}
$(function(){
	pageLine = 10;
	pageNo = 1;
	sendRequest();
});
//请求函数
function sendRequest()
{
	$.get("/staffingsystem/GetStaffInfoByDepartmentId", {"pageLine":pageLine, "pageNo":pageNo, "departmentId":departmentId},callback);
}
function callback(text, status, xmlhttp)
{
	if(status == "success")
	{
		putDataToTable(text);
		changeButtonDisable();
	}
}
//查询请求
function sendSelectRequest()
{
	var likeName = $("[name=text01]").val();
	 
	$.get("/staffingsystem/LikeSelectEmpNameServlet", {"pageLine":pageLine, "pageNo":pageNo, "likeName":likeName},callback);
}
//写数据到table里
function putDataToTable(text)
{
	var data
	var emps;
	
	eval("data=" + text);
	emps = data.data;
	
	isEmpty = data.isEmpty;/*区别请求*/
	pageTotal = data.pageTotal;
	
	$("#table01 tr:gt(0)").remove();
	for(var i=0 ; i<emps.length ; i++)
	{
		//<a href="<%=request.getContextPath()%>/DeleStuServlet?name=<%=stu.getName() %>">删除</a>
		var $tr = $("<tr></tr>");
		
		var $td = $("<td></td>");
		var empId = emps[i].empId;
		$td.html(empId);
		$tr.append($td);
		
		var $td = $("<td></td>");
		var empName = emps[i].empName;
		$td.html(empName);
		$tr.append($td);
		
		var $td = $("<td></td>");
		var empSex = emps[i].empSex;
		$td.html(empSex);
		$tr.append($td);
		
		var $td = $("<td></td>");
		var empAge = emps[i].empAge;
		$td.html(empAge);
		$tr.append($td);
		
		var $td = $("<td></td>");
		var birthday = emps[i].birthday;
		$td.html(birthday);
		$tr.append($td);
		
		var $td = $("<td></td>");
		var telephone = emps[i].telephone;
		$td.html(telephone);
		$tr.append($td);
		
		var $td = $("<td></td>");
		var qq = emps[i].qq;
		$td.html(qq);
		$tr.append($td);
		
		var $td = $("<td></td>");
		var departmentName = emps[i].departmentName;
		$td.html(departmentName);
		$tr.append($td);
		
		var $td = $("<td></td>");
		var $a = $("<a></a>");
		$a.html("删除");
		$a.attr("href","/staffingsystem/DeleteStaffByIDServlet?empId="+empId);
		$td.append($a);
		var $a = $("<a></a>");
		$a.html("修改");
		$a.attr("href","/staffingsystem/jsp_showEmpInfo/updateEmpInfo.jsp?empId="+empId);
		$td.append($a);
		$tr.append($td);
		
		$("#table01").append($tr);
	}
}
//改变按钮状态
function changeButtonDisable(){
	if (pageTotal == 1){
		$("[value=上一页]").prop("disabled", true);
		$("[value=下一页]").prop("disabled", true);
	} else {
		if (pageNo == 1){
			$("[value=上一页]").prop("disabled", true);
			$("[value=下一页]").prop("disabled", false);
		} else if (pageNo != pageTotal){
			$("[value=上一页]").prop("disabled", false);
			$("[value=下一页]").prop("disabled", false);
		} else {
			$("[value=上一页]").prop("disabled", false);
			$("[value=下一页]").prop("disabled", true);
		}
	}
}
//下一页
function showNextPage(){
	pageNo++;
	if(isEmpty == 2)
	{
		sendSelectRequest();
	}else
	{
		sendRequest();
	}
	
}
//上一页
function showPrevPage(){
	pageNo--;
	if(isEmpty == 2)
	{
		sendSelectRequest();
	}else
	{
		sendRequest();
	}
}
//首页
function showFirstPage(){
	pageNo = 1;
	if(isEmpty == 2)
	{
		sendSelectRequest();
	}else
	{
		sendRequest();
	}
}
//末页
function showLastPage(){
	pageNo = pageTotal;
	if(isEmpty == 2)
	{
		sendSelectRequest();
	}else
	{
		sendRequest();
	}
}
//跳转指定页码
function showGoPage(){
	var val = $("[name=page]").val();
	if (val<1 || val>pageTotal){
		alert("输入的数据不合法");
	} else {
		pageNo = val;
		if(isEmpty == 2)
		{
			sendSelectRequest();
		}else
		{
			sendRequest();
		}
	}
}