<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en"><head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>MOS-美业邦-合同</title>

		<!-- Bootstrap -->
		<link href="../css/bootstrap.min.css" rel="stylesheet">
		<link href="../css/back-style.css" rel="stylesheet">
		<link href="../css/dashboard.css" rel="stylesheet">
		<script src="../js/jquery-2.1.1.min.js"></script>
		<script src="../js/bootstrap.min.js"></script>
		
		
	</head>

	<body>

		<section id="contact-page">
			<div class="container1">
				<div class="row">
					<!--包含左侧菜单  -->
					
					<!--当前菜单的展示内容  -->
					<div class="col-lg-offset-2 main">
						<h3 class="page-header">合同管理</h3>
<!-- 						<a href="../utils/contractSave.jhtml" class="btn btn-success pull-right">新增合同</a> -->
						<div class="row head">
							<div class="col-lg-4" style="width: 300px;">
								<div class="input-group">
									<input type="text" class="form-control" placeholder="合同编号">
									<span class="input-group-btn">
                            <button class="btn" type="button" id="searchContract" style="height: 34px"><span class="glyphicon glyphicon-search"></span></button>
									</span>
								</div>
							</div>
						</div>
						
						
						<br>
						<table class="table table-striped table-bordered " style="margin-bottom: 0px;">
							<thead>
								<tr>
									<th>合同编号</th>
									<th>甲方</th>
									<th>姓名</th>
									<th>开通号码</th>
									<th>店数</th>
									<th>合同金额</th>
									<th>签约日期</th>
									<th>销售</th>
							
								</tr>
							</thead>
						<tbody id="contractContent">
							<c:forEach  items="${Contract.content}"  var="account" >
								<tr>
								<c:if test="${type eq '1' }">
									<td><a href="../contract/contractInfo.jhtml?contractId=${account.contractId}">${account.contractCode}</a></td>
								</c:if>
								<c:if test="">
									<td><a href="../contract/contractInfo.jhtml?contractId=${account.contractId}">${account.contractCode}</a></td>
								</c:if>
									<td>${account.companyName}</td>
									<td>${account.companyName}</td>
									<td>${account.openNumber}</td>
									<td>${account.shopCount}</td>
									<td>￥${account.contractMoney}</td>
									<td><fmt:formatDate value="${account.payDate}" type="date" dateStyle="default"/></td>
									<td>${account.bossAccount}</td>
								</tr>
							</c:forEach>
						</tbody>
						</table>
						<nav>
							<ul class="pagination pull-right">
								<li >
									<a href="javascript:void(0)" aria-label="Previous" onclick="pageForword(${Contract.pageIndex -1})"><span aria-hidden="true">«</span></a>
								</li>
							
							<!--开总页数小于5   -->
							<c:if test="${Contract.totalPage<=5 }">
								<c:forEach begin="1" end="${Contract.totalPage}" var="currentPage">
								<li  <c:if test="${currentPage ==  Contract.pageIndex}">class="active"</c:if>><a href="javascript:void(0)" onclick="pageForword(${currentPage})">${currentPage}</a></li>
								</c:forEach>
							</c:if>
							
					<!--总页数大于5  -->
							<c:if test="${Contract.totalPage > 5}">
								<!--当前索引小于3  -->
								<c:if test="${Contract.pageIndex <= 3}">
									<c:forEach begin="1" end="5" var="currentPage"> 
									<li  <c:if test="${currentPage ==  Contract.pageIndex}">class="active"</c:if>><a href="javascript:void(0)" onclick="pageForword(${currentPage})">${currentPage}</a></li>
									</c:forEach>
								</c:if>
							
							<!--当前索引大于3  -->
								<c:if test="${Contract.pageIndex > 3}">
									<li><a href="javascript:void(0)" onclick="pageForword(1)">1</a></li>
									<li><a href="javascript:void(0)" >...</a></li>
									<!--当前页加2小于total  -->
									
									<c:choose>
										<c:when test="${Contract.pageIndex*1 + 2 < Contract.totalPage }">
											<c:forEach begin="${Contract.pageIndex -2 }" end="${Contract.pageIndex + 2}" var="currentPage"> 
											<li  <c:if test="${currentPage ==  Contract.pageIndex}">class="active"</c:if>><a href="javascript:void(0)" onclick="pageForword(${currentPage})">${currentPage}</a></li>
											</c:forEach>
											<li><a href="javascript:void(0)" >...</a></li>
											<li><a href="javascript:void(0)" onclick="pageForword(${Contract.totalPage})">${Contract.totalPage}</a></li>
										</c:when>
										<c:otherwise>
											<c:forEach begin="${Contract.totalPage -4}" end="${Contract.totalPage}" var="current">
											<li  <c:if test="${current ==  Contract.pageIndex}">class="active"</c:if>><a href="javascript:void(0)" onclick="pageForword(${current})">${current}</a></li>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</c:if>
							</c:if>
								
							<!--点击过之后的分页start当前页小于5  -->
							<c:if test="${Contract.pageIndex < Contract.totalPage}">
								<li>
									<a href="javascript:void(0)" aria-label="Next" onclick="pageForword(${Contract.pageIndex+1})"><span aria-hidden="true">»</span></a>
								</li>
							</c:if>
								
						 </ul>
						</nav>
					</div>
				</div>
			</div>
		</section>
		<!--/#contact-page-->
		<footer class="footer navbar-fixed-bottom">
			<div class="container">
				<p class="text-muted pull-right">美业邦 (北京) 科技有限公司      Copyright®2016</p>
			</div>
		</footer>
		
		<script type="text/javascript">
		
		$(function(){
			$(".pagination li").click(function(){
			$(".pagination li").eq($(this).index()).addClass("active").siblings().removeClass("active");
			});
			$("#searchContract").click(function(){
				var contractId = $(".form-control").val();
				$.ajax({
					type:"POST",
					data:{"contractCode" : contractId},
					url:"../contract/searchByContractId.jhtml",
					dataType:"json",
					success:function(data){
							console.info(data);
						if(data=="-1"){
							alert("不存在此合同编号");
						}else {
							var str="";
							str+="<tr>";
							str+="<td><a href=\"contract-detail.html\">"+data.contractCode+"</a></td>";
							str+="<td>北京爱心生股份有限公司</td>";
							str+="<td>${account.objName}</td>";
							str+="<td>"+data.bossAccount+"</td>";
							str+="<td>5</td>";
							str+="<td>￥1980</td>";
							str+="<td>"+data.beginDate+"</td>";
							str+="<td>张三</td>";
							str+="<td style=\"color: #00AA88;font-weight: 800;\">待支付</td>";
							str+="</tr>";
							$("#contractContent").html(str);
							
							$(".pagination").html("");
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
			});
			
		});
		
		//分页公共方法
		function pageForword(pageIndex){
			
			if(pageIndex < 5){
				$(".pagination li").addClass("active").siblings().removeClass("active");
			}
			if(pageIndex <= 0){
				pageIndex=1;
			}
			var accountId="${Contract.content[0].accountId}";
			$.ajax({
				type:"GET",
				data:"",
				datatype:"json",
				url:"../contract/index.jhtml?accountId="+accountId+"&pageIndex="+pageIndex,
				success:function(data){
					$(".table-striped").html($(data).find(".table-striped").html());
					$(".pagination").html($(data).find(".pagination").html());
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
		
		</script>
	</body>
</html>