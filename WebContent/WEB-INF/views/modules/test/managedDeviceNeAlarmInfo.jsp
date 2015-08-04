<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/dialog.jsp"%>
<html>
<head>
	<title>告警</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		function page(n,s){
			if(n) $("#pageNo").val(n);
			if(s) $("#pageSize").val(s);
			$("#searchForm").attr("action","${ctx}/test/maintainer/list");
			$("#searchForm").submit();
	    	return false;
	    }
		
		function clearAlarm() {
			top.$.jBox.tip("清除告警成功","success",{persistent:true,opacity:0});
			window.location.href='${ctx}/test/managedDevice/handle?type=1&streamCode=${alarm.streamCode}'
		}
		
		function confirmAlarm() {
			top.$.jBox.tip("确认告警成功","success",{persistent:true,opacity:0});
			window.location.href='${ctx}/test/managedDevice/handle?type=2&streamCode=${alarm.streamCode}';
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/test/managedDevice/nelist">网元列表</a></li>
			<li><a href="${ctx}/test/managedDevice/nealarmlist?neid=${neid}">网元告警列表</a></li>
			<li  class="active"><a href="${ctx}/test/managedDevice/alarminfo?alarmStreamCode=${streamCode}">告警详细信息</a></li>
	</ul>
	<form:form id="inputForm" modelAttribute="alarm" action="${ctx}/test/managedDevice/handle" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">流水号:</label>
			<div class="controls">
				<form:input path="streamCode" htmlEscape="false" maxlength="50" class="required" readonly="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">告警类型:</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="50" class="required" readonly="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">告警名称:</label>
			<div class="controls">
				<form:input path="type" htmlEscape="false" maxlength="50" readonly="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">告警级别:</label>
			<div class="controls">
				<form:input path="level" htmlEscape="false" maxlength="50" class="required" readonly="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">告警影响:</label>
			<div class="controls">
				<form:input path="effect" htmlEscape="false" maxlength="50" class="required" readonly="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">告警描述:</label>
			<div class="controls">
				<form:input path="description" htmlEscape="false" maxlength="50" class="required" readonly="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">产生时间:</label>
			<div class="controls">
				<form:input path="createTime" htmlEscape="false" maxlength="50" class="required" readonly="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否清除:</label>
			<div class="controls">
				<form:input path="clear" htmlEscape="false" maxlength="50" class="required" readonly="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">清除时间:</label>
			<div class="controls">
				<form:input path="clearTime" htmlEscape="false" maxlength="50" class="required" readonly="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否确认:</label>
			<div class="controls">
				<form:input path="ack" htmlEscape="false" maxlength="50" class="required" readonly="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">确认时间:</label>
			<div class="controls">
				<form:input path="ackTime" htmlEscape="false" maxlength="50" class="required" readonly="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">管理员:</label>
			<div class="controls">
				<form:input path="maintainerId" htmlEscape="false" maxlength="50" class="required" readonly="true"/>
			</div>
		</div>
		<div class="form-actions">
			<c:choose>  
			   <c:when test="${alarm.clear == 'YES'}">
			   <input id="btnClear" disabled="true" class="btn btn-primary" type="button" value="清  除" onclick="clearAlarm()"/>&nbsp;
			   </c:when>  
			   <c:otherwise> 
			   <input id="btnClear" class="btn btn-primary" type="button" value="清  除" onclick="clearAlarm()"/>&nbsp;
			   </c:otherwise>  
			</c:choose>  
			<c:choose>  
			<c:when test="${alarm.ack == 'YES'}">
			   <input id="btnConfirm" disabled="true" class="btn btn-primary" type="button" value="确  认" onclick="confirmAlarm()"/>&nbsp;
			   </c:when>  
			   <c:otherwise> 
			   <input id="btnConfirm" class="btn btn-primary" type="button" value="确  认" onclick="confirmAlarm()"/>&nbsp;
			   </c:otherwise>  
			</c:choose>  
		</div>
	</form:form>
</body>
</html>