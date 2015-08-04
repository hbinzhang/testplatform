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
			$("#searchForm").attr("action","${ctx}/test/terminal/list");
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
		<li class="active"><a href="${ctx}/test/terminal/list">测试终端列表</a></li>
			<li><a href="${ctx}/test/terminal/form">终端添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="terminal" action="${ctx}/test/terminal/list" method="post" class="breadcrumb form-search ">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<sys:tableSort id="orderBy" name="orderBy" value="${page.orderBy}" callback="page();"/>
		<ul class="ul-form">
			<li><label>生产厂家：</label><form:input path="manufacturer" htmlEscape="false" maxlength="50" class="input-medium"/></li>
			<li class="clearfix"></li>
			<li><label>终端名称：</label><form:input path="name" htmlEscape="false" maxlength="50" class="input-medium"/></li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询" onclick="return page();"/>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>终端类型</th><th>生产厂家</th><th class="sort-column name">终端名称</th><th>设备编码</th><th>协议版本</th><th>IP地址</th><th>端口</th><th>操作</th>
			</tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="terminal">
			<tr>
				<td>${terminal.type}</td>
				<td>${terminal.manufacturer}</td>
				<td><a href="${ctx}/test/terminal/form?id=${terminal.id}">${terminal.name}</a></td>
				<td>${terminal.code}</td>
				<td>${terminal.protocal}</td>
				<td>${terminal.ip}</td>
				<td>${terminal.port}</td> 
				<td>
    				<a href="${ctx}/test/terminal/form?id=${terminal.id}">修改</a>
					<a href="${ctx}/test/terminal/delete?id=${terminal.id}" onclick="return confirmx('确认要删除该终端吗？', this.href)">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>