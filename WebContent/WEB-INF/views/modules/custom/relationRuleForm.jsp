<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>告警关联规则</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
			$("#inputForm").validate({
				rules: {
					name: {remote: "${ctx}/custom/filter/checkRelationName?oldName=" + encodeURIComponent('${rule.name}')}
				},
				messages: {
					name: {remote: "规则名已存在"}
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
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/custom/filter/relationlist">关联规则列表</a></li>
		<li class="active"><a href="${ctx}/custom/filter/relationform?name=${rule.name}">关联规则${not empty rule.name?'修改':'添加'}</li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="rule" action="${ctx}/custom/filter/relationsave" method="post" class="form-horizontal">
		<sys:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">规则名:</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="50" class="required name"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">告警类型:</label>
			<div class="controls">
				<form:input path="alarmType" htmlEscape="false" maxlength="50" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">时间范围(秒):</label>
			<div class="controls">
				<form:input path="timeRange" htmlEscape="false" maxlength="50" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">关联告警类型:</label>
			<div class="controls">
				<form:input path="relatedAlarmType" htmlEscape="false" maxlength="50" class="required"/>
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>