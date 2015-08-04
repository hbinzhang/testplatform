<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>测试终端</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		function page(n,s){
			if(n) $("#pageNo").val(n);
			if(s) $("#pageSize").val(s);
			$("#searchForm").attr("action","${ctx}/stat/region/");
			$("#searchForm").submit();
	    	return false;
	    }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/stat/region/">故障处理统计</a></li>
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
			<li class="clearfix"></li>
			<li><label>区域维度：</label><select id="stattotal" style="width:80px" name=total>
					<option value="1">网元</option>
					<option value="2" selected="selected">区域</option>
			</select>
			<label>统计区域：</label>
			<form:input path="neLabel" htmlEscape="false" maxlength="50"
					class="input-medium" /></li>
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
		<thead><tr><th>区域名称</th><th class="sort-column count">总数(个)</th><th>总时长(小时)</th>
			</tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="stat">
			<tr>
				<td>${stat.neLabel}</td>
				<td>${stat.total}</td>
				<td>${stat.duration}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>