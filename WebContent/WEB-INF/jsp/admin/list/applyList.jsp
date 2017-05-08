<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="/WEB-INF/mytag.tld" prefix="myTag" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
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
<link href="${CTP}/resources/common/css/page.css"  rel="stylesheet" />
<link href="${CTP_ADMIN }/css/date.css" rel="stylesheet" type="text/css" />
<link href="${CTP_ADMIN }/css/magic-check.css" rel="stylesheet" type="text/css" />
<link href="${CTP}/resources/common/select-tether/dist/css/select-theme-dark.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="${CTP_ADMIN }/js/lib/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${CTP_ADMIN }/js/module/common.js"></script>
<script type="text/javascript" src="${CTP}/resources/common/js/extends/layer-2.4/layer.js"></script>
<script type="text/javascript" src="${CTP_ADMIN }/js/extends/jquery.date_input.pack.js"></script> 

<script type="text/javascript" src="${CTP}/resources/common/select-tether/js/tether.js"></script>
<script src="${CTP}/resources/common/select-tether/dist/js/select.min.js"></script>


<script type="text/javascript">
var CTPPATH="${pageContext.request.contextPath}";
var CTP_ADMIN=CTPPATH+"/resources/admin";
var _status="${status}";
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
	
	
	//验证年份
	
	function  checkYear(className){
		var _year_filter=/^[1-9]+\d{3}$/;
		
		var _year_str=$(className).val();
		_year_str=_year_str.replace(/\s/g , '');//输入空格时自动忽略，\s表示空格
		if( _year_str ==""|| _year_str==null ){
	   		layer.tips('*年份不能为空',  $(className));
	   		$(className).focus();
	   		ok_year=false;	
		}else{
			if(_year_filter.test(_year_str)){
				ok_year=true;
					
			}else{
				layer.tips('*请输入4位年份', $(className));
		   		$(className).focus();
		   		ok_year=false;
			}
		}
	}
	
	//加载页面执行
	checkYear(".a-year");
	
	/**验证年份**/
	$(".a-year").bind("blur",function(){
		checkYear($(this));
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
	
	//自动执行
	var  _start_date=$(".a-start-date").val();
	if(checkDate(_start_date,$(".a-start-date"))){
		ok_start_date=true;
	}
	
	var _end_date=$(".a-end-date").val();
	if(checkDate(_end_date,$(".a-end-date"))){
		ok_end_date=true;
	}
	
	$(".submit").bind("click",function(){
		var start_date = $(".a-start-date").val();
		var end_date = $(".a-end-date").val();
		var timeslong = getDate(end_date).getTime()-getDate(start_date).getTime();
	    var sub_date = timeslong/(1000*60*60*24);
	    var _year=$(".a-year").val();
	    var date_status=$(".hide-date-status").val();
	    var id="${dateInfo.id}";
	    var datajson="";
	    
	    if(id==""){
	    	datajson={"flag":date_status,"year":_year,"startDate":start_date,"endDate":end_date};
	    }else{
	    	datajson={"flag":date_status,"id":"${dateInfo.id}","year":_year,"startDate":start_date,"endDate":end_date};
	    }
	    if(sub_date>=0){
	    	if(ok_start_date == true && ok_end_date == true && ok_year == true){
	    		
	        //start
	    		
        	$.ajax({
				type:'post',
				dataType:'text',
				url:CTPPATH+"/admin/apply/dealApplyDate",
				data:datajson,		
				beforeSend:function(){
					//显示正在加载
					layer.load(2);
					
				},
				success:function(data){

					//关闭正在加载
					setTimeout(function(){
						  layer.closeAll('loading');
					}, 1000); 
					
					//根据 date_status 进行相应的提示
					if(data==1){
						if(date_status==0){
							layer.msg("报名时间新增成功",{icon: 1,time:2000});
						
						    $(".apply-time  > b").html(start_date+" ~ "+end_date);
						}else if(date_status==1){
							layer.msg("报名时间修改成功",{icon: 1,time:2000});
							
							 $(".apply-time  > b").html(start_date+" ~ "+end_date);
						}
						 
					}else if(data==0){
						if(date_status==0){
							layer.msg("报名时间新增失败",{icon: 2,time:2000});
						}else if(date_status==1){
							layer.msg("报名时间修改失败",{icon: 2,time:2000});
						}
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
	    	}else{
	    		layer.msg("输入校验失败，请仔细检查后提交！");
	    	}
	    	
	    }else{
	    	layer.msg("结束时间与开始时间设置不合理，请重新设置！");
	    }
	});
	
	
	//设置开启报名功能
	$(".begin-apply-btn").bind("click",function(){
		var mythis=$(this);
		//获取绑定的值
		var default_value=mythis.attr("data-beginApply");
		
		layer.confirm('确定操作？', {
			  btn: ['确定','取消'] 
			}, function(){
				if(default_value!=""){
					$.ajax({
						type:'post',
						dataType:'text',
						url:CTPPATH+"/admin/apply/updateBeginApply",
						data:{"begin":default_value},
					
						beforeSend:function(){
							//显示正在加载
							layer.load(2);
						},
						success:function(data){

							//关闭正在加载
							setTimeout(function(){
								  layer.closeAll('loading');
							}, 1000);
							
							//修改成功
							if(data==1){
								
								//如果原来的值为1，说明已经修改为0
								if(default_value==1){
									layer.msg("结束报名成功！", {icon: 1,time:2000});
									mythis.text("开启报名");
									mythis.attr("data-beginApply",0);
								}else if(default_value==0){
									layer.msg("开启报名成功！", {icon: 1,time:2000});
									//如果原来的值为0，说明已经修改为1
									mythis.text("结束报名");
									mythis.attr("data-beginApply",1);
								}
							
							}else{
								layer.msg("更改出错了", {icon: 2,time:2000});
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
				}
			}, function(){
  			    //取消操作 ，这里可以为空
  			    
				
  			});
	});
	
	//检测查看的报名状态
	$(".status-select").change(function(){
		var value=$(this).val();
		//进行判断
		if(value=="all"){
			$(".new_div1_span").html("今年报名全部列表");
			
			window.location.href=CTPPATH+"/admin/apply/listAll?status=3&p=1";
		}else if(value=="complete"){
			$(".new_div1_span").html("审核通过列表");
			window.location.href=CTPPATH+"/admin/apply/listAll?status=1&p=1";
		}else if(value=="wait"){
			$(".new_div1_span").html("等待审核列表");
			window.location.href=CTPPATH+"/admin/apply/listAll?status=0&p=1";
		}else if(value=="fail"){
			$(".new_div1_span").html("审核失败列表");
			window.location.href=CTPPATH+"/admin/apply/listAll?status=2&p=1";
		}
	});
	
	
	//删除
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
						url:CTPPATH+"/admin/apply/delete",
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
								window.location.href="${pageContext.request.contextPath}/admin/apply/listAll?status="+_status+"&p=1";
							
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
	   

});

</script>




</head>
<body>

<%--检测浏览器 --%>
<jsp:include page="../../common/browsehappy.jsp"></jsp:include>
	
<!-- S header -->
<jsp:include page="../common/header.jsp" />


<div class="apply-info">

<span style="font-weight: bold;">报名管理</span>
<!-- 开始报名按钮 -->
<button  data-beginApply="${dateInfo.beginApply}" class="begin-apply-btn"  <c:if test="${empty dateInfo}">disabled="disabled"  style="color:#666666;background:#CCCCCC;cursor:not-allowed;"</c:if> >
<c:choose>
<c:when test="${dateInfo.beginApply eq 0}">
开启报名
</c:when>

<c:when test="${dateInfo.beginApply eq 1}">
结束报名
</c:when>

<c:otherwise>报名未开始</c:otherwise>
</c:choose>

</button>

<br>
<span class="apply-time">当前报名时间:
<c:if test="${empty dateInfo}">
<b>暂未设置报名起止时间，点击右侧按钮进行设置</b>
</c:if>
<b>
<fmt:formatDate value="${dateInfo.startDate}" pattern="yyyy-MM-dd"/>
 ~ 
<fmt:formatDate value="${dateInfo.endDate}" pattern="yyyy-MM-dd"/>
</b>

<!-- 设置报名时间隐藏域，用于 处理报名时间标志 -->

<a href="javascript:void(0);" class="set-time-btn">

<c:choose>

<c:when test="${empty dateInfo}">
设置报名时间
<input type="hidden" class="hide-date-status" value="0">
</c:when>

<c:otherwise>
<input type="hidden" class="hide-date-status" value="1">
修改报名时间
</c:otherwise>

</c:choose>

</a>
</span>

<!-- 设置报名时间  隐藏区域-->
<div class="set-apply-time" >

<label>报名年份(系统自动计算)</label>
<input type="text"  placeholder="填写报名年份" class="a-year" disabled="disabled">

<label>报名开始时间</label>
<div class="date-div">
<input type="text"  placeholder="填写报名开始时间" class="a-start-date" value="<fmt:formatDate value='${dateInfo.startDate}' pattern='yyyy-MM-dd'/>">
</div>

<label>报名截止时间</label>

<div class="date-div">
<input type="text"  placeholder="填写报名截止时间" class="a-end-date" value="<fmt:formatDate value='${dateInfo.endDate}' pattern='yyyy-MM-dd'/>">
</div>

<button class="submit">确定</button><button class="reset">取消</button>
</div>


<div class="census-div">
    <img src="${CTP_ADMIN }/img/统计.png">
    <div><span>总报名人数:</span><span>${allCount}</span></div>
    <div><span>等待审核人数:</span><span>${waitCount}</span></div>
    <div><span>审核通过人数:</span><span>${completeCount}</span></div>
    <div><span>审核失败人数:</span><span>${failCount}</span></div>
</div>


</div>


<div class="new_div1"><span class="new_div1_span">
<c:choose>

<c:when test="${status eq 3 }">
今年报名全部列表
</c:when>
<c:when test="${status eq 0 }">
等待审核列表
</c:when>
<c:when test="${status eq 1 }">
审核通过列表
</c:when>
<c:when test="${status eq 2 }">
审核失败列表
</c:when>

</c:choose>


</span>
<select class="status-select">
  <option value="">--请选择报名状态--</option>
  <option value="all">全部名单</option>
  <option value="wait">等待审核</option>
  <option value="complete">审核通过</option>
  <option value="fail">审核失败</option>
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
                <input type="text" class="new_text" placeholder="请输入关键字" value="" name="keywords" />&nbsp;  
                
                
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
        <input type="hidden" class="hide-apply-id" value="">      
        <div class="new_div3">
               
            <table>
                <tr>
                    <th></th>
                    <th>学生姓名</th>
                    <th>学生身份证号</th>
                    <th>性别</th>
                    <th>民族</th>
                    <th>报名时间</th>
                    <th>报名状态</th>
                    <th>报名失败原因</th>
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
                    <td class="s${list.id}">
                    <c:choose>
                       <c:when test="${list.status eq 0}"><font color="#444444">等待审核</font></c:when>
                       <c:when test="${list.status eq 1}"><font color="#467B96">审核通过</font></c:when>
                       <c:when test="${list.status eq 2}"><font color="red">审核失败</font></c:when>
                    </c:choose>
                    </td>
                    <td class="r${list.id}" title="${list.reason}">${myTag:substr(list.reason,0,10,true)}</td>
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
				<input class="magic-radio" type="radio" name="radio" id="rr1" value="0" checked>
				<label for="rr1">等待审核</label>
			</div>
	     	
	     	<div class="opt">
				<input class="magic-radio" type="radio" name="radio" id="rr2" value="1">
				<label for="rr2">审核通过</label>
			</div>
			
			<div class="opt">
				<input class="magic-radio" type="radio" name="radio" id="rr3" value="2">
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

function  substrzzz(maxLen,str,isDot){
	if(str.length>maxLen){
		if(isDot==true){
		    str=str.substring(0,maxLen)+"...";
		}else{
			str=str.substring(0,maxLen);
		}
	}
	return str;
}

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
					
					    //图片信息
					    
					    xhtml+="<div class='stu-info-display-img'><span class='tips'>户口本户主页，学生页，房产证页等</span><br><br>";
					    xhtml+="<div class='img-show-div'> <a href='"+data.imgPath+"' target='_blank' class='img-show-a'><img src='"+data.imgPath+"' class='img-show' style='width:250px; height:200px;'/></a> </div></div>"
					    
					}else{
						
						xhtml+="数据暂未找到，请重试^_^";
					//	layer.msg("数据暂未找到，请重试^_^");
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
	$(document).on("click",".update-status",function(){
    	
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
    	   //
    	   var id=$(".hide-apply-id").val();
	       //获取该项报名失败原因
	   	   var reason=$(".r"+id).html();
	   
	       if(reason!=""){
	       		$(".reason-content").val(reason);
	       }
       }else{
    	   $(".fail-reason").slideUp();
    	   $(".reason-content").val("");
       } 
     });
	
	//点击保存对用户报名状态进行更改
	$(".save").bind("click",function(){
		//获取单选按钮的值
		var value=$("input[type='radio']:checked").val();
		
		//获取报名失败原因
		var reason=$(".reason-content").val();
		
		//获取隐藏id
		var id=$(".hide-apply-id").val();
	    if(value!=""){
	    	//调用ajax更改信息
	    	
	    	//start
	    	
        	$.ajax({
				type:'post',
				dataType:'text',
				url:CTPPATH+"/admin/apply/updateStatus",
				data:{"id":id,"statusValue":value,"reason":reason},
			
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
						layer.msg("更改状态成功", {icon: 1,time:2000});
						//此时对文字进行处理
						if(value==0){
							//此时需要对点击该项的class进行寻找
							$(".s"+id).html("<font color='#444444'>等待审核</font>");
							$(".r"+id).html("");
						}else if(value==1){
							$(".s"+id).html("<font color='#467B96'>审核通过</font>");
							$(".r"+id).html("");
						}else if(value==2){
							$(".s"+id).html("<font color='red'>审核失败</font>");
							//截取下字符串
							var maxLen=10;
					
							if(reason.length>maxLen){
								reason=reason.substring(0,maxLen)+"...";
							}
							$(".r"+id).html(reason);
						}
						
						
					}else{
						layer.msg("修改状态失败！");
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
	    }else{
	    	layer.msg("请选择状态！");
	    }
	});
	
	
	//搜素加载信息
	$(".new_button").bind("click",function(){
		var token=$(".new_text").val();
		token=token.replace(/\s/g , '');//输入空格时自动忽略，\s表示空格
		var status=_status;//根据状态条件
		if(token=="" || token==null){
			layer.msg("请输入搜素内容哦！");
		}else{
			//start
			$.ajax({
				type:'post',
				dataType:'json',
				url:CTPPATH+"/admin/apply/findApplyInfoByToken",
				data:{"token":token,"status":status},
			
				beforeSend:function(){
					//显示正在加载
					layer.load(2);
					
				},
				success:function(data){

					//关闭正在加载
					setTimeout(function(){
						  layer.closeAll('loading');
					}, 1000); 
					
					var xhtml="<table><tr><th></th><th>学生姓名</th><th>学生身份证号</th><th>性别</th><th>民族</th><th>报名时间</th><th>报名状态</th><th>报名失败原因</th><th>操作</th></tr>";
					if(data.length>0){
				
						$.each(data,function(idx,item){ 
						    xhtml+="<tr class='bubblemenu'><td align='center'><input type='checkbox' name='info_id' value='"+item.id+"'/></td>";
						    xhtml+="<td><a href='javascript:void(0);' class='item_title' data-id='"+item.id+"'>"+item.stuName+"</a><div class='bubb-image'></div></td>";
						    xhtml+="<td>"+item.stuIdNum+"</td><td >"+item.stuSex+"</td><td >"+item.stuNation+"</td>";
						    xhtml+="<td>"+substrzzz(10,item.addTime,false)+"</td>";
						    xhtml+="<td class='s"+item.id+"'>";
						    
						    if(item.status==0){
						    	xhtml+="<font color='#444444'>等待审核</font>";
						    }else if(item.status==1){
						    	xhtml+="<font color='#467B96'>审核通过</font>";
						    }else if(item.status==2){
						    	xhtml+="<font color='red'>审核失败</font>";
						    }
						    xhtml+"</td>";
						    xhtml+="<td class='r"+item.id+"' title='"+item.reason+"'>"+substrzzz(10,item.reason,true)+"</td><td><img src='"+CTP_ADMIN+"/img/assign.png'/><a href='javascript:void(0);' class='update-status' data-id='"+item.id+"'>更改报名状态</a></td>";
						    xhtml+="</tr>";
						});
					}else{
						xhtml+="<tr><td colspan='9' style='background:#F2DEDE; color:#444444;text-align:center;'>没有找到信息</td></tr>";
					}
					xhtml+="</table>";
				   $(".new_div3").html(xhtml);
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
		}
	});
	
	
	

});
</script>



<script type="text/javascript">
		$('select.status-select').each(function(){
			new Select({
				el: this,
				selectLikeAlignment: $(this).attr('data-select-like-alignement') || 'auto',
				className: 'select-theme-dark'
			});
		});
</script>

