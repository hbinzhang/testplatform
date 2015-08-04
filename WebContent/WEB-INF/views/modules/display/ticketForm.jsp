<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>历史备份管理</title>
	<meta name="decorator" content="default"/>
</head>
<body>
	<ul class="nav nav-tabs">
		<li ><a href="${ctx}/display/ticket/ticketlist">故障工单列表</a></li>
		<li class="active"><a href="#">详细信息</a></li>
		<li ><a href="${ctx}/display/ticket/tracklist?ticketId=${ticket.ticketId}">行程轨迹</a></li>
		<li ><a href="${ctx}/display/ticket/processlist?ticketId=${ticket.ticketId}">处理过程</a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="ticket" class="form-horizontal">
		<div class="control-group">
			<label class="control-label">工单号:</label>
			<div class="controls">
				<form:input path="ticketId" htmlEscape="false" maxlength="50" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">网元编号:</label>
			<div class="controls">
				<form:input path="neId" htmlEscape="false" maxlength="50" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">网元名称:</label>
			<div class="controls">
				<form:input path="neLabel" htmlEscape="false" maxlength="50" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">处理人:</label>
			<div class="controls">
				<form:input path="maintainerName" htmlEscape="false" maxlength="50" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">下达时间:</label>
			<div class="controls">
				<form:input path="createTime" htmlEscape="false" maxlength="50" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">故障信息:</label>
			<div class="controls">
				<form:input path="detail" htmlEscape="false" maxlength="50" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">结束标志:</label>
			<div class="controls">
				<form:input path="flag" htmlEscape="false" maxlength="50" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">结束时间:</label>
			<div class="controls">
				<form:input path="endTime" htmlEscape="false" maxlength="50" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">最后处理结果:</label>
			<div class="controls">
				<form:input path="result" htmlEscape="false" maxlength="50" />
			</div>
		</div>
		<div class="form-actions">
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>