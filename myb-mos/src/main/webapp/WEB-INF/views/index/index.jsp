<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<!-- Bootstrap -->
	<!-- 	<link href="../css/bootstrap.min.css" rel="stylesheet">
		<link href="../css/back-style.css" rel="stylesheet">
		<link href="../css/dashboard.css" rel="stylesheet">
		<script src="../js/jquery-2.1.1.min.js"></script>
		 -->
		<script type="text/javascript">
			$(function(){
				//首页的显示当前用户的权限
				$.ajax({
	    				type:"POST",
	    				dataType:"json",
	    				url:"../role/roleList.jhtml",
	    				success:function(data){
	    					console.info(data);
	    					if (data != "0"){
	    						if (data.length <= 0){
	    							console.info("空内容");
	    						}else {
	    							var str = "";
	    							for (var s=0; s<data.length; s++){
	    																														//父项目名称
	    							  str+="<h1 class=\"function\"><a href=\"#sysMeun\" class=\"collapse in\" data-toggle=\"collapse\">"+data[s].roleName+"</a></h1>";	
	    							  str+="<ul id=\"sysMeun\" class=\"nav nav-sidebar collapse\">";  
	    								for( var t=0; t<data[s].roleChild.length; t++){
	    									str+="<li><a href=\"employee.html\">"+data[s].roleChild[t].childName+"</a></li>";
	    								}
	    							  str+="</ul>";
	    							}
	    							
	    							$("#showMenu").append(str);
	    							
	    						}
	    					}
	    					
	    				},error:function(){
	    					var dialog = jDialog.alert('连接超时了',{},{
				   				showShadow: false,// 不显示对话框阴影
				   				buttonAlign : 'center',
				   				events : {
				   					show : function(evt){
				   						var dlg = evt.data.dialog;
				   					},
				   					close : function(evt){
				   						var dlg = evt.data.dialog;
				   					},
				   					enterKey : function(evt){
				   					},
				   					escKey : function(evt){
				   						evt.data.dialog.close();
				   					}
				   				}
				   			  });
	    				}
	    			});
				
				
				
				
				
			});
		
		</script>
	</head>

	<body>

		<section id="contact-page">
			<div class="container">
				<div class="row">
					<div class="col-lg-offset-2 col-md-10 main">
						<h3>欢迎使用美业邦MOS系统</h3>
						<hr>
					</div>
				</div>
			</div>
		</section>
		<!--/#contact-page-->

		<footer class="footer navbar-fixed-bottom">
			<div class="container">
				<p class="text-muted pull-right">美业邦 (北京) 科技有限公司 Copyright®2016</p>
			</div>
		</footer>

		
		<script src="../js/bootstrap.min.js"></script>

	
	<script type="text/javascript">
	
		$(function(){
			$("a").click(function(ix){
				$(this).next().addClass("in");
				
			});
		});
	
	</script>

	</body>
