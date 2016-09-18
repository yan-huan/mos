<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			
		<div class="fakeloader"></div>
		<header>
			<nav class="navbar navbar-sky navbar-fixed-top" style="padding: 0px;margin: 0px;" role="navigation">
				<div class="container navbar-container">
					<div class="navbar-header">
						<h1>mos</h1>
					</div>
					
					<div class="top-set pull-right" ><a href="/myb-mos/" class="top-set pull-right">退出 &nbsp;&nbsp;</a></div>
					<div class="top-set pull-right"><a href="../utils/modifyPwd.jhtml" class="top-set pull-right">修改密码&nbsp;&nbsp;</a> </div>
					<div class="top-set pull-right">${employee.empName} &nbsp;&nbsp; </div>
					<div class="top-set pull-right"><marquee direction=left scrollamount=6 onmouseover="this.stop()" onmouseout="this.start()">此网站有任何的建议或意见请联系微信15811347889 </marquee></div>
					<ul class="nav navbar-nav hidden-lg">
						<li style="width: 100px;">
							<p></p>
						</li>
						<c:forEach items="${roleVOs}" var="roleVO" varStatus="status">
							<li class="menu-item">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${roleVO.roleName}
								<span class="caret"></span>
								</a>
								<ul class="dropdown-menu">
								<c:if test="${!empty roleVO.roleChild }">
									<c:forEach items="${roleVO.roleChild}" var="roleChild">
										<li id="menChild${roleChild.childId}"><a href="${roleChild.openUrl}">${roleChild.childName}</a></li>
									</c:forEach>
								</c:if>
								</ul>
							</li>
						</c:forEach>
					</ul>
				</div>
			</nav>
		</header>
			<script type="text/javascript" src="../js/jquery-2.1.1.min.js"></script>
			<script type="text/javascript" src="../js/bootstrap.min.js"></script>
			<script src="../js/fakeLoader.min.js"></script>
	<!-- <script>
        $(document).ready(function(){
            $(".fakeloader").fakeLoader({
                timeToHide:1200,
                bgColor:"rgba(0,0,0,0.5)",
                spinner:"spinner3" //可选值 'spinner1', 'spinner2', 'spinner3', 'spinner4', 'spinner5', 'spinner6', 'spinner7' 对应有7种效果
            });
        });
    </script> -->