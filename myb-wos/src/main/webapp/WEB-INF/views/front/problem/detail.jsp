<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/share/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>查看问题</title>
<%@ include file="/WEB-INF/views/share/cssAndJs.jsp"%>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation"
		style="background-color: #3C7AAD;">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar" style="background-color: #3C7AAD;">
					<span class="sr-only">导航</span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="javascript:window.history.go(-1);" style="color: white;">
					<span class="glyphicon glyphicon-chevron-left"></span>
				</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<%@ include file="/WEB-INF/views/share/nav.jsp"%>
				</ul>
			</div>
		</div>
	</nav>

<div class="container">
 <div class="page-header col-sm-offset-2" >
     <h2>问题详情</h2>
 </div>
<form class="form-horizontal" id="addDomain" method="post" action="${base }/wos/problem/add.jhtml"  enctype="multipart/form-data">

  <div class="form-group">
    <label class="col-sm-2 col-xs-12 control-label">状态</label>
    <div class="col-sm-4" style="line-height: 40px;">
    	${dbDataDictionaryMap[entity.status] }
    </div>
  </div>

  <div class="form-group">
    <label for="code" class="col-sm-2 col-xs-12 control-label">问题编号</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="code" name="code" placeholder="code" autocomplete="off" value="${entity.id }" readonly="readonly"/>
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
  
  <c:if test="${entity.bugType == '闪退BUG' }">
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
  </c:if>
  
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
  	<label class="col-sm-2 control-label" for="role">角色</label>
  	<div class="col-sm-offset-0 col-sm-4">
  		<input type="text" class="form-control" id="role" name="role" placeholder="角色" autocomplete="off" value="${entity.role }" readonly="readonly"/>
	</div>
  </div>
  
  <div class="form-group">
    <label for="account" class="col-sm-2 col-xs-12 control-label">角色帐号</label>
    <div class="col-sm-4">
    	<input type="text" class="form-control" id="account" name="account" placeholder="角色帐号" autocomplete="off" value="${entity.account }" readonly="readonly"/>
    </div>
  </div>
  
  <div class="form-group">
  	<label class="col-sm-2 control-label" for="rate">出现几率</label>
  	<div class="col-sm-offset-0 col-sm-4">
  		<input type="text" class="form-control" id="rate" name="rate" placeholder="出现几率" autocomplete="off" value="${entity.rate }" readonly="readonly"/>
	</div>
  </div>
  
  <div class="form-group">
    <label for="descripe" class="col-sm-2 col-xs-12 control-label">描述</label>
    <div class="col-sm-4">
    	<span id="descripe" style="line-height: 40px;"><pre>${entity.descripe }</pre></span>
    </div>
  </div>
  
  <c:if test="${!empty imgNames }">
	  <div class="form-group">
	    <label for="img" class="col-sm-2 col-xs-12 control-label">图片预览</label>
	    <c:forEach items="${imgNames }" var="imgName">
	    	<div class="col-sm-2">
		    	<a href="${base }/uploads/img/${imgName}" target="_blank"><img alt="${imgName }" src="${base }/uploads/img/${imgName}" id="img" width="100px;" height="200px;"/></a>
		    </div>
	    </c:forEach>
	  </div>
  </c:if>
  
  <c:if test="${entity.status == 'STATUS_SUCCESS' }">
  	<c:if test="${!empty entity.answer }">
	  <div class="form-group">
	    <label for="answer" class="col-sm-2 col-xs-12 control-label">解决方案</label>
	    <div class="col-sm-4">
	    	<span id="answer" style="line-height: 40px;"><pre>${entity.answer }</pre></span>
	    </div>
	  </div>
	 </c:if>
  </c:if>
</form>
</div>
</body>
</html>