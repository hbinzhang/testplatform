<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>告警统计</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		function page(n,s){
			if(n) $("#pageNo").val(n);
			if(s) $("#pageSize").val(s);
			$("#searchForm").attr("action","${ctx}/stat/alarm/table");
			$("#searchForm").submit();
	    	return false;
	    }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="#">表格</a></li>
		<li><a href="${ctx}/stat/alarm/chart">级别统计图</a></li>
		<li><a href="${ctx}/stat/alarm/timechart">时长统计图</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="stat"
		action="${ctx}/stat/region/" method="post"
		class="breadcrumb form-search ">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden"
			value="${page.pageSize}" />
		<sys:tableSort id="orderBy" name="orderBy" value="${page.orderBy}"
			callback="page();" />
		<ul class="ul-form">
			<li><label>时间维度：</label><select id="statneId" style="width:80px" name="neId">
					<option value="day">天</option>
					<option value="month">月</option>
			</select>
			<label>统计时间：</label>
			<input id="statTime" name="statTime"
				type="text" readonly="readonly" maxlength="20"
				class="input-mini Wdate"
				value="<fmt:formatDate value="${stat.statTime}" pattern="yyyy-MM-dd"/>"
				onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});" />
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary"
				type="submit" value="查询" onclick="return page();" />
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<script type="text/javascript">
			$("#statneId").val("${stat.neId}");
	</script>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
		<th>网元编号</th>
		<th>网元名称</th>
		<th class="sort-column count">总数(个)</th>
		<th class="sort-column count">严重告警数(个)</th>
		<th class="sort-column count">主要告警数(个)</th>
		<th class="sort-column count">次要告警数(个)</th>
		<th class="sort-column count">警告告警数(个)</th>
		<th>总时长(小时)</th>
			</tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="stat">
			<tr>
				<td>${stat.neId}</td>
				<td>${stat.neLabel}</td>
				<td>${stat.total}</td>
				<td>${stat.criticalCount}</td>
				<td>${stat.majorCount}</td>
				<td>${stat.minorCount}</td>
				<td>${stat.warnCount}</td>
				<td>${stat.duration}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>