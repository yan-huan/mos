<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
<title>登录页面</title> 
<script src="../js/jquery-2.1.1.min.js" type="text/javascript"></script>
<link href="../css/login-style01.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="../js/jquery.cookie.js"></script>
<script type="text/javascript">

$(function(){
	$("#userName").focus();
	$.cookie('currentClick', '', { expires: -1 });
	 //回车提交事件
	$("body").keydown(function() {
	    if (event.keyCode == "13") {//keyCode=13是回车键
	    	login();
	    }
	});    
	
	//得到焦点
	$("#pwd").focus(function(){
		$("#left_hand").animate({
			left: "150",
			top: " -38"
		},{step: function(){
			if(parseInt($("#left_hand").css("left"))>140){
				$("#left_hand").attr("class","left_hand");
			}
		}}, 2000);
		$("#right_hand").animate({
			right: "-64",
			top: "-38px"
		},{step: function(){
			if(parseInt($("#right_hand").css("right"))> -70){
				$("#right_hand").attr("class","right_hand");
			}
		}}, 2000);
	});
	//失去焦点
	$("#pwd").blur(function(){
		$("#left_hand").attr("class","initial_left_hand");
		$("#left_hand").attr("style","left:100px;top:-12px;");
		$("#right_hand").attr("class","initial_right_hand");
		$("#right_hand").attr("style","right:-112px;top:-12px");
	});
	
	$("#login").click(function(){
		login();
	});
	
	
});

	function  login(){
		var userName = $("#userName").val();
		var passWord = $("#pwd").val();
		 
		$.ajax({
			url:"../login/index.jhtml",
			data:{"userName":userName, "passWord":passWord},
			type:"POST",
			dataType:"json",
			success:function(data){
				$.cookie('currentClick', '', { expires: -1 });
				if(data == "1") {
					$("#showErr").hide();
					window.location.href="../project/index.jhtml";
				}else if (data == "2"){
					$("#showErr").html("手机号或密码错误").show();
				}else if(data == "3"){
					$("#showErr").html("手机号或密码错误").show();
				}else{
					$("#showErr").html("登录失败").show();
				}
			},error:function(){
				$("#showErr").html("登录失败").show();
				
			}
			
		});
	} 
</script>
 
<meta name="GENERATOR" content="MSHTML 11.00.9600.17496"></head> 
<body>
<form action="login" method="post" >
	<div class="top_div"></div>
	<div style="background: rgb(255, 255, 255); margin: -100px auto auto; border: 1px solid rgb(231, 231, 231); border-image: none; width: 400px; height: 200px; text-align: center;">
		<div style="width: 165px; height: 96px; position: absolute;">
			<div class="tou"></div>
			<div class="initial_left_hand" id="left_hand"></div>
			<div class="initial_right_hand" id="right_hand"></div>
		</div>
		<p style="padding: 30px 0px 10px; position: relative;">
			<span class="u_logo"></span> <input class="ipt" id="userName" type="text" placeholder="请输入手机号" value="">
		</p>
		<p style="position: relative;">
			<span class="p_logo"></span> <input class="ipt" id="pwd" type="password" placeholder="请输入密码" value="">
		</p>
		<span id="showErr" style="display: none; color: red">手机号或密码错误</span>
		<div
			style="height: 50px; line-height: 50px; margin-top: 30px; border-top-color: rgb(231, 231, 231); border-top-width: 1px; border-top-style: solid;">
			<p style="margin: 0px 35px 20px 45px;">
				<span style="float: right;">
					<a id="login" style="background: rgb(0, 142, 173); padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;"
					href="#">登录</a>
				</span>
			</p>
		</div>
	</div>
	<div style="text-align: center;"></div>

	</form>
</body>
</html>