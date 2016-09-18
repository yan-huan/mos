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
		<link href="../css/bootstrap/bootstrap-datetimepicker.min.css?v=2016817" rel="stylesheet" media="screen">
		<script type="text/javascript" src="../js/provinceCity.js?v=2016817"></script>
		<script type="text/javascript" src="../js/validate.js?v=2016817"></script>
		<script src="../js/alertInfo.js"></script>
		
	</head>
	<body >
	<jsp:include page="../menu/header.jsp" ></jsp:include>
		<section id="contact-page">
			<div class="container1">
				<div class="row">
				<jsp:include page="../menu/headerNext.jsp" ></jsp:include>
				<!--拒绝原因的弹窗Start  -->
			<div class="modal" id="mymodal1" style="display: none;">
				<div class="modal-dialog" style="width: 900px;">
					<div class="modal-content" style="width: 386px;margin: auto;">
						<div class="modal-body">
							<table class="table table-bordered">
								<tbody>
								<tr>
									<th width="20%">拒绝原由</th>
									<td width="30%">
										<input type="text" id="refuseInfo" class="form-control" placeholder="必填内容" datatype="Require" msg="请输入内容">
									</td>
								</tr>
							</tbody>
						</table>
						</div>
						<div class="modal-footer" >
							<button type="button" class="btn btn-success" id="saveRefuseInfo">保存</button>
							<button type="button" class="btn btn-default" data-dismiss="modal" onclick="closeWin()">关闭</button>	
						</div>
					</div>
				</div>
			</div>
			<!--拒绝原因的弹窗end  -->
					<div class="col-lg-offset-2 main">
						<h3 class="page-header">账号信息</h3>
						<div style="width: 50%;">
						<c:if test="${exception ne 1 }">
							<c:if test="${isqudao ne 'isqudao' }">
								<c:if test="${openAccount.isAddAccount ne 1}">
									<a class="btn btn-info btn-sm pull-right" href="../utils/contractSave.jhtml?accountId=${openAccount.accountId}" >添加合同</a>
								</c:if>
							</c:if>
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
											<c:if test="${exception ne 1 }">
												<c:if test="${finance eq 1}">
														<a href="javascript:void(0)" id="addCount" class="btn btn-danger bt pull-right btn-xs">+</a>
												</c:if>	
												<%-- <c:if test="${finance eq 1 and openAccount.approvalStatus ne 2}">
														<a href="javascript:void(0)"  class="btn btn-default bt pull-right btn-xs" style="background-color: #CDB79E">+</a>
												</c:if> --%>
											</c:if>
										</span>
									</td>
								</tr>
								<b style=" color: red;  size: b5; display: none;" id="Above"><font size="5">店数已满,如要加店请联系财务可申请加店</font></b>
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
							</tbody></table>

						</form>
						
						<c:if test="${exception eq 1 and shopList[0].ispass ne 1}">
						<a href="javascript:void(0)" onclick="passOk(${openAccount.accountId})" class="btn btn-success btn-sm pull-right">审核通过</a>
						<a href="javascript:void(0)" class="btn btn-success btn-sm pull-right" onclick="returnBack()">拒绝</a>
						</c:if>
						<c:if test="${exception eq 1 and  openAccount.ispass eq 1}">
						<a href="javascript:void(0)" onclick="passOk(${openAccount.accountId})" class="btn btn-success btn-sm pull-right">审核通过</a>
						<a href="javascript:void(0)" class="btn btn-success btn-sm pull-right" onclick="returnBack()">拒绝</a>
						</c:if>
											<c:if test="${exception ne 1 }">
							<%-- <c:if test="${openAccount.isOpenStatus eq 1 and finance eq 1}">
								<button id="addshop" class="btn btn-success btn-sm pull-right" type="button">添加店</button>
							</c:if>
							<c:if test="${openAccount.isOpenStatus ne 1 and finance eq 1}">
								<button id="addshop" class="btn btn-success btn-sm pull-right" type="button" disabled="disabled">添加店</button>
							</c:if>
							<c:if test="${finance ne 1}"> --%>
								<button id="addshop" class="btn btn-success btn-sm pull-right" type="button" >添加店</button>
							<%-- </c:if> --%>
						</c:if>
				<form  name="saveShop" id="addShop" method="post" >
					<input type="hidden" name="mobile" id="mobile" value="${openAccount.openNumber}" />
					<input type="hidden" name="accountId" id="accountId" value="${openAccount.accountId}" />
					
						<div class="modal" id="mymodal">
							<div class="modal-dialog" style="width: 900px;">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true" onclick="closeWin()">×</span><span class="sr-only">Close</span></button>
										<h4 class="modal-title">添加店</h4>
									</div>
									<div class="modal-body">
										<table class="table table-bordered">
											<tbody id="shopInfo">
											<tr>
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
												</td>
												<th width="20%">详细地址</th>
												<td width="30%">
														
											            
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
													<input type="text" name="giveAway" style="width: 50px;" class="form-control zengsong"   dataType="Require" msg="请输入内容" value="0">
												</td>
											</tr>
											<tr>
												<th width="20%">开通日期</th>
												<td width="30%">
													<input type="text"  name="beginDate"  class="form_datetime form-control kaitongriqi"  dataType="Require" msg="请输入开始日期">
												</td>
												<th width="20%">到期日期</th>
												<td width="30%">
													<input type="text" name="endDate" class="form_datetime form-control daoqiriqi"  dataType="Require" msg="请输入结束日期">
												</td>
											</tr>
										</tbody>
										</table>
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
								<c:if test="${openAccount.approvalStatus eq 2}">
									<c:if test="${finance ne 1}">
									<th>操作</th>
									</c:if>
									<c:if test="${finance eq 1}">
									<th>修改原因</th>
									</c:if>
								</c:if>
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
										<c:choose>
											<c:when test="${shop.giveAway ne '0' and shop.giveAway ne null and shop.giveAway ne ''}">
											<td class="giveAway">${shop.giveAway}月</td>
											</c:when>
											
											<c:otherwise>
											<td class="giveAway">无赠送月</td>
											</c:otherwise>
										</c:choose>
										<td class="beginDate">${shop.beginDate}</td>
										<td class="endDate">${shop.endDate}</td>
										<c:if test="${openAccount.approvalStatus eq 2}">
											<c:if test="${finance ne 1}">
											<td class="operation"><a href="javascript:void(0)"  onclick="modifyInfo(${shop.shopId},'delay')">延期</a>&nbsp;&nbsp;<a href="javascript:void(0)" class="modifyInfo" onclick="modifyInfo(${shop.shopId},'0')">修改信息</a>
												<!--是否通过  -->
												<c:if test="${shop.exceptionStatus ne 0 and shop.ispass eq 1}">
													通过
												</c:if>
												<c:if test="${shop.exceptionStatus ne 0 and shop.ispass eq 2}">
													未通过 <img alt="" src="../images/yuanyin.png?v=20160817" title="${shop.refuse}" width= 21px;>
												</c:if>
												<c:if test="${shop.exceptionStatus ne 0 and shop.ispass eq 3}">
													未审核
												</c:if>
											</td>
											</c:if>
											<!--销助修改的原因  -->
											<c:if test="${finance eq 1 and shop.exceptionStatus ne 0 }">
												<td ><img alt="" src="../images/yuanyin.png?v=20160817" title="${shop.refuse}" width= 21px;></td>
											</c:if>
											<c:if test="${finance eq 1 and shop.exceptionStatus eq 0 }">
												<td ></td>
											</c:if>
										</c:if>
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
		<script type="text/javascript" src="../js/bootstrap/bootstrap-datetimepicker.js" charset="UTF-8"></script>
		<script type="text/javascript" src="../js/bootstrap/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
		<script type="text/javascript" >
		String.prototype.replaceAll = function(reallyDo, replaceWith, ignoreCase) {  
		    if (!RegExp.prototype.isPrototypeOf(reallyDo)) {  
		        return this.replace(new RegExp(reallyDo, (ignoreCase ? "gi": "g")), replaceWith);  
		    } else {  
		        return this.replace(reallyDo, replaceWith);  
		    }  
		}  
		//日期格式化插件
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
		 $(function() {
				$(".kaitongriqi").change(function(){
					getDate();
				});
				$(".radio-inline").change(function(){
					getDate();
				});
				$('#addshop').click(function() {
					
					var myDate = new Date();
					if($(".showBeautiful").length == $("#countChange").text()) {
						//展示错误提示的弹框
						alertInfo("店数已满,如要加店请联系财务可申请加店");
					} else {
						$("#Above").hide();
						$(".dianming").val("");
					    $("#mymodal").show();
					}
					var ktrq = myDate.getFullYear()+"-"+(myDate.getMonth()*1+1)+"-"+(myDate.getDate());
					
					$(".kaitongriqi").val(ktrq);
					
					myDate.setDate(myDate.getDate()+6);
					var radioVal = $(".radio-inline:checked").val();
					if (radioVal == 1) {
						var allDate = (myDate.getFullYear()+1)+"-"+(myDate.getMonth()*1+1)+"-"+(myDate.getDate());
						console.info(allDate);

						$(".daoqiriqi").val(allDate);
					}
					if (radioVal == 3) {
						var allDate = (myDate.getFullYear()+3)+"-"+(myDate.getMonth()*1+1)+"-"+(myDate.getDate());
						$(".daoqiriqi").val(allDate);
					}
					if (radioVal == 50) {
						var allDate = (myDate.getFullYear()+50)+"-"+(myDate.getMonth()*1+1)+"-"+(myDate.getDate());
						$(".daoqiriqi").val(allDate);
					}
					
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
	   	    					location.reload();
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
				
				//退回店方法
				$("#saveRefuseInfo").click(function(){
					
					var refuseInfo = $("#refuseInfo").val();
					$("#errorInfo").remove();
					if (refuseInfo != ""){
						
					}else {
						$("#refuseInfo").after("<font color='red' id='errorInfo'>请输入拒绝原因</font>");
						return false;
					}
					
					var accountId = $("#accountId").val();
					$.ajax({
    				type:"POST",
    				dataType:"json",
    				data:{"refuse":refuseInfo},
    				url:"../ExceptionShop/returnBack.jhtml?accountId="+accountId,
    				success:function(data){
    					$("#mymodal1").hide();
    					if (data == 1) {
    						alertInfoAndHref("操作成功啦", "../ExceptionShop/modifyShopList.jhtml?pageIndex=1&type=delay&exception=delay");
    					}
    				},error:function(){
    					$("#mymodal1").hide();
    					//展示错误提示的弹框
    					alertInfo("连接超时了");
    					
    				}
				});
				
			});
					
			});
			
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
				$("#mymodal1").hide();
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
	    						$("#cityCode").html("");
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
			
			var accountId=0;
			//修改店的信息
			function modifyInfo(shopId,type){
				//如果加参数type等于delay是店的延期
				if (type=="delay") {
					url = "../Shop/modifyViewShop.jhtml?type=delay";
				} else {
					url = "../Shop/modifyViewShop.jhtml";
				}
				$.ajax({
    				type:"POST",
    				dataType:"json",
    				data:{"shopId":shopId},
    				url:url,
    				success:function(data){
    					console.info(data);
    					if(data != "0"){
    					$(".dianming").val(data.shopName);
    					$(".radio-inline").each(function(){
    						if ($(this).val() == data.duration){
    							$(this).attr("checked","checked");
    						}
    					})
    					$("#provinceCode option").each(function(){
    						if($(this).val()==data.province){
    							$(this).attr("selected","selected");
    						}
    					});
    					if (data.cityVos != undefined){
    						
    					for (var s=0; s<data.cityVos.length; s++) {
    						if(data.cityVos[s].cityCode == data.city){
    						$("#cityCode").append("<option value='"+data.cityVos[s].cityCode+"' selected='selected'>"+data.cityVos[s].cityName+"</option>");
    						}else{
    						$("#cityCode").append("<option value='"+data.cityVos[s].cityCode+"'>"+data.cityVos[s].cityName+"</option>");
    						}
    					}
    					}
    					$("#address").val(data.address);
    					//delay续签
    					if(data.modifyType=="delay"){
    						$("input").each(function(){
    							$(this).attr("disabled",true);
    						});
    						$("select").each(function(){
//     							$(this).attr("disabled",true);
    						});
    						$("input:radio").each(function(){
    							$(this).attr("disabled",false);
    						});
    						$(".kaitongriqi").attr("disabled",true).val(data.beginDate);
        					$(".daoqiriqi").attr("disabled",false).val(data.endDate);
        					$("#saveShopInfo").after("<button type=\"button\" class=\"btn btn-success\"  onclick='modifyShop("+1+","+shopId+")'>修改</button>");
    					
    					}else{
    						$("input").each(function(){
    							$(this).attr("disabled",false);
    						});
    						$("select").each(function(){
    							$(this).attr("disabled",false);
    						});
    						$("input:radio").each(function(){
    							$(this).attr("disabled",true);
    						});
    						//修改店的信息禁用时间
	    					$(".kaitongriqi").attr("disabled",true).val(data.beginDate);
	    					$(".daoqiriqi").attr("disabled",true).val(data.endDate);
	    					$("#saveShopInfo").after("<button type=\"button\" class=\"btn btn-success\"  onclick='modifyShop("+0+","+-1+")'>修改</button>");
    					}
    					$("#mobile").after("<input type='hidden' name='shopId' value='"+data.shopId+"' />");
						$("#mymodal").show();//显示出弹框
						$("#saveShopInfo").remove();
						$(".modal-title").html("修改店");
						//添加修改的原因输入框
						var str="";
						str+="<tr class='yy'>";
						str+="<th width=\"20%\">修改原因</th>";
						str+="<td width=\"30%\">";
						str+="<input type=\"text\"  name=\"refuse\"  class=\"form-control\"  dataType=\"Require\" msg=\"请输入修改原因\">";
						str+="</td>";
						str+="</tr>";	
						$(".yy").remove();
						$("#shopInfo").append(str);
						accountId=data.accountId;
    					}else  {
    						//展示错误提示的弹框
    						alertInfo("连接服务器失败了");
    					}
    				},error:function(){
    					//展示错误提示的弹框
    					alertInfo("连接服务器失败了");
    				}
    			});
			}
			
			
			function modifyShop(type,shopId){
				if(Validator.Validate(document.getElementById('addShop'),3)){
				$("#modifyShop").attr("disabled",true);
				
				if (type=="1"){
				 var url="../Shop/modifyShop.jhtml?type=delay";
				} else if(type=="0"){
				 var url="../Shop/modifyShop.jhtml?type=modify";
				} else {
				 var url="../Shop/modifyShop.jhtml";
				}
				$.ajax({
	    				type:"POST",
	    				dataType:"json",
	    				data:$("#addShop").serialize(),
	    				url:url,
	    				success:function(data){
	    					
	    					$("#modifyShop").attr("disabled",false);
	    					//第一次申请开店
	    					if(data == "1"){
	    						$(".addcurrentBeautiful").after(getContentData());
	    						$("#mymodal").hide();
	    						alertInfoAndHref("修改成功了","../Account/index.jhtml?type=2&accountId="+accountId);
	    					//已开通店	
	    					} else if (data == "2"){
	    						$("#mymodal").hide();
	   	    					$("#addcurrentBeautiful").after(getContentData());
	   	    					alertInfoAndHref("修改成功了","../Account/index.jhtml?type=2&accountId="+accountId);
	    					} else if (data == "5"){//延期需要添加完合同才修改店的状态为未审核
	    						window.location.href="../utils/contractSave.jhtml?type=delay&accountId="+accountId+"&shopId="+shopId;
	    					}else  {
	    						$("#mymodal").hide();
	    					//展示错误提示的弹框
	    					alertInfoAndHref("修改失败了","../Account/index.jhtml?type=2&accountId="+accountId);
	    					location.reload();
	    					}
	    				},error:function(){
	    					$("#mymodal").hide();
	    					//展示错误提示的弹框
	    					$("#modifyShop").attr("disabled",false);
	    					alertInfo("连接超时了");
	    					
	    				}
	    			});
				  }
				}
			function passOk(accountId){
				$.ajax({
    				type:"POST",
    				dataType:"json",
    				url:"../ExceptionShop/passedOk.jhtml?accountId="+accountId,
    				success:function(data){
    					if (data == 1) {
    						alertInfoAndHref("操作成功啦", "../ExceptionShop/modifyShopList.jhtml?pageIndex=1&type=delay&exception=delay");
    					}
    				},error:function(){
    					//展示错误提示的弹框
    					alertInfo("连接超时了");
    					
    				}
				});
			}
			//拒绝账号升级或者修改
			function returnBack(){
				
				$("#mymodal1").show();
				return false;
				
			}
			
			
		</script>

</body>
</html>