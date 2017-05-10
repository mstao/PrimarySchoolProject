$(function(){
	
	var sub=function(str,Len){
		var maxLen=Len;
		var len=str.length;
		if(len>maxLen){
		    //此时需要截取
			return str.substring(0,maxLen)+"...";
		}else{
			return str;
		}
	}
	
	/**阳光德育加载**/
	$('.tab-card-education >li').bind('click',function(){
	 //	alert($(this).index());
	   var  mythis=$(this);
	   
	   //获取点击的序号
	   var index=mythis.index();
	   
	   //flag标识
	   var flag;
	   
	   if(index==1){          //国旗下的讲话
		   flag="speak"; 
	   }else if(index==2){    //少先队活动
 		   flag="active";
	   }else if(index==3){    //家长委员会
		   flag="parents";
	   }else if(index==4){    //心灵驿站
		   flag="stagent";
	   }
	   
	  //获取显示div
	   
	  var checkdiv=mythis.parent().next(".tab-paper").children("dd").eq(index).children("div");
	  //第一个选项不要加载信息
	  if(index!=0){
		  //调用ajax加载信息
		  $.ajax({
				type:'post',
				dataType:'json',
				url:CTPPATH+'/tojson/education',
				data:{"flag":flag},
				
				beforeSend:function(){
					//显示正在加载
					checkdiv.html('<div class="spinner"><div class="bounce1"></div><div class="bounce2"></div><div class="bounce3"></div></div>');
				},
				success:function(data){
	
					//关闭正在加载
					
				//	checkdiv.html("zzzzz"+data);
		       
		        var xhtml="";
		        if(data.length>0){
		        	
		        	xhtml+="<ul>";
		        
					
		        		$.each(data,function(idx,item){ 
		        			
		        			xhtml+="<li><img src='"+CTP_HOME+"/img/sjiantou.png'/><a href='"+CTPPATH+"/details/education?id="+item.id+"&flag="+flag+"'>"+sub(item.itemTitle,35)+"</a><span class='pub-data sub-time'>["+item.addTime+"]</span></li>";
		        		    
		        		}); 
		        	
		        	
		        	xhtml+="</ul>";
		        }else{
		        	xhtml+="<div class='no-message'><img src='"+CTP_HOME+"/img/nomessage.png' /></div>";
		        }
		        
				
				checkdiv.html(xhtml);
					
				},
				error:function(){
	
					//关闭正在加载
					checkdiv.html('');
					layer.msg("加载出错了", {icon: 2,time:2000});
				}
			});
	  }
	});
	
	
	
	/***学生天地加载***/
	$(".tab-card-student > li").bind("click",function(){
		 var  mythis=$(this);
		   
		   //获取点击的序号
		   var index=mythis.index();
		   
		   //flag标识
		   var flag;
		   
		   if(index==1){          //活动风采
			   flag="activity"; 
		   }else if(index==2){    //班级主页
	 		   flag="class";
		   }else if(index==3){    //综合实验课
			   flag="lab";
		   }
		   
		 //获取显示div
		   
			  var checkdiv=mythis.parent().next(".tab-paper").children("dd").eq(index).children("div");
			  //第一个选项不要加载信息
			  if(index!=0  && index==1){
				  //调用ajax加载信息
				  $.ajax({
						type:'post',
						dataType:'json',
						url:CTPPATH+'/tojson/student',
						data:{"flag":flag},
						
						beforeSend:function(){
							//显示正在加载
							checkdiv.html('<div class="spinner"><div class="bounce1"></div><div class="bounce2"></div><div class="bounce3"></div></div>');
						},
						success:function(data){
			
							//关闭正在加载
							
						//	checkdiv.html("zzzzz"+data);
				       
				        var xhtml="";
				        if(data.length>0){
				        	
				        	xhtml+="<ul>";
				        
							
				        		$.each(data,function(idx,item){ 
				        			
				        			xhtml+="<li><img src='"+CTP_HOME+"/img/sjiantou.png'/><a href='"+CTPPATH+"/details/student?id="+item.id+"&flag="+flag+"'>"+sub(item.itemTitle,35)+"</a><span class='pub-data sub-time'>["+item.addTime+"]</span></li>";
				        		   
				        		}); 
				        	
				        	
				        	xhtml+="</ul>";
				        }else{
				        	xhtml+="<div class='no-message'><img src='"+CTP_HOME+"/img/nomessage.png' /></div>";
				        }
				        
						
						checkdiv.html(xhtml);
							
						},
						error:function(){
			
							//关闭正在加载
							checkdiv.html('');
							layer.msg("加载出错了", {icon: 2,time:2000});
						}
					});
			  }else if(index==3){
				  //此时加载 综合实验课信息
				//调用ajax加载信息
				  $.ajax({
						type:'post',
						dataType:'json',
						url:CTPPATH+'/tojson/labclass',				
						beforeSend:function(){
							//显示正在加载
							checkdiv.html('<div class="spinner"><div class="bounce1"></div><div class="bounce2"></div><div class="bounce3"></div></div>');
						},
						success:function(data){
			
							//关闭正在加载
							
						//	checkdiv.html("zzzzz"+data);
				       
				        var xhtml="";
				        if(data.length>0){
				        	
				        	xhtml+="<div class='lab-class-list'>";
				        
							
				        		$.each(data,function(idx,item){ 
				        			
				        		//	xhtml+="<li><img src='"+CTP_HOME+"/img/sjiantou.png'/><a href='"+CTPPATH+"/details/student?id="+item.id+"&flag="+flag+"'>"+item.itemTitle+"</a><span class='pub-data sub-time'>["+item.addTime+"]</span></li>";
				        			xhtml+="<span><img src='"+CTP_HOME+"/img/shetuan.png'/> <a href='"+CTPPATH+"/category/labclass?id="+item.id+"'>"+item.labName+"</a></span>";
				        		}); 
				        	
				        	
				        	xhtml+="</div>";
				        }else{
				        	xhtml+="<div class='no-message'><img src='"+CTP_HOME+"/img/nomessage.png' /></div>";
				        }
				        
						
						checkdiv.html(xhtml);
							
						},
						error:function(){
			
							//关闭正在加载
							checkdiv.html('');
							layer.msg("加载出错了", {icon: 2,time:2000});
						}
					});
			  }else if(index==2){
				  //此时加载班级主页信息
					//调用ajax加载信息
					  $.ajax({
							type:'post',
							dataType:'json',
							url:CTPPATH+'/tojson/classHomePage',				
							beforeSend:function(){
								//显示正在加载
								checkdiv.html('<div class="spinner"><div class="bounce1"></div><div class="bounce2"></div><div class="bounce3"></div></div>');
							},
							success:function(data){
				
								//关闭正在加载
								
							//	checkdiv.html("zzzzz"+data);
					       
					        var xhtml="";
					        if(data.length>0){
					        	
					        	xhtml+="<ul>";
						        
								
				        		$.each(data,function(idx,item){ 
				        			xhtml+="<li><img src='"+CTP_HOME+"/img/sjiantou.png'/><a href='"+CTPPATH+"/details/newsinfo?id="+item.id+"&gradeFlag="+item.gradeName+"&classFlag="+item.className+"&classId="+item.classId+"'>"+sub(item.itemTitle,35)+"</a><span class='pub-data sub-time'>["+item.addTime+"]</span></li>";
				        		}); 
				        	
				        	
				        	xhtml+="</ul>";
					        }else{
					        	xhtml+="<div class='no-message'><img src='"+CTP_HOME+"/img/nomessage.png' /></div>";
					        }
					        
							
							checkdiv.html(xhtml);
								
							},
							error:function(){
				
								//关闭正在加载
								checkdiv.html('');
								layer.msg("加载出错了", {icon: 2,time:2000});
							}
						});
				  }
			   
		   
	});
	
	
	//加载教师园地信息
	$(".tab-card-teacher > li").bind("click",function(){
		   var  mythis=$(this);
		   
		   //获取点击的序号
		   var index=mythis.index();
		   
		   //flag标识
		   var flag;
		   
		   if(index==1){          //教师风采
			   flag="teachers"; 
		   }else if(index==2){    //教师培训
	 		   flag="train";
		   }else if(index==3){    //获奖登记
			   flag="prize";
		   }
		   
		 //获取显示div
		   
			  var checkdiv=mythis.parent().next(".tab-paper").children("dd").eq(index).children("div");
			  //第一个选项不要加载信息
			  if(index!=0){
				  //调用ajax加载信息
				  $.ajax({
						type:'post',
						dataType:'json',
						url:CTPPATH+'/tojson/teacher',
						data:{"flag":flag},
						
						beforeSend:function(){
							//显示正在加载
							checkdiv.html('<div class="spinner"><div class="bounce1"></div><div class="bounce2"></div><div class="bounce3"></div></div>');
						},
						success:function(data){
			
							//关闭正在加载
							
						//	checkdiv.html("zzzzz"+data);
				       
				        var xhtml="";
				        if(data.length>0){
				        	
				        	xhtml+="<ul>";
				        
							
				        		$.each(data,function(idx,item){ 
				        			
				        			xhtml+="<li><img src='"+CTP_HOME+"/img/sjiantou.png'/><a href='"+CTPPATH+"/details/teacher?id="+item.id+"&flag="+flag+"'>"+sub(item.itemTitle,35)+"</a><span class='pub-data sub-time'>["+item.addTime+"]</span></li>";
				        		   
				        		}); 
				        	
				        	
				        	xhtml+="</ul>";
				        }else{
				        	xhtml+="<div class='no-message'><img src='"+CTP_HOME+"/img/nomessage.png' /></div>";
				        }
				        
						
						checkdiv.html(xhtml);
							
						},
						error:function(){
			
							//关闭正在加载
							checkdiv.html('');
							layer.msg("加载出错了", {icon: 2,time:2000});
						}
					});
			  }
	});
	
	
	//加载党务工会信息
	$(".tab-card-party > li").bind("click",function(){
		   var  mythis=$(this);
		   
		   //获取点击的序号
		   var index=mythis.index();
		   
		   //flag标识
		   var flag;
		   
		   if(index==1){          //教师风采
			   flag="trade_union"; 
		   }
		   
		 //获取显示div
		   
			  var checkdiv=mythis.parent().next(".tab-paper").children("dd").eq(index).children("div");
			  //第一个选项不要加载信息
			  if(index!=0){
				  //调用ajax加载信息
				  $.ajax({
						type:'post',
						dataType:'json',
						url:CTPPATH+'/tojson/party',
						data:{"flag":flag},
						
						beforeSend:function(){
							//显示正在加载
							checkdiv.html('<div class="spinner"><div class="bounce1"></div><div class="bounce2"></div><div class="bounce3"></div></div>');
						},
						success:function(data){
			
							//关闭正在加载
							
						//	checkdiv.html("zzzzz"+data);
				       
				        var xhtml="";
				        if(data.length>0){
				        	
				        	xhtml+="<ul>";
				        
							
				        		$.each(data,function(idx,item){ 
				        			
				        			xhtml+="<li><img src='"+CTP_HOME+"/img/sjiantou.png'/><a href='"+CTPPATH+"/details/party?id="+item.id+"&flag="+flag+"'>"+sub(item.itemTitle,27)+"</a><span class='pub-data sub-time'>["+item.addTime+"]</span></li>";
				        		   
				        		}); 
				        	
				        	
				        	xhtml+="</ul>";
				        }else{
				        	xhtml+="<div class='no-message'><img src='"+CTP_HOME+"/img/nomessage.png' /></div>";
				        }
				        
						
						checkdiv.html(xhtml);
							
						},
						error:function(){
			
							//关闭正在加载
							checkdiv.html('');
							layer.msg("加载出错了", {icon: 2,time:2000});
						}
					});
			  }
	});
	
	//加载学校管理信息
	
	$(".tab-card-manage > li").bind("click",function(){
		var  mythis=$(this);
		   
		   //获取点击的序号
		   var index=mythis.index();
		   
		   //flag标识
		   var flag;
		   
		   if(index==1){          //评职评优
			   flag="recommendation"; 
		   }else if(index==2){    //教师会议
			   flag="notice";  
		   }else if(index==3){
			   flag="rules";
		   }else if(index==4){
			   flag="email";
		   }
		   
		 //获取显示div
		   
			  var checkdiv=mythis.parent().next(".tab-paper").children("dd").eq(index).children("div");
			  //第一个选项不要加载信息
			  if(index!=0){
				  //调用ajax加载信息
				  $.ajax({
						type:'post',
						dataType:'json',
						url:CTPPATH+'/tojson/manage',
						data:{"flag":flag},
						
						beforeSend:function(){
							//显示正在加载
							checkdiv.html('<div class="spinner"><div class="bounce1"></div><div class="bounce2"></div><div class="bounce3"></div></div>');
						},
						success:function(data){
			
							//关闭正在加载
							
						//	checkdiv.html("zzzzz"+data);
				       
				        var xhtml="";
				        if(data.length>0){
				        	
				        	xhtml+="<ul>";
				        
							
				        		$.each(data,function(idx,item){ 
				        			
				        			xhtml+="<li><img src='"+CTP_HOME+"/img/sjiantou.png'/><a href='"+CTPPATH+"/details/manage?id="+item.id+"&flag="+flag+"'>"+sub(item.itemTitle,27)+"</a><span class='pub-data sub-time'>["+item.addTime+"]</span></li>";
				        		   
				        		}); 
				        	
				        	
				        	xhtml+="</ul>";
				        }else{
				        	xhtml+="<div class='no-message'><img src='"+CTP_HOME+"/img/nomessage.png' /></div>";
				        }
				        
						
						checkdiv.html(xhtml);
							
						},
						error:function(){
			
							//关闭正在加载
							checkdiv.html('');
							layer.msg("加载出错了", {icon: 2,time:2000});
						}
					});
			  }
	});
	
});