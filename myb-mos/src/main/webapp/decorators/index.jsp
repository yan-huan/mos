<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<html lang="en">
	
<head>
<title><decorator:title/></title>
<decorator:head/>
<link href="../css/bootstrap.min.css" rel="stylesheet">
	<link href="../css/back-style.css" rel="stylesheet">
	<link href="../css/dashboard.css" rel="stylesheet">
	<link rel="stylesheet" href="../css/autocomplete/autocomplete.css">
	<link rel="stylesheet" href="../css/autocomplete/style.css">
	<script type="text/javascript" src="../js/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="../js/jquery.cookie.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../js/autocomplete/jquery.js"></script>
	<script type="text/javascript" src="../js/autocomplete/autocomplete.js"></script>
</head>

<body <decorator:getProperty property="body.id" writeEntireProperty="true"/><decorator:getProperty property="body.class" writeEntireProperty="true"/>>
		<div class="fakeloader"></div>
				
		<div class="container">
			<div class="row">
				<div class="col-lg-offset-2 col-md-10 main">
					<h3>欢迎使用美业邦MOS系统</h3><a href="../utils/lanren.jhtml">观赏图片</a>
					<hr>
				</div>
			</div>
<!-- 			<embed pluginspage="http://www.macromedia.com/go/getflashplayer"  menu="true" loop="true" play="true" type="application/x-shockwave-flash" width="100%" height="450px" src="http://mybmoss.oss-cn-shanghai.aliyuncs.com/2016%E5%B9%B407%E6%9C%8807%E6%97%A5%20/ccc.gif"></embed> -->
		</div>
	</section>
<jsp:include page="header.jsp" />

<decorator:body/>
<!-- footer star-->
<jsp:include page="headerNext.jsp" />
<!-- footer end--> 
</body>
</html>

