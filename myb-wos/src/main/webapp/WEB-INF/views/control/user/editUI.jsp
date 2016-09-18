<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/share/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>更新用户</title>
<%@ include file="/WEB-INF/views/share/cssAndJs.jsp"%>
<script type="text/javascript">
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
 <div class="page-header col-sm-offset-2" >
     <h2>更新用户</h2>
 </div>
<form class="form-horizontal" id="addDomain" method="post" action="${base }/manage/control/user/edit.jhtml" >
	<input type="hidden" name="id" value="${entity.id }"/>
  <div class="form-group">
    <label for="username" class="col-sm-2 control-label">用户名</label>
    <div class="col-sm-4">
    	<input type="text" class="form-control" autocomplete="off" value="${entity.username }" disabled="disabled"/>
    </div>
  </div>
  
  <div class="form-group">
    <label for="uname" class="col-sm-2 control-label">姓&nbsp;&nbsp;名</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="uname" name="uname" placeholder="姓名" autocomplete="off" value="${entity.uname }"/>
    </div>
  </div>
  
  <div class="form-group">
    <label for="mobile" class="col-sm-2 control-label">手机号</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="mobile" name="mobile" placeholder="手机号" autocomplete="off" value="${entity.mobile }"/>
    </div>
  </div>
  
  <div class="form-group">
    <label for="email" class="col-sm-2 control-label">邮&nbsp;&nbsp;箱</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="email" name="email" placeholder="邮箱" autocomplete="off" value="${entity.email }"/>
    </div>
  </div>
  
  <div class="form-group">
    <label for="weixin" class="col-sm-2 control-label">微&nbsp;&nbsp;信</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="weixin" name="weixin" placeholder="微信" autocomplete="off" value="${entity.weixin }"/>
    </div>
  </div>
  
  <div class="form-group">
    <label for="qq" class="col-sm-2 control-label">QQ</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="qq" name="qq" placeholder="QQ" autocomplete="off" value="${entity.qq }"/>
    </div>
  </div>
  
  <div class="form-group">
    <label for="department" class="col-sm-2 control-label">部&nbsp;&nbsp;门</label>
    <div class="col-sm-4">
    	<select name="department" class="form-control" id="department" >
    		<option value=""></option>
	    	<c:if test="${!empty departments }">
	    		<c:forEach items="${departments }" var="depart">
	    			<option value="${depart.id }"<c:if test="${entity.department == depart.id }"> selected="selected"</c:if>>${depart.name }</option>
	    		</c:forEach>
	    	</c:if>
		</select>
		<a href="${base }/manage/control/dictionary/list.jhtml?tp=5">添加部门</a>
    </div>
  </div>
  
  <div class="form-group">
    <label for="administrator" class="col-sm-2 control-label">用户类型</label>
    <div class="col-sm-4">
	    <select name="administrator" class="form-control" id="administrator"  style="width: 150px;">
			<option value="0"<c:if test="${entity.administrator == 0 }"> selected="selected"</c:if>>普通用户</option>
			<option value="1"<c:if test="${entity.administrator == 1 }"> selected="selected"</c:if>>管理员</option>
		</select>
	</div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-info" value="保存信息">更新信息</button>
    </div>
  </div>
</form>
</body>
</html>