<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/share/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>数据字典列表</title>
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
            	$("#from").attr("action", "${base}/manage/control/dictionary/batchDelete.jhtml?tp=${tp}");
            	$("#from").submit();
            	$("#from").attr("action", oldAction);
       		}
        });
	});
</script>
</head>
<body>
<div class="container-fluid" style="margin: 20px;font-size: 12px;">
	<form class="form-inline" action="${base }/manage/control/dictionary/list.jhtml" method="post" id="from">
			<div class="form-group">
			    <label for="tp">类型：</label>
			    <select name="tp" class="form-control" id="tp" >
			    	<option value="">全部</option>
					<option value="1"<c:if test="${tp ==1 }"> selected="selected"</c:if>>问题类型</option>
					<option value="2"<c:if test="${tp ==2 }"> selected="selected"</c:if>>系统版本</option>
					<option value="3"<c:if test="${tp ==3 }"> selected="selected"</c:if>>角色</option>
					<option value="4"<c:if test="${tp ==4 }"> selected="selected"</c:if>>App版本</option>
					<option value="5"<c:if test="${tp ==5 }"> selected="selected"</c:if>>部门</option>
					<option value="6"<c:if test="${tp ==6 }"> selected="selected"</c:if>>问题状态</option>
					<option value="7"<c:if test="${tp ==7 }"> selected="selected"</c:if>>是否已授权</option>
					<option value="8"<c:if test="${tp ==8 }"> selected="selected"</c:if>>出现几率</option>
					<option value="99"<c:if test="${tp ==99 }"> selected="selected"</c:if>>其他</option>
				</select>&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
	    <button type="submit" class="btn btn btn-primary" style="font-size: 12px;">查&nbsp;&nbsp;&nbsp;&nbsp;询</button>&nbsp;&nbsp;&nbsp;&nbsp;
	  	<button type="button" class="btn btn btn-primary" style="font-size: 12px;" onclick="javascript:window.location.href='${base}/manage/control/dictionary/addUI.jhtml?tp=${tp}'">新增</button>&nbsp;&nbsp;&nbsp;&nbsp;
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
							ID
						</th>
						<th>
							名称
						</th>
						<th>
							类型
						</th>
						<th>
							CODE
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
									<input type="checkbox"  value="${entity.id }" name="ids"/>
								</td>
								<td>
									${entity.id }
								</td>
								<td>
									<a href="${base }/manage/control/dictionary/editUI.jhtml?id=${entity.id}&tp=${tp}">${entity.name }</a>
								</td>
								<td>
									<c:if test="${entity.type == 1 }">问题类型</c:if>
									<c:if test="${entity.type == 2 }">系统版本</c:if>
									<c:if test="${entity.type == 3 }">角色</c:if>
									<c:if test="${entity.type == 4 }">App版本</c:if>
									<c:if test="${entity.type == 5 }">部门</c:if>
									<c:if test="${entity.type == 6 }">问题状态</c:if>
									<c:if test="${entity.type == 7 }">是否已授权</c:if>
									<c:if test="${entity.type == 8 }">出现几率</c:if>
									<c:if test="${entity.type == 99 }">其他</c:if>
								</td>
								<td>
									${entity.code }
								</td>
								<td>
									${entity.addTime }
								</td>
								<td>
									${entity.modifyTime }
								</td>
								<td>
									<a href="${base }/manage/control/dictionary/editUI.jhtml?id=${entity.id}&tp=${tp}">编辑</a>
									<a href="${base }/manage/control/dictionary/delete.jhtml?id=${entity.id}&tp=${tp}">删除</a>
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
		<li class="<c:if test="${pagedList.pageIndex == 1 }">disabled</c:if>"><a href="<c:if test="${pagedList.pageIndex > 1 }">${firstPage }</c:if><c:if test="${pagedList.pageIndex <= 1 }">javascript:void(0);</c:if>">首页</a></li>
	  	<li class="<c:if test="${pagedList.pageIndex == 1 }"> disabled</c:if>"><a href="<c:if test="${pagedList.pageIndex > 1 }">${prePage }</c:if><c:if test="${pagedList.pageIndex <= 1 }">javascript:void(0);</c:if>" >上一页</a></li>
	  	<li class="<c:if test="${pagedList.pageIndex == pagedList.totalPage }">disabled</c:if>"><a href="<c:if test="${pagedList.pageIndex < pagedList.totalPage }">${nextPage }</c:if><c:if test="${pagedList.pageIndex >= pagedList.totalPage }">javascript:void(0);</c:if>">下一页</a></li>
	  	<li class="<c:if test="${pagedList.pageIndex == pagedList.totalPage }">disabled</c:if>"><a href="<c:if test="${pagedList.pageIndex <= pagedList.totalPage }">${lastPage }</c:if><c:if test="${pagedList.pageIndex >= pagedList.totalPage }">javascript:void(0);</c:if>">尾页</a></li>
	</ul>
</div>
</form>
</body>
</html>