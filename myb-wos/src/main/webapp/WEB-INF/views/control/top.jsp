<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/share/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>顶部</title>
<%@ include file="/WEB-INF/views/share/cssAndJs.jsp"%>
<link href="${base }/resources/css/style.css" rel="stylesheet"/>
</head>
<body>
	<div id="header">
		<div class="logo">美业邦WOS后台管理系统</div>
		<div class="navigation">
			<ul>
				<li>欢迎您！</li>
				<li><c:if test="${!empty user.uname }"><a href="${base }/manage/control/user/editUI.jhtml?id=${user.id}" target="mainFrame">${user.uname }</a></c:if></li>
				<li><a href="${base }/manage/control/user/modifyPasswordUI.jhtml" target="mainFrame">修改密码</a></li>
				<li><a href="${base }/manage/control/user/logout.jhtml">退出</a></li>
			</ul>
		</div>
	</div>
</body>
</html>