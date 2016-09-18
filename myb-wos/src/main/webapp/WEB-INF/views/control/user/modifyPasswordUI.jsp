<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/share/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>修改密码</title>
<%@ include file="/WEB-INF/views/share/cssAndJs.jsp"%>
<script type="text/javascript">
var message = "${message}";
if(message == "1") {
	alert("修改密码成功。");
}
if(message == "0") {
	alert("原始密码不正确。");
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
        	
        	 oldPassword: {
                 validators: {
                     notEmpty: true,
                     different: {
                         field: 'newPassword',
                         message: '用户名和密码不能相同'
                     }
                 }
             },
             
             confirmNewPassword: {
               	 validators: {
                        notEmpty:true,
                         identical: {
                             field: 'newPassword',
                             message: '输入的两次密码不一致'
                         },
                         different: {
                             field: 'oldPassword',
                             message: '用户名和确认密码不能相同'
                         }
                    }
               },
               
               newPassword : {
            	   validators: {
                       notEmpty:true,
                        identical: {
                            field: 'confirmNewPassword',
                            message: '输入的两次密码不一致'
                        },
                        different: {
                            field: 'oldPassword',
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
<div class="container">
 <div class="page-header col-sm-offset-2" >
     <h2>修改密码</h2>
 </div>
<form class="form-horizontal" id="addDomain" method="post" action="${base }/manage/control/user/modifypwd.jhtml" >
  
  <div class="form-group">
    <label for="oldPassword" class="col-sm-2 control-label">原始密码</label>
    <div class="col-sm-4">
      <input type="password" class="form-control" id="oldPassword" name="oldPassword" placeholder="原始密码" autocomplete="off"/>
    </div>
  </div>
  
  <div class="form-group">
    <label for="newPassword" class="col-sm-2 control-label">新密码</label>
    <div class="col-sm-4">
      <input type="password" class="form-control" id="newPassword" name="newPassword" placeholder="新密码" autocomplete="off"/>
    </div>
  </div>
  <div class="form-group">
    <label for="confirmNewPassword" class="col-sm-2 control-label">确认新密码</label>
    <div class="col-sm-4">
      <input type="password" class="form-control" id="confirmNewPassword" name="confirmNewPassword" placeholder="确认新密码" autocomplete="off"/>
    </div>
  </div>
  
	  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-info" value="保存信息">更新密码</button>
    </div>
  </div>
</form>
</div>
</body>
</html>