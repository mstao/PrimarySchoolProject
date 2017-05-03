<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="/WEB-INF/mytag.tld" prefix="myTag" %> 
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
<link href="${CTP_ADMIN }/css/magic-check.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${CTP_ADMIN }/js/lib/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${CTP_ADMIN }/js/module/common.js"></script>
<script type="text/javascript" src="${CTP}/resources/common/js/extends/layer-2.4/layer.js"></script>
<script type="text/javascript" src="${CTP_ADMIN }/js/extends/jquery.date_input.pack.js"></script> 
<script type="text/javascript">
var CTPPATH="${pageContext.request.contextPath}";
</script>

<script type="text/javascript">
$(function(){
	
	
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
<span class="apply-time">当前报名时间:
<c:if test="${empty dateInfo}">
<b>暂未设置报名起止时间，点击右侧按钮进行设置</b>
</c:if>
<b>
${dateInfo.startDate}
 - 
${dateInfo.endDate}
</b>
<a href="javascript:void(0);" class="set-time-btn">设置报名时间</a>
</span>

<!-- 设置报名时间  隐藏区域-->
<div class="set-apply-time" >

<label>报名年份</label>
<input type="text"  placeholder="填写报名年份" class="a-year">

<label>报名开始时间</label>
<div class="date-div">
<input type="text"  placeholder="填写报名开始时间" class="a-start-date" value="${dateInfo.startDate}">
</div>

<label>报名截止时间</label>

<div class="date-div">
<input type="text"  placeholder="填写报名截止时间" class="a-end-date" value="${dateInfo.endDate}">
</div>

<button class="submit">确定</button><button class="reset">取消</button>
</div>


</div>

  <div class="new_div1"><span class="new_div1_span">今年报名全部列表</span>
<select class="status-select">
  <option>请选择报名状态<option>
  <option value="wait">等待审核<option>
  <option value="complete">审核通过<option>
  <option value="fail">审核失败<option>
</select>
</div>

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
                <div class="status-tips">
	                <div>
	                <span class="color-tips" style="background:#444444;"></span>
	                <span class="word-tips">等待审核</span>
	                </div>
	                
	                <div>
	                <span class="color-tips" style="background:#467B96;"></span>
	                <span class="word-tips">审核通过</span>
	                </div>
	                
	                <div>
	                <span class="color-tips" style="background:red;"></span>
	                <span class="word-tips">审核失败</span>
	                </div>
                </div>
            </div>
        <div class="new_div3">
         <input type="hidden" class="hide-apply-id" value="">            
            <table>
                <tr>
                    <th></th>
                    <th>学生姓名</th>
                    <th>学生身份证号</th>
                    <th>性别</th>
                    <th>民族</th>
                    <th>报名时间</th>
                    <th>报名状态</th>
                    <th>操作</th>
                </tr>
                <c:forEach  items="${apply}" var="list">
                <tr class="bubblemenu">
                    <td align="center"><input type="checkbox" name="info_id" value="${list.id}"/></td>
                    <td><a href="javascript:void(0);" class="item_title" data-id="${list.id}">${list.stuName }</a>
                    
                    <!--气泡悬浮显示图片信息  -->
			           <div class="bubb-image">
			             <!-- 这里为加载内容 -->
			           </div>
                    </td>
                    <td>${list.stuIdNum }</td>
                    <td >${list.stuSex }</td>
                    <td >${list.stuNation }</td>
                    <td >${myTag:substr(list.addTime,0,10,false)}</td>
                    <td>
                    <c:choose>
                       <c:when test="${list.status eq 0}"><font color="#444444">等待审核</font></c:when>
                       <c:when test="${list.status eq 1}"><font color="#467B96">审核通过</font></c:when>
                       <c:when test="${list.status eq 2}"><font color="red">审核失败</font></c:when>
                    </c:choose>
                    </td>
                    <td><img src="${CTP_ADMIN }/img/assign.png"/><a href="javascript:void(0);" class="update-status" data-id="${list.id}">更改报名状态</a></td>
                </tr>
                </c:forEach>
            </table>
             <!-- 分页导航引入 -->
			    ${toolBar}
        </div>

<!--S 引入footer  -->
<jsp:include page="../common/footer.jsp" />
<!--E 引入footer -->

<!--S 弹窗 -->
<div class="mark"></div>
<div class="dialog">
     
        <div class="dialog-close" onClick="$('.mark,.dialog').hide();"></div> 
        <div class="dialog-title">
                              更改报名状态
        </div> 
        <div class="dialog-content"> 
            <input type="hidden" class="hide-checked-id" value="">
            <div class="opt-div">
            <h4>请选择一个报名状态 </h4>
			
			
			<div class="opt">
				<input class="magic-radio" type="radio" name="radio" id="rr1" value="1">
				<label for="rr1">等待审核</label>
			</div>
	     	
	     	<div class="opt">
				<input class="magic-radio" type="radio" name="radio" id="rr2" value="2">
				<label for="rr2">审核通过</label>
			</div>
			
			<div class="opt">
				<input class="magic-radio" type="radio" name="radio" id="rr3" value="3">
				<label for="rr3">审核失败</label>
			</div>
	     	
	     	<div class="fail-reason">
	     	
	     	  <textarea rows="" cols="" class="reason-content" placeholder="请填写审核失败原因"></textarea>
	     	</div>
	     	  
	     	
	     	
            </div>
           
           <div class="active">
				<button class="close" onClick="$('.mark,.dialog').hide();">关闭</button><button class="save">保存</button>
		  <br>
		   </div>
        </div>
</div>

<!--E 弹窗  -->

</body>
</html>

<script type="text/javascript">

$(function(){
	
	//动态加载报名用户的具体信息

	$(document).on("mouseover",".item_title",function(){
		
		var mythis=$(this);
		//获取绑定的id值
		var id= mythis.attr("data-id");
        if(id!=""){
        	
        	//start
        	
        	$.ajax({
				type:'post',
				dataType:'json',
				url:CTPPATH+"/admin/apply/loadinfo",
				data:{"id":id},
			
				beforeSend:function(){
					//显示正在加载
					//layer.load(2);
					 mythis.next(".bubb-image").html('<div class="spinner"><div class="bounce1"></div><div class="bounce2"></div><div class="bounce3"></div></div>');
				},
				success:function(data){

					//关闭正在加载
					/* setTimeout(function(){
						  layer.closeAll('loading');
					}, 1000); */
					
					var xhtml="";
					if(data!=null){
					    //添加学生基本信息
						xhtml+="<div class='stu-info-display-left'><span class='tips'>学生基本信息</span><br><br>";
						xhtml+="<div><span>姓名：</span><span>"+data.stuName+"</span></div><div><span>性别：</span><span>"+data.stuSex+"</span></div><div><span>民族：</span><span>"+data.stuNation+"</span></div><div><span>身份证号：</span><span>"+data.stuIdNum+"</span></div><div><span>原学校名称：</span><span>"+data.originalSchool+"</span></div><div><span>现地址：</span><span>"+data.address+"</span></div><div><span>所在户籍：</span><span>"+data.register+"</span></div></div>";
						
						//添加监护人信息
						
						xhtml+="<div class='stu-info-display-right'><span class='tips'>监护人信息</span><br><br>";
						xhtml+="<div><span>父亲姓名：</span><span>"+data.fatherName+"</span></div><div><span>父亲身份证：</span><span>"+data.fatherIdNum+"</span></div><div><span>父亲电话：</span><span>"+data.fatherPhone+"</span></div><div><span>母亲姓名：</span><span>"+data.motherName+"</span></div><div><span>母亲身份证：</span><span>"+data.motherIdNum+"</span></div><div><span>母亲电话：</span><span>"+data.motherPhone+"</span></div></div> ";
					}else{
						
						xhtml+="数据暂未找到，请重试^_^";
						layer.msg("数据暂未找到，请重试^_^");
					}
					 mythis.next(".bubb-image").html(xhtml);
					
				},
				error:function(){
					mythis.next(".bubb-image").html("");
					//关闭正在加载
					/* setTimeout(function(){
						  layer.closeAll('loading');
					}, 1000); */
					layer.msg("出错了", {icon: 2,time:2000});
				}
			});
        	//end
        	
        }else{
        	layer.msg("id未知");
        }
	});
	
	
	//点击弹出弹出框，并且将id写入隐藏域
	
    $(".update-status").bind("click",function(){
    	
    	$(".mark").show();
		$(".dialog").show();
		
		//获取该项id值
		var id=$(this).attr("data-id");
		//将该id值写入隐藏域，供其他方法使用
		$(".hide-apply-id").val(id);
    	
    });
	
	//点击审核失败出现原因回复框
	 $(":radio").click(function(){
		 
       if($(this).attr("id")=="rr3"){
    	   $(".fail-reason").slideDown();
       }else{
    	   $(".fail-reason").slideUp();
       } 
     });
	
	$(".save").bind("click",function(){
		alert("zz");
	});
	
	

});
</script>