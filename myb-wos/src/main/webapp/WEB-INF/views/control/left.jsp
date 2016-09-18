<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/share/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>左侧菜单</title>
<link href="${base }/resources/css/style.css" rel="stylesheet" />
<script type="text/javascript"
	src="${base }/resources/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${base }/resources/js/menu.js"></script>
</head>
<body>
	<div class="left_menu">
		<ul id="nav_dot">
			<li>
				<h4 class="M1">
					<span></span>全局设置
				</h4>
				<div class="list-item none">
					<a href='${base }/manage/control/dictionary/list.jhtml' target="mainFrame">数据字典</a>
					<a href='${base }/manage/control/user/list.jhtml' target="mainFrame">用户管理</a>
				</div>
			</li>
			
			<li>
				<h4 class="M1">
					<span></span>问题中心
				</h4>
				<div class="list-item none">
					<a href='${base }/manage/control/problem/list.jhtml' target="mainFrame">问题列表</a>
				</div>
			</li>
		</ul>
	</div>
	<script>
		navList(12);
	</script
</body>
</html>