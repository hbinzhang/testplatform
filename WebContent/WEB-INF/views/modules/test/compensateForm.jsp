<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>数据补采</title>
	<meta name="decorator" content="default"/>
	<%@include file="/WEB-INF/views/include/treeview.jsp" %>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#no").focus();
			$("#inputForm").validate({
				rules: {
					// name: {remote: "${ctx}/test/manager/checkName?oldName=" + encodeURIComponent('${manager.name}')}
				},
				messages: {
					name: {remote: "用户登录名已存在"}
				},
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
			
			var setting = {check:{enable:true,nocheckInherit:true},view:{selectedMulti:false},
					data:{simpleData:{enable:true}},callback:{beforeClick:function(id, node){
						tree.checkNode(node, !node.checked, true, true);
						return false;
					}}};
			
			var zNodes2=[{id:"1", pId:"0", name:"被管网元列表"},
							<c:forEach items="${deviceList}" var="v">
								{id:"${v.id}", 
								pId:"1", 
								name:"${v.deviceName}"},
							</c:forEach>];
				// 初始化树结构
				var tree2 = $.fn.zTree.init($("#devicesTree"), setting, zNodes2);
				/* var ids2 = "${compensate.devices}".split(",");
				for(var i=0; i<ids2.length; i++) {
					var node2 = tree2.getNodeByParam("name", ids2[i]);
					try{tree2.checkNode(node2, true, false);}catch(e){}
				} */
				tree2.expandAll(true);
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/test/compensate/list">按缺失时段补采</a></li>
		<li><a href="${ctx}/test/compensate/form">按条件补采</a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="compensate" action="${ctx}/test/compensate/compensate" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">开始时间:</label>
			<div class="controls">
				<form:input path="startTime" htmlEscape="false" maxlength="50" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">结束时间:</label>
			<div class="controls">
				<form:input path="endTime" htmlEscape="false" maxlength="50" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">被管网元设备列表:</label>
			<div class="controls">
				<div id="devicesTree" class="ztree" style="margin-top:3px;float:left;"></div>
				<form:hidden path="devices"/>
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="补 采"/>
		</div>
	</form:form>
</body>
</html>