<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 	<div class="fakeloader"></div>
				<div class="row">
					<div class="col-sm-3 col-md-2 sidebar hidden-md hidden-sm" id="showMenu">
					<!-- 
						<h1 class="function"><a href="#sysMeun" class="collapse in" data-toggle="collapse">系统</a></h1>
						<ul id="sysMeun" class="nav nav-sidebar collapse">
				 		<li><a href="permission.html">权限管理</a></li>
						</ul>
						<h1 class="function"><a href="#approve" class="collapse in" data-toggle="collapse"><span class="badge pull-right">2</span> 审批</a></h1>
						<ul id="approve" class="nav nav-sidebar collapse">
							<li><a href="approve.html"><span class="badge badge-white pull-right">2</span> 待审批</a></li>
							<li><a href="approved.html"><span class="badge badge-white pull-right">0</span>已完成</a></li>
							<li><a href="#"><span class="badge badge-white pull-right">1</span>我提交的</a></li>
						</ul>
						<h1 class="plugin"><a href="#financeMeun" class="collapse in" data-toggle="collapse">财务</a></h1>
						<ul id="financeMeun" class="nav nav-sidebar collapse">
							<li><a href="finance.html">核款</a></li>
							<li><a href="finance-back.html">退款</a></li>
							<li><a href="finance-completed.html">已完成</a></li>
						</ul>
						<h1 class="setup"><a href="#sysBiz" class="collapse in" data-toggle="collapse" aria-expanded="true">CRM</a></h1>
						<ul id="sysBiz" class="nav nav-sidebar collapse" aria-expanded="true">
							<li><a href="public-sea.html">公海管理</a></li>
							<li><a href="customer.html">客户管理</a></li>
							<li><a href="report.html">销售报表</a></li>
							<li><a href="../contract/index.jhtml">合同管理</a></li>
							<li><a href="after-sale.html">落地培训</a></li>
							<li><a href="channel-in.html">合伙人</a></li>
						</ul>
						<h1 class="setup"><a href="#search" class="collapse in" data-toggle="collapse">查询</a></h1>
						<ul id="search" class="nav nav-sidebar collapse">
							<li><a href="">合同</a></li>
							<li><a href="">客户</a></li>
						</ul>
						
						<h1 class="setup"><a href="#openAccount" class="collapse in" data-toggle="collapse" aria-expanded="true">开通账号</a></h1>
						<ul id="openAccount" class="nav nav-sidebar collapse in" aria-expanded="true">
							<li><a href="../utils/OpenAccount.jhtml">开通</a></li>
							<li><a href="../utils/BeautifulYardSearch.jhtml">美容院查询</a></li>
							<li><a href="account-catch.html">员工查询</a></li>
						</ul> -->
						
						<!-- 	<h1 class="function"><a href="#sysMeun" class="collapse in" data-toggle="collapse">系统</a></h1>
						<ul id="sysMeun" class="nav nav-sidebar collapse">
							<li><a href="employee.html">员工管理</a></li>
							<li><a href="permission.html">权限管理</a></li>
						</ul>
						<h1 class="function"><a href="#approve" class="collapse in" data-toggle="collapse"><span class="badge pull-right">2</span> 审批</a></h1>
						<ul id="approve" class="nav nav-sidebar collapse">
							<li><a href="approve.html"><span class="badge badge-white pull-right">2</span> 待审批</a></li>
							<li><a href="approved.html"><span class="badge badge-white pull-right">0</span>已完成</a></li>
							<li><a href="#"><span class="badge badge-white pull-right">1</span>我提交的</a></li>
						</ul>
						<h1 class="plugin"><a href="#financeMeun" class="collapse in" data-toggle="collapse">财务</a></h1>
						<ul id="financeMeun" class="nav nav-sidebar collapse">
							<li><a href="finance.html">核款</a></li>
							<li><a href="finance-back.html">退款</a></li>
							<li><a href="finance-completed.html">已完成</a></li>
						</ul>
						<h1 class="setup"><a href="#sysBiz" class="collapse in" data-toggle="collapse" aria-expanded="true">CRM</a></h1>
						<ul id="sysBiz" class="nav nav-sidebar collapse" aria-expanded="true">
							<li><a href="public-sea.html">公海管理</a></li>
							<li><a href="customer.html">客户管理</a></li>
							<li><a href="report.html">销售报表</a></li>
							<li><a href="../contract/index.jhtml">合同管理</a></li>
							<li><a href="after-sale.html">落地培训</a></li>
							<li><a href="channel-in.html">合伙人</a></li>
						</ul>
						<h1 class="setup"><a href="#search" class="collapse in" data-toggle="collapse">查询</a></h1>
						<ul id="search" class="nav nav-sidebar collapse">
							<li><a href="">合同</a></li>
							<li><a href="">客户</a></li>
						</ul>
						
						<h1 class="setup"><a href="#openAccount" class="collapse in" data-toggle="collapse" aria-expanded="true">开通账号</a></h1>
						<ul id="openAccount" class="nav nav-sidebar collapse" aria-expanded="true">
							<li><a href="../utils/OpenAccount.jhtml">开通</a></li>
							<li><a href="../utils/BeautifulYardSearch.jhtml">美容院查询</a></li>
							<li><a href="account-catch.html">员工查询</a></li>
						</ul> -->
						<c:forEach items="${roleVOs}" var="roleVO" varStatus="status">
							<h1 class="setup"><a href="#openAccount${status.index}" class="collapse in" data-toggle="collapse" aria-expanded="true">${roleVO.roleName}</a></h1>
								<ul id="openAccount${status.index}" class="nav nav-sidebar collapse in" aria-expanded="true">
									<c:if test="${!empty roleVO.roleChild }">
										<c:forEach items="${roleVO.roleChild}" var="roleChild" >
											<c:choose>
												<c:when test="${roleChild.childId eq 3}">
													<c:if test="${roleVOs[0].zhiyingCount eq -1}">
														<li><a href="${roleChild.openUrl}"><span class="badge badge-white pull-right">√</span>${roleChild.childName}</a></li>
													</c:if>
													<c:if test="${roleVOs[0].zhiyingCount ne -1}">
														<li><a href="${roleChild.openUrl}"><span class="badge badge-white pull-right">${roleVOs[0].zhiyingCount}</span>${roleChild.childName}</a></li>
													</c:if>
												</c:when>
											
												<c:when test="${roleChild.childId eq 4}">
													<c:if test="${roleVOs[0].qudaoCount eq -1}">
														<li><a href="${roleChild.openUrl}"><span class="badge badge-white pull-right">√</span>${roleChild.childName}</a></li>
													</c:if>
													<c:if test="${roleVOs[0].qudaoCount ne -1}">
														<li><a href="${roleChild.openUrl}"><span class="badge badge-white pull-right">${roleVOs[0].qudaoCount}</span>${roleChild.childName}</a></li>
													</c:if>
												</c:when>
												
												<c:when test="${roleChild.childId eq 22}">
													<c:if test="${roleVOs[0].exceptionModify eq -1}">
														<li><a href="${roleChild.openUrl}"><span class="badge badge-white pull-right">√</span>${roleChild.childName}</a></li>
													</c:if>
													<c:if test="${roleVOs[0].exceptionModify ne -1}">
														<li><a href="${roleChild.openUrl}"><span class="badge badge-white pull-right">${roleVOs[0].exceptionModify}</span>${roleChild.childName}</a></li>
													</c:if>
												</c:when>
												
												<c:when test="${roleChild.childId eq 23}">
													<c:if test="${roleVOs[0].exceptionDelay eq -1}">
														<li><a href="${roleChild.openUrl}"><span class="badge badge-white pull-right">√</span>${roleChild.childName}</a></li>
													</c:if>
													<c:if test="${roleVOs[0].exceptionDelay ne -1}">
														<li><a href="${roleChild.openUrl}"><span class="badge badge-white pull-right">${roleVOs[0].exceptionDelay}</span>${roleChild.childName}</a></li>
													</c:if>
												</c:when>
											
												<c:otherwise>
													<li><a href="${roleChild.openUrl}">${roleChild.childName}</a></li>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</c:if>
								</ul>
						</c:forEach>
					</div>
				</div>
				
