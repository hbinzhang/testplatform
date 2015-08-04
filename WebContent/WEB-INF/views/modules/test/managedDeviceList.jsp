<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>告警</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		// alert("message is: " + "${message}");
		function page(n,s){
			if(n) $("#pageNo").val(n);
			if(s) $("#pageSize").val(s);
			$("#searchForm").attr("action","${ctx}/test/managedDevice/nelist");
			$("#searchForm").submit();
	    	return false;
	    }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/test/managedDevice/nelist">网元列表</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="managedDevice" action="${ctx}/test/managedDevice/nelist" method="post" class="breadcrumb form-search ">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<sys:tableSort id="orderBy" name="orderBy" value="${page.orderBy}" callback="page();"/>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
		<th>网元标识</th>
		<th>网元名称</th>
		<th>网元版本</th>
		<th>网元类型</th>
		<th>严重告警数量</th>
		<th>主要告警数量</th>
		<th>次要告警数量</th>
		<th>警告告警数量</th>
			</tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="v">
			<tr>
				<td>${v.neid}</td>
				<td>${v.neName}</td>
				<td>${v.neVersion}</td>
				<td>${v.neType}</td>
				<td>
				<c:choose>  
				   <c:when test="${v.critical != '0'}">
				   	<font color="red"><b>${v.critical}</b></font>
				   </c:when>  
				   <c:otherwise> 
				  	 ${v.critical}
				   </c:otherwise>  
				</c:choose>  
				</td>
				<td>
				<c:choose>  
				   <c:when test="${v.major != '0'}">
				   	<font color="red"><b>${v.major}</b></font>
				   </c:when>  
				   <c:otherwise> 
				  	 ${v.major}
				   </c:otherwise>  
				</c:choose>  
				</td>
				<td>
				<c:choose>  
				   <c:when test="${v.minor != '0'}">
				   	<font color="red"><b>${v.minor}</b></font>
				   </c:when>  
				   <c:otherwise> 
				  	 ${v.minor}
				   </c:otherwise>  
				</c:choose>  
				</td>
				<td>
				<c:choose>  
				   <c:when test="${v.warn != '0'}">
				   	<font color="red"><b>${v.warn}</b></font>
				   </c:when>  
				   <c:otherwise> 
				  	 ${v.warn}
				   </c:otherwise>  
				</c:choose>  
				</td>
				<td>
    				<a href="${ctx}/test/managedDevice/nealarmlist?neid=${v.neid}">查询</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>