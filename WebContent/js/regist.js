window.onload = function(){
	
	$("form").submit(function(){
		var user = $("[name=user]").val();
				
		if(user.length>6||user.length<2){
			alert("账号长度不正确");
			return false;
		}
		for(var i=0;i<user.length;i++){
			var c = user.charAt(i);
			if(c>="0" && c<="9" || c>="a" && c<=z || c>="A"  && c<="Z"){
				alert("账号格式不正确");
				return false;
			}
		}
		return true;
	});

	$(":submit").click(function(){
		if($("[name=user]")[0].validity.valueMissing){
			$("[name=user]")[0].setCustomValidity("请输入用户名");
		}else{
			$("[name=user]")[0].setCustomValidity("");
		}
		
		
		if($("[name=email]")[0].validity.typeMismatch){
			$("[name=email]")[0].setCustomValidity("邮箱格式不正确");
		}else{
			$("[name=email]")[0].setCustomValidity("");
		}
		
		if($("[name=tel]")[0].validity.patternMismatch){
			$("[name=tel]")[0].setCustomValidity("请输入正确的电话号码");
		}else{
			$("[name=tel]")[0].setCustomValidity("");
		}
				
	});
}