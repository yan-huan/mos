<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
<title>register</title> 
<meta name="keywords" content="网站模板下载,网站后台登录模板,后台登录模板HTML,后台模板登录,后台登录模板下载" />
<meta name="description" content="JS代码网提供大量的网站后台模板下载以及手机网站模板下载" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link href="../css/login/login2.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="../js/login/login.js"></script>
		<script type="text/javascript" src="../js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../js/bootstrap/bootstrap-datetimepicker.js" charset="UTF-8"></script>
		<script type="text/javascript" src="../js/bootstrap/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>

		<link href="../css/bootstrap.min.css" rel="stylesheet">
		<link href="../css/back-style.css" rel="stylesheet">
		<link href="../css/dashboard.css" rel="stylesheet">
    	<link href="../css/bootstrap/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
</head>
<body>
<h1>register<sup>V2016</sup></h1>

<div class="login" style="margin-top:50px;">
    
    <div class="header">
        <div class="switch" id="switch">
			<a class="switch_btn" id="switch_login" href="javascript:void(0);" tabindex="8">快速注册</a><div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 64px; left: 0px;"></div>
        </div>
    </div>    

  <!--注册-->
    <div class="qlogin" id="qlogin" >
   
    <div class="web_login">
    
    <form name="employeeVO" id="regUser" accept-charset="utf-8"   method="post">
	      <input type="hidden" name="to" value="reg"/>
		      		       <input type="hidden" name="did" value="0"/>
        <ul class="reg_form" id="reg-ul">
        		<div id="userCue" class="cue">快速注册请注意格式</div>
                <li>
                	
                    <label for="user"  class="input-tips2">手机号：</label>
                    <div class="inputOuter2">
                        <input type="text" id="user" name="userName" maxlength="11" class="inputstyle2" placeholder="请输入手机号" />
                    </div>
                    
                </li>
                
                <li>
                <label for="passwd" class="input-tips2">密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="passwd"  name="passWord" maxlength="16" placeholder="密码不能小于6位"  class="inputstyle2"/>
                    </div>
                    
                </li>
                <li>
                <label for="passwd2" class="input-tips2">确认密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="passwd2" name="" maxlength="16" class="inputstyle2" placeholder="请输入确认密码"/>
                    </div>
                </li>
                
                <li>
                 <label for="qq" class="input-tips2">真实姓名：</label>
                    <div class="inputOuter2">
                        <input type="text" id="realName" name="empName" maxlength="10" class="inputstyle2" placeholder="真实姓名"/>
                    </div>
                </li>
                
                <li>
                 <label for="qq" class="input-tips2">入职时间：</label>
                    <div class="inputOuter2">
                        <input type="text"  class="form_datetime form-control" name="entryTime" id="entryTime"/>
                    </div>
                </li>
                
                <li>
                 <label for="qq" class="input-tips2">QQ：</label>
                    <div class="inputOuter2">
                       
                        <input type="text" id="qq" name="qq" maxlength="10" class="inputstyle2" placeholder="请输入QQ"/>
                    </div>
                   
                </li>
                
                <li>
                    <div class="inputArea">
                        <input type="button" id="reg"  style="margin-top:10px;margin-left:85px;" class="button_blue" value="同意协议并注册"/> <a href="/myb-mos" class="zcxy" target="_blank">登录</a>
                    </div>
                    
                </li><div class="cl"></div>
            </ul>
           </form>
      </div>
     </div>
     <!--注册end-->
    </div>
   <div class="jianyi">*推荐使用ie8或以上版本ie浏览器或Chrome内核浏览器访问本站</div>
   <script src="../js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../js/bootstrap/bootstrap-datetimepicker.js" charset="UTF-8"></script>
		<script type="text/javascript" src="../js/bootstrap/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
   <script type="text/javascript">
	   $('.form_datetime').datetimepicker({
		 	minView: 'month',     //设置时间选择为年月日 去掉时分秒选择
	       format:'yyyy-mm-dd',
	       weekStart: 1,
	       todayBtn:  1,
	       autoclose: 1,
	       todayHighlight: 1,
	       startView: 2,
	       forceParse: 0,
	       showMeridian: 1,
	       language: 'zh-CN'    //设置时间控件为中文
	   });
   </script>
 </body>
</html>