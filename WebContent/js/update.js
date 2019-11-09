var str = window.location.search;
var empId = getEmpId();
$(function(){
	sendRequest();
});
//	请求函数
function sendRequest()
{
	$.get("/staffingsystem/GetStaffInfoByID", {"empId":empId},sendRequestCallback);
}
function sendRequestCallback(text, status, xmlhttp)
{
	if(status == "success")
	{
		putDataToForm(text);
	}
}
//写数据到Form里
function putDataToForm(text)
{
	var emp;
	
	eval("emp=" + text);
	
	$("[name=ID]").val(emp.empId);
	$("[name=ID]").attr("readonly","readonly");
	$("[name=name]").val(emp.empName);
	$("[name=age]").val(emp.empAge);
	$("[name=phone]").val(emp.telephone);
	$("[name=qq]").val(emp.qq);
	$("[name=department]").val(emp.departmentName);
	$("[name=birthday]").val(emp.birthday);
	
}

function getEmpId()
{
	var empId = str.split("?");
	str = empId[1];
	var empId2 = str.split("=");
	return empId = empId2[1];
}