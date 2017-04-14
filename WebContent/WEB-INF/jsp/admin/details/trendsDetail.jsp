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
		<link href="${CTP_ADMIN }/css/date.css" rel="stylesheet" type="text/css" />
		<link href="${CTP_ADMIN }/js/extends/wangEditor/dist/css/wangEditor.min.css" rel="stylesheet" type="text/css"/>
		
	    <script type="text/javascript" src="${CTP_ADMIN }/js/lib/jquery-1.8.3.js"></script>
	    <script type="text/javascript" src="${CTP}/resources/common/js/extends/layer-2.4/layer.js"></script>
	
	    <script type="text/javascript" src="${CTP_ADMIN }/js/extends/jquery.date_input.pack.js"></script> 
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

	<!--S 编辑区域-->
	<div class="edit-div"> 
		<span class="edit-span">修改${item.itemTypeName}</span>
		<span class="title-span">标题</span>
		<input type="text" name="eidt_title" class="edit-title" placeholder="标题" value="${item.itemTitle}">
		<span class="content-span">${item.itemTypeName}内容</span><br>
		 <!--S 编辑器 -->              
              <div id="editor-container" class="answercontainer"><div id="editor-trigger">${item.itemContent}</div></div>
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
			<span class="publish-dept-span">发布者</span>
			<input type="text" name="publish_dept" class="publish-dept" value="万科小学">
		    <br>
		    <span class="publish-dept-span">发布时间</span>
		    <div id="date-div">
		    <input type="text"  class="date_picker" value="${item.addTime}">
		    </div>
		     <span class="publish-dept-span">分类(zzzz)</span>
		    <select name="publish_style" id="publish-style">
		    	<option value="${item.itemTypeName}" selected="true">${item.itemTypeName}</option>
		    
		    </select>
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

<script type="text/javascript">

$('.date_picker').date_input();


//获得信息
$(function(){
	
	// 阻止输出log
  // wangEditor.config.printLog = false;

  var editor = new wangEditor('editor-trigger');
  editor.config.pasteFilter=true;
  editor.config.pasteText = true;
  // 上传图片
  editor.config.uploadImgUrl = CTPPATH+'/admin/upload/uploadpic';
  editor.config.uploadParams = {
      // token1: 'abcde',
      // token2: '12345'	
  };
  editor.config.uploadHeaders = {
      // 'Accept' : 'text/x-json'
  }
   editor.config.uploadImgFileName = 'myEditorImgName';

  // 普通的自定义菜单
  editor.config.menus = [
      'source',
      '|',     // '|' 是菜单组的分割线
      'bold',
      'underline',
      'italic',
      'eraser',
      '|',
      'head',
      'quote',
      'unorderlist',
      'orderlist',
      'alignleft',
      'aligncenter',
      'alignright',
      '|',
      'table',
      'link',
      'unlink',
      'img',
      '|',
      'undo',
      'redo',
      'fullscreen'
   ];
    

  
  //创建编辑器
  editor.create();
});

</script>
