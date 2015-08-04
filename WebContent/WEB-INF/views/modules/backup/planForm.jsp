<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>自动备份策略</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript"><!--
		$(document).ready(function() {
			$("#no").focus();
			$("#inputForm").validate({
				rules: {
					value: {remote: "${ctx}/custom/filter/checkRelationName?oldName=" + encodeURIComponent('${rule.name}')}
				},
				messages: {
					value: {remote: "规则名已存在"}
				},
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});-->
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li ><a href="${ctx}/backup/planlist">自动备份计划列表</a></li>
		<li class="active"><a href="${ctx}/backup/planform">自动备份计划添加</a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="plan" action="${ctx}/backup/plansave" method="post" class="form-horizontal">
		<sys:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">备份类型:</label>
			<div class="controls">
				<form:input path="type" htmlEscape="false" maxlength="50" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">级别:</label>
			<div class="controls">
				<form:input path="level" htmlEscape="false" maxlength="50" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">间隔:</label>
			<div class="controls">
				<form:input path="value" htmlEscape="false" maxlength="50" class="required value"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">开始时间:</label>
			<div class="controls">
				<form:input path="startTime" htmlEscape="false" maxlength="50" class="required"/>
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>