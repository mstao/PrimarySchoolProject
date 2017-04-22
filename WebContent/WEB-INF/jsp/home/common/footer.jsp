<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<div class="fixed-login-input">
				<input type="text" placeholder="用户名" autocomplete="off" class="input-username"/>
				<input type="password" placeholder="密码" autocomplete="off" class="input-password"/>
				
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
 
</script>