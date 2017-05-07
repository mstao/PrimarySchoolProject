$(function(){
	//登录验证
	var ok_username=false;
	var ok_password=false;
	
	/**
	 * 验证用户名
	 */
	$("#userName").bind("blur",function(){
		var filter=/^[a-zA-Z\u4e00-\u9fa5]{1}[a-zA-Z0-9_\u4e00-\u9fa5]{1,8}$/;
    	var str = $(this).val();
		str = str.replace(/\s/g , '');//输入空格时自动忽略，\s表示空格
    	if( str ==""|| str==null ){
    		layer.tips('*用户名不能为空', '#userName');
    		$(this).focus();
    		ok_username=false;
		}else{
			
			if(!filter.test( $(this).val() )){
				layer.tips('*用户名为2-9字符,首字不为数字,无特殊字符 !', '#userName');
				$(this).focus();
				ok_username=false;
			}else{
				ok_username=true;
			}
		}
	});
	
	//验证密码 
	$("#password").bind("blur",function(){
		var filter=/^[a-zA-Z0-9_]{5,18}$/;
    	var str = $(this).val();
		str = str.replace(/\s/g , '');//输入空格时自动忽略，\s表示空格
		if( $(this).val() == "" || $(this).val==null ){
			layer.tips('*密码不能为空', '#password');
    		$(this).focus();
    		ok_password=false;
		}else{
			if(filter.test( $(this).val() )){
				layer.tips('密码格式正确', '#password');
				ok_password=true;
			}else{
				layer.tips('*密码5-18字符 ,不能有特殊字符!', '#password');
				$(this).focus();
				ok_password=false;
			}
		}
	});
	
	$('form').eq(0).bind('submit',function(e){
		if(!(ok_password==true && ok_username)){
			//阻止自动提交
	    	e.preventDefault();
			layer.msg("*用户信息验证失败，请仔细核对无误后进行提交！");
		}
	});
});