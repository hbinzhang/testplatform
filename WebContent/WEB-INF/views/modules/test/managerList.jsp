<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>系统管理员</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		function page(n,s){
			if(n) $("#pageNo").val(n);
			if(s) $("#pageSize").val(s);
			$("#searchForm").attr("action","${ctx}/test/manager/list");
			$("#searchForm").submit();
	    	return false;
	    }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/test/manager/list">系统管理员列表</a></li>
			<li><a href="${ctx}/test/manager/form">系统管理员添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="manager" action="${ctx}/test/manager/list" method="post" class="breadcrumb form-search ">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<sys:tableSort id="orderBy" name="orderBy" value="${page.orderBy}" callback="page();"/>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
		<th>登陆名</th>
		<th>姓名</th>
		<th>职务</th>
		<th class="sort-column name">手机号</th>
		<th>电子邮件</th>
			</tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="v">
			<tr>
				<td>${v.loginName}</td>
				<td>${v.name}</td>
				<td>${v.title}</td>
				<td>${v.mobile}</td>
				<%-- <td>${v.password}</td> --%>
				<td>${v.email}</td>
				<td>
    				<a href="${ctx}/test/manager/form?id=${v.id}">修改</a>
					<a href="${ctx}/test/manager/delete?id=${v.id}" onclick="return confirmx('确认要删除该人员吗？', this.href)">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>