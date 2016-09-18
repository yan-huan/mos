<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/share/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>更新用户</title>
<%@ include file="/WEB-INF/views/share/cssAndJs.jsp"%>
<script type="text/javascript">
var message = "${message}";
if(message == "1") {
	alert("信息修改成功。");
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
        	
              uname: {
               	 validators: {
                        notEmpty:true
                    }
               }
            
        }
    });
});
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
     <h2>修改资料</h2>
 </div>
<form class="form-horizontal" id="addDomain" method="post" action="${base }/wos/user/edit.jhtml" >
	<input type="hidden" name="id" value="${user.id }"/>
  <div class="form-group">
    <label for="username" class="col-sm-2 control-label">用户名</label>
    <div class="col-sm-4">
    	<input type="text" class="form-control" autocomplete="off" value="${user.username }" disabled="disabled"/>
    </div>
  </div>
  
  <div class="form-group">
    <label for="uname" class="col-sm-2 control-label">姓&nbsp;&nbsp;名</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="uname" name="uname" placeholder="姓名" autocomplete="off" value="${user.uname }"/>
    </div>
  </div>
  
  <div class="form-group">
    <label for="mobile" class="col-sm-2 control-label">手机号</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="mobile" name="mobile" placeholder="手机号" autocomplete="off" value="${user.mobile }"/>
    </div>
  </div>
  
  <div class="form-group">
    <label for="email" class="col-sm-2 control-label">邮&nbsp;&nbsp;箱</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="email" name="email" placeholder="邮箱" autocomplete="off" value="${user.email }"/>
    </div>
  </div>
  
  <div class="form-group">
    <label for="weixin" class="col-sm-2 control-label">微&nbsp;&nbsp;信</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="weixin" name="weixin" placeholder="微信" autocomplete="off" value="${user.weixin }"/>
    </div>
  </div>
  
  <div class="form-group">
    <label for="qq" class="col-sm-2 control-label">QQ</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="qq" name="qq" placeholder="QQ" autocomplete="off" value="${user.qq }"/>
    </div>
  </div>
  
  <div class="form-group">
    <label for="department" class="col-sm-2 control-label">部&nbsp;&nbsp;门</label>
    <div class="col-sm-4">
    	<select name="department" class="form-control" id="department" >
    		<option value=""></option>
	    	<c:if test="${!empty departments }">
	    		<c:forEach items="${departments }" var="depart">
	    			<option value="${depart.id }"<c:if test="${user.department == depart.id }"> selected="selected"</c:if>>${depart.name }</option>
	    		</c:forEach>
	    	</c:if>
		</select>
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-info" value="保存信息">更新信息</button>
    </div>
  </div>
</form>
</div>
</body>
</html>