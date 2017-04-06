<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- S FOOTER -->
<div class="footer-bg">
			  <div class="footer">
			  	   <div class="left-con"> 
			  	   		<ul>
			  	   			<li><a href="#">设为首页</a></li>
			  	   			<li><a href="#">加入收藏</a></li>
			  	   			<li><a href="#">联系我们</a></li>
			  	   			<li><a href="#">版权声明</a></li>
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
				<input type="text" placeholder="用户名" class="input-username"/>
				<input type="password" placeholder="密码" class="input-password"/>
				
				<button class="input-submit">登录</button>
			</div>
		</div>
	</div>
<!-- E footer -->