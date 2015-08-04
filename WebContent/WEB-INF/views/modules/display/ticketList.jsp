<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>故障工单</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		function page(n,s){
			if(n) $("#pageNo").val(n);
			if(s) $("#pageSize").val(s);
			$("#searchForm").attr("action","${ctx}/display/ticket/ticketlist");
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
		<li class="active"><a href="#">故障工单列表</a></li>
		<li ><a href="#">详细信息</a></li>
		<li ><a href="#">行程轨迹</a></li>
		<li ><a href="#">处理过程</a></li>
	</ul>
	<sys:message content="${message}"/>
	<form:form id="searchForm" modelAttribute="rule" action="${ctx}/display/ticket/ticketlist" method="post" class="breadcrumb form-search ">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<sys:tableSort id="orderBy" name="orderBy" value="${page.orderBy}" callback="page();"/>
		<ul class="ul-form">
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="刷新" onclick="return page();"/>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>工单号</th><th >网元编号</th><th>网元名称</th><th>处理人</th><th>下达时间</th><th>故障信息</th><th>结束标志</th><th>结束时间</th><th>最后处理结果</th><th>操作</th>
			</tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="ticket">
			<tr>
				<td>${ticket.ticketId}</td>
				<td>${ticket.neId}</td>
				<td>${ticket.neLabel}</td>
				<td>${ticket.maintainerName}</td>
				<td>${ticket.createTime}</td>
				<td>${ticket.detail}</td>
				<td>${ticket.flag}</td>
				<td>${ticket.endTime}</td>
				<td>${ticket.result}</td>
				<td>
					<a href="${ctx}/display/ticket/ticketform?ticketId=${ticket.ticketId}">查看</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>