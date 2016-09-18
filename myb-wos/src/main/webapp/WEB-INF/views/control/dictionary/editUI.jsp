<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/share/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>更新数据</title>
<%@ include file="/WEB-INF/views/share/cssAndJs.jsp"%>
<script type="text/javascript">
$(document).ready(function() {
    $('form').bootstrapValidator({
    	live: 'disabled',
    	feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            name: {
                validators: {
                    notEmpty: true,
                    stringLength: {
                        min: 1,
                        max: 30
                    }
                }
            },
            code: {
                validators: {
                    notEmpty: true,
                    stringLength: {
                        min: 1,
                        max: 30
                    }
                }
            }
        }
    });
});
</script>
</head>
<body>
 <div class="page-header col-sm-offset-2" >
     <h2>更新数据</h2>
 </div>
<form class="form-horizontal" id="addDomain" method="post" action="${base }/manage/control/dictionary/edit.jhtml" >
  <input type="hidden" name="id" value="${entity.id }"/>
  <input type="hidden" name="tp" value="${tp }"/>
  <div class="form-group">
    <label for="name" class="col-sm-2 control-label">数据名称</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="name" name="name" placeholder="数据名称" autocomplete="off" value="${entity.name }"/>
    </div>
  </div>
  <div class="form-group">
  	<label class="col-sm-2 control-label" for="type">类型</label>
  	<div class="col-sm-offset-0 col-sm-4">
		<select name="type" class="form-control" id="type" style="width: 360px;">
			<option value="1"<c:if test="${entity.type == 1 }"> selected="selected"</c:if>>问题类型</option>
			<option value="2"<c:if test="${entity.type == 2 }"> selected="selected"</c:if>>系统版本</option>
			<option value="3"<c:if test="${entity.type == 3 }"> selected="selected"</c:if>>角色</option>
			<option value="4"<c:if test="${entity.type == 4 }"> selected="selected"</c:if>>App版本</option>
			<option value="5"<c:if test="${entity.type == 5 }"> selected="selected"</c:if>>部门</option>
			<option value="6"<c:if test="${entity.type == 6 }"> selected="selected"</c:if>>问题状态</option>
			<option value="7"<c:if test="${entity.type == 7 }"> selected="selected"</c:if>>是否已授权</option>
			<option value="8"<c:if test="${entity.type == 8 }"> selected="selected"</c:if>>出现几率</option>
			<option value="99"<c:if test="${entity.type == 99 }"> selected="selected"</c:if>>其他</option>
		</select>
	</div>
  </div>
  <div class="form-group">
    <label for="name" class="col-sm-2 control-label">CODE</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="code" name="code" placeholder="CODE" autocomplete="off" value="${entity.code }"/>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-info" value="更新信息">更新信息</button>
    </div>
  </div>
</form>
</body>
</html>