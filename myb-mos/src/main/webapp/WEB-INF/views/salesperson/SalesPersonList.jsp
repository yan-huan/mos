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
		<link href="../css/bootstrap/bootstrap.min.css" rel="stylesheet" media="screen">
    	<link href="../css/bootstrap/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
		
		<script src="../js/jquery-2.1.1.min.js"></script>
		<script src="../js/bootstrap.min.js"></script>
		<script src="../js/validate.js"></script>
		<script src="../js/alertInfo.js"></script>
		<script type="text/javascript" src="../js/bootstrap/bootstrap.min.js"></script>
		
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
				dataType:"html",
				url:"../excel/salePersonList.jhtml?pageIndex="+pageIndex,
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
			//日期时间选择器
			//条件搜索
			$("#search").click(function(){
			var inp2="";
			var sell = $(".autocomplete-input1").val();
			console.info(sell+"gggttt");
			if(sell!=null && sell!=""){
			var inp1 = sell.split("(")[1];
			inp2= inp1.split(")")[0];
			}
			console.info($("#endTime").val() +"      "+ $("#openTime").val());
			var openTime = $("#openTime").val();
			var endTime = $("#endTime").val();
				$.ajax({
					type:"GET",
					data:{"openTime":openTime,"endTime":endTime,"salePerson":inp2,"entryTime":$("#entryTime").val(),"xz":$("#xz :selected").val()},
					dataType:"html",
					url:"../excel/salePersonList.jhtml",
					success:function(data){
						console.info(data);
						$(".table-striped").html($(data).find(".table-striped").html());
						$(".pagination").html("");
						setAllMoneyAndCount();
					},error:function(){
						//展示错误提示的弹框
						alertInfo("连接超时了");
					}
				});
			});
			
			  //调取城市小组列表
		  	  $("#cs").change(function(){
		  		  
		  		var cs = $("#cs option:selected").val();
		  		$.ajax({
					type:"GET",
					dataType:"json",
					data:{"cs":cs},
					url:"../excel/Leader.jhtml",
					success:function(data){
						$("#xz").html("<option value='全部("+cs+")'>全部("+cs+")</option>");
						for (var i = 0; i < data.length;i++){
						$("#xz").append("<option value='"+data[i].argName+"'>"+data[i].argName+"</option>");
						}
						console.info(data);
					},error:function(){
						//展示错误提示的弹框
						alertInfo("连接超时了");
					}
				});
		  		
		  	  })
		});
		function showListOpenAcountByMarket(mobile,obj){
			 var openTime = $("#openTime").val();
			 var endTime = $("#endTime").val();
			 obj.target="view_window";
             obj.href= "../excel/showListOpenAccount.jhtml?pageIndex=1&market="+mobile+"&openTime="+openTime+" 00:00:00&endTime="+endTime+" 23:59:59";
             
		}
		
		function setAllMoneyAndCount(){
			$.ajax({
				type:"GET",
				dataType:"json",
				url:"../excel/getAll.jhtml",
				success:function(data){
					$("#zje").html("总金额: "+data[1]);
					$("#zqd").html("总签单: "+data[0]);
				},error:function(){
					//展示错误提示的弹框
					alertInfo("连接超时了");
				}
			});
		}
		
	</script>
	</head>
	<body>
		<jsp:include page="../menu/header.jsp"></jsp:include>
		<section id="contact-page">
			<div class="container1">
				<div class="row">
				  <jsp:include page="../menu/headerNext.jsp"></jsp:include>
					<div class="col-lg-offset-2 main">
					<h3 class="page-header">销售人员数据</h3>
						<div class="row head">
							<div class="col-md-12">
							<form id="yanzheng">
								<table class="table-nobordered" style="width: 100%">
									<tr>
										<td>
										开始时间
										<input type="text"  class="form_datetime form-control" name="openTime" id="openTime" value="${dateList[0]}"/>
										</td>
										<td>
										截止时间
										<input type="text"  class="form_datetime form-control" name="endTime" id="endTime" value="${dateList[1]}"/>
										</td>
										<td>
										城市
											<select id="cs" class="form-control">
												<option >请选择</option>
												<c:forEach items="${argsXz}" var="argsXz">
													<option value="${argsXz.argName}">${argsXz.argName}</option>
												</c:forEach>
											</select>
										</td>
										<td>
										销售小组
											<select id="xz" class="form-control">
											<option >请选择</option>
											</select>
										</td>
										<td>
										入职时间
										<input type="text"  class="form_datetime form-control" name="endTime" id="entryTime"/>
										</td>
										
										<td>
										销售人
										<div id="demo" style="width: 100%;height: 36px;">
									        <div class="">
									            <div id="search-form"  style="width: 100%;"></div>
									        </div>
								    	</div>
										</td>
										<td><a href="javascript:void(0)" id="search" class="btn btn-info btn-sm">查询</a></td>
										<td><a href="../excel/index.jhtml"  class="btn btn-info btn-sm">导出excel</a></td>
									</tr>
								</table>
							</form>
							</div>
						</div>
						<br>
						<table class="table table-striped table-bordered " style="margin-bottom: 0px;">
							<thead>
								<tr>
									<th>序号</th>
									<th>城市</th>
									<th>所属销售总监</th>
									<th>销售人</th>
									<th>入职时间</th>
									<th>成交单</th>
									<th>汇款金额</th>
									<th>本月牌级</th>
								</tr>
							</thead>
								<tbody id="allData">
								<c:forEach items="${pagedList.content}" var="openAccount"  varStatus="idxStatus">
								
											<tr>
												<td>${idxStatus.count}</td>
												<td>${openAccount.cityName}</td>
												<td>${openAccount.saleParent}</td>
												<td><a  href="javascript:void(0)" onclick="showListOpenAcountByMarket(${openAccount.mobile},this)">${openAccount.salePerson}</a></td>
												<td>${openAccount.joinTime}</td>
												<td>${openAccount.sucessCount}</td>
												<td>${openAccount.saleMoney}</td>
												<c:if test="${openAccount.paiji == '金牌'}">
												<td style="color: gold">${openAccount.paiji}</td>
												</c:if>
												<c:if test="${openAccount.paiji == '银牌'}">
												<td style="color:silver ">${openAccount.paiji}</td>
												</c:if>
												<c:if test="${openAccount.paiji == '铜牌'}">
												<td style="color:#00CD00">${openAccount.paiji}</td>
												</c:if>
												<c:if test="${openAccount.paiji == '无牌'}">
												<td style="color: ">${openAccount.paiji}</td>
												</c:if>
												
											</tr>
								</c:forEach>
								<tr><td colspan="5"></td><td id="zqd">总签单: ${pagedList.content[0].allSuccessCount}</td><td id="zje">总金额: ${pagedList.content[0].allMoney}</td><td></td></tr>
								</tbody>
					<tbody id="searchContent">
					</tbody>
						</table>
						<nav id="allpage">
							<ul class="pagination pull-right">
								<li >
									<a href="javascript:void(0)" aria-label="Previous" onclick="pageForword(${pagedList.pageIndex -1})"><span aria-hidden="true">«</span></a>
								</li>
								
							<!--开总页数小于5   -->
							<c:if test="${pagedList.totalPage<=5 }">
								<c:forEach begin="1" end="${pagedList.totalPage}" var="currentPage">
								<li  <c:if test="${currentPage ==  pagedList.pageIndex}">class="active"</c:if>><a href="javascript:void(0)" onclick="pageForword(${currentPage})">${currentPage}</a></li>
								</c:forEach>
							</c:if>
								
							<!--总页数大于5  -->
							<c:if test="${pagedList.totalPage > 5}">
								<!--当前索引小于3  -->
								<c:if test="${pagedList.pageIndex <= 3}">
									<c:forEach begin="1" end="5" var="currentPage"> 
									<li  <c:if test="${currentPage ==  pagedList.pageIndex}">class="active"</c:if>><a href="javascript:void(0)" onclick="pageForword(${currentPage})">${currentPage}</a></li>
									</c:forEach>
								</c:if>
								
								<!--当前索引大于3  -->
								<c:if test="${pagedList.pageIndex > 3}">
									<li><a href="javascript:void(0)" onclick="pageForword(1)">1</a></li>
									<li><a href="javascript:void(0)" >...</a></li>
									<!--当前页加2小于total  -->
									<c:choose>
										<c:when test="${pagedList.pageIndex*1 + 2 < pagedList.totalPage }">
											<c:forEach begin="${pagedList.pageIndex -2 }" end="${pagedList.pageIndex + 2}" var="currentPage"> 
											<li  <c:if test="${currentPage ==  pagedList.pageIndex}">class="active"</c:if>><a href="javascript:void(0)" onclick="pageForword(${currentPage})">${currentPage}</a></li>
											</c:forEach>
											<li><a href="javascript:void(0)" >...</a></li>
											<li><a href="javascript:void(0)" onclick="pageForword(${pagedList.totalPage})">${pagedList.totalPage}</a></li>
										</c:when>
										<c:otherwise>
											<c:forEach begin="${pagedList.totalPage -4}" end="${pagedList.totalPage}" var="current">
												<li  <c:if test="${current ==  pagedList.pageIndex}">class="active"</c:if>><a href="javascript:void(0)" onclick="pageForword(${current})">${current}</a></li>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</c:if>
							</c:if>
							<!--点击过之后的分页start当前页小于5  -->
							<c:if test="${pagedList.pageIndex < pagedList.totalPage}">
								<li>
									<a href="javascript:void(0)" aria-label="Next" onclick="pageForword(${pagedList.pageIndex+1})"><span aria-hidden="true">»</span></a>
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
				<p class="text-muted pull-right">美业邦 (北京) 科技有限公司 Copyright®2016</p>
			</div>
		</footer>
		<script src="../js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../js/bootstrap/bootstrap-datetimepicker.js" charset="UTF-8"></script>
		<script type="text/javascript" src="../js/bootstrap/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
		<script src="../js/autocomplete/autocompleteSell.js"></script>
		<script src="../js/autocomplete/autocompleteSellUserInfo.js"></script>
		<script type="text/javascript">
		 $('.form_datetime').datetimepicker({
			 	minView: 'month',     //设置时间选择为年月日 去掉时分秒选择
		        format:'yyyy-mm-dd',
		        weekStart: 1,
		        todayBtn:  1,
		        autoclose: 1,
		        todayHighlight: 1,
		        startView: 2,
		        forceParse: 0,
		        showMeridian: 1,
		        language: 'zh-CN'    //设置时间控件为中文
		    });
		 
		$(function(){
			
			    //销售的autocomplate
		  	    var arr = new Array();
			    //销售总监
		  	    var arr1 = new Array();
				//默认调取员工的手机号
				$.ajax({
					url:"../role/roleAddMenu.jhtml",
					type:"POST",
					dataType:"json",
					success:function(data){
						for(var s=0; s<data.length; s++){
							arr.push(data[s]);
						}
						},error:function(){
							//展示错误提示的弹框
							alertInfo("连接超时了");
					}
					
				});
				
		    	$('#search-form').autocomplete({
					hints: arr,
					width: '100%',
					height: 35,
					onSubmit: function(text){
						var inp = $(".autocomplete-input").val();
						if (inp == null ||$.trim(inp) == ""){
							//展示错误提示的弹框
							alertInfo("请输入销售名称");
							return false;
						}
					}
				});
		  	    	
		  	  $(".autocomplete-input").attr("datatype","Require").attr("msg","请输入签约代表").css("width","100%");
		  	  $(".autocomplete-container").css("width","100%");
		  
		});
  	</script>
		
	</body>
</html>