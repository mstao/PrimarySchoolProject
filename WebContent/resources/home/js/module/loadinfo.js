$(function(){
	
	
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
		        			
		        			xhtml+="<li><img src='"+CTP_HOME+"/img/sjiantou.png'/><a href='"+CTPPATH+"/details/education?id="+item.id+"&flag="+flag+"'>"+item.itemTitle+"</a><span class='pub-data sub-time'>["+item.addTime+"]</span></li>";
		        		   
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