<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>告警</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		function page(n,s){
			if(n) $("#pageNo").val(n);
			if(s) $("#pageSize").val(s);
			$("#searchForm").attr("action","${ctx}/test/managedDevice/nealarmlist?neid=${neid}");
			$("#searchForm").submit();
	    	return false;
	    }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/test/managedDevice/nelist">网元列表</a></li>
		<li class="active"><a href="${ctx}/test/managedDevice/nealarmlist?neid=${neid}">网元告警列表</a></li>
	</ul>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
		<th>流水号</th>
		<th>告警类型</th>
		<th>告警名称</th>
		<th>网元ID</th>
		<th>告警级别</th>
		<th>告警影响</th>
		<th>告警描述</th>
		<th>产生时间</th>
		<th>是否清除</th>
		<th>清除时间</th>
		<th>是否确认</th>
		<th>确认时间</th>
		<th>管理员ID</th>
			</tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="v">
			<tr>
				<td>${v.streamCode}</td>
				<td>${v.type}</td>
				<td>${v.name}</td>
				<td>${v.neid}</td>
				<td>${v.level}</td>
				<td>${v.effect}</td>
				<td>${v.description}</td>
				<td>${v.createTime}</td>
				<td>${v.clear}</td>
				<td>${v.clearTime}</td>
				<td>${v.ack}</td>
				<td>${v.ackTime}</td>
				<td>${v.maintainerId}</td>
				<td>
    				<a href="${ctx}/test/managedDevice/alarminfo?alarmStreamCode=${v.streamCode}">查询</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>