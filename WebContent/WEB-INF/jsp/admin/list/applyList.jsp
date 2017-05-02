<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学校报名管理</title>

<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_ADMIN" value="${pageContext.request.contextPath}/resources/admin"></c:set>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../common/meta.jsp" flush="true"/>	

<link href="${CTP_ADMIN }/css/admin_header.css" rel="stylesheet" type="text/css" />
<link href="${CTP_ADMIN }/css/list.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${CTP}/resources/common/css/page.css"/>
<link href="${CTP_ADMIN }/css/date.css" rel="stylesheet" type="text/css" />
 <script type="text/javascript" src="${CTP_ADMIN }/js/lib/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${CTP_ADMIN }/js/module/common.js"></script>
<script type="text/javascript" src="${CTP}/resources/common/js/extends/layer-2.4/layer.js"></script>
<script type="text/javascript" src="${CTP_ADMIN }/js/extends/jquery.date_input.pack.js"></script> 
<script type="text/javascript">
$(function(){
	var CTPPATH="${pageContext.request.contextPath}";
	
	var ok_year=false;
	var ok_start_date=false;
	var ok_end_date=false;
	
	var date = new Date();
	
	var _year=date.getFullYear();
	$(".a-year").val(_year);
	
	
	$(".a-start-date").date_input();
	
	$(".a-end-date").date_input();
	
	$(".set-time-btn").bind("click",function(){
				
	     $(".set-apply-time").slideToggle();
	});
	
	$(".reset").bind("click",function(){
		$(".a-start-date").val("");
		$(".a-end-date").val("");
		
	});
	
	/**验证年份**/
	$(".a-year").bind("blur",function(){
		var filter=/^[1-9]+\d{3}$/;
		var str=$(this).val();
		
		str = str.replace(/\s/g , '');//输入空格时自动忽略，\s表示空格
	   	if( str ==""|| str==null ){
	   		layer.tips('*年份不能为空', $(this));
	   		$(this).focus();
				
		}else{
			if(filter.test(str)){
				ok_year=true;
			}else{
				layer.tips('*请输入4位年份', $(this));
		   		$(this).focus();
					
			}
		}
	});	
	
	//检验年份
	
	function checkDate(str,className){
		var filter=/^((?:19|20)\d\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$/;
		
		str = str.replace(/\s/g , '');//输入空格时自动忽略，\s表示空格

	   	if( str ==""|| str==null ){
	   		layer.tips('*日期不能为空', $(className));
	   		$(className).focus();
		    return false;
		}else{
			if(filter.test(str)){
				return true;
			}else{
				layer.tips('*请输入yyyy-MM-dd格式日期', $(className));
				$(className).focus();
				return false;
			}
		}
	}
	
	//计算天数差的函数，通用 
	function getDate(strDate){
	    if(strDate==null||strDate===undefined) return null;
	    var date = new Date();
	    try{
	      if(strDate == undefined){ 
	        date= null;
	      }else if(typeof strDate == 'string'){
	        strDate = strDate.replace(/:/g,'-');
	        strDate = strDate.replace(/ /g,'-');
	        var dtArr = strDate.split("-");
	        if(dtArr.length>=3&&dtArr.length<6){
	          date=new Date(dtArr[0], dtArr[1], dtArr[2]);
	        }else if(date.length>8){
	          date=new Date(Date.UTC(dtArr[0],dtArr[1]-1,dtArr[2],dtArr[3]-8,dtArr[4],dtArr[5]));
	        }
	      }else{
	        date = null;
	      }
	      return date;
	    }catch(e){ 
	      alert('格式化日期出现异常：' + e.message); 
	    } 
	  }
	
	$(".a-start-date").bind("click",function(){
		var str=$(this).val();
		if(checkDate(str,$(this))){
			ok_start_date=true;
		}
	});
	$(".a-end-date").bind("click",function(){
		var str=$(this).val();
		if(checkDate(str,$(this))){
			ok_end_date=true;
		}
	});
	
	$(".submit").bind("click",function(){
		var start_date = $(".a-start-date").val();
		var end_date = $(".a-end-date").val();
		var timeslong = getDate(end_date).getTime()-getDate(start_date).getTime();
	    var sub_date = timeslong/(1000*60*60*24);
	    
	    
	    
	    if(sub_date>=0){
	    	
	    }else{
	    	layer.msg("结束时间与开始时间设置不合理，请重新设置！");
	    }
	});
});

</script>

</head>
<body>
<!-- S header -->
<jsp:include page="../common/header.jsp" />


<div class="apply-info">
<span>报名管理</span>
<br>
<span class="apply-time">当前报名时间:<b>2016年 9月2日-2016年 9月30日</b><a href="javascript:void(0);" class="set-time-btn">设置报名时间</a></span>

<!-- 设置报名时间  隐藏区域-->
<div class="set-apply-time" >

<label>报名年份</label>
<input type="text"  placeholder="填写报名年份" class="a-year">

<label>报名开始时间</label>
<div class="date-div">
<input type="text"  placeholder="填写报名开始时间" class="a-start-date">
</div>

<label>报名截止时间</label>

<div class="date-div">
<input type="text"  placeholder="填写报名截止时间" class="a-end-date">
</div>

<button class="submit">确定</button><button class="reset">取消</button>
</div>


</div>

  <div class="new_div1"><span class="new_div1_span">${typeName }列表</span></div>

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
                    <th></th>
                    <th>标题</th>
                    <th>作者</th>
                    <th>类别</th>
                    <th>发布日期</th>
                </tr>
                <c:forEach var="list" items="${item }">
                <tr>
                    <td width="5%" align="center"><input type="checkbox" name="info_id" value="${list.id}"/></td>
                    <td width="35%"><a href="${CTP}/admin/distribute/${durl }?id=${list.id}" class="item_title">${list.itemTitle }</a>
                     <c:if test="${list.isPublish eq 0}">
		              <span class="draft-span">草稿</span>
		             </c:if>
                    </td>
                    <td width="20%"><a href="">${list.author }</a></td>
                    <td width="20%"><a href="">${typeName }</a></td>
                    <td width="20%">${list.addTime }</td>
                </tr>
                </c:forEach>
            </table>
             <!-- 分页导航引入 -->
			    ${toolBar}
        </div>

<!--S 引入footer  -->
<jsp:include page="../common/footer.jsp" />
<!--E 引入footer -->
</body>
</html>