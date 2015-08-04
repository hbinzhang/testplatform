<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>代维人员</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		function page(n,s){
			if(n) $("#pageNo").val(n);
			if(s) $("#pageSize").val(s);
			$("#searchForm").attr("action","${ctx}/test/maintainer/list");
			$("#searchForm").submit();
	    	return false;
	    }
	</script>
</head>
<body>
<!--	<div id="importBox" class="hide">
		<form id="importForm" action="${ctx}/test/maintainer/import" method="post" enctype="multipart/form-data"
			class="form-search" style="padding-left:20px;text-align:center;" onsubmit="loading('正在导入，请稍等...');"><br/>
			<input id="uploadFile" name="file" type="file" style="width:330px"/><br/><br/>　　
			<input id="btnImportSubmit" class="btn btn-primary" type="submit" value="   导    入   "/>
			<a href="${ctx}/test/maintainer/import/template">下载模板</a>
		</form>
	</div>-->
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/test/maintainer/list">代维人员列表</a></li>
			<li><a href="${ctx}/test/maintainer/form">代维人员添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="maintainer" action="${ctx}/test/maintainer/list" method="post" class="breadcrumb form-search ">
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
		<th>手机号</th>
		
			</tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="v">
			<tr>
				<td>${v.loginName}</td>
				<td>${v.name}</td>
				<td>${v.title}</td>
				<td>${v.mobile}</td>
				
				<td>
    				<a href="${ctx}/test/maintainer/form?id=${v.id}">修改</a>
					<a href="${ctx}/test/maintainer/delete?id=${v.id}" onclick="return confirmx('确认要删除该人员吗？', this.href)">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>