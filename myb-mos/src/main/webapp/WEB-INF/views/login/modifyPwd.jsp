<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
<title>register</title> 
<meta name="keywords" content="网站模板下载,网站后台登录模板,后台登录模板HTML,后台模板登录,后台登录模板下载" />
<meta name="description" content="JS代码网提供大量的网站后台模板下载以及手机网站模板下载" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="../js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="../js/login/modify.js"></script>
<link href="../css/login/login2.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>modify<sup>V2016</sup></h1>

<div class="login" style="margin-top:50px;">
    
    <div class="header">
        <div class="switch" id="switch">
			<a class="switch_btn" id="switch_login" href="javascript:void(0);" tabindex="8">修改密码</a><div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 64px; left: 0px;"></div>
        </div>
    </div>    

  <!--修改-->
    <div class="qlogin" id="qlogin" >
   
    <div class="web_login">
    
    <form name="employee" id="regUser" accept-charset="utf-8"   method="post">
	      <input type="hidden" name="to" value="reg"/>
		      		       <input type="hidden" name="did" value="0"/>
        <ul class="reg_form" id="reg-ul">
        		<div id="userCue" class="cue">快速修改请注意格式</div>
                <li>
                	<input type="hidden" name="empId" value="${employee.empId}" >
                    <label for="user"  class="input-tips2">手机号：</label>
                    <div class="inputOuter2">
                        <input type="text" id="userName" name="userName" value="${employee.userName}" maxlength="11" class="inputstyle2" placeholder="请输入手机号" />
                    </div>
                    
                </li>
                
                <li>
                <label for="preferPwd" class="input-tips2">原密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="preferPwd"  name="preferPwd" maxlength="16"  class="inputstyle2"/>
                    </div>
                    
                </li>
                
                <li>
                <label for="passwd" class="input-tips2">新密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="passwd"  name="passWord" maxlength="16" placeholder="密码不能小于6位"  class="inputstyle2"/>
                    </div>
                    
                </li>
                
                <li>
                <label for="passwd2" class="input-tips2">确认密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="passwd2" name=""  maxlength="16" class="inputstyle2" placeholder="请输入确认密码"/>
                    </div>
                    
                </li>
                 <li>
                    <div class="inputArea">
                        <input type="button" id="reg"  style="margin-top:10px;margin-left:85px;" class="button_blue" value="修改密码"/> <a href="/myb-mos" class="zcxy" target="_blank">登录</a>
                    </div>
                    
                </li>
                <div class="cl"></div>
              </ul>
                
           </form>
          </div>
       </div>
    </div>
    <!--注册end-->
<div class="jianyi">*推荐使用ie8或以上版本ie浏览器或Chrome内核浏览器访问本站</div>
</body></html>