<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/share/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1.0" />
<title>美业邦WOS登录</title>
<link href="${base }/resources/css/bootstrap.css" rel="stylesheet">
<link href="${base }/resources/css/bootstrapValidator.min.css" rel="stylesheet">
<link href="${base }/resources/css/frontlogin.css" rel="stylesheet">
<script src="${base }/resources/js/jquery-1.10.2.min.js"></script>
<script src="${base }/resources/js/bootstrap.min.js"></script>
<script src="${base }/resources/js/bootstrapValidator.min.js"></script>
<script src="${base }/resources/js/zh_CN.js"></script>
<script type="text/javascript">
var message = "${message}";
if(message == "0") {
	alert("用户名或密码错误");
} else if(message == "1") {
	alert("用户不存在");
}

function changeImage(obj) {
	obj.src = "${base }/servlet/CheckCodeServlet?" + new Date().getTime();
}

$(document).ready(function() {
	$('#loginForm').bootstrapValidator({
		feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            username: {
                validators: {
                    notEmpty:  {
                    	message : "请输入用户名"
                    }
                }
            },
            password : {
                validators: {
                    notEmpty:  {
                    	message : "请输入密码"
                    }
                }
            },
            checkCode : {
                validators: {
                    notEmpty: {
                    	message : "请输入验证码"
                    },
                    remote : {
                    	url : "${base}/check.jhtml",
                    	message:"验证码错误"
                    }
                }
            }
        }
	});
});
</script>
</head>
<body>
	<div class="box">
		<div class="login-box">
			<div class="login-title text-center">
				<h1><small>美业邦WOS系统登录</small></h1>
			</div>
			<div class="login-content ">
			<div class="form">
			<form action="${base }/login.jhtml" method="post" id="loginForm">
				<div class="form-group">
					<div class="col-xs-12  ">
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
							<input type="text" id="username" name="username" class="form-control" placeholder="用户名" autocomplete="off"/>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-12  ">
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
							<input type="password" id="password" name="password" class="form-control" placeholder="密码" autocomplete="off"/>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-12  ">
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-question-sign"></span></span>
							<input type="text" id="checkCode" name="checkCode" class="col-sm-4 col-xs-4" placeholder="验证码" autocomplete="off" style="height: 40px;"/>
							<img alt="点击刷新验证码" src="${base }/servlet/CheckCodeServlet" style="border: 0px none; margin-left: 5px; height: 39px; display: inline-block;" onclick="changeImage(this)" class="col-sm-offset-5 col-xs-offset-1 col-xs-7">
						</div>
					</div>
				</div>
				<div class="form-group form-actions">
					<div class="col-xs-12">
						<button type="submit" class="btn btn-sm btn-info col-xs-12 col-sm-12"><span class="glyphicon glyphicon-off"></span> 登录</button>
					</div>
				</div>
				<!-- <div class="form-group">
					<div class="col-xs-12 link">
						<p class="text-center remove-margin"><small>忘记密码？</small> <a href="javascript:void(0)" ><small>找回密码</small></a>
						</p>
					</div>
				</div> -->
			</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>