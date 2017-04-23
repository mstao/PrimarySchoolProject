<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/common/js/extends/layer-2.4/layer.js"></script>

<!-- S FOOTER -->
<div class="footer-bg">
			  <div class="footer">
			  	   <div class="left-con"> 
			  	   		<ul>
			  	   			<li><a onclick="SetHome(this,window.location)" href="javascript:void(0);">设为首页</a></li>
			  	   			<li><a onclick="AddFavorite(window.location,document.title)" href="javascript:void(0);">加入收藏</a></li>
			  	   			<li><a href="${pageContext.request.contextPath}/contact">联系我们</a></li>
			  	   			<li><a href="${pageContext.request.contextPath}/copyright">版权声明</a></li>
			  	   			<li><a href="${pageContext.request.contextPath}/admin/loginRegister/showTeaLogin">登录后台</a></li>
			  	   			
			  	   		</ul>
			  	   </div>
			  	   <center>
			  	   <div class="center-con">
			  	   	
							<img src="${pageContext.request.contextPath}/resources/home/img/logo.png" width="100"  height="100" class="school-logo"/>
							<span class="school-name">${WEBSITE_NAME}</span>
							<span class="copyright">Copyright&copy;${WEB_CURRENT_YEAR} www.xxxx.com .All Rights Reserved</span>
							<span class="ad">地址:${SCHOOL_ADDRESS}&nbsp;邮编:${SCHOOL_POSTCODE}</span>
			  	   </div>
			  	   </center>
			  	   <div class="reight-con"></div>
			  </div>
		</div>
		
	<!--登录底部-->
	<div class="fixed-login">
		<div class="fixed-login-content">
			<div class="fixed-login-image">
			<img src="${pageContext.request.contextPath}/resources/home/img/weixin.png" title="微信"/>	<img src="${pageContext.request.contextPath}/resources/home/img/weibo.png" title="微博"/>
			</div>
			<div class="spinner  login-loading" style="display:none;"><div class="bounce1"></div><div class="bounce2"></div><div class="bounce3"></div></div>
			<div class="fixed-login-input">
				
				<input type="text" placeholder="用户名" autocomplete="off" class="input-username" id="userName"/>
				<input type="password" placeholder="密码" autocomplete="off" class="input-password" id="password"/>
				
				<button class="input-submit">登录</button>
			</div>
		</div>
		
	</div>
<!-- E footer -->
   <script type="text/javascript">
 
   //添加收藏
   function AddFavorite(sURL, sTitle)
   {
       try
       {
           window.external.addFavorite(sURL, sTitle);
       }
       catch (e)
       {
           try
           {
               window.sidebar.addPanel(sTitle, sURL, "");
           }
           catch (e)
           {
               alert("加入收藏失败，请使用Ctrl+D进行添加");
           }
       }
   }
   
   //设为首页
   function SetHome(obj,vrl){
       try{
               obj.style.behavior='url(#default#homepage)';obj.setHomePage(vrl);
       }
       catch(e){
               if(window.netscape) {
                       try {
                               netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
                       }
                       catch (e) {
                               alert("此操作被浏览器拒绝！\n请在浏览器地址栏输入“about:config”并回车\n然后将 [signed.applets.codebase_principal_support]的值设置为'true',双击即可。");
                       }
                       var prefs = Components.classes['@mozilla.org/preferences-service;1'].getService(Components.interfaces.nsIPrefBranch);
                       prefs.setCharPref('browser.startup.homepage',vrl);
                }
       }
}
 
   
   $(function(){
	   var CTPPATH="${pageContext.request.contextPath}";
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
	    	
	    		layer.tips('*用户名不能为空', '#userName', {
							  tips: [1, '#3595CC'],
							  time: 4000
						});
	    		$(this).focus();
				
			}else{
				
				if(!filter.test( $(this).val() )){
				
					layer.tips('*用户名为2-9字符,首字不为数字,无特殊字符 !', '#userName', {
							  tips: [1, '#3595CC'],
							  time: 4000
						});
					$(this).focus();
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
	
				layer.tips('*密码不能为空', '#password', {
					  tips: [1, '#3595CC'],
					  time: 4000
				});
	    		$(this).focus();
			}else{
				if(filter.test( $(this).val() )){					
					ok_password=true;
				}else{

					layer.tips('*密码5-18字符 ,不能有特殊字符!', '#password', {
						  tips: [1, '#3595CC'],
						  time: 4000
					});
					$(this).focus();
				}
			}
		});
		
		$(".input-submit").bind("click",function(){
			var userName=$("#userName").val();
			var password=$("#password").val();
			if(ok_username==true && ok_password ==true){
				//start
				$.ajax({
					type:'post',
					dataType:'json',
					url:CTPPATH+"/admin/loginRegister/ajaxLogin",
					data:{"userName":userName,"password":password},
				
					beforeSend:function(){
						//显示正在加载
						$(".login-loading").show();
					},
					success:function(data){
						
						
						//关闭正在加载
					    $(".login-loading").hide();
						if(data=="0"){
							layer.tips("用户名或者密码错误", '.input-submit', {
								  tips: [1, '#3595CC'],
								  time: 4000
							});
						}else if(data=="1"){
							window.location.href=CTPPATH+"/admin/index";
						}
					},
					error:function(){
	
						//关闭正在加载
						$(".login-loading").hide();
						layer.tips('*登录失败!', '.input-submit', {
							  tips: [1, '#3595CC'],
							  time: 4000
						});
					}
				});
				
				//end
			}else{
				layer.tips('*用户名和密码校验失败，请核对后再提交!', '.input-submit', {
					  tips: [1, '#3595CC'],
					  time: 4000
				});
			}
			
		});
   });
</script>