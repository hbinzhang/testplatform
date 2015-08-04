<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>告警级别规则</title>
<meta name="decorator" content="default" />
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/custom/filter/severitylist">告警级别规则</a></li>
	</ul>
	<sys:message content="${message}" />
	<form:form id="searchForm" modelAttribute="rule"
		action="${ctx}/custom/filter/severitysave" method="post"
		class="breadcrumb form-search ">
		<sys:message content="${message}" />
		<table id="contentTable"
			class="table table-striped table-bordered table-condensed">
			<thead>
				<tr>
					<th>告警级别</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><form:checkbox path="critical" />严重告警</td>
				</tr>
				<tr>
					<td><form:checkbox path="major" />主要告警</td>
				</tr>
				<tr>
					<td><form:checkbox path="minor" />次要告警</td>
				</tr>
				<tr>
					<td><form:checkbox path="warning" />警告告警</td>
				</tr>
			</tbody>
		</table>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit"
				value="保 存" />&nbsp; <input id="btnCancel" class="btn" type="button"
				value="返 回" onclick="history.go(-1)" />
		</div>
	</form:form>

</body>
</html>