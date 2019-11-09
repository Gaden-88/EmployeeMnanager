window.onload = function(){
	
	$(":submit").click(function(){
		if($("[name=user]")[0].validity.valueMissing){
			$("[name=user]")[0].setCustomValidity("请输入用户名");
		}else{
			$("[name=user]")[0].setCustomValidity("");
		}
		
		if($("[name=pwd]")[0].validity.patternMismatch){
			$("[name=pwd]")[0].setCustomValidity("请输入密码(密码为6位数字)");
		}else{
			$("[name=pwd]")[0].setCustomValidity("");
		}
				
	});
}