<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>自动备份策略</title>
	<meta name="decorator" content="default"/>
</head>
<body>
<!--	<div id="importBox" class="hide">
		<form id="importForm" action="${ctx}/test/terminal/import" method="post" enctype="multipart/form-data"
			class="form-search" style="padding-left:20px;text-align:center;" onsubmit="loading('正在导入，请稍等...');"><br/>
			<input id="uploadFile" name="file" type="file" style="width:330px"/><br/><br/>　　
			<input id="btnImportSubmit" class="btn btn-primary" type="submit" value="   导    入   "/>
			<a href="${ctx}/test/terminal/import/template">下载模板</a>
		</form>
	</div>-->
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/backup/planlist">自动备份计划列表</a></li>
			<li><a href="${ctx}/backup/planform">自动备份计划添加</a></li>
	</ul>
	<sys:message content="${message}"/>
	<form:form id="searchForm"  action="${ctx}/backup/planlist" method="post" class="breadcrumb form-search ">
		<ul class="ul-form">
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="刷新" />
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>备份类型</th><th>级别</th><th>间隔</th><th>开始时间</th><th>操作</th>
			</tr></thead>
		<tbody>
		<c:forEach items="${page}" var="plan">
			<tr>
				<td>${plan.type}</td>
				<td>${plan.level}</td>
				<td>${plan.value}</td>
				<td>${plan.startTime}</td>
				<td>
					<a href="${ctx}/backup/planform?id=${rule.id}">修改</a>
					<a href="${ctx}/custom/filter/relationdelete?name=${rule.name}" onclick="return confirmx('确认要删除该告警关联规则吗？', this.href)">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>