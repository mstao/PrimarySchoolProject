<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成绩查询</title>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_HOME" value="${pageContext.request.contextPath}/resources/home"></c:set>
<link rel="stylesheet" href="${CTP_HOME}/css/header.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/footer.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/classmain.css" />
<script type="text/javascript" src="${CTP_HOME}/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${CTP_HOME}/js/module/common.js" ></script>
<script type="text/javascript" src="${CTP}/resources/common/js/extends/layer-2.4/layer.js"></script>

<script>

var CTPPATH="${pageContext.request.contextPath}";
</script>
</head>
<body>
<%--引入header --%>

<jsp:include page="../common/header.jsp"></jsp:include>

<%--S 主体 --%>

<div class="content-location">
<img src="${CTP_HOME}/img/home.png"/><span> 您现在的位置: <a href="${CTP}/main/index">万科城小学</a> > <a href="javascript:void(0);">成绩查询</a></span>
</div>

<div class="content">
    <div class="trends-top"><img src="${CTP_HOME}/img/成绩.png"/> <span class="tag-ch">成绩查询</span> </div>
    <!--S CONETNT-->
    <div class="class-content">
    	<!--s class-info-->
    	<div class="class-content-only">
    		<div class="score-info">
    		<span>请选择年级：</span>
    		<select class="gradeId">
	    		<c:forEach items="${grade}" var="grade">
    			<c:set var="grades" value="${year-grade.gradeCode+1}"></c:set>
    				<c:choose>
    					<c:when test="${year==grade.gradeCode}">
    						<option value="${grade.id }" selected>${grades}年级</option>
    					</c:when>
    					<c:otherwise>
    						<option value="${grade.id }">${grades}年级</option>
    					</c:otherwise>
    				</c:choose>
	    		</c:forEach>
    		</select>
    		<span>请选择班级：</span>
    		<select class="classId">
    			<c:forEach var="sclass" items="${sclass }">
    				<option value="${sclass.id }">${sclass.className}</option>
    			</c:forEach>
    		</select>
    		
    		<input type="button" class="new_button" value="查找"/>
            <input type="text" class="new_text" placeholder="请输入关键字：姓名/学号" value="" name="keywords" />  
    		</div>
    		<div class="scoredetail">
    		   <div class="no-message-div">
    		   	<img src="${CTP}/resources/apply/img/no-message.png"/>
    		   	<span>还没有进行查询哦(●—●) </span>
    		   </div>
    		   
    		</div>
    	</div>
    	<!--e class-info-->
    </div>
    
    <!--E CONTENT-->
</div>
<div class="clear"></div>
<%--E 主体 --%>

<%--引入footer --%>
<jsp:include page="../common/footer.jsp"></jsp:include>

<script type="text/javascript">
$('.gradeId').bind('change',function(){
	var id=$('.gradeId').val();
	 $.ajax({
			type:'post',
			dataType:'json',
			url:CTPPATH+'/tojson/findClass',
			data:{"gradeId":id},
			success:function(data){
				//alert(data.length);
				var xhtml="";
				$.each(data,function(id,item){
                         xhtml+="<option value='"+item.id+"'>"+item.className+"</option>";

					});
             
				$(".classId").html(xhtml);
			},
			error:function(){
				layer.msg("出错了", {icon: 2,time:2000});
			}
		}); 
});

//绑定回车键
$('.new_text').keydown(function(event){  
	    if(event.keyCode==13){  
	       $(".new_button").click();  
	    }  
	 });  

$('.new_button').bind('click',function(){
	var classId=$('.classId').val();
	var info=$('.new_text').val();
	 $.ajax({
			type:'post',
			dataType:'json',
			url:CTPPATH+'/tojson/findScore',
			data:{"classId":classId,"info":info},
			beforesend:function(){
				layer.load(2);
				},
			success:function(data){
				//alert(data.length);
				var sum;
				var xhtml="<table><tr><th>学号</th><th>姓名</th>";
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
								
								xhtml+="<tr><td>"+item3.stuId+"</td><td>"+item3.stuName+"</td>";
									}
							
							xhtml+="<td>"+item3.score+"</td>";
							 if(id3%sum== sum-1){
								xhtml+="<td>"+item3.addTime+"</td><td>"+item3.author+"</td></tr>";
								}
							}); 
					 	}else{
								 xhtml+="<tr><td colspan="+sum+4+" class='errorinfo'>没有记录!</td></tr>"; 
						 	}
						
						}
				});
				
          			xhtml+="</table>";
					$(".scoredetail").html(xhtml);
			},
			error:function(){
				layer.msg("信息不匹配,请重新输入", {icon: 2,time:2000});
			}
		}); 
});

</script>
</body>
</html>