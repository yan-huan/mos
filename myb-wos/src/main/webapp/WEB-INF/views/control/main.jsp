<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/share/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>美业邦WOS后台管理系统</title>
<%@ include file="/WEB-INF/views/share/cssAndJs.jsp"%>
</head>
<frameset rows="79,*" cols="*" frameborder="no" border="0"
	framespacing="0">
	<frame src="${base }/manage/control/top.jhtml" name="topFrame" scrolling="No" noresize="noresize"
		id="topFrame" />
	<frameset cols="300,*" frameborder="no" border="0" framespacing="0">
		<frame src="${base }/manage/control/left.jhtml" name="leftFrame" scrolling="No" noresize="noresize"
			id="leftFrame"/>
		<frame src="${base }/manage/control/right.jhtml" name="mainFrame" id="mainFrame" />
	</frameset>
</frameset>
</html>