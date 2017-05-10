<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		
		<title></title>
		<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
		<c:set var="CTP_ADMIN" value="${pageContext.request.contextPath}/resources/admin"></c:set>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${CTP_ADMIN }/css/admin_header.css" rel="stylesheet" type="text/css" />
		<link href="${CTP_ADMIN }/css/list.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="${CTP}/resources/common/css/page.css"/>
		<script type="text/javascript" src="${CTP_ADMIN }/js/extends/wangEditor/dist/js/lib/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" src="${CTP_ADMIN }/js/module/common.js"></script>
		<script type="text/javascript" src="${CTP}/resources/common/js/extends/layer-2.4/layer.js"></script>
		
<script type="text/javascript">
	$(function(){
		var CTPPATH="${pageContext.request.contextPath}";
	   //批量删除信息
       $('.deleteInfo-btn').bind('click',function(){
    	   var sum="${sum}";
    	  
       	var t=document.getElementsByName("info_id");
       	var id=document.getElementsByClassName("ss");
    		var ids = "";
            for (var i = 0; i < t.length; i++) {
                if (t[i].checked) {
                	for(var j=sum*i;j<sum*(i+1);j++){
                		ids +=id[j].innerHTML+',';
                    	}
                }
            }
            ids = ids.substring(0, ids.length - 1);
            if(ids==""){
           	 layer.msg("请选择您要删除的选项");
            }else{
              layer.confirm('确定删除所选择的记录？', {
      			  btn: ['确定','取消'] 
      			}, function(){
      				//已选定，可以进行批量删除操作
      				//调用Ajax向后台发送请求 ，删除所选项
      				
      				$.ajax({
						type:'post',
						dataType:'json',
						url:CTPPATH+"/admin/delete/${durl }",
						data:{"ids":ids},
					
						beforeSend:function(){
							//显示正在加载
							layer.load(2);
						},
						success:function(data){
		
							//关闭正在加载
							setTimeout(function(){
								  layer.closeAll('loading');
							}, 1000);
							
							if(data==1){
								layer.msg('删除成功', {icon: 1,time:2000});
								window.location.href="${pageContext.request.contextPath}/admin/list/${durl }?classId=${classId}&fullName=${fullName}&p=1";
							
							}else{
								layer.msg("删除出错了", {icon: 2,time:2000});
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
      			}, function(){
      			    //取消操作 ，这里可以为空
      			});
           	
            }
       });


       $('.new_button').bind('click',function(){
    		var info=$('.new_text').val();
    		 token=token.replace(/\s/g , '');//输入空格时自动忽略，\s表示空格
 	        if(token==null || token==""){
 	        	 layer.msg("请输入要搜索的内容！");
 	        }else {
    		 $.ajax({
    				type:'post',
    				dataType:'json',
    				url:CTPPATH+'/tojson/findScore',
    				data:{"classId":"${classId}","info":info},
    				beforesend:function(){
    					layer.load(2);
    					},
    				success:function(data){
    					//alert(data.length);
    					var sum;
    					var xhtml="<table><tr><th width='5%' align='center'></th><th>学号</th><th>姓名</th>";
    					$.each(data,function(id,item){
    						sum=data.sum;
    								
    	                    if(id=="courseType"){
    	                	   $.each(item,function(id2,item2){
    								xhtml+="<th>"+item2.courseName+"</th>";
    	     					});     
    	                	   xhtml+="<th>考试时间</th><th>负责人</th></tr>";
    	                       } 
    						if(id=="sclass"){
    						 	if(item.length!=0){
    							$.each(item,function(id3,item3){
    								if(id3%sum==0){
    									xhtml+="<tr><td align='center'><input type='checkbox' name='info_id' /></td><td><a href='${CTP}/admin/distribute/scoreInfo?classId=${classId}&stuId="+item3.stuId+"&addTime="+item3.addTime+"&fullName=${fullName}'>"+item3.stuId+"</a></td><td>"+item3.stuName+"</td>";
    										}
    								
    								xhtml+="<td><span class='ss' style='display: none'>"+item3.id+"</span>"+item3.score+"</td>";
    								 if(id3%sum== sum-1){
    									xhtml+="<td>"+item3.addTime+"</td><td>"+item3.author+"</td></tr>";
    									}
    								}); 
    						 	}else{
    									 xhtml+="<tr><td colspan="+sum+5+" class='errorinfo'>没有记录!</td></tr>"; 
    							 	}
    							
    							}
    					});
    					
    	          			xhtml+="</table>";
    						$(".new_div3").html(xhtml);
    				},
    				error:function(){
    					layer.msg("信息不匹配,请重新输入", {icon: 2,time:2000});
    				}
    			}); 
 	        }
    	}); 
       //绑定回车键
  	 $('.new_text').keydown(function(event){  
    	    if(event.keyCode==13){  
    	       $(".new_button").click();  
    	    }  
    	 });  
	 });
	  
	</script>
	</head>
	<body>
		<!-- S header -->
	<jsp:include page="../common/header.jsp" />
	<!--S main-->
			<div id="location">您现在的位置: 后台管理 ><span>${SCHOOL_STUDENT_SCORE}></span><span>${fullName }</span></div>
            <div class="new_div1">
            <span class="new_div1_span">${fullName }学生成绩</span>
            <a href="${CTP }/admin/write/${durl }?classId=${classId}&fullName=${fullName}" class="add_list">新增</a></div>
            <div class="new_div2">
            	
                <input type="checkbox" class="new_div2_input"/>
                <ul>
                    <li>
		                 <a href="javascript:void(0);">已选定</a>
		                 <ul>
		                     <li><a href="javascript:void(0);" class="deleteInfo-btn">删除</a></li>
		                 </ul>
		             </li>
                </ul>
                <input type="button" class="new_button" value="筛选"/>
                <input type="text" class="new_text" placeholder="请输入详细信息,如：姓名/学号" value="" name="keywords" />  
                
                
                <div class="clear"></div>
            </div>
        <div class="new_div3">            
            <table>
                <tr>
                    <th></th>
                    <th>学号</th>
                    <th>姓名</th>
                    <c:forEach var="type" items="${courseType}">
                    <th>${type.courseName }</th>
                    </c:forEach>
                    <th>考试时间</th>
                    <th>负责人</th>
                </tr>
            <c:forEach var="list" items="${item }" varStatus="count" step="${sum }">
                <tr>
                  <td width="5%" align="center"><input type="checkbox" name="info_id" />
                  <c:forEach begin="${count.index }" end="${count.index + sum-1}" var="newId" items="${item }">
                  <span class="ss" style="display: none">${newId.id }</span>
                  </c:forEach>
                  </td>
                   
                  <td><a href="${CTP }/admin/distribute/scoreInfo?classId=${classId}&stuId=${list.stuId}&addTime=${list.addTime}&fullName=${fullName}">${list.stuId }</a></td>
                    <td>${list.stuName }</td>
                    <c:forEach begin="${count.index }" end="${count.index + sum-1}" var="score" items="${item }">
                    <td>${score.score }</td>
                    </c:forEach>
                    <%--  <td>${list.score }</td> --%>
                    <td>${list.addTime }</td>
                    <td>${list.author }</td> 
                </tr>
                </c:forEach> 
            </table>
             <!-- 分页导航引入 -->
			    ${toolBar}
        </div>
        <div> 
</div>
<!--E main-->

<!--S footer-->
<jsp:include page="../common/footer.jsp" />
<!--E footer-->
	</body>
</html>
