<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>历史备份管理</title>
	<meta name="decorator" content="default"/>
</head>
<body>
	<ul class="nav nav-tabs">
		<li ><a href="${ctx}/backup/historylist">历史备份列表</a></li>
		<li class="active"><a href="#">详细信息</a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="his" class="form-horizontal">
		<div class="control-group">
			<label class="control-label">开始时间:</label>
			<div class="controls">
				<form:input path="startTime" htmlEscape="false" maxlength="50" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">执行时长(秒):</label>
			<div class="controls">
				<form:input path="duration" htmlEscape="false" maxlength="50" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备份类型:</label>
			<div class="controls">
				<form:input path="type" htmlEscape="false" maxlength="50" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">成功标记:</label>
			<div class="controls">
				<form:input path="result" htmlEscape="false" maxlength="50" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">数据位置:</label>
			<div class="controls">
				<form:input path="filePath" htmlEscape="false" maxlength="50" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">数据大小(K):</label>
			<div class="controls">
				<form:input path="fileSize" htmlEscape="false" maxlength="50" />
			</div>
		</div>
		<div class="form-actions">
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>