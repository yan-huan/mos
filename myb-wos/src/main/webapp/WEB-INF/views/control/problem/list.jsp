<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/share/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>问题列表</title>
<%@ include file="/WEB-INF/views/share/cssAndJs.jsp" %>
</head>
<body>
<div class="container-fluid" style="margin: 20px;font-size: 12px;">
	<form class="form-inline" action="${base }/manage/control/problem/list.jhtml" method="post" id="from">
		<div class="form-group">
		    <label for="tp">CODE：</label>
		    <input type="text" name="code" value="${code }" class="form-control" autocomplete="off"/>&nbsp;&nbsp;&nbsp;&nbsp;
		    
		    <label for="status">状态：</label>
		    <select name="status" class="form-control" id="status" >
			    	<option value="">全部</option>
			    	<c:forEach items="${dbDataDictionaryList }" var="dbDataDictionary">
			    		<option value="${dbDataDictionary.code }"<c:if test="${dbDataDictionary.code == status }"> selected="selected"</c:if>>${dbDataDictionary.name }</option>
			    	</c:forEach>
			</select>&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
	    <button type="submit" class="btn btn btn-primary" style="font-size: 12px;">查&nbsp;&nbsp;&nbsp;&nbsp;询</button>&nbsp;&nbsp;&nbsp;&nbsp;
	  	<input type="hidden" name="page" id="page" value="1"/>
	<div class="row-fluid" style="margin-top: 20px;">
		<div class="span12">
			<table class="table table-hover">
				<thead>
					<tr class="active">
						<th>
							问题编号
						</th>
						<th>
							标题
						</th>
						<th>
							状态
						</th>
						<th>
							提交人
						</th>
						<th>
							提交时间
						</th>
						<th>
							处理人
						</th>
						<th>
							处理时间
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
									${entity.id }
								</td>
								<td>
									<a href="${base }/manage/control/problem/editUI.jhtml?id=${entity.id}">${entity.title }</a>
								</td>
								<td>
									${dbDataDictionaryMap[entity.status] }
								</td>
								<td>
									${entity.createByUname }
								</td>
								<td>
									${entity.addTime }
								</td>
								<td>
									${entity.updateByUname }
								</td>
								<td>
									${entity.modifyTime }
								</td>
								<td>
									<a href="${base }/manage/control/problem/editUI.jhtml?id=${entity.id}">查看详情</a>
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
</form>
<div class="footer">
	<ul class="pager">
		<li><a href="javascript:void(0);">共${pagedList.recordCount }条记录</a></li>
		<li class="<c:if test="${pagedList.pageIndex == 1 }">disabled</c:if>"><a href="<c:if test="${pagedList.pageIndex > 1 }">${firstPage }</c:if><c:if test="${pagedList.pageIndex <= 1 }">javascript:void(0);</c:if>">首页</a></li>
	  	<li class="<c:if test="${pagedList.pageIndex == 1 }"> disabled</c:if>"><a href="<c:if test="${pagedList.pageIndex > 1 }">${prePage }</c:if><c:if test="${pagedList.pageIndex <= 1 }">javascript:void(0);</c:if>" >上一页</a></li>
	  	<li class="<c:if test="${pagedList.pageIndex >= pagedList.totalPage }">disabled</c:if>"><a href="<c:if test="${pagedList.pageIndex < pagedList.totalPage }">${nextPage }</c:if><c:if test="${pagedList.pageIndex >= pagedList.totalPage }">javascript:void(0);</c:if>">下一页</a></li>
	  	<li class="<c:if test="${pagedList.pageIndex >= pagedList.totalPage }">disabled</c:if>"><a href="<c:if test="${pagedList.pageIndex <= pagedList.totalPage }">${lastPage }</c:if><c:if test="${pagedList.pageIndex >= pagedList.totalPage }">javascript:void(0);</c:if>">尾页</a></li>
	</ul>
</div>
</body>
</html>