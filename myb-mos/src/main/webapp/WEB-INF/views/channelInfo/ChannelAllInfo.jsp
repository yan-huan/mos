<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="en"><head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>MOS-美业邦</title>
		<script src="../js/jquery-2.1.1.min.js"></script>
		<script src="../js/alertInfo.js"></script>
	<script type="text/javascript">
	
	$(function(){
		
		$("#showRefuseInfo").click(function(){
			
			$("#mymodal").show();
			$("#refuseInfo").focus();
		});
		
		//添加账号拒绝的原因
		$("#saveRefuseInfo").click(function(){
			
			var refuseInfo = $("#refuseInfo").val();
			
			if (refuseInfo != ""){
				
			}else {
				return false;
			}
			
			$.ajax({
				url:"../Account/updateRefuseInfo.jhtml",
				type:"GET",
				data:{"accountId":$("#accountId").val(),"refuseInfo":$("#refuseInfo").val()},
				dataType:"text",
				success:function(data){
					//账号通过
					if(data=="1"){
						$("#mymodal").hide();
						//展示提示的弹框
						alertInfoAno("合同已退回");
						//调取失败
					}else {
						$("#mymodal").hide();
						alertInfo("保存信息失败了");
					}
				},error:function(){
					$("#mymodal").hide();
					alertInfo("保存信息失败了");
				}
			
		});
		
	});
	});
	function closeWin() {
		$("#mymodal").hide();
	}
	function approve(accountId,type) {
		
		$("#tg").attr("disabled",true);
		//通过
		if(type==1){
			$.ajax({
				data:{"isqudao":"isqudao"},
				url:"../Account/updateStatus.jhtml?isOk=1&accountId="+accountId,
				type:"GET",
				dataType:"text",
				success:function(data){
					$("#tg").attr("disabled",false);
					if (data == "qudaoErrShopCount") {
						alertInfoAndHref("店数还没加全呢!","../channelInfo/allOpenAccountList.jhtml");
					}
					if (data == "qudaoErrMoney") {
						console.info(12122);
						alertInfoAndHref("预存款还不够呢!","../channelInfo/allOpenAccountList.jhtml");
					}
					//账号通过
					if(data=="tg"){
						//展示提示的弹框
						alertInfoAndHref("开通账号成功了!","../channelInfo/allOpenAccountList.jhtml");
						//调取失败
					}else if (data=="0"){
						alertInfoAndHref("开通账号失败了!","../channelInfo/allOpenAccountList.jhtml");
					}
					//调取失败
				},error:function(){
					$("#tg").attr("disabled",false);
					alertInfoAndHref("连接超时了!","../channelInfo/allOpenAccountList.jhtml");
				}
			});
		}
	}
	
	//渠道销售提交信息给财务
	function qudaotj(accountId,type) {
		
		$("#qdtg").attr("disabled",true);
		//通过
		if(type==1){
			$.ajax({
				url:"../channelInfo/setisShowQudaoList.jhtml?accountId="+accountId,
				type:"GET",
				dataType:"text",
				success:function(data){
					$("#qdtg").attr("disabled",false);
					if (data == "istj"){
						alertInfoAndHref("您已经提交过了,请等待财务审核!","../channelInfo/allOpenAccountList.jhtml");
					}
					if (data == "qudaoErrShopCount") {
						alertInfoAndHref("店数还没加全呢!","../channelInfo/allOpenAccountList.jhtml");
					}
					if (data == "qudaoErrMoney") {
						alertInfoAndHref("预存款还不够呢!","../channelInfo/allOpenAccountList.jhtml");
					}
					if (data == "qudaoErrContract") {
						alertInfoAndHref("合同还没添加呢!","../channelInfo/allOpenAccountList.jhtml");
					}
					//账号通过
					if(data=="success"){
						//展示提示的弹框
						alertInfoAndHref("成功提交给财务，等待审核!","../channelInfo/allOpenAccountList.jhtml");
						//调取失败
					}else if (data=="err"){
						alertInfoAndHref("提交失败，服务器错误!","../channelInfo/allOpenAccountList.jhtml");
					}
					//调取失败
				},error:function(){
					$("#qdtg").attr("disabled",false);
					alertInfoAndHref("连接超时了!","../channelInfo/allOpenAccountList.jhtml");
				}
			});
		}
	}
	
	  function  alertInfo(info){
 	    	var dialog = jDialog.alert(info,{},{
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
	  
	  function alertInfoAno(info){
		  
		  var dialog = jDialog.alert(info,{},{
 				showShadow: false,// 不显示对话框阴影
 				buttonAlign : 'center',
 				events : {
 					show : function(evt){
 						var dlg = evt.data.dialog;
 					},
 					close : function(evt){
 					window.location.href="../Account/showListOpenAccount.jhtml?finance=1&isqd=isqudao";
 						var dlg = evt.data.dialog;
 					},
 					enterKey : function(evt){
 					window.location.href="../Account/showListOpenAccount.jhtml?finance=1&isqd=isqudao";
 					},
 					escKey : function(evt){
 					window.location.href="../Account/showListOpenAccount.jhtml?finance=1&isqd=isqudao";
 						evt.data.dialog.close();
 					}
 				}
 			  });
	  }
	</script>
	</head>

	<body>
		<section id="contact-page">
			<div class="container1">
				<div class="row">
					<div class="col-lg-offset-2 col-md-10 main">
						<h3 class="page-header">渠道信息</h3>
						<input type="hidden"  id="accountId" value="${openAccount.accountId}"/>
						<table class="table table-bordered">
							<tr>
								<th width="20%">公司名称</th>
								<td width="30%">
									${channelInfo.companyName}
								</td>
								<th width="20%">公司地址</th>
								<td width="30%">
									${channelInfo.companyAddress}
								</td>
							</tr>
							<tr>
								<th width="20%">账户余额</th>
								<td width="30%">
									${channelInfo.readyDepositMoney}元
								</td>
								<th width="20%">保证金</th>
								<td width="30%">
									${channelInfo.marginMoney}元
								</td>
							</tr>
							<tr>
								<th width="20%">折扣</th>
								<td width="30%">
									${channelInfo.discountRate}
								</td>
								<th width="20%">合同到期时间</th>
								<td width="30%">
								${channelInfo.endTime}
								</td>
							</tr>
						</table>
						<h3 class="page-header">美容院信息</h3>
						<table class="table table-bordered">
							<tr>
								<th width="20%">美容院名称</th>
								<td width="30%">
									${openAccount.beautifulyard}
								</td>
								<th width="20%">老板手机号</th>
								<td width="30%">
									${openAccount.openNumber}
								</td>
							</tr>
							<tr>
								<th width="20%">购买店数</th>
								<td width="30%">
									${openAccount.shopCount}
								</td>
								<th width="20%">省市区</th>
								<td width="30%">
									${openAccount.provinceName}-${openAccount.cityName}
								</td>
							</tr>
						</table>
						<h3 class="page-header">费用统计</h3>
						<table class="table table-bordered">
							<tr>
								<th >店名</th>
								<th >年限</th>
								<th >赠送</th>
								<th >单价</th>
								<th >折扣</th>
								<th >实际费用</th>
							</tr>
							<c:forEach items="${shopsList}" var="shopsList">
							<tr>
								<td>${shopsList.shopName}</td>
								<c:if test="${shopsList.duration eq 1}">
								<td>一年</td>
								</c:if>
								<c:if test="${shopsList.duration eq 3}">
								<td>三年</td>
								</c:if>
								<c:if test="${shopsList.duration eq 50}">
								<td>终身</td>
								</c:if>
								
								<td>${shopsList.giveAway}</td>
								<td>${shopsList.danjia}元</td>
								<td>${shopsList.currentRate}</td>
								<td >${shopsList.shijiMoney}元</td>
							</tr>
							
							</c:forEach>
							
							<tr>
							<td colspan="4"></td><td><strong>合计金额</strong></td>
								<td>
								<c:if test="${shopsList[0].allMoney eq 0 or shopsList[0].allMoney eq null}">
								<font color="red" size="5">0元</font>
								</c:if>
								<c:if test="${shopsList[0].allMoney ne 0 and shopsList[0].allMoney ne null}">
								<font color="red" size="5">${shopsList[0].allMoney}元</font>
								</c:if>
										
								</td>
							</tr>
						</table>
						<c:if test="${finance eq 1}">
							<button id="tg" onclick="approve(${openAccount.accountId},1)" class="btn btn-success">通过</button>
							<button class="btn btn-danger"  id="showRefuseInfo" >退回</button> 
						</c:if>
						<c:if test="${qudao eq 1}">
							<c:if test="${openAccount.approvalStatus eq 1 and openAccount.isShowQudaoList ne 1}">
								<button id="qdtg"  onclick="qudaotj(${openAccount.accountId},1)" class="btn btn-success">提交</button>
							</c:if>
							<c:if test="${openAccount.approvalStatus eq 3 and openAccount.isShowQudaoList eq 1}">
								<button id="qdtg"  onclick="qudaotj(${openAccount.accountId},1)" class="btn btn-success">提交</button>
							</c:if>
							<c:if test="${openAccount.approvalStatus eq 4 and openAccount.isShowQudaoList eq 1}">
								<button id="qdtg"  onclick="qudaotj(${openAccount.accountId},1)" class="btn btn-success">提交</button>
							</c:if>
							<c:if test="${openAccount.approvalStatus eq 2}">
								<span class="text-status-success" style="font-size: large;font-weight: bold;">已开通</span>
							</c:if>
						</c:if>
						<a href="../contract/index.jhtml?pageIndex=1&accountId=${openAccount.accountId}">查看历史合同</a>
				</div>
				</div>
			</div>
			<div class="modal" id="mymodal" style="display: none;">
							<div class="modal-dialog" style="width: 900px;">
								<div class="modal-content" style="width:386px;margin:auto;">
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
		</section>
		
		
		<!--/#contact-page-->

		<footer class="footer navbar-fixed-bottom">
			<div class="container">
				<p class="text-muted pull-right">美业邦 (北京) 科技有限公司 Copyright®2016</p>
			</div>
		</footer>
	

</body></html>