<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/share/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>提交问题</title>
<%@ include file="/WEB-INF/views/share/cssAndJs.jsp"%>
<script type="text/javascript">
var uploadMessage = "${uploadMessage}"
	if(uploadMessage == "1") {
		alert("视频格式不正确");
	}
	if(uploadMessage == "2") {
		alert("图片格式不正确");
	}

$(document).ready(function() {
    $('form').bootstrapValidator({
    	live: 'disabled',
    	feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	
        	title: {
                validators: {
                    notEmpty: true
                }
            },
        
            bugType: {
                validators: {
                    notEmpty: true
                }
            },
        
            version: {
                validators: {
                    notEmpty: true
                }
            },
            
            account: {
                validators: {
                    notEmpty: true
                }
            },
        
            iosAuth: {
                validators: {
                    notEmpty: true
                }
            },
        
            mobileModel: {
                validators: {
                    notEmpty: true
                }
            },
        
            appVersion: {
                validators: {
                    notEmpty: true
                }
            },
        
            role: {
                validators: {
                    notEmpty: true
                }
            },
        
            rate: {
                validators: {
                    notEmpty: true
                }
            },
        
            shantuiTime: {
                validators: {
                    notEmpty: true
                }
            },
        
            beforeShantui: {
                validators: {
                    notEmpty: true
                }
            },
        
            descripe: {
                validators: {
                    notEmpty: true
                }
            }
        
        }
    });
    
    $('input[id=lefile-1]').change(function() {
    	$('#vedio').val($(this).val());
    });
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

function showDetail(obj) {
	var val = obj.value;
	if(val == "闪退BUG") {
		$("#shantuiTimeId").show();
		$("#beforeShantuiId").show();
	} else {
		$("#shantuiTimeId").hide();
		$("#beforeShantuiId").hide();
	}
}
</script>
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
     <h2>提交问题</h2>
 </div>
<form class="form-horizontal" id="addDomain" method="post" action="${base }/wos/problem/add.jhtml"  enctype="multipart/form-data">

  <div class="form-group">
    <label for="title" class="col-sm-2 col-xs-12 control-label">标题</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="title" name="title" placeholder="标题" autocomplete="off" value="${entity.title }"/>
    </div>
  </div>

  <div class="form-group">
  	<label class="col-sm-2 control-label" for="bugType">BUG类型</label>
  	<div class="col-sm-offset-0 col-sm-4">
		<select name="bugType" class="form-control" id="bugType" onchange="showDetail(this);">
			<option value=""></option>
			<c:if test="${!empty bugTypes }">
				<c:forEach items="${bugTypes }" var="bugType">
					<option value="${bugType.name }"<c:if test="${entity.bugType ==  bugType.name}"> selected="selected"</c:if>>${bugType.name }</option>
				</c:forEach>
			</c:if>
		</select>
	</div>
  </div>
  
  <div class="form-group" style="display: none;" id="shantuiTimeId">
    <label for="shantuiTime" class="col-sm-2 col-xs-12 control-label">闪退时间</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="shantuiTime" name="shantuiTime" placeholder="闪退时间" autocomplete="off" value="${entity.shantuiTime }"/>
    </div>
  </div>
 
  <div class="form-group" style="display: none;" id="beforeShantuiId">
    <label for="beforeShantui" class="col-sm-2 col-xs-12 control-label">闪退前操作</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="beforeShantui" name="beforeShantui" placeholder="闪退前操作" autocomplete="off" value="${entity.beforeShantui }"/>
    </div>
  </div>
  
  <div class="form-group">
  	<label class="col-sm-2 control-label" for="version">系统版本</label>
  	<div class="col-sm-offset-0 col-sm-4">
		<select name="version" class="form-control" id="version">
			<option value=""></option>
			<c:if test="${!empty systemVersions }">
				<c:forEach items="${systemVersions }" var="systemVersion">
					<option value="${systemVersion.name }"<c:if test="${entity.version ==  systemVersion.name}"> selected="selected"</c:if>>${systemVersion.name }</option>
				</c:forEach>
			</c:if>
		</select>
	</div>
  </div>
  
  <div class="form-group">
  	<label class="col-sm-2 control-label" for="iosAuth">是否授权</label>
  	<div class="col-sm-offset-0 col-sm-4">
		<select name="iosAuth" class="form-control" id="iosAuth">
			<option value=""></option>
			<c:if test="${!empty isoAuths }">
				<c:forEach items="${isoAuths }" var="isoAuth">
					<option value="${isoAuth.name }"<c:if test="${entity.iosAuth ==  isoAuth.name}"> selected="selected"</c:if>>${isoAuth.name }</option>
				</c:forEach>
			</c:if>
		</select>
	</div>
  </div>
  
  <div class="form-group">
    <label for="mobileModel" class="col-sm-2 col-xs-12 control-label">手机型号</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="mobileModel" name="mobileModel" placeholder="手机型号" autocomplete="off" value="${entity.mobileModel }"/>
    </div>
  </div>
  
  <div class="form-group">
  	<label class="col-sm-2 control-label" for="appVersion">App版本</label>
  	<div class="col-sm-offset-0 col-sm-4">
		<select name="appVersion" class="form-control" id="appVersion">
			<option value=""></option>
			<c:if test="${!empty appVersions }">
				<c:forEach items="${appVersions }" var="appVersion">
					<option value="${appVersion.name }"<c:if test="${entity.appVersion ==  appVersion.name}"> selected="selected"</c:if>>${appVersion.name }</option>
				</c:forEach>
			</c:if>
		</select>
	</div>
  </div>
  
  <div class="form-group">
  	<label class="col-sm-2 control-label" for="role">角色</label>
  	<div class="col-sm-offset-0 col-sm-4">
		<select name="role" class="form-control" id="role">
			<option value=""></option>
			<c:if test="${!empty roles }">
				<c:forEach items="${roles }" var="role">
					<option value="${role.name }"<c:if test="${entity.role ==  role.name}"> selected="selected"</c:if>>${role.name }</option>
				</c:forEach>
			</c:if>
		</select>
	</div>
  </div>
  
  <div class="form-group">
    <label for="account" class="col-sm-2 col-xs-12 control-label">角色帐号</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="account" name="account" placeholder="角色帐号" autocomplete="off" value="${entity.account }"/>
    </div>
  </div>
  
  <div class="form-group">
  	<label class="col-sm-2 control-label" for="rate">出现几率</label>
  	<div class="col-sm-offset-0 col-sm-4">
		<select name="rate" class="form-control" id="rate">
			<option value=""></option>
			<c:if test="${!empty rates }">
				<c:forEach items="${rates }" var="rate">
					<option value="${rate.name }"<c:if test="${entity.rate ==  rate.name}"> selected="selected"</c:if>>${rate.name }</option>
				</c:forEach>
			</c:if>
		</select>
	</div>
  </div>
  
  <div class="form-group">
    <label for="descripe" class="col-sm-2 col-xs-12 control-label">描述</label>
    <div class="col-sm-4">
    	<textarea class="form-control" rows="10" placeholder="描述"  name="descripe" id="descripe">${entity.descripe }</textarea>
    </div>
  </div>
  
  <div class="form-group">
    <label for="vedio" class="col-sm-2 col-xs-12 control-label">上传视频</label>
    <div class="col-sm-4">
    	<input id="lefile-1" type="file" style="display:none" name="vedioFile">
   			<input id="vedio"  name="vedioFileTemp"  class="form-control" type="text" onclick="$('input[id=lefile-1]').click();" readonly="readonly">
   			<a class="btn btn-info" onclick="$('input[id=lefile-1]').click();">选择视频</a>
    </div>
  </div>
  
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
    <div class="col-sm-offset-2 col-sm-4 col-xs-12">
      <button type="submit" class="btn btn-info col-xs-12" value="提交问题">提交问题</button>
    </div>
  </div>
</form>
</div>
</body>
</html>