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
	
	/**
	 * category模块 字符串截取
	 */
	
	$(".sub-ul-category >li").each(function(){
		var maxLen=20;
		//获取原来字符串的长度
		var len=$(">a",this).text().length;
		if(len>maxLen){
		  //此时需要截取
			$(">a",this).text($(">a",this).text().substring(0,maxLen)+"...");
		}
		//将日期整理一下，不要年份
		var _date=$("> span",this).text();
		var _date_c=_date.substr(6,5);
		
		_date_c="["+_date_c+"]";
		$("> span",this).text(_date_c);
	});
	
	
	//前台列表显示字数控制
	$(".list-content >ul >li").each(function(){
		//设置最大长度
		var maxLen=40;
		//获取当前字符串长度
		var _str_len=$("> a",this).text().length;
		if(_str_len>maxLen){
			$(">a",this).text($(">a",this).text().substring(0,maxLen)+"...");
		}
		
	});
	

	
	
});