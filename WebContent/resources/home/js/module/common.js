$(function(){
	
	
	var nav=$(".header-nav-bg"); //得到导航对象
	var win=$(window); //得到窗口对象
	var sc=$(document);//得到document文档对象。
	win.scroll(function(){
	  if(sc.scrollTop()>=200){
	    nav.addClass("fixednav"); 	   
	   $('.header-top-bg  .header-school-logo-bg').fadeOut();
	   //底部固定登录显示
	   $('.fixed-login').fadeIn();
	  }else{
	   nav.removeClass("fixednav");
	  $('.header-top-bg .header-school-logo-bg').fadeIn();
	  //底部固定登录隐藏
	   $('.fixed-login').fadeOut();
	  }
	});  

	$('.searchinput').bind('focus',function(){
		$(this).next().css('backgroundColor','#ffffff');
	}).bind('blur',function(){
		$(this).next().css('backgroundColor','#f4f4f4');
	});
});