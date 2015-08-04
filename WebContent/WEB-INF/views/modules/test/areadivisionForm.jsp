<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>区域划分</title>
	<meta name="decorator" content="default"/>
	<%@include file="/WEB-INF/views/include/treeview.jsp" %>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#no").focus();
			$("#inputForm").validate({
				rules: {
					// name: {remote: "${ctx}/test/areadivision/checkName?oldName=" + encodeURIComponent('${areadivision.name}')}
				},
				messages: {
					name: {remote: "用户登录名已存在"}
				},
				submitHandler: function(form){
						var ids = [], nodes = tree.getCheckedNodes(true);
						for(var i=0; i<nodes.length; i++) {
							if (nodes[i].id != 1)
								ids.push(nodes[i].name);
						}
						$("#maintainers").val(ids);
						var ids2 = [], nodes2 = tree2.getCheckedNodes(true);
						for(var i=0; i<nodes2.length; i++) {
							if (nodes2[i].id != 1)
								ids2.push(nodes2[i].name);
						}
						$("#devices").val(ids2);
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
			
			 /* {id:"1", pId:"0", name:"代维人员列表"},
	            {id:"2", pId:"1", name:"张海斌"},
	            {id:"3", pId:"1", name:"胡伦良"},
	            {id:"4", pId:"1", name:"成筱文"} */
	            
			// 用户-菜单
			var zNodes=[{id:"1", pId:"0", name:"代维人员列表"},
			<c:forEach items="${maintainsList}" var="v">
				{id:"${v.id}", 
				pId:"1", 
				name:"${v.maintainerName}"},
			</c:forEach>];
			// 初始化树结构
			var tree = $.fn.zTree.init($("#maintainerTree"), setting, zNodes);
			
			// 默认选择节点
			var ids = "${areadivision.maintainers}".split(",");
			for(var i=0; i<ids.length; i++) {
				var node = tree.getNodeByParam("name", ids[i]);
				try{tree.checkNode(node, true, false);}catch(e){}
			}
			
			tree.expandAll(true);
			
			var zNodes2=[{id:"1", pId:"0", name:"被管网元列表"},
						<c:forEach items="${deviceList}" var="v">
							{id:"${v.id}", 
							pId:"1", 
							name:"${v.deviceName}"},
						</c:forEach>];
			// 初始化树结构
			var tree2 = $.fn.zTree.init($("#devicesTree"), setting, zNodes2);
			var ids2 = "${areadivision.devices}".split(",");
			for(var i=0; i<ids2.length; i++) {
				var node2 = tree2.getNodeByParam("name", ids2[i]);
				try{tree2.checkNode(node2, true, false);}catch(e){}
			}
			tree2.expandAll(true);
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/test/areadivision/list">区域划分列表</a></li>
		<li class="active"><a href="${ctx}/test/form/form?id=${areadivision.id}">区域划分${not empty areadivision.id?'修改':'添加'}</a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="areadivision" action="${ctx}/test/areadivision/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">编码:</label>
			<div class="controls">
				<form:input path="code" htmlEscape="false" maxlength="50" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">名称:</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="50" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">代维人员列表:</label>
			<div class="controls">
				<div id="maintainerTree" class="ztree" style="margin-top:3px;float:left;"></div>
				<form:hidden path="maintainers"/>
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
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>