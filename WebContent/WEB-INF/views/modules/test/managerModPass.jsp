<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>系统管理员</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#no").focus();
			$("#inputForm").validate({
				rules: {
					// name: {remote: "${ctx}/test/manager/checkName?oldName=" + encodeURIComponent('${manager.name}')}
				},
				messages: {
					name: {remote: "用户登录名已存在"}
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
		<li><a href="${ctx}/test/manager/list">系统管理员列表</a></li>
		<%-- <li class="active"><a href="${ctx}/test/manager/form">系统管理员修改}</a></li> --%>
		<li class="active"><a href="${ctx}/test/manager/modPass/${manager.loginName}">修改系统管理员${manager.loginName}密码</a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="manager" action="${ctx}/test/manager/changePassWord" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">登陆名:</label>
			<div class="controls">
				<form:input path="loginName" htmlEscape="false" maxlength="50" readonly="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">旧密码:</label>
			<div class="controls">
				<form:input type="password" path="passwordOld" htmlEscape="false" maxlength="50" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">新密码:</label>
			<div class="controls">
				<form:input type="password" path="password" htmlEscape="false" maxlength="50" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">新密码确认:</label>
			<div class="controls">
				<form:input type="password" path="passwordAgain" htmlEscape="false" maxlength="50" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>