<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en"><head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>MOS-美业邦</title>

		<!-- Bootstrap -->
		<link href="../css/bootstrap.min.css" rel="stylesheet">
		<link href="../css/back-style.css" rel="stylesheet">
		<link href="../css/dashboard.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="../css/calendar/jquery.datetimepicker.css"/>
		<script src="../js/jquery-2.1.1.min.js"></script>
		<script src="../js/bootstrap.min.js"></script>
		<script src="../js/validate.js"></script>
		<script src="../js/alertInfo.js"></script>
		
		<script type="text/javascript">
		
		//分页公共方法
		function pageForword(pageIndex){
			
			if(pageIndex < 5){
				$(".pagination li").addClass("active").siblings().removeClass("active");
			}
			if(pageIndex <= 0){
				pageIndex=1;
			}
			var finance = "${finance}";
			$.ajax({
				type:"GET",
				data:"",
				datatype:"html",
				url:"../ExceptionShop/modifyShopList.jhtml?finance="+finance+"&pageIndex="+pageIndex,
				success:function(data){
					$(".table-striped").html($(data).find(".table-striped").html());
					$(".pagination").html($(data).find(".pagination").html());
				},error:function(){
					//展示错误提示的弹框
					alertInfo("连接超时了");
				}
				
				
			});
		}
		
		$(function(){
			$("#searchBeautiful").click(function(){
				var sj0="";
				var sj1="";
				var accountName = $(".accountName").val();
				var dh = $(".dh").val();
				var mobile =$(".mobile").val();
				if(accountName !=""&&dh==""&&mobile==""){
					sj0="accountName";
					sj1=accountName;
				}
				else if(accountName ==""&&dh!=""&&mobile==""){
					sj0="dh";
					sj1=dh;
				}
				else if(accountName ==""&&dh==""&&mobile!=""){
					sj0="mobile";
					sj1=mobile;
				} else {
					alertInfo("只能填写一项!<font color=\"red\" size=\"4\">下次可要记住了。</font>");
					return false;
				}
				if(Validator.Validate(document.getElementById('yanzheng'),3)){
				$.ajax({
	    				type:"POST",
	    				dataType:"json",
	    				url:"../Account/findByBeautifulId.jhtml?finance=${finance}"+"&"+sj0+"="+sj1,
	    				success:function(data){
	    					console.info(data);
	    					if(data != "-1"){
	    						$("#searchContent").html("");
	    						var str="";
	    						for (var s = 0; s <data.length; s++) {
	    						str+="<tr>"
    							if(data[s].finance == 1){
    	    					str+="<td><a href=\"../Account/index.jhtml?type=2&finance=1&accountId="+data[s].accountId+"\" id=\"beautifulName\">"+data[s].beautifulyard+"</a></td>";
    	    						}
   	    						if(data[s].finance != 1){
   	    						str+="<td ><a href=\"../Account/index.jhtml?type=2&accountId="+data[s].accountId+"\" id=\"beautifulName\">"+data[s].beautifulyard+"</a></td>";
   	    						}
	    						
	    						str+="<td id=\"province\">"+data[s].provinceName+"</td>";
	    						str+="<td id=\"city\">"+data[s].cityName+"</td>";
	    						str+="<td id=\"mobile\">"+data[s].openNumber+"</td>";
	    						str+="<td id=\"openCount\">"+data[s].shopCount+"</td>";
	    						str+="<td id=\"payDate\">"+(data[s].payDate).split(" ")[0]+"</td>";
	    						str+="<td id=\"updateDate\">"+(data[s].updateDate).split(" ")[0]+"</td>";
	    						str+="<td id=\"sellPerson\">"+data[s].market+"</td>";
	    						if(data[s].isAddAccount == 1 && data[s].finance != 1){
	    							
	    							str+="<td><a href=\"../contract/contractInfo.jhtml?type=2&finance="+data[s].finance+"&accountId="+data[s].accountId+"\" class=\"btn btn-xs btn-info\">查看合同</a></td>";	
	    						}if(data[s].isAddAccount == 1 && data[s].finance ==1){
	    							/*财务看的  */
	    							str+="<td><a href=\"../contract/contractInfo.jhtml?type=2&finance="+data[s].finance+"&accountId="+data[s].accountId+"\" class=\"btn btn-xs btn-info\">查看合同</a></td>";	
	    						}
	    						if(data[s].isAddAccount == 2 ){
	    							str+="<td><a href=\"../utils/contractSave.jhtml?accountId="+data[s].accountId+"\" class=\"btn btn-xs btn-info\">添加合同</a></td>";	
	    						}
	    						//样咧
// 	    						str+="<td><a href=\"../Account/index.jhtml?type=2&accountId="+data.accountId+"\" class=\"btn btn-xs btn-info\">查看</a></td>";
	    						
	    						console.info(data[s].approvalStatus+"审批状态");
	    						//审批状态
 	    						//1未审批，2审批通过，3审批未通过
 	    						console.info("审批状态"+data[s].approvalStatus);
	    						console.info("合同"+data[s].isAddAccount);
								if(data[s].approvalStatus == 1 && data[s].isAddAccount != 2){
									str+="<td class=\"text-status-normal\">待审批</td>";
								}
								if(data[s].approvalStatus == 4 && data[s].isAddAccount != 2){
									str+="<td class=\"text-status-normal\">待审批</td>";
								}
								if(data[s].approvalStatus == 2 && data[s].isAddAccount != 2){
									str+="<td class=\"text-status-success\">已开通</td>";
								}
								if(data[s].approvalStatus == 3 && data[s].isAddAccount != 2){
									str+="<td class=\"text-status-danger\">退回</td>";
								}
								if(data[s].isAddAccount == 2){
									str+="<td class=\"text-status-danger\">请添加合同</td>";
								}
	    						str+="</tr>";
	    						}
	    						$("#allData").html(str);
	    						$("#allpage").html("");
	    					}else  {
	    						alertInfo("不存在当前手机号的美容院！");
	    					}
	    					
	    				},error:function(){
	    					//展示错误提示的弹框
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
				}
				
			});
			
		});
		</script>
		
	</head>
	<body>
		<jsp:include page="../menu/header.jsp"></jsp:include>
		<section id="contact-page">
			<div class="container1">
				<div class="row">
					<jsp:include page="../menu/headerNext.jsp"></jsp:include>
					<div class="col-lg-offset-2 main">
					<c:if test="${finance eq 1}">
					<h3 class="page-header">直营开号</h3>
					</c:if>
					<c:if test="${finance ne 1}">
					<h3 class="page-header">直营账号列表</h3>
					</c:if>
						<div class="row head">
							<div class="col-md-8">
							<form id="yanzheng">
								<table class="table-nobordered">
									<tbody><tr>
										<td>
											<input type="text" class="form-control mobile"  placeholder="手机号" >
										</td>
										<td>
											<input type="text" class="form-control accountName"  placeholder="账户名称" >
										</td>
										<td>
											<input type="text" class="form-control dh"  placeholder="单号" >
										</td>
										<td><a href="javascript:void(0)" id="searchBeautiful" class="btn btn-info btn-sm">查询</a></td>
									</tr>
								</tbody>
								</table>
								</form>
							</div>
						</div>
						<br>
						<table class="table table-striped table-bordered " style="margin-bottom: 0px;">
							<thead>
								<tr>
									<th>美容院名称</th>
									<th>省份</th>
									<th>城市</th>
									<th>老板手机号</th>
									<th>店数</th>
									<th>付款日期</th>
									<th>开通日期</th>
									<th>销售</th>
									<th>操作</th>
								</tr>
							</thead>
								<tbody id="allData">
										<c:forEach items="${openAccountPageList.content}" var="openAccountPageList">
											<tr>
												<td>
												<a href="../Account/index.jhtml?exception=1&type=2&finance=1&accountId=${openAccountPageList.accountId}" target="view_window">${openAccountPageList.beautifulyard}</a>
														<img alt="" src="../images/deng.png">
														<!-- 	//处理状态 -->
															<c:if test="${openAccountPageList.ispass eq 1}">
																<font class="text-status-success" size="3">
																	通过
																</font>
															</c:if>
															<c:if test="${openAccountPageList.ispass eq 3}">
																<font class="text-status-normal" size="3">
																	未审核
																</font>
															</c:if>
												</td>
												<td>${openAccountPageList.provinceName}</td>
												<td>${openAccountPageList.cityName}</td>
												<td>${openAccountPageList.openNumber}</td>
												<td>${openAccountPageList.shopCount}</td>
												<td><fmt:formatDate value="${openAccountPageList.payDate}" type="date" dateStyle="default"/> </td>
												<td><fmt:formatDate value="${openAccountPageList.updateDate}" type="date" dateStyle="default"/> </td>
												<td>${openAccountPageList.market}</td>
												
												<td>
													<!--销售助理查看的内容  -->
													<c:if test="${openAccountPageList.isAddAccount == 1 and finance ne 1}">
													<a href="../contract/contractInfo.jhtml?type=1&accountId=${openAccountPageList.accountId}" class="">查看合同</a>
													</c:if>
													<!--财务查看的内容  -->
													<c:if test="${openAccountPageList.isAddAccount == 1 and finance == 1}">
													<a href="../contract/contractInfo.jhtml?type=1&finance=1&accountId=${openAccountPageList.accountId}" class="">查看合同</a>
													</c:if>
													
													<c:if test="${openAccountPageList.isAddAccount == 2}">
													<a href="../utils/contractSave.jhtml?accountId=${openAccountPageList.accountId}" class="btn btn-xs btn-info">添加合同</a>
													</c:if>
												</td>
												
											</tr>
									</c:forEach>
						</tbody>
					<tbody id="searchContent">
						
						
					</tbody>
						</table>
						<nav id="allpage">
							<ul class="pagination pull-right">
								<li >
								<c:if test="${type eq 'delay'}">
									<a href="javascript:void(0)" aria-label="Previous" onclick="pageForword(${openAccountPageList.pageIndex -1},1)"><span aria-hidden="true">«</span></a>
								</c:if>
								<c:if test="${type ne 'delay'}">
									<a href="javascript:void(0)" aria-label="Previous" onclick="pageForword(${openAccountPageList.pageIndex -1},0)"><span aria-hidden="true">«</span></a>
								</c:if>
								</li>
								
							<!--开总页数小于5   -->
							<c:if test="${openAccountPageList.totalPage<=5 }">
								<c:forEach begin="1" end="${openAccountPageList.totalPage}" var="currentPage">
									<li  <c:if test="${currentPage ==  openAccountPageList.pageIndex}">class="active"</c:if>>
											<c:if test="${type eq 'delay'}">
												<a href="javascript:void(0)" onclick="pageForword(${currentPage},1)">${currentPage}</a>
											</c:if>
											<c:if test="${type ne 'delay'}">
												<a href="javascript:void(0)" onclick="pageForword(${currentPage},0)">${currentPage}</a>
											</c:if>
									</li>
								</c:forEach>
							</c:if>
								
							<!--总页数大于5  -->
							<c:if test="${openAccountPageList.totalPage > 5}">
								<!--当前索引小于3  -->
								<c:if test="${openAccountPageList.pageIndex <= 3}">
									<c:forEach begin="1" end="5" var="currentPage"> 
										<li  <c:if test="${currentPage ==  openAccountPageList.pageIndex}">class="active"</c:if>>
											<c:if test="${type eq 'delay'}">
												<a href="javascript:void(0)" onclick="pageForword(${currentPage},1)">${currentPage}</a>
											</c:if>
											<c:if test="${type ne 'delay'}">
												<a href="javascript:void(0)" onclick="pageForword(${currentPage},0)">${currentPage}</a>
											</c:if>
										</li>
									</c:forEach>
								</c:if>
								
								<!--当前索引大于3  -->
								<c:if test="${openAccountPageList.pageIndex > 3}">
									<li>
										<c:if test="${type eq 'delay'}">
											<a href="javascript:void(0)" onclick="pageForword(1,1)">1</a>
										</c:if>
										<c:if test="${type ne 'delay'}">
											<a href="javascript:void(0)" onclick="pageForword(1,0)">1</a>
										</c:if>
									</li>
									<li><a href="javascript:void(0)" >...</a></li>
									<!--当前页加2小于total  -->
									
									<c:choose>
										<c:when test="${openAccountPageList.pageIndex*1 + 2 < openAccountPageList.totalPage }">
											<c:forEach begin="${openAccountPageList.pageIndex -2 }" end="${openAccountPageList.pageIndex + 2}" var="currentPage"> 
											<li  <c:if test="${currentPage ==  openAccountPageList.pageIndex}">class="active"</c:if>>
												<c:if test="${type eq 'delay'}">
													<a href="javascript:void(0)" onclick="pageForword(${currentPage},1)">${currentPage}</a>
												</c:if>
												<c:if test="${type ne 'delay'}">
													<a href="javascript:void(0)" onclick="pageForword(${currentPage},0)">${currentPage}</a>
												</c:if>
											</li>
											</c:forEach>
											<li><a href="javascript:void(0)" >...</a></li>
											<li>
											<c:if test="${type eq 'delay'}">
												<a href="javascript:void(0)" onclick="pageForword(${openAccountPageList.totalPage},1)">${openAccountPageList.totalPage}</a>
											</c:if>
											<c:if test="${type ne 'delay'}">
												<a href="javascript:void(0)" onclick="pageForword(${openAccountPageList.totalPage},0)">${openAccountPageList.totalPage}</a>
											</c:if>
											</li>
										</c:when>
										<c:otherwise>
											<c:forEach begin="${openAccountPageList.totalPage -4}" end="${openAccountPageList.totalPage}" var="current">
												<li  <c:if test="${current ==  openAccountPageList.pageIndex}">class="active"</c:if>><a href="javascript:void(0)" onclick="pageForword(${current})">${current}</a></li>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</c:if>
							</c:if>
								
							<!--点击过之后的分页start当前页小于5  -->
							<c:if test="${openAccountPageList.pageIndex < openAccountPageList.totalPage}">
								<li>
									<a href="javascript:void(0)" aria-label="Next" onclick="pageForword(${openAccountPageList.pageIndex+1})"><span aria-hidden="true">»</span></a>
								</li>
							</c:if>
								
						 </ul>
						</nav>
					</div>
				</div>
			</div>
		</section>
		<form action="http://localhost:8080/myb-mos/contract/test.jhtml" method="post">
		<input name="aaa" value="ddddd"/>
		<input type="submit" value="tj" />
		</form>
		<!--/#contact-page-->

		<footer class="footer navbar-fixed-bottom">
			<div class="container">
				<p class="text-muted pull-right">美业邦 (北京) 科技有限公司 Copyright®2016</p>
			</div>
		</footer>
	</body>
</html>