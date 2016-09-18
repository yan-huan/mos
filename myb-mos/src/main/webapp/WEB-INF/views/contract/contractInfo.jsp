<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="en"><head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>MOS-美业邦</title>
		<script src="../js/jquery-2.1.1.min.js"></script>
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
		
		var zhifuMoney = $("#zhifuMoney").val();
		if(zhifuMoney==0){
			alertInfo("请输入支付金额大于0");
			return false;
		}
		$("#showzhifuMoneyErr").hide();
		var zhifuMoney = $("#zhifuMoney").val();
			zhifuMoney = zhifuMoney.trim();
		if(zhifuMoney == ""){
			$("#showzhifuMoneyErr").show();
			return false;
		}
		$("#tg").attr("disabled",true);
		var contractId = $("#contractId").val();
		//通过
		if(type==1){
			$.ajax({
				url:"../Account/updateStatus.jhtml?isOk=1&contractId="+contractId+"&accountId="+accountId+"&zhifuMoney="+zhifuMoney,
				type:"GET",
				dataType:"text",
				success:function(data){
					$("#tg").attr("disabled",false);
					//账号通过
					if(data=="tg"){
						//展示提示的弹框
						alertInfoAno("开通账号成功了");
						//调取失败
					}else{
						alertInfoAno("开通账号失败了");
					}
					//调取失败
				},error:function(){
					$("#tg").attr("disabled",false);
					alertInfoAno("连接超时了");
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
 					window.location.href="../Account/showListOpenAccount.jhtml?finance=1";
 						var dlg = evt.data.dialog;
 					},
 					enterKey : function(evt){
 					window.location.href="../Account/showListOpenAccount.jhtml?finance=1";
 					},
 					escKey : function(evt){
 					window.location.href="../Account/showListOpenAccount.jhtml?finance=1";
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
						<h3 class="page-header">合同信息</h3>
						<input type="hidden" id="accountId" value="${contract.accountId}"/>
						<input type="hidden" id="contractId" value="${contract.contractId}"/>
						<table class="table table-bordered">
							<tbody><tr>
								<th width="20%">合同编号</th>
								<td width="30%">${contract.contractCode}</td>
								<th width="20%">公司名称</th>
								<td width="30%">${contract.companyName}</td>
							</tr>
							<tr>
								<th>甲方</th>
								<td>${contract.contractBody}</td>
								<th>姓名</th>
								<td>${contract.bossName}</td>
							</tr>

							<tr>
								<th>签约代表</th>
								<td>${contract.ownerName}</td>
								<th>开通账号</th>
								<td>${contract.openNumber}</td>
							</tr>
							<tr>
								<th>手机号</th>
								<td>${contract.bossAccount}</td>
								<th>店面数量</th>
								<td>${contract.shopCount}</td>
							</tr>
							<tr>
								<th>签约日期</th>
								<td>
								${fn:split(contract.beginDate, " ")[0]}
								</td>
								<th>合同金额</th>
								<td>￥${contract.contractMoney}</td>
							</tr>
							<tr>
								<th>备注</th>
								<td colspan="1">
								<c:if test="${fn:length(contract.remark)>23}">
									<div style='white-space:nowrap;text-overflow:ellipsis;overflow:hidden;' title='${contract.remark}'>
									${ fn:substring( contract.remark ,0,23)} ...
									</div>
								</c:if>
 								<c:if test="${fn:length(contract.remark)<=23}">${contract.remark}</c:if>
								
								</td>
								<th>创建合同人</th>
								<td>${contract.creater}</td>
							</tr>
							
							<tr>
								<th>附件</th>
								<td colspan="3">
								<c:if test="${contract.contractAnnex eq null || contract.contractAnnex eq ''}">
								<a href="javascript:void(0)">暂无下载附件</a>
								</c:if>
								<c:if test="${contract.contractAnnex ne null and contract.contractAnnex ne ''}">
									<a href="${httpUrl}/${contract.contractAnnex}">下载合同</a>
								</c:if>
								</td>
							</tr>
						</tbody>
					</table>
						<h3 class="page-header">付款信息</h3>
						
						<div class="tab-pane" id="b">
							<br>
							<table class="table table-bordered">
								<tbody>
								<tr>
									<th width="15%">支付日期</th>
									<th width="10%">实际支付金额</th>
									<th width="10%">支付方式</th>
									<th width="15%">账户名</th>
									<th width="20%">单号</th>
									<th>备注</th>
								</tr>
								<tr>
									<td>
									${fn:split(contract.payDate, " ")[0]}
									</td>
									<td> 
									
										<c:if test="${ispass ne 1 and finance eq 1}">
											<input type="text" class="form-control" placeholder="请输入支付金额" dataType="Require" msg="请输入支付金额" id="zhifuMoney" value="${contract.payMoney}" />
											<span style="display: none;color: red" id="showzhifuMoneyErr">请输入支付金额</span>
										</c:if>
										<c:if test="${ispass eq 1 and finance eq 1}">
											<input type="text" class="form-control" readonly="readonly" placeholder="请输入支付金额" dataType="Require" msg="请输入支付金额" id="zhifuMoney" value="${contract.payMoney}" />
										</c:if>
										<c:if test="${finance ne 1}">
											${contract.payMoney}
										</c:if>
									</td>
									<td>
									<c:if test="${contract.payType == 1}">
									支付宝
									</c:if>
									<c:if test="${contract.payType == 2}">
									微信
									</c:if>
									<c:if test="${contract.payType == 3}">
									刷卡
									</c:if>
									<c:if test="${contract.payType == 4}">
									银行转账
									</c:if>
									</td>
									<td>${contract.payAccountName}</td>
									<td>${contract.payNumber }</td>
									<td>
									<c:if test="${fn:length(contract.payRemark)>23}">
										<div style='white-space:nowrap;text-overflow:ellipsis;overflow:hidden;' title='${contract.payRemark}'>
										${ fn:substring(contract.payRemark ,0,23)} ...
										</div>
									</c:if>
									<c:if test="${fn:length(contract.payRemark)<=23}">
										${contract.payRemark}
									</c:if>
									</td>
								</tr>
							</tbody></table>
						</div>
						<a href="../contract/index.jhtml?pageIndex=1&accountId=${contract.accountId}">查看历史合同</a>
						<c:if test="${finance ==1 and ispass ne 1}">
							<button id="tg" onclick="approve(${contract.accountId},1)" class="btn btn-success">通过</button>
						</c:if>
						<c:if test="${finance ==1 }">
								<button class="btn btn-danger"  id="showRefuseInfo" >退回</button> 
						</c:if>
											
					</div>
				</div>
			</div>
			
			<div class="modal" id="mymodal" style="display: none;">
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
		</section>
		
		
		<!--/#contact-page-->

		<footer class="footer navbar-fixed-bottom">
			<div class="container">
				<p class="text-muted pull-right">美业邦 (北京) 科技有限公司 Copyright®2016</p>
			</div>
		</footer>
	

</body></html>