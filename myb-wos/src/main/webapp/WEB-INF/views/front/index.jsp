<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/share/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>美业邦WOS首页</title>
<%@ include file="/WEB-INF/views/share/cssAndJs.jsp"%>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation"
		style="background-color: #3C7AAD;">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar"  aria-expanded="false" aria-controls="navbar" style="background-color: #3C7AAD;">
					<span class="sr-only">导航</span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand pull-left hidden-md hidden-sm" href="" style="color: white;">美业邦WOS</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<%@ include file="/WEB-INF/views/share/nav.jsp"%>
				</ul>
			</div>
		</div>
	</nav>
	
	<div class="container" style="margin-top: 5px; display: block; margin-bottom: 70px;">
		<div class="row">
			<c:if test="${!empty pagedList.content }">
				<c:forEach items="${pagedList.content }" var="entity">
					<a href="${base }/wos/problem/detail.jhtml?id=${entity.id}">
						<div class="col-sm-6 col-xs-12 col-md-4 col-lg-4"
							style="background-color: #5995C9; color: #fff; border: 0.2em solid #fff; height: 140px;">
							<div style="text-align: left;padding-left: 10px;padding-right: 10px;">
								<div>
									<h3>
										<c:if test='${entity.status == "STATUS_UNPROCESS" }'>
											<span class="glyphicon glyphicon-remove-circle" style="color: red;"></span>
										</c:if>
										<c:if test='${entity.status == "STATUS_PROCESSING" }'>
											<span class="glyphicon glyphicon-refresh" style="color: #5C6E7C;"></span>
										</c:if>
										<c:if test='${entity.status == "STATUS_SUCCESS" }'>
											<span class="glyphicon glyphicon-ok-circle" style="color: green;"></span>
										</c:if>
									    <span>[&nbsp;${entity.id}&nbsp;]&nbsp;${entity.title }</span>
									</h3>
									<h5>${entity.descripe }&nbsp;&nbsp;<c:if test="${!empty entity.videoUrl or !empty entity.imgUrl }">[<span class="glyphicon glyphicon-paperclip" style="color: #FBC56F;"></span>]</c:if></h5>
									<h4 style="float: right;color: <c:if test='${entity.status == "STATUS_SUCCESS" }'>green</c:if><c:if test='${entity.status == "STATUS_PROCESSING" }'>#5C6E7C</c:if><c:if test='${entity.status == "STATUS_UNPROCESS" }'>red</c:if>;">
										${dbDataDictionaryMap[entity.status] }
									</h4>
								</div>
							</div>
						</div>
					</a>
				</c:forEach>
				<div class="footer navbar-fixed-bottom">
					<ul class="pager">
						<li><a href="javascript:void(0);">共${pagedList.recordCount }条记录</a></li>
						<li class="<c:if test="${pagedList.pageIndex == 1 }">disabled</c:if>"><a href="<c:if test="${pagedList.pageIndex > 1 }">${base }/wos/index.jhtml?page=1}</c:if><c:if test="${pagedList.pageIndex <= 1 }">javascript:void(0);</c:if>">首页</a></li>
					  	<li class="<c:if test="${pagedList.pageIndex == 1 }"> disabled</c:if>"><a href="<c:if test="${pagedList.pageIndex > 1 }">${base }/wos/index.jhtml?page=${pagedList.pageIndex - 1}</c:if><c:if test="${pagedList.pageIndex <= 1 }">javascript:void(0);</c:if>" >上一页</a></li>
					  	<li class="<c:if test="${pagedList.pageIndex == pagedList.totalPage }">disabled</c:if>"><a href="<c:if test="${pagedList.pageIndex < pagedList.totalPage }">${base }/wos/index.jhtml?page=${pagedList.pageIndex + 1}</c:if><c:if test="${pagedList.pageIndex >= pagedList.totalPage }">javascript:void(0);</c:if>">下一页</a></li>
					  	<li class="<c:if test="${pagedList.pageIndex == pagedList.totalPage }">disabled</c:if>"><a href="<c:if test="${pagedList.pageIndex <= pagedList.totalPage }">${base }/wos/index.jhtml?page=${pagedList.totalPage}</c:if><c:if test="${pagedList.pageIndex >= pagedList.totalPage }">javascript:void(0);</c:if>">尾页</a></li>
					</ul>
				</div>
			</c:if>
			<c:if test="${empty pagedList.content }">
				<div class="col-sm-12 col-xs-12 col-md-12 col-lg-12"
							style="background-color: #5995C9; color: #fff; border: 0.2em solid #fff;height: 100px;line-height: 100px;text-align: center;">
							您还没有提交过问题，快去<a href="${base }/wos/problem/addUI.jhtml" style="color: red;">提问题</a>吧！
				</div>
			</c:if>
		</div>
	</div>
</body>
</html>