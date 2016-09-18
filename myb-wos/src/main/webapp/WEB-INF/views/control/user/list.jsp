<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/share/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>用户列表</title>
<%@ include file="/WEB-INF/views/share/cssAndJs.jsp" %>
<script type="text/javascript">
	$(document).ready(function(){
		$("#allCheckBox").click(function() {
            $('input[name="ids"]').prop("checked",this.checked); 
        });
        var $subBox = $("input[name='ids']");
        $subBox.click(function(){
            $("#allCheckBox").prop("checked",$subBox.length == $("input[name='ids']:checked").length ? true : false);
        });
        
        $("#deleteBatch").click(function(){
       		if($("input[name='ids']:checked").length == 0) {
       			alert("请至少选择一项。");
       			return;
       		} else {
       			var oldAction = $("#from").attr("action");
            	$("#from").attr("action", "${base}/manage/control/user/batchDelete.jhtml?tp=${tp}");
            	$("#from").submit();
            	$("#from").attr("action", oldAction);
       		}
        });
	});
</script>
</head>
<body>
<div class="container-fluid" style="margin: 20px;font-size: 12px;">
	<form class="form-inline" action="${base }/manage/control/user/list.jhtml" method="post" id="from">
			<div class="form-group">
			    <label for="tp">姓名：</label>
			    <input type="text" name="un" value="${un }" class="form-control" autocomplete="off"/>&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
	    <button type="submit" class="btn btn btn-primary" style="font-size: 12px;">查&nbsp;&nbsp;&nbsp;&nbsp;询</button>&nbsp;&nbsp;&nbsp;&nbsp;
	  	<button type="button" class="btn btn btn-primary" style="font-size: 12px;" onclick="javascript:window.location.href='${base}/manage/control/user/addUI.jhtml'">新增</button>&nbsp;&nbsp;&nbsp;&nbsp;
	  	<button type="button" class="btn btn btn-primary" style="font-size: 12px;" id="deleteBatch">批量删除</button>&nbsp;&nbsp;&nbsp;&nbsp;
	  	<input type="hidden" name="page" id="page" value="1"/>
	<div class="row-fluid" style="margin-top: 20px;">
		<div class="span12">
			<table class="table table-hover">
				<thead>
					<tr class="active">
						<th>
							<label class="checkbox-inline">
							  <input type="checkbox" id="allCheckBox" > 全选
							</label>
						</th>
						<th>
							姓名
						</th>
						<th>
							用户名
						</th>
						<th>
							类型
						</th>
						<th>
							电话
						</th>
						<th>
							邮箱
						</th>
						<th>
							微信
						</th>
						<th>
							QQ
						</th>
						<th>
							部门
						</th>
						<th>
							添加时间
						</th>
						<th>
							修改时间
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody class="table table-striped table-hover table-condensed">
					<c:if test="${!empty pagedList.content }">
						<c:forEach items="${pagedList.content }" var="entity" varStatus="st">
							<tr class="<c:if test="${st.index % 2 == 0 }">success</c:if>">
								<td>
									<c:if test='${entity.username != "hailinlover"  }'><input type="checkbox"  value="${entity.id }" name="ids"/></c:if>
								</td>
								<td>
									${entity.uname }
								</td>
								<td>
									<c:if test='${entity.username != "hailinlover"  }'><a href="${base }/manage/control/user/editUI.jhtml?id=${entity.id}">${entity.username }</a></c:if>
									<c:if test='${entity.username == "hailinlover" }'>${entity.username }</c:if>
								</td>
								<td>
									<c:if test="${entity.administrator == 0 }">普通用户</c:if>
									<c:if test="${entity.administrator == 1 }"><font color="red">管理员</font></c:if>
								</td>
								<td>
									${entity.mobile }
								</td>
								<td>
									${entity.email }
								</td>
								<td>
									${entity.weixin }
								</td>
								<td>
									${entity.qq }
								</td>
								<td>
									${departMap[entity.department] }
								</td>
								<td>
									${entity.addTime }
								</td>
								<td>
									${entity.modifyTime }
								</td>
								<td>
									<c:if test='${entity.username != "hailinlover"  }'>
										<a href="${base }/manage/control/user/editUI.jhtml?id=${entity.id}">编辑</a>
										<a href="${base }/manage/control/user/delete.jhtml?id=${entity.id}">删除</a>
										<c:if test="${entity.administrator == 0 }">
											<a href="${base }/manage/control/user/admin.jhtml?id=${entity.id}&flag=1">设置为管理员</a>
										</c:if>
										<c:if test="${entity.administrator == 1 }">
											<a href="${base }/manage/control/user/admin.jhtml?id=${entity.id}&flag=0">取消管理员</a>
										</c:if>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${empty pagedList.content }">
						<tr class="danger">
							<td colspan="100" style="color: red;text-align: center;">
								暂无数据...
							</td>
						</tr>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>
</div>

<div class="footer">
	<ul class="pager">
		<li><a href="javascript:void(0);">共${pagedList.recordCount }条记录</a></li>
		<li class="<c:if test="${pagedList.pageIndex <= 1 }">disabled</c:if>"><a href="<c:if test="${pagedList.pageIndex > 1 }">${firstPage }</c:if><c:if test="${pagedList.pageIndex <= 1 }">javascript:void(0);</c:if>">首页</a></li>
	  	<li class="<c:if test="${pagedList.pageIndex <= 1 }"> disabled</c:if>"><a href="<c:if test="${pagedList.pageIndex > 1 }">${prePage }</c:if><c:if test="${pagedList.pageIndex <= 1 }">javascript:void(0);</c:if>" >上一页</a></li>
	  	<li class="<c:if test="${pagedList.pageIndex >= pagedList.totalPage }">disabled</c:if>"><a href="<c:if test="${pagedList.pageIndex < pagedList.totalPage }">${nextPage }</c:if><c:if test="${pagedList.pageIndex >= pagedList.totalPage }">javascript:void(0);</c:if>">下一页</a></li>
	  	<li class="<c:if test="${pagedList.pageIndex >= pagedList.totalPage }">disabled</c:if>"><a href="<c:if test="${pagedList.pageIndex < pagedList.totalPage }">${lastPage }</c:if><c:if test="${pagedList.pageIndex >= pagedList.totalPage }">javascript:void(0);</c:if>">尾页</a></li>
	</ul>
</div>
</form>
</body>
</html>