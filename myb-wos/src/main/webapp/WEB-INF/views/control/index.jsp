<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/share/taglib.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>美业邦WOS后台登录界面</title>
<%@ include file="/WEB-INF/views/share/cssAndJs.jsp"%>
<link href="${base }/resources/css/signin.css" rel="stylesheet">
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
	<div class="signin">
	<div class="signin-head"><img src="${base }/resources/images/test/head_120.png" alt="" class="img-circle"></div>
	<form class="form-signin form-horizontal" role="form" action="${base }/manage/login.jhtml" id="loginForm" method="post">
		<input type="hidden" name="domainId" value="${domain.id }"/>
		<div class="form-group">
			<input class="form-control" placeholder="用户名" autofocus="" name="username" id="username" type="text" value="${userDto.username }" autocomplete="off">
		</div>
		<div class="form-group">
			<input class="form-control" placeholder="密码" name="password" type="password" id="password">
		</div>
		<div class="form-group">
			<input class="col-sm-2 form-control" placeholder="验证码" name="checkCode" id="checkCode" style="width: 100px; display: inline-block;border-radius:0px;" type="text" autocomplete="off">
			<img alt="点击刷新验证码" src="${base }/servlet/CheckCodeServlet" style="border: 0px none; margin-left: 5px; height: 43px; width: 223px; display: inline-block;" onclick="changeImage(this)" class="col-sm-offset-5">
		</div>
		<div class="form-group">
			<button style="margin-top: 10px;height: 44px;" class="btn btn-primary btn-block" type="submit">登录</button>
		</div>
	</form>
</div>

<div style="text-align:center;">
	<p style="font-size: 12px;">来源:美业邦</p>
</div>
</body>
</html>