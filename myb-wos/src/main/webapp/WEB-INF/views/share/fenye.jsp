<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/share/taglib.jsp" %>
<c:if test="${pageView.totalPage != 0 }">
	<div style="float: right;margin-right: 35px;">
		<nav>
		  <ul class="pagination pagination-sm">
		    <li<c:if test="${pageView.currentPage <= 1 }"> class="disabled"</c:if>>
		    	<c:if test="${pageView.currentPage <= 1 }">
		    		<a aria-label="首页"><span aria-hidden="true">首页</span></a>
		    	</c:if>
		    	<c:if test="${pageView.currentPage > 1 }">
		    		<a href="#" aria-label="首页" onclick="toPage('1');"><span aria-hidden="true">首页</span></a>
		    	</c:if>
		    </li>
		    
		    <li<c:if test="${pageView.currentPage <= 1 }"> class="disabled"</c:if>>
		    	<c:if test="${pageView.currentPage <= 1 }">
		    		<a aria-label="上一页"><span aria-hidden="true">上一页</span></a>
		    	</c:if>
		    	<c:if test="${pageView.currentPage > 1 }">
		    		<a href="#" aria-label="上一页" onclick="toPage('${pageView.currentPage - 1}');"><span aria-hidden="true">上一页</span></a>
		    	</c:if>
		    </li>
		    
		    <c:forEach begin="${pageView.pageIndex.start }" end="${pageView.pageIndex.end }" var="sp">
		    	<li<c:if test="${pageView.currentPage == sp }"> class="active"</c:if>><a href="<c:if test="${pageView.currentPage == sp }">javascript:void(0);</c:if><c:if test="${pageView.currentPage != sp }">#</c:if>"<c:if test="${pageView.currentPage != sp }"> onclick="toPage('${sp}');"</c:if>>${sp }</a></li>
		    </c:forEach>
		    
		     <li<c:if test="${pageView.currentPage >= pageView.totalPage }"> class="disabled"</c:if>>
		    	<c:if test="${pageView.currentPage >= pageView.totalPage }">
		    		<a aria-label="下一页"><span aria-hidden="true">下一页</span></a>
		    	</c:if>
		    	<c:if test="${pageView.currentPage < pageView.totalPage }">
		    		<a href="#" aria-label="下一页" onclick="toPage('${pageView.currentPage + 1}');"><span aria-hidden="true">下一页</span></a>
		    	</c:if>
		    </li>
		    
		    <li<c:if test="${pageView.currentPage >= pageView.totalPage }"> class="disabled"</c:if>>
		    	<c:if test="${pageView.currentPage >= pageView.totalPage }">
		    		<a aria-label="尾页"><span aria-hidden="true">尾页</span></a>
		    	</c:if>
		    	<c:if test="${pageView.currentPage < pageView.totalPage }">
		    		<a href="#" aria-label="尾页" onclick="toPage('${pageView.totalPage}');"><span aria-hidden="true">尾页</span></a>
		    	</c:if>
		    </li>
		    
		  </ul>
		</nav>
	</div>
</c:if>
<script type="text/javascript">
	function toPage(page) {
		$("#page").val(page);
		$("form").submit();
	}
</script>