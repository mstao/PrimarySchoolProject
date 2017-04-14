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
		<script type="text/javascript">
	$(function(){
		//全选和取消全选
		$('.new_div2_input').click(function(){
		  var is_check=$('.new_div2_input').is(':checked');
		  var info_check=document.getElementsByName('info_check');
		  if(is_check==true){

			for(var i=0;i<info_check.length;i++){
				info_check[i].checked=true;
			}
				  	   
		  }else{
		  	for(var i=0;i<info_check.length;i++){
			    info_check[i].checked=false;
			}
		  }
		});
		
	  //限制标题的显示字数长度
       var item_length= $('.item_title').text().length;
       var  maxwidth=18;
	   if(item_length>maxwidth){
        		$('.item_title').text($('.item_title').text().substring(0,maxwidth)+'..');
       	}
	 });
	  
	</script>
	</head>
	<body>
		<!-- S header -->
	<jsp:include page="../common/header.jsp" />
	<!--S main-->
			<div id="location">您现在的位置: 后台管理 ><span>${typeName }</span></div>
            <div class="new_div1"><span class="new_div1_span">新闻列表</span><a href="${CTP }/adminAdd/editDetails?flag=${typeFlag }&durl=${durl }" class="add_list">新增</a></div>
            <div class="new_div2">
            	
                <input type="checkbox" class="new_div2_input"/>
                <ul>
                    <li>
                        <a href="#">已选定</a>
                        <ul>
                            <li><a href="#">删除</a></li>
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
                    <th></th>
                    <th>标题</th>
                    <th>作者</th>
                    <th>类别</th>
                    <th>发布日期</th>
                </tr>
                <c:forEach var="list" items="${item }">
                <tr>
                    <td width="5%" align="center"><input type="checkbox" name="info_check"/></td>
                    <td width="35%"><a href="${CTP}/admin/distribute/trends?id=${list.id}" class="item_title">${list.itemTitle }</a></td>
                    <td width="20%"><a href="">${list.author }</a></td>
                    <td width="20%"><a href="">${typeName }</a></td>
                    <td width="20%">${list.addTime }</td>
                </tr>
                </c:forEach>
            </table>
             
        </div>
        <div> <!-- 分页导航引入 -->
			    ${toolBar}
</div>
<!--E main-->

<!--S footer-->
<div class="footer">
			<center><span>Copyright &copy;万科城小学  版权所有 2016 All Rights Reserved.</span></center>
<br><br>
</div>
<!--E footer-->
	</body>
</html>
