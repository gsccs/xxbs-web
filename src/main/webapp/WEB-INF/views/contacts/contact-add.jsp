<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>集团通讯录</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>

</head>

<body>
<fieldset>
	<legend style="font-weight: bold; font-size: 16pt; color: #E3393C;">新增通讯录</legend>
	<form id="contact_form" action="" method="post">
		<table cellspacing="0" cellpadding="0">
			<tr class="thclass" style="height: 40px">
					<th style="width: 130px;">姓名<font style="color: red">*</font></th>
					<td><input type="text" id="name" name="name" class="easyui-validatebox"
						required="true" missingMessage="不能为空"
						value="${contacts.name}" />
					</td>
			</tr>
			
			<tr class="thclass" style="height: 40px">
					<th style="width: 130px;">职务<font style="color: red">*</font></th>
					<td><input type="text" id="duty" name="duty" class="easyui-validatebox"
						value="${contacts.duty}" />
					</td>
			</tr>
		
			<tr class="thclass" style="height: 40px">
					<th style="width: 130px;">集团编码<font style="color: red">*</font></th>
					<td>
						<input type="text" id="ispcode" name="ispcode" class="easyui-validatebox"
						value="${contacts.ispcode}" />
					</td>
			</tr>
			
			
			<tr>
				<td colspan="2" style="text-align: right">
					<a id="saveTopicBtn"
						class="easyui-linkbutton" data-options="iconCls:'icon-add'"
						href="javascript:" onclick="saveContact()">保存</a> 
					<a id="btnBack" class="easyui-linkbutton" data-options="iconCls:'icon-back'"
						href="javascript:" onclick="BackIndex()">返回</a>
			</tr>
		</table>
	</form>
</fieldset>
<script type="text/javascript">
var basepath="${pageContext.request.contextPath}";

function saveContact(){
	var valid = $("#contact_form").form('validate');
	if(!valid){
		return;
	}
	$.ajax({
		url: basepath+'/contact/create',
		data : $("#contact_form").serialize(),
		dataType : 'json',
		type : 'POST',
	   success: function(result){
		   $.messager.show({
				title : '提示',
				msg : result.msg,
				timeout : 3000,
				showType : 'slide'
			});
		 	if (result.success) {
			 	document.location = basepath+'/contact';
			}
	   }
	});
}
function BackIndex(){
	document.location = basepath+'/contact';
}

$(document).ready(function(){
	
});	

</script>
</body>
</html>
