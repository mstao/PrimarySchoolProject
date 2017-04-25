/**
 * 主页》部门链接。在部门链接中各个部门信息的加载。
 */

//用于加载人员设置
$(function(){
	
	
	$('.departmentlink-dnl-ul > li').bind('click',function(){
	 //	alert($(this).index());
	   var  mythis=$(this);
	   //获取点击的序号
	   var index=mythis.index();
	   var more="更多>>";
	   
	
	   var flag="staff";
	   var indexflag=index+1;//indexflag用于当前消息数目为空时，json内容为空时，实现“更多>>”链接获取当前的departmentId
	   
	   
	  /* if(index==0){				//教导处
		   departmentNameType="teach"
	   }else if(index==1){          //安保处
		   departmentNameType="security"; 
	   }else if(index==2){    //德育处
		   departmentNameType="education";
	   }else if(index==3){    //办公室
		   departmentNameType="office";
	   }*/
	   
	   var item_id=$(this).attr("data-id");
	   
	  //获取显示div
	   
	  var checkdiv=mythis.parent().parent().next(".departmentlink-mainbody-right").children("div:eq(0)").children("div:eq(1)");
	//修改“更多”的链接信息
	  var morediv=mythis.parent().parent().next(".departmentlink-mainbody-right").children("div:eq(0)").children("div:eq(0)").find("span");
	  //调用ajax加载信息
		  $.ajax({
				type:'post',
				dataType:'json',
				url:CTPPATH+'/tojson/departmentLink',
				data:{"departmentId":item_id,"flag":flag},
				
				beforeSend:function(){
					//显示正在加载
					checkdiv.html('<div class="spinner"><div class="bounce1"></div><div class="bounce2"></div><div class="bounce3"></div></div>');
				},
				success:function(data){
	
					//关闭正在加载
					
				//	checkdiv.html("zzzzz"+data);
		       
		        var xhtml="";
		        var xhtmllink="";
		        if(data.length>0){
		        	
		        	xhtml+="<ul>";
		        
					
		        		$.each(data,function(idx,item){ 
		        			
		        			xhtml+="<li><img src='"+CTP_HOME+"/img/sjiantou.png'/><a href='"+CTPPATH+"/details/departmentLink?departmentId="+item.departmentId+"&contentFlag="+item.typeId+"&contentId="+item.id+"'>"+item.itemTitle+"</a><span class='pub-data sub-time'>["+item.addTime+"]</span></li>";
		        			xhtmllink="<a href='"+CTPPATH+"/list/departmentLinkContent?departmentId="+item.departmentId+"&contentFlag="+flag+"&p=1'>"+more+"</a>";
		        		}); 
		        	
		        	
		        	xhtml+="</ul>";
		        	
		  
		        }else{
		        	xhtml+="<div class='no-message'><img src='"+CTP_HOME+"/img/nomessage.png' /></div>";
		        	xhtmllink="<a href='"+CTPPATH+"/list/departmentLinkContent?departmentId="+item_id+"&contentFlag="+flag+"&p=1'>"+more+"</a>";
		        }
		        
				
				checkdiv.html(xhtml);
				morediv.html(xhtmllink);
					
				},
				error:function(){
	
					//关闭正在加载
					checkdiv.html('');
//					layer.msg("加载出错了", {icon: 2,time:2000});
					alert("加载出错");
				}
			});
	});




});


//用于加载工作安排
$(function(){
	
	
	$('.departmentlink-dnl-ul > li').bind('click',function(){
	 //	alert($(this).index());
	   var  mythis=$(this);
	   //获取点击的序号
	   var index=mythis.index();
	   var more="更多>>";
	   
	 
	   var flag="job";
	
	   var item_id=$(this).attr("data-id");
	  //获取显示div
	   
	  var checkdiv=mythis.parent().parent().next(".departmentlink-mainbody-right").children("div:eq(1)").children("div:eq(1)");
		  
	//修改“更多”的链接信息
	  var morediv=mythis.parent().parent().next(".departmentlink-mainbody-right").children("div:eq(1)").children("div:eq(0)").find("span");
	  //调用ajax加载信息
		  $.ajax({
				type:'post',
				dataType:'json',
				url:CTPPATH+'/tojson/departmentLink',
				data:{"departmentId":item_id,"flag":flag},
				
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
		        			
		        			xhtml+="<li><img src='"+CTP_HOME+"/img/sjiantou.png'/><a href='"+CTPPATH+"/details/departmentLink?departmentId="+item.departmentId+"&contentFlag="+item.typeId+"&contentId="+item.id+"'>"+item.itemTitle+"</a><span class='pub-data sub-time'>["+item.addTime+"]</span></li>";
		        			xhtmllink="<a href='"+CTPPATH+"/list/departmentLinkContent?departmentId="+item.departmentId+"&contentFlag="+flag+"&p=1'>"+more+"</a>";
		        		}); 
		        	
		        	
		        	xhtml+="</ul>";
		        }else{
		        	xhtml+="<div class='no-message'><img src='"+CTP_HOME+"/img/nomessage.png' /></div>";
		        	xhtmllink="<a href='"+CTPPATH+"/list/departmentLinkContent?departmentId="+item_id+"&contentFlag="+flag+"&p=1'>"+more+"</a>";
		        }
		        
				
				checkdiv.html(xhtml);
				morediv.html(xhtmllink);
					
				},
				error:function(){
	
					//关闭正在加载
					checkdiv.html('');
					layer.msg("加载出错了", {icon: 2,time:2000});
				}
			});
	});
});

/*部门名称列表样式*/
$(function(){
	$(".departmentlink-dnl-ul").children("li:eq(0)").addClass("js-load-a");
	$('.departmentlink-dnl-ul > li').bind('click',function(){
	 //	alert($(this).index());
	   var  mythis=$(this);
	   //获取点击的序号
	   var index=mythis.index();
		
			//添加css
			$(this).addClass("js-load-a");
			
			
			//将该选项的对应的div显示
			$(".departmentlink-dnl-ul").children().eq(index).show();
			
			//其他选项移除css
			for(var i=1;i<=4;i++){
				if(i!=index){
				$(this).parent().children("li").eq(i).removeClass("js-load-a");
				}
				
			} 
			if(index!=0){
				$(this).parent().children("li").eq(0).removeClass("js-load-a");
			}
			
		});
	   
});