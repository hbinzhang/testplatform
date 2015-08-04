<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>区域划分</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		function page(n,s){
			if(n) $("#pageNo").val(n);
			if(s) $("#pageSize").val(s);
			$("#searchForm").attr("action","${ctx}/test/compensate/list");
			$("#searchForm").submit();
	    	return false;
	    }
	</script>
</head>
<body>
<!--	<div id="importBox" class="hide">
		<form id="importForm" action="${ctx}/test/areadivision/import" method="post" enctype="multipart/form-data"
			class="form-search" style="padding-left:20px;text-align:center;" onsubmit="loading('正在导入，请稍等...');"><br/>
			<input id="uploadFile" name="file" type="file" style="width:330px"/><br/><br/>　　
			<input id="btnImportSubmit" class="btn btn-primary" type="submit" value="   导    入   "/>
			<a href="${ctx}/test/areadivision/import/template">下载模板</a>
		</form>
	</div>-->
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/test/areadivision/list">区域划分列表</a></li>
			<li><a href="${ctx}/test/areadivision/form">区域划分添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="areadivision" action="${ctx}/test/areadivision/list" method="post" class="breadcrumb form-search ">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<sys:tableSort id="orderBy" name="orderBy" value="${page.orderBy}" callback="page();"/>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
		<th>编码</th>
		<th>名称</th>
		<th>代维人员列表</th>
		<th>被管网元设备列表</th>
			</tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="v">
			<tr>
				<td>${v.code}</td>
				<td>${v.name}</td>
				<td>${v.maintainers}</td>
				<td>${v.devices}</td>
				<td>
    				<a href="${ctx}/test/areadivision/form?id=${v.id}">修改</a>
					<a href="${ctx}/test/areadivision/delete?id=${v.id}" onclick="return confirmx('确认要删除该人员吗？', this.href)">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>