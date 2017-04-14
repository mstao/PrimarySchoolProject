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
		<link href="${CTP_ADMIN }/css/edit.css" rel="stylesheet" type="text/css" />
		<link href="${CTP_ADMIN }/js/extends/wangEditor/dist/css/wangEditor.min.css" rel="stylesheet" type="text/css"/>
		
	    <script type="text/javascript" src="${CTP_ADMIN }/js/extends/wangEditor/dist/js/lib/jquery-1.10.2.min.js"></script>
	    <script type="text/javascript" src="${CTP_ADMIN }/js/layer-2.4/layer.js"></script>
	<script type="text/javascript">
	 var CTPPATH="${pageContext.request.contextPath}";
	
	function check(val,obj){
		    obj.style.backgroundColor="#E9E9E6";
			if(val=='f'){
					f.style.display='block';
					s.style.display='none';
					sb.style.backgroundColor="#F6F6F3";
		    }else if(val=='s'){
		 	        s.style.display='block';
					f.style.display='none';
					fb.style.backgroundColor="#F6F6F3";
		    }
		    
	}
		
	
    </script>
	</head>
	<body>
	<!-- S header -->
	<jsp:include page="../common/header.jsp"></jsp:include>
	
	<!-- S body -->
	<div class="main">
	<div id="location">您现在的位置: 后台管理 ><span> 校园管理</span> > 撰写新闻</div>
	<!--S 编辑区域-->
	<div class="edit-div"> 
		<span class="edit-span">撰写新闻</span>
		<input type="text" name="eidt_title" class="edit-title" placeholder="标题" value="国家重大科研仪器设备研制项目《新一代高衬度低剂量X射线相位衬度CT装置》项目研讨会成功召开">
		<span class="content-span">新闻内容</span>
		 <!--S 编辑器 -->              
                      <div id="editor-container" class="answercontainer"><div id="editor-trigger">国家重大科研仪器设备研制项目《新一代高衬度低剂量X射线相位衬度CT装置》项目研讨会成功召开</div></div>
          <!--E 编辑器  -->
        <div class="edit-submit">
        	<a href="javascript:void(0);" class="draft-btn">保存草稿</a><a href="javascript:void(0);">发布内容</a>
        </div>
	</div>
	<!--S 编辑区域-->
	
	<!--S 附件选择区-->
	<div class="check-zone">
		<div class="check-btn">
			<ul>
				<li ><a href="javascript:void(0);" onclick="check('s',this)" id='sb'>选项</a></li>
				<li ><a href="javascript:void(0);" onclick="check('f',this)" id="fb">附件</a></li>
			</ul>
		</div>
		<!--clear-->
		<div class="clear"></div>
		<!--clear-->
		<div class="options-checked-div" id="s">
			<span class="publish-dept-span">新闻发布者</span>
			<input type="text" name="publish_dept" class="publish-dept" value="万科小学">
		    
		</div>
		<div class="draft-cheched-div" id="f">
			<input type="file" name="add_file" class="add-file" value="添加附件"/>
		</div>
	</div>
	<!--E 附件选择区-->
	
	<!--clear-->
	<div class="clear"></div>
	<!--clear-->
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
<script type="text/javascript" src="${CTP_ADMIN }/js/extends/wangEditor/dist/js/wangEditor.js"></script>
<script type="text/javascript" src="${CTP_ADMIN }/js/Editor.js"></script>

