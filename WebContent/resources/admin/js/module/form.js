/**验证教师注册表单**/
$(function(){
	
	/**
	 * 验证教师注册表单
	 */
	var ok_usrename=false;
	var ok_number=false;
	var ok_email=false;
	var ok_password=false;
    var ok_re_password=false;
	
    /**
     * 对用户名校验
     */
    $("#username").bind("blur",function(){
    	
    	var filter=/^[a-zA-Z\u4e00-\u9fa5]{1}[a-zA-Z0-9_\u4e00-\u9fa5]{1,8}$/;
    	var str = $(this).val();
		str = str.replace(/\s/g , '');//输入空格时自动忽略，\s表示空格
    	if( str ==""|| str==null ){
    		layer.tips('*用户名不能为空', '#username');
    		$(this).focus();
			
		}else{
			
			if(filter.test( $(this).val() )){
				//调用ajax验证用户是否已被注册
				
				//start
				$.ajax({
					type:'post',
					dataType:'json',
					url:CTPPATH+"/admin/loginRegister/checkUser",
					data:{"userName":str},
				
					beforeSend:function(){
						//显示正在加载
						layer.load(2,{offset: 10,time:2000});
					},
					success:function(data){
	
						//关闭正在加载
						setTimeout(function(){
							  layer.closeAll('loading');
						}, 1000);
						
						//代表用户名可用
						if(data==1){
							layer.tips('恭喜！用户名可用', '#username');
							ok_usrename=true;
						}else if(data==0){
							//代表用户名不可用
							layer.tips('*抱歉，用户名已被使用', '#username');
							$(this).focus();
						}
					},
					error:function(){
	
						//关闭正在加载
						setTimeout(function(){
							  layer.closeAll('loading');
						}, 1000);
						layer.msg("出错了", {icon: 2,time:2000});
					}
				});
				
				//end
			}else{
				layer.tips('*用户名为2-9字符,首字不为数字,无特殊字符 !', '#username');
				$(this).focus();
			}
		}
    });
    
    /**
     * 对邮箱校验
     */
    $("#email").bind("blur",function(){
    	var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    	var str = $(this).val();
		str = str.replace(/\s/g , '');//输入空格时自动忽略，\s表示空格
		if( $(this).val() == "" || $(this).val==null ){
			layer.tips('用户名不能为空', '#email');
    		$(this).focus();
		}else{
			if(filter.test( $(this).val() )){
				//ajax验证邮箱是否被使用
				//start
				$.ajax({
					type:'post',
					dataType:'json',
					url:CTPPATH+"/admin/loginRegister/checkEmail",
					data:{"email":str},
				
					beforeSend:function(){
						//显示正在加载
						layer.load(2,{offset: 10,time:2000});
					},
					success:function(data){
	
						//关闭正在加载
						setTimeout(function(){
							  layer.closeAll('loading');
						}, 1000);
						
						//代表用户名可用
						if(data==1){
							layer.tips('恭喜！邮箱可用', '#email');
							ok_email=true;
						}else if(data==0){
							//代表用户名不可用
							layer.tips('*抱歉，邮箱已被使用', '#email');
							$(this).focus();
						}
					},
					error:function(){
	
						//关闭正在加载
						setTimeout(function(){
							  layer.closeAll('loading');
						}, 1000);
						layer.msg("出错了", {icon: 2,time:2000});
					}
				});
				
				//end
			}else{
				layer.tips('*邮箱格式不正确', '#email');
				$(this).focus();
			}
		}
    });
    
    /**
     * 对密码进行校验
     */
    
    $("#password").bind("blur",function(){
    	var filter=/^[a-zA-Z0-9_]{5,18}$/;
    	var str = $(this).val();
		str = str.replace(/\s/g , '');//输入空格时自动忽略，\s表示空格
		if( $(this).val() == "" || $(this).val==null ){
			layer.tips('*密码不能为空', '#password');
    		$(this).focus();
		}else{
			if(filter.test( $(this).val() )){
				layer.tips('密码格式正确', '#password');
				ok_password=true;
			}else{
				layer.tips('*密码5-18字符 ,不能有特殊字符!', '#password');
				$(this).focus();
			}
		}
    });
    
    /**
     * 对重复密码校验
     */
    $("#passwords").bind("blur",function(){
    	var filter=/^[a-zA-Z0-9_]{5,18}$/;
    	var str = $(this).val();
		str = str.replace(/\s/g , '');//输入空格时自动忽略，\s表示空格
		if( $(this).val() == "" || $(this).val==null ){
			layer.tips('*重复密码不能为空', '#passwords');
    		$(this).focus();
		}else{
			if(filter.test( $(this).val() )){
				 
				if($(this).val()!=$("#password").val()){
					layer.tips('*两次填写的密码不一致!', '#passwords');
					$(this).focus();
				}else{
					layer.tips('重复密码正确!', '#passwords');
					ok_re_password=true;
				}
			 
			}else{
				layer.tips('*重复密码5-18字符 ,不能有特殊字符!', '#passwords');
				$(this).focus();
			}
		}
    	
    });
    
    /**
     * 验证工号
     */
    
    $("#number").bind("blur",function(){
    	var filter=/^[a-zA-Z0-9_]{5,18}$/;
    	var str = $(this).val();
		str = str.replace(/\s/g , '');//输入空格时自动忽略，\s表示空格
		if( $(this).val() == "" || $(this).val==null ){
			layer.tips('*重复密码不能为空', '#number');
    		$(this).focus();
		}else{
			layer.tips('*工号正确', '#number');
    		ok_number=true;
		}
    });
    
    /**
     * 调用ajax注册
     */
    $('form').eq(0).bind('submit',function(e){
    	
    	//阻止自动提交
    	e.preventDefault();
    	
    	if(ok_usrename==true && ok_number==true  &&  ok_email==true && ok_password==true  && ok_re_password==true){
        	var userName=$("#username").val();
        	var number=$("#number").val();
        	var email=$("#email").val();
        	var password=$("#password").val();
            //注册
    		$.ajax({
				type:'post',
				dataType:'json',
				url:CTPPATH+"/admin/loginRegister/save",
				data:{"userName":userName,"number":number,"email":email,"password":password},
			
				beforeSend:function(){
					//显示正在加载
					layer.msg('正在注册',{offset: 0,time:2000});
				},
				success:function(data){

					//关闭正在加载
					setTimeout(function(){
						  layer.closeAll('loading');
					}, 1000);
					
					//代表用户名可用
					if(data==1){
						layer.msg('恭喜！用户注册成功',{time:4000});
						
					}else if(data==0){
						//代表用户名不可用
						layer.msg('*抱歉，用户注册失败，请仔细核对信息！',{time:4000});
						
					}
				},
				error:function(){

					//关闭正在加载
					setTimeout(function(){
						  layer.closeAll('loading');
					}, 1000);
					layer.msg("出错了", {icon: 2,time:2000});
				}
			});
			
        }else{
        	layer.msg("*用户信息验证失败，请仔细核对无误后进行提交！");
        }
    	
    });
    
    
});