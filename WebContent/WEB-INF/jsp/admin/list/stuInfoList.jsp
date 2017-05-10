<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="/WEB-INF/mytag.tld" prefix="myTag" %> 
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

	$(function(){
		var CTPPATH="${pageContext.request.contextPath}";
	   
	   //批量删除信息
       $('.deleteInfo-btn').bind('click',function(){
       	var t=document.getElementsByName("info_id");
    		var ids = "";
            for (var i = 0; i < t.length; i++) {
                if (t[i].checked) {
                	ids +=t[i].value+',';
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

       
     //查询功能
  	 $('.new_button').bind('click',function(){
  	     var token=$('.new_text').val();
  	     
  	   token=token.replace(/\s/g , '');//输入空格时自动忽略，\s表示空格
       if(token==null || token==""){
       	 layer.msg("请输入要搜索的内容！");
       }else {
  	     
  		$.ajax({
  			type:'post',
  			dataType:'json',
  			
  			url:CTPPATH+"/admin/ajax/${durl }",
  			data:{"flag":"${classId}","token":token},
  		
  			beforeSend:function(){
  				//显示正在加载
  				layer.load(2);
  			},
  			success:function(data){
  				var xhtml="";
  				//关闭正在加载
  				 setTimeout(function(){
  					  layer.closeAll('loading');
  				}, 1000);
  				xhtml="<table><tr> <th width='5%' align='center'></th><th width='8%'>学号</th><th width='5%'>姓名</th><th width='5%'>民族</th><th width='5%'>性别</th><th width='3%'>年龄</th><th width='7%'>出生日期</th><th width='16%'>身份证号</th><th width='16%'>家庭住址</th><th width='6%'>监护人</th><th width='10%'>联系电话</th><th width='7%'>录入人员</th></tr>";
  				if(data.length!=0){
  				$.each(data,function(id,item){
						xhtml+=" <tr><td align='center'><input type='checkbox' name='info_id' value="+item.id+"/></td><td><a href='${CTP}/admin/distribute/${durl }?classId=${classId }&fullName=${fullName }&id="+item.id+"' class='item_title'>"+item.stuId+"</a></td>";
	                    xhtml+=" <td>"+item.stuName+"</td><td>"+item.stuNation+"</td><td>"+item.stuSex+"</td><td>"+item.stuAge+"</td><td>"+item.stuBirthday+"</td><td>"+item.stuCardId+"</td><td>"+sub(item.stuAddress,10)+"</td><td>"+item.stuParent+"</td><td>"+item.stuPhone+"</td> <td>"+item.stuAuthor+"</td></tr>";
  				});
  				}else{
  					xhtml+="<tr><td colspan='12' class='errorinfo'>没有记录!</td></tr>";
  				 }
  				 
  					xhtml+="</table>";
  				$('.new_div3').html(xhtml);
  			},
  			error:function(){
  	
  				//关闭正在加载
  				setTimeout(function(){
  					  layer.closeAll('loading');
  				}, 1000);
  				layer.msg("出错了", {icon: 2,time:2000});
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
			<div id="location">您现在的位置: 后台管理 ><span>${SCHOOL_STUDENT_INFOMATION}></span><span>${fullName }</span></div>
            <div class="new_div1">
            <span class="new_div1_span">${fullName }学生列表</span>
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
                <input type="text" class="new_text" placeholder="请输入关键字" value="" name="keywords" />  
                
                
                <div class="clear"></div>
            </div>
        <div class="new_div3">            
            <table>
                <tr>
                    <th width="5%" align="center"></th>
                    <th width="8%">学号</th>
                    <th width="5%">姓名</th>
                    <th width="5%">民族</th>
                    <th width="5%">性别</th>
                    <th width="3%">年龄</th>
                    <th width="7%">出生日期</th>
                    <th width="16%">身份证号</th>
                    <th width="16%">家庭住址</th>
                    <th width="6%">监护人</th>
                    <th width="10%">联系电话</th>
                    <th width="7%">录入人员</th>
                </tr>
                <c:forEach var="list" items="${item }">
                <tr>
                  <td align="center"><input type="checkbox" name="info_id" value="${list.id}"/></td>
                    <td><a href="${CTP}/admin/distribute/${durl }?classId=${classId }&fullName=${fullName }&id=${list.id}" class="item_title">${list.stuId }</a></td>
                    <td>${list.stuName }</td>
                    <td>${list.stuNation }</td>
                    <td>${list.stuSex }</td>
                    <td>${list.stuAge }</td>
                    <td>${list.stuBirthday }</td>
                    <td>${list.stuCardId }</td>
                    <td>${myTag:substr(list.stuAddress,0,10,true)}</td>
                    <td>${list.stuParent }</td>
                    <td>${list.stuPhone }</td> 
                    <td>${list.stuAuthor }</td>
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
