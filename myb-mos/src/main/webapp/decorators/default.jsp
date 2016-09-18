<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<html lang="en">
<head>
<title><decorator:title/></title>
<decorator:head/>
	<link rel="shortcut icon" href="../images/M.png?v20160826" />  
	<link href="../css/bootstrap.min.css?v20160826" rel="stylesheet">
	<link href="../css/back-style.css?v20160826" rel="stylesheet">
	<link href="../css/dashboard.css?v20160826" rel="stylesheet">
	<link rel="stylesheet" href="../css/autocomplete/autocomplete.css?v20160826">
	<link rel="stylesheet" href="../css/autocomplete/style.css?v20160826">
	<link rel="stylesheet" href="../css/jDialog/jDialog.css?v20160826">
<!-- 	<link rel="stylesheet" href="../css/loading/fakeLoader.css"> -->
	
	<script type="text/javascript" src="../js/jquery-2.1.1.min.js?v20160826"></script>
	<script type="text/javascript" src="../js/jquery.cookie.js?v20160826"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js?v20160826"></script>
	<script type="text/javascript" src="../js/autocomplete/jquery.js?v20160826"></script>
	<script type="text/javascript" src="../js/autocomplete/autocomplete.js?v20160826"></script>
	<script type="text/javascript" src="../js/jDialog/jDialog.js?v20160826"></script>
	<script type="text/javascript" src="../js/jDialog/jDialog/jquery.dialog.js?v20160826"></script>
	<script type="text/javascript" src="../js/jDialog/jDialog/jquery.drag.js?v20160826"></script>
	<script type="text/javascript" src="../js/jDialog/jDialog/jquery.mask.js?v20160826"></script>
	 
</head>

<body <decorator:getProperty property="body.id" writeEntireProperty="true"/><decorator:getProperty property="body.class" writeEntireProperty="true"/>>
 	
<jsp:include page="header.jsp" />

<decorator:body/>
<!-- footer star-->
<jsp:include page="headerNext.jsp" />
<!-- footer end--> 
<script type="text/javascript" src="../js/jquery.cookie.js?v20160826"></script>
<!-- <script src="../js/loading/fakeLoader.min.js"></script> -->
<script type="text/javascript">
				
			
				$(function(){
					var currentClick =$.cookie('currentClick');
					if(currentClick != null){
						console.info("点击后重新加载样式");
						$("#"+currentClick).attr("class","active");
						$("#"+currentClick).parent().addClass("in");
					}
					$("ul li").click(function(){
						$.cookie('currentClick', '', { expires: -1 });
						console.info("点击"+$(this).attr("id"));
						$("ul li").removeClass("active");
						$(this).parent().parent().removeClass("in");
						$(this).addClass("active");
						$.cookie('currentClick', $(this).attr("id"));
					});
					
					/* $(".fakeloader").fakeLoader({
						zIndex:999, 
		                timeToHide:800,
		                bgColor:"rgba(0,0,0,0.5)",
		                spinner:"spinner1" //可选值 'spinner1', 'spinner2', 'spinner3', 'spinner4', 'spinner5', 'spinner6', 'spinner7' 对应有7种效果
		            }); */
				});
			
		</script>
</body>
</html>

