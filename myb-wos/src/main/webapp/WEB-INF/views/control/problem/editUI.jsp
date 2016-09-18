<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/share/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>查看问题</title>
<%@ include file="/WEB-INF/views/share/cssAndJs.jsp"%>
<script type="text/javascript">
	var message = "${message}";
	if(message != null && message != "") {
		alert(message);
	}
	$(function(){
		$('input[id=lefile-2]').change(function() {
    		$('#img-2').val($(this).val());
	    });
	    $('input[id=lefile-3]').change(function() {
	    	$('#img-3').val($(this).val());
	    });
	    $('input[id=lefile-4]').change(function() {
	    	$('#img-4').val($(this).val());
	    });
	    $('input[id=lefile-5]').change(function() {
	    	$('#img-5').val($(this).val());
	    });
	    $('input[id=lefile-6]').change(function() {
	    	$('#img-6').val($(this).val());
	    });		
	});
</script>
</head>
<body>
<div class="container">
 <div class="page-header col-sm-offset-2" >
     <h2>查看问题</h2>
 </div>
<form class="form-horizontal" id="addDomain" method="post" action="${base }/manage/control/problem/answer.jhtml"  enctype="multipart/form-data">

  <div class="form-group">
    <label for="status" class="col-sm-2 col-xs-12 control-label">状态</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="status" name="status" placeholder="状态" autocomplete="off" value="${dbDataDictionaryMap[entity.status] }" readonly="readonly"/>
    </div>
  </div>
  
  <div class="form-group">
    <label for="id" class="col-sm-2 col-xs-12 control-label">问题编号</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="id" name="id" placeholder="code" autocomplete="off" value="${entity.id }" readonly="readonly"/>
    </div>
  </div>

  <div class="form-group">
    <label for="title" class="col-sm-2 col-xs-12 control-label">标题</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="title" name="title" placeholder="标题" autocomplete="off" value="${entity.title }" readonly="readonly"/>
    </div>
  </div>
  
  <div class="form-group">
    <label for="createByUname" class="col-sm-2 col-xs-12 control-label">发布人</label>
    <div class="col-sm-4" id="createByUname">
    	<input type="text" class="form-control" id="createByUname" name="createByUname" placeholder="发布人" autocomplete="off" value="${entity.createByUname }" readonly="readonly"/>
    </div>
  </div>

  <div class="form-group">
  	<label class="col-sm-2 control-label" for="bugType">BUG类型</label>
  	<div class="col-sm-offset-0 col-sm-4">
  		<input type="text" class="form-control" id="bugType" name="bugType" placeholder="BUG类型" autocomplete="off" value="${entity.bugType }" readonly="readonly"/>
	</div>
  </div>
  
  <div class="form-group">
  	<label class="col-sm-2 control-label" for="version">系统版本</label>
  	<div class="col-sm-offset-0 col-sm-4">
  		<input type="text" class="form-control" id="version" name="version" placeholder="系统版本" autocomplete="off" value="${entity.version }" readonly="readonly"/>
	</div>
  </div>
  
  <div class="form-group">
  	<label class="col-sm-2 control-label" for="iosAuth">是否授权</label>
  	<div class="col-sm-offset-0 col-sm-4">
  		<input type="text" class="form-control" id="iosAuth" name="iosAuth" placeholder="是否授权" autocomplete="off" value="${entity.iosAuth }" readonly="readonly"/>
	</div>
  </div>
  
  <div class="form-group">
    <label for="mobileModel" class="col-sm-2 col-xs-12 control-label">手机型号</label>
    <div class="col-sm-4">
    	<input type="text" class="form-control" id="mobileModel" name="mobileModel" placeholder="手机型号" autocomplete="off" value="${entity.mobileModel }" readonly="readonly"/>
    </div>
  </div>
  
  <div class="form-group">
  	<label class="col-sm-2 control-label" for="appVersion">App版本</label>
  	<div class="col-sm-offset-0 col-sm-4">
  		<input type="text" class="form-control" id="appVersion" name="appVersion" placeholder="App版本" autocomplete="off" value="${entity.appVersion }" readonly="readonly"/>
	</div>
  </div>
  
  <div class="form-group">
    <label for="account" class="col-sm-2 col-xs-12 control-label">帐号</label>
    <div class="col-sm-4">
    	<input type="text" class="form-control" id="account" name="account" placeholder="帐号" autocomplete="off" value="${entity.account }" readonly="readonly"/>
    </div>
  </div>
  
  <div class="form-group">
  	<label class="col-sm-2 control-label" for="role">角色</label>
  	<div class="col-sm-offset-0 col-sm-4">
  		<input type="text" class="form-control" id="role" name="role" placeholder="角色" autocomplete="off" value="${entity.role }" readonly="readonly"/>
	</div>
  </div>
  
  <div class="form-group">
  	<label class="col-sm-2 control-label" for="rate">出现几率</label>
  	<div class="col-sm-offset-0 col-sm-4">
  		<input type="text" class="form-control" id="rate" name="rate" placeholder="出现几率" autocomplete="off" value="${entity.rate }" readonly="readonly"/>
	</div>
  </div>
  
  <div class="form-group">
    <label for="shantuiTime" class="col-sm-2 col-xs-12 control-label">闪退时间</label>
    <div class="col-sm-4">
    	<input type="text" class="form-control" id="shantuiTime" name="shantuiTime" placeholder="闪退时间" autocomplete="off" value="${entity.shantuiTime }" readonly="readonly"/>
    </div>
  </div>
 
  <div class="form-group">
    <label for="beforeShantui" class="col-sm-2 col-xs-12 control-label">闪退前操作</label>
    <div class="col-sm-4">
    	<input type="text" class="form-control" id="beforeShantui" name="beforeShantui" placeholder="闪退前操作" autocomplete="off" value="${entity.beforeShantui }" readonly="readonly"/>
    </div>
  </div>
  
  <div class="form-group">
    <label for="descripe" class="col-sm-2 col-xs-12 control-label">描述</label>
    <div class="col-sm-4" style="line-height: 40px;">
    	<span id="descripe"><pre>${entity.descripe }</pre></span>
    </div>
  </div>
  
  <c:if test="${!empty entity.videoUrl }">
	  <div class="form-group">
	    <label for="vedio" class="col-sm-2 col-xs-12 control-label">视频</label>
	    <div class="col-sm-4">
	    	<a href="${base }/uploads/vedio/${entity.videoUrl}">下载观看</a>
	    </div>
	  </div>
  </c:if>
  
  <c:if test="${!empty questionlImage }">
	  <div class="form-group">
	    <label for="img" class="col-sm-2 col-xs-12 control-label">图片预览</label>
	    	<c:forEach items="${questionlImage }" var="imgName">
		    	<div class="col-sm-2">
			    	<a href="${base }/uploads/img/${imgName}" target="_blank"><img alt="${imgName}" src="${base }/uploads/img/${imgName}" id="img" width="100px;" height="200px;"/></a>
			    </div>
	    	</c:forEach>
	  </div>
  </c:if>
  
  <c:if test="${entity.status != 'STATUS_UNPROCESS' }">
  	<div class="form-group">
	    <label for="answer" class="col-sm-2 col-xs-12 control-label">解决方案</label>
	    <div class="col-sm-4">
	    	<textarea class="form-control" rows="10" placeholder="解决方案"  name="answer" id="answer">${entity.answer }</textarea>
	    </div>
	  </div>
  </c:if>
  
  <c:if test="${!empty replyImage }">
	  <div class="form-group">
	    <label for="img" class="col-sm-2 col-xs-12 control-label">图片预览</label>
	    	<c:forEach items="${replyImage }" var="imgName">
		    	<div class="col-sm-2">
			    	<a href="${base }/uploads/img/${imgName}" target="_blank"><img alt="${imgName}" src="${base }/uploads/img/${imgName}" id="img" width="100px;" height="200px;"/></a>
			    </div>
	    	</c:forEach>
	  </div>
  </c:if>
  
  <div class="form-group">
    <label for="img" class="col-sm-2 col-xs-12 control-label">上传图片</label>
    <div class="col-sm-4">
    	<input id="lefile-2" type="file" style="display:none" name="imgFiles">
   			<input id="img-2"  name="imgFileTemp" class="form-control" type="text" onclick="$('input[id=lefile-2]').click();" readonly="readonly">
   			<a class="btn btn-info " onclick="$('input[id=lefile-2]').click();">选择图片</a>
    </div>
  </div>
  
  <div class="form-group">
    <label for="img" class="col-sm-2 col-xs-12 control-label">&nbsp;</label>
    <div class="col-sm-4">
    	<input id="lefile-3" type="file" style="display:none" name="imgFiles">
   			<input id="img-3"  name="imgFileTemp" class="form-control" type="text" onclick="$('input[id=lefile-3]').click();" readonly="readonly">
   			<a class="btn btn-info " onclick="$('input[id=lefile-3]').click();">选择图片</a>
    </div>
  </div>
  
  <div class="form-group">
    <label for="img" class="col-sm-2 col-xs-12 control-label">&nbsp;</label>
    <div class="col-sm-4">
    	<input id="lefile-4" type="file" style="display:none" name="imgFiles">
   			<input id="img-4"  name="imgFileTemp" class="form-control" type="text" onclick="$('input[id=lefile-4]').click();" readonly="readonly">
   			<a class="btn btn-info " onclick="$('input[id=lefile-4]').click();">选择图片</a>
    </div>
  </div>
  
  <div class="form-group">
    <label for="img" class="col-sm-2 col-xs-12 control-label">&nbsp;</label>
    <div class="col-sm-4">
    	<input id="lefile-5" type="file" style="display:none" name="imgFiles">
   			<input id="img-5"  name="imgFileTemp" class="form-control" type="text" onclick="$('input[id=lefile-5]').click();" readonly="readonly">
   			<a class="btn btn-info " onclick="$('input[id=lefile-5]').click();">选择图片</a>
    </div>
  </div>
  
  <div class="form-group">
    <label for="img" class="col-sm-2 col-xs-12 control-label">&nbsp;</label>
    <div class="col-sm-4">
    	<input id="lefile-6" type="file" style="display:none" name="imgFiles">
   			<input id="img-6"  name="imgFileTemp" class="form-control" type="text" onclick="$('input[id=lefile-6]').click();" readonly="readonly">
   			<a class="btn btn-info " onclick="$('input[id=lefile-6]').click();">选择图片</a>
    </div>
  </div>
  
  
  <div class="form-group" style="margin-top: 20px;margin-bottom: 20px;">
  	<c:if test="${entity.status == 'STATUS_UNPROCESS' }">
	    <div class="col-sm-offset-2 col-sm-2 col-xs-2">
	      <button type="button" class="btn btn-info col-xs-12" value="受理问题" onclick="window.location.href='${base}/manage/control/problem/processing.jhtml?id=${entity.id}'">受理问题</button>
	    </div>
    </c:if>
    <div class="<c:if test="${entity.status != 'STATUS_UNPROCESS' }">col-sm-offset-2 </c:if>col-sm-2 col-xs-2">
      <button type="submit" class="btn btn-info col-xs-12" value="解决问题">解决问题</button>
    </div>
  </div>
</form>
</div>
</body>
</html>