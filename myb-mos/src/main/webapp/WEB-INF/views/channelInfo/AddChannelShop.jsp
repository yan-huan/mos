<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<html lang="en"><head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>MOS-美业邦</title>

		<!-- Bootstrap -->
		<link rel="stylesheet" type="text/css" href="../css/calendar/jquery.datetimepicker.css"/>
		<script type="text/javascript" src="../js/provinceCity.js"></script>
		<script type="text/javascript" src="../js/validate.js"></script>
		<script src="../js/alertInfo.js"></script>
		
	</head>
<!-- onload="setup();preselect('北京市');promptinfo();" -->
	<body >
	<jsp:include page="../menu/header.jsp" ></jsp:include>
		<section id="contact-page">
			<div class="container1">
				<div class="row">
				<jsp:include page="../menu/headerNext.jsp" ></jsp:include>
					<div class="col-lg-offset-2 main">
						<h3 class="page-header">账号信息</h3>
						<div style="width: 50%;">
						<c:if test="${openAccount.approvalStatus ne 2 and finance ne 1}">
							<a class="btn btn-info btn-sm pull-right" href="../utils/contractSave.jhtml?isqudao=isqudao&accountId=${openAccount.accountId}" >添加合同</a>
						</c:if>
						</div>
						<form id="form1" name="form1" role="form" class="form-horizontal" action="javascript:alert('验证成功,可以提交.');" method="post">
							<table class="table table-bordered" style="width: 40%;">
								<tbody><tr>
									<th width="30%">美容院名称</th>
									<td>
										${openAccount.beautifulyard}
									</td>
								</tr>
								<tr>
									<th width="30%">老板手机号</th>
									<td>
										${openAccount.openNumber}
									</td>
								</tr>
								<tr id="Above">
									<th width="30%">购买店数</th>
									<td >
										<span id="countChange">${openAccount.shopCount} </span><span>
											<c:if test="${finance eq 1}">
													<a href="javascript:void(0)" id="addCount" class="btn btn-danger bt pull-right btn-xs">+</a>
											</c:if>	
											
										</span>
									</td>
								</tr>
								<b style=" color: red;  size: b5; display: none;" id="Above"><font size="5">店数已满</font></b>
								<tr>
									<th width="30%">付款日期</th>
									<td>
									${fn:split(openAccount.payDate, " ")[0]}
									</td>
								</tr>
								<tr>
									<th width="30%">销售</th>
									<td>
										${openAccount.market}
									</td>
								</tr>
								<%-- <tr>
									<th width="30%">客服电话</th>
									<td>
										${openAccount.kefumobile}
									</td>
								</tr> --%>
								<tr>
									<th width="30%">省市区</th>
									<td>
										${openAccount.provinceName}-${openAccount.cityName}
									</td>
								</tr>
								<tr>
									<th width="30%">总部地址</th>
									<td>
										${openAccount.zongbuAddress}
									</td>
								</tr>
								<tr>
									<th width="30%">备注</th>
									<td>
										${openAccount.remark}
									</td>
								</tr>
								<!--<tr>
									<th width="30%"></th>
									<td>
										<a href="#" class="btn btn-success">添加店</a>
									</td>
								</tr>-->
							</tbody></table>

						</form>
						<c:if test="${openAccount.isOpenStatus eq 1 and finance eq 1}">
							<button id="addshop" class="btn btn-success btn-sm pull-right" type="button">添加店</button>
						</c:if>
						<c:if test="${openAccount.isOpenStatus ne 1 and finance eq 1}">
							<button id="addshop" class="btn btn-success btn-sm pull-right" type="button" disabled="disabled">添加店</button>
						</c:if>
						<c:if test="${finance ne 1}">
							<button id="addshop" class="btn btn-success btn-sm pull-right" type="button" >添加店</button>
						</c:if>
					
					<form  name="saveShop" id="addShop" method="post" >
					<input type="hidden" name="mobile" id="mobile" value="${openAccount.openNumber}" />
					
						<div class="modal" id="mymodal">
							<div class="modal-dialog" style="width: 900px;">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true" onclick="closeWin()">×</span><span class="sr-only">Close</span></button>
										<h4 class="modal-title">添加店</h4>
									</div>
									<div class="modal-body">
										<table class="table table-bordered">
											<tbody><tr>
												<th width="20%">店名</th>
												<td width="30%">
													<input type="text" name="shopName" class="form-control dianming" dataType="Require" msg="请输入内容">
												</td>
												<th width="20%"></th>
												<td width="30%">

												</td>
											</tr>
											<tr>
												<th width="20%">省份*城市</th>
												<td width="30%">
												<select class="select form-control" name="province"  onchange="searchCity()" id="provinceCode" dataType="Require" msg="请选择省份" style="width: 50%;float: left;">
													<option value="">请选择省份</option>
													<c:forEach items="${addressAreaDefParent}" var="addressAreaDefParent">
															<option value="${addressAreaDefParent.code}">${addressAreaDefParent.objName}</option>
													</c:forEach>
												</select>
														
												<select class="select form-control" name="city" id="cityCode" dataType="Require" msg="请选择城市" style="width: 50%;float: right;">
											              	<option value="">请选择城市</option>
											    </select>
											    <!-- <select class="select" name="province" id="s1"  >
														     <option></option>
														</select> -->
												</td>
												<th width="20%">详细地址</th>
												<td width="30%">
														
											            
											            <!--  <select class="select" name="business" id="s3">
												              <option></option>
												          </select> -->
													    <input id="address" name="address" class="form-control" type="text"  dataType="Require" msg="请输入地址" placeholder="请输入地址"/>
													    <input id="provinceName" name="provinceName"type="hidden" />
													     <input id="cityName" name="cityName"type="hidden" />

												</td>
											</tr>
											
											<tr>
												<th width="20%">年限</th>
												<td width="30%">
													<input type="radio" name="duration" class="radio-inline" value="1" checked="checked"> 一年 
													<input type="radio" name="duration" class="radio-inline" value="3"> 三年 
													<input type="radio" name="duration" class="radio-inline" value="50"> 终身 
												</td>
												<th width="20%">赠送（单位月）</th>
												<td width="30%">
													<input type="text" name="giveAway" style="width: 50px;" class="form-control zengsong"   dataType="Require" msg="请输入内容" value="0 ">
												</td>
											</tr>
											<tr>
												<th width="20%">开通日期</th>
												<td width="30%">
													<input type="text"  name="beginDate"  class="datetimepicker form-control kaitongriqi"  dataType="Require" msg="请输入开始日期">
												</td>
												<th width="20%">到期日期</th>
												<td width="30%">
													<input type="text" name="endDate" class="datetimepicker form-control daoqiriqi"  dataType="Require" msg="请输入结束日期">
												</td>
											</tr>

										</tbody></table>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-success" id="saveShopInfo">保存</button>
										<button type="button" class="btn btn-default" data-dismiss="modal" onclick="closeWin()">关闭</button>	
									</div>
								</div>
							</div>
						</div>
					</form>
						<h3 class="page-header">店信息</h3>

						<table class="table table-bordered">
							<tbody >
							<tr id="addcurrentBeautiful">
								<th width="20%">店名</th>
								<th>城市</th>
								<th>年限</th>
								<th>赠送</th>
								<th>开通日期</th>
								<th>到期日期</th>
							</tr>
							
							<c:if test="${!empty  shopList }">
								<c:forEach items="${shopList }" var="shop">
									<tr class="showBeautiful" >
										<td width="20%" class="addshopName">${shop.shopName}</td>
										<td class="city">${shop.cityName}</th>
										<c:if test="${shop.duration == '50'}">
										<td class="duration">终身</td>
										</c:if>
										<c:if test="${shop.duration != '50'}">
										<td class="duration">${shop.duration}年</td>
										</c:if>
										<c:if test="${shop.giveAway eq '0' or null}">
											<td class="giveAway">无赠送月</td>
										</c:if>
										<c:if test="${shop.giveAway ne '0'}">
											<td class="giveAway">${shop.giveAway}月</td>
										</c:if>
										<td class="beginDate">${shop.beginDate}</td>
										<td class="endDate">${shop.endDate}</td>
									</tr>
								</c:forEach>
							</c:if>
							<c:if test="${empty  shopList }">
								
							</c:if>
							
						</tbody>
					</table>
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
		<script>
		String.prototype.replaceAll = function(reallyDo, replaceWith, ignoreCase) {  
		    if (!RegExp.prototype.isPrototypeOf(reallyDo)) {  
		        return this.replace(new RegExp(reallyDo, (ignoreCase ? "gi": "g")), replaceWith);  
		    } else {  
		        return this.replace(reallyDo, replaceWith);  
		    }  
		}  
		
		$(function() {
// 			promptinfo();
// 			setup();
// 			preselect('北京市');
			//开通日期自动计算结束日期	
				$(".kaitongriqi").blur(function(){
					getDate();
				});
				$(".radio-inline").click(function(){
					getDate();
				});
				$('#addshop').click(function() {
					
					var myDate = new Date();
					if($(".showBeautiful").length == $("#countChange").text()) {
						//展示错误提示的弹框
						alertInfo("店数已满");
					} else {
						$("#Above").hide();
						$(".dianming").val("");
					$("#mymodal").show();
					}
					myDate.setDate(myDate.getDate()+6);
					var allDate = (myDate.getFullYear()+1)+"-"+(myDate.getMonth()*1+1)+"-"+(myDate.getDate());
					console.info(allDate);
					$(".daoqiriqi").val(allDate);
				});
				
				//保存店的信息
				$("#saveShopInfo").click(function(){
					//保存渠道添加店有标识isqudao
					var isqudao="${isqudao}";
					var url="";
					if (isqudao=="isqudao"){
						url="../Shop/saveShop.jhtml?afterAddShop=2&isqudao=isqudao";
					}else {
						url="../Shop/saveShop.jhtml?afterAddShop=2";
					}
					$("#cityName").val($("#cityCode :selected").html());
					var validateArea = true;
					$(".area").remove();
					if($("#s1").val() == "请选择省份"){
						
						$("#s1").after("<span class='area'  style=\"color: red;\">*请选择省份</span>");
						validateArea = false;
					}if($("#s2").val() == "请选择城市"){
						validateArea = false;
						$("#s2").after("<span class='area'  style='color: red;'>*请选择城市</span>");
					}if($("#s3").val() == "请选择区域"){
						validateArea = false;
						$("#s3").after("<span class='area'  style='color: red;'>*请选择区域</span>");
					}
					if(Validator.Validate(document.getElementById('addShop'),3) && validateArea){
					
						$(this).attr("disabled",true);
						$.ajax({
	   	    				type:"POST",
	   	    				dataType:"json",
	   	    				data:$("#addShop").serialize(),
	   	    				url:url,
	   	    				success:function(data){
	   	    					$("#saveShopInfo").attr("disabled",false);
	   	    					//第一次申请开店
	   	    					if(data == "1"){
	   	    						$(".addcurrentBeautiful").after(getContentData());
	   	    						$("#mymodal").hide();
	   	    					//已开通店	
	   	    					} else if (data == "2"){
	   	    						$("#mymodal").hide();
	 	   	    					$("#addcurrentBeautiful").after(getContentData());
	   	    					}else  {
	   	    						$("#mymodal").hide();
	   	    					//展示错误提示的弹框
	   	    					alertInfo("添加店失败了");
	   	    					}
	   	    				},error:function(){
	   	    					$("#mymodal").hide();
	   	    					//展示错误提示的弹框
	   	    					$("#saveShopInfo").attr("disabled",false);
	   	    					alertInfo("连接超时了");
	   	    					
	   	    				}
	   	    			});
					}
				});
				//给账号添加店数量
				$("#addCount").click(function(){
					
					var dialog = jDialog.confirm('确认添加店吗？',{
							handler : function(button,dialog) {
								var currentShopCount = $("#countChange").text();
								$.ajax({
			   	    				type:"POST",
			   	    				dataType:"json",
			   	    				data:{"shopCount":currentShopCount*1+1,"mobile":$("#mobile").val()},
			   	    				url:"../Account/updateshopCount.jhtml",
			   	    				success:function(data){
			   	    					
			   	    					if(data == "1"){
			   	   	 						$("#countChange").html(currentShopCount*1+1);
			   	    					}else  {
			   	    						$("#mymodal").hide();
			   	    						//展示错误提示的弹框
			   	    						alertInfo("添加店失败了");
			   	    					}
			   	    				},error:function(){
			   	    					$("#mymodal").hide();
			   	    					$("#addCount").attr("disabled",false);
			   	    				//展示错误提示的弹框
			   	    				alertInfo("连接超时了");
			   	    				}
			   	    			});
								dialog.close();
							}
						},{
							handler : function(button,dialog) {
								dialog.close();
							}
						});
					});

			});
			
			//这个函数是必须的，因为在geo.js里每次更改地址时会调用此函数
			/* function promptinfo()
			{
			    var address = document.getElementById('address');
			    var s1 = document.getElementById('s1');
			    var s2 = document.getElementById('s2');
			    var s3 = document.getElementById('s3');
			    address.value = s1.value + s2.value + s3.value;
			} */
			
			function getContentData(){
				var str="";
					str+="<tr class=\"showBeautiful\" >";
					str+="<td width=\"20%\" class=\"addshopName\">"+$(".dianming").val()+"</td>";
					str+="<td class=\"city\">"+$("#provinceCode :selected").html() +"-"+$("#cityCode :selected").html()+"</td>";
					
					if($(".radio-inline:checked").val() == '50'){
					str+="<td class=\"duration\">终身</td>";
					}else {
					str+="<td class=\"duration\">"+$(".radio-inline:checked").val()+"年</td>";
					}
					str+="<td class=\"giveAway\">"+$(".zengsong").val()+"月</td>";
					str+="<td class=\"beginDate\">"+$(".kaitongriqi").val()+"</td>";
					str+="<td class=\"endDate\">"+$(".daoqiriqi").val()+"</td>";
					str+="</tr>";
				return str;
			}
			function closeWin() {
				$("#mymodal").hide();
			}
			
			function searchCity(){
				$(".cityList").remove();
				$("#provinceName").val($("#provinceCode :selected").html());
				$.ajax({
	    				type:"POST",
	    				dataType:"json",
	    				data:{"parentCode":$("#provinceCode").val()},
	    				url:"../utils/getCityList.jhtml",
	    				success:function(data){
	    					
	    					if(data != "0"){
	    						for(var s=0;s<data.length;s++){
	    						$("#cityCode").append("<option class=\"cityList\" value='"+data[s].code+"'>"+data[s].objName+"</option>");
	    						}
	    					}else  {
	    						//展示错误提示的弹框
	    						alertInfo("调取城市失败了");
	    					}
	    				},error:function(){
	    					//展示错误提示的弹框
	    					alertInfo("连接超时了");
	    				}
	    			});
			}
			
			function getDate(){
				var ktrq = $(".kaitongriqi").val();
				var date = new Date(ktrq);
				var d1=new Date(ktrq); 
				var d2=new Date(d1); 
				var checkStartDate = $(".radio-inline:checked").val();
				if(checkStartDate == "1"){
					d2.setFullYear(d2.getFullYear()+1); 
					d2.setDate(d2.getDate()+6); 
					var d22=d2.toLocaleDateString();
					var dd3 = d22.toString();
					dd3 = dd3.replaceAll("/","-");
					$(".daoqiriqi").val(dd3);
				}if(checkStartDate == "3"){
					d2.setFullYear(d2.getFullYear()+3); 
					d2.setDate(d2.getDate()+6); 
					var d22=d2.toLocaleDateString();
					var dd3 = d22.toString();
					dd3 = dd3.replaceAll("/","-");
					$(".daoqiriqi").val(dd3);
				}if(checkStartDate == "50"){
					d2.setFullYear(d2.getFullYear()+50); 
					d2.setDate(d2.getDate()+6); 
					var d22=d2.toLocaleDateString();
					var dd3 = d22.toString();
					dd3 = dd3.replaceAll("/","-");
					$(".daoqiriqi").val(dd3);
				}
			}
			
		</script>

   	  	<script src="../js/calendar/jquery.js"></script>
   	    <script src="../js/calendar/jquery.datetimepicker.js"></script>
   	    <script src="../js/calendar/calendar.js"></script>
		

</body></html>