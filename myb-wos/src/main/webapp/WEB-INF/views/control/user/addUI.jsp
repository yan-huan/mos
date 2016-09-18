<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/share/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>新增用户</title>
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
        	
            username: {
                validators: {
                    notEmpty: true,
                    regexp: {
                        regexp: /^[a-zA-Z0-9_\.\-]+$/,
                        message: '用户名只能包含字母、数字、下划线和"-"号'
                    },
                    remote: {
                    	url : '${base}/manage/control/user/checkUsername.jhtml'
                    }
                }
            },
            
            password: {
                validators: {
                    notEmpty: true,
                    different: {
                        field: 'username',
                        message: '用户名和密码不能相同'
                    }
                }
            },
            
            confirmpassword: {
              	 validators: {
                       notEmpty:true,
                        identical: {
                            field: 'password',
                            message: '输入的两次密码不一致'
                        },
                        different: {
                            field: 'username',
                            message: '用户名和确认密码不能相同'
                        }
                   }
              }
            
        }
    });
});
</script>
</head>
<body>
 <div class="page-header col-sm-offset-2" >
     <h2>新增用户</h2>
 </div>
<form class="form-horizontal" id="addDomain" method="post" action="${base }/manage/control/user/add.jhtml" >

  <div class="form-group">
    <label for="username" class="col-sm-2 control-label">用户名</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="username" name="username" placeholder="用户名" autocomplete="off"/>
    </div>
  </div>
  
  <div class="form-group">
    <label for="password" class="col-sm-2 control-label">密&nbsp;&nbsp;码</label>
    <div class="col-sm-4">
      <input type="password" class="form-control" id="password" name="password" placeholder="密码" autocomplete="off"/>
    </div>
  </div>
  <div class="form-group">
    <label for="confirmpassword" class="col-sm-2 control-label">确认密码</label>
    <div class="col-sm-4">
      <input type="password" class="form-control" id="confirmpassword" name="confirmpassword" placeholder="确认密码" autocomplete="off"/>
    </div>
  </div>
  
  <div class="form-group">
    <label for="uname" class="col-sm-2 control-label">姓&nbsp;&nbsp;名</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="uname" name="uname" placeholder="姓名" autocomplete="off"/>
    </div>
  </div>
  
  <div class="form-group">
    <label for="mobile" class="col-sm-2 control-label">手机号</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="mobile" name="mobile" placeholder="手机号" autocomplete="off"/>
    </div>
  </div>
  
  <div class="form-group">
    <label for="email" class="col-sm-2 control-label">邮&nbsp;&nbsp;箱</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="email" name="email" placeholder="邮箱" autocomplete="off"/>
    </div>
  </div>
  
  <div class="form-group">
    <label for="weixin" class="col-sm-2 control-label">微&nbsp;&nbsp;信</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="weixin" name="weixin" placeholder="微信" autocomplete="off"/>
    </div>
  </div>
  
  <div class="form-group">
    <label for="qq" class="col-sm-2 control-label">QQ</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="qq" name="qq" placeholder="QQ" autocomplete="off"/>
    </div>
  </div>
  
  <div class="form-group">
    <label for="department" class="col-sm-2 control-label">部&nbsp;&nbsp;门</label>
    <div class="col-sm-4">
    	<select name="department" class="form-control" id="department" >
    		<option value=""></option>
	    	<c:if test="${!empty departments }">
	    		<c:forEach items="${departments }" var="depart">
	    			<option value="${depart.id }">${depart.name }</option>
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
			<option value="0">普通用户</option>
			<option value="1">管理员</option>
		</select>
	</div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-info" value="保存信息">保存信息</button>
    </div>
  </div>
</form>
</body>
</html>