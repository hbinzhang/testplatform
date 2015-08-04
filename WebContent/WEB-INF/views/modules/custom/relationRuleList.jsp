<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>告警关联规则</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		function page(n,s){
			if(n) $("#pageNo").val(n);
			if(s) $("#pageSize").val(s);
			$("#searchForm").attr("action","${ctx}/custom/filter/relationlist");
			$("#searchForm").submit();
	    	return false;
	    }
	</script>
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
		<li class="active"><a href="${ctx}/custom/filter/relationlist">关联规则列表</a></li>
			<li><a href="${ctx}/custom/filter/relationform">关联规则添加</a></li>
	</ul>
	<sys:message content="${message}"/>
	<form:form id="searchForm" modelAttribute="rule" action="${ctx}/custom/filter/relationlist" method="post" class="breadcrumb form-search ">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<sys:tableSort id="orderBy" name="orderBy" value="${page.orderBy}" callback="page();"/>
		<ul class="ul-form">
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="刷新" onclick="return page();"/>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>规则名</th><th class="sort-column name">告警类型</th><th>时间范围</th><th>关联告警类型</th><th>操作</th>
			</tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="rule">
			<tr>
				<td><a href="${ctx}/custom/filter/relationform?name=${rule.name}">${rule.name}</a></td>
				<td>${rule.alarmType}</td>
				<td>${rule.timeRange}</td>
				<td>${rule.relatedAlarmType}</td>
				<td>
					<a href="${ctx}/custom/filter/relationdelete?name=${rule.name}" onclick="return confirmx('确认要删除该告警关联规则吗？', this.href)">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>