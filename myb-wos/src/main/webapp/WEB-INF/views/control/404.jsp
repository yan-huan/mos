<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/share/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>找不到你要访问的页面</title>
<%@ include file="/WEB-INF/views/share/cssAndJs.jsp"%>
<style type="text/css">
<!--
body {
	font-size: 13px;
	FILTER: progid:DXImageTransform.Microsoft.Gradient(gradientType=0,
		startColorStr=#dbebfa, endColorStr=#f9fcfd);
	margin: 0px;
}
-->
</style>
</head>

<body>
	<table border=0 cellpadding=0 cellspacing=0 width="100%" height="100%">
		<tr>
			<td align="center" style="padding-top: 60px;"><img
				src="${base }/resources/404/001.jpg" /></td>
		</tr>
		<tr>
			<form name=loading>
				<td align=center>
					<p>
						<font color=gray>55555，你找的页面不见了，请联系管理员。。。</font>
					</p>
					<p>
						<input type=text name=chart size=46
							style="font-family: Arial; font-weight: bolder; color: gray; background-color: white; padding: 0px; border-style: none;">
						<br> <input type=text name=percent size=46
							style="font-family: Arial; color: gray; text-align: center; border-width: medium; border-style: none;">
					</p>
				</td>
			</form>
		</tr>
	</table>
</body>
</html>