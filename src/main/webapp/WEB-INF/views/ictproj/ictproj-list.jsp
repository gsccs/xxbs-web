<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ICT项目</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
<style type="text/css">
th{
	font-size: 12px;
  	padding: 5px 10px;
}

.datagrid-header td{
	text-align: center;
}
</style>
</head>

<body>
	<div class="easyui-layout" fit="true" border="false">
            <div data-options="region:'north'" style="height: 50px; background: #F4F4F4;">
                <form id="searchForm">
                    <table>
                        <tr>
                            <th>项目名称：</th>
                            <td>
                                <input id="notice_title" name="title" value=""/></td>
                            <th>状态：</th>
                            <td><select id="state" name="state">
                            		<option value="0">未开始</option>
									<option value="1">进行中</option>
									<option value="-1">关闭</option>
								</select>
                            </td>
                            <td><a class="easyui-linkbutton" href="javascript:void(0);" onclick="searchFunc();">查找</a></td>
                        </tr>
                    </table>
                </form>
            </div>
            <div data-options="region:'center',split:false">
                <div class="easyui-layout" fit="true" border="false">
					<div data-options="region:'west',title:''" style="width:65%;">
						<table id="list_data" cellspacing="0" cellpadding="0">
						</table>
					</div>
					<div data-options="region:'east'" style="width:36%;">
						<table id="prog_list_data" cellspacing="0" cellpadding="0"></table>
					</div>
				</div>
            </div>
            <div id="toobar" style="padding:5px;height:auto">
				<div style="margin-bottom:5px">
					<shiro:hasPermission name="corp:create">
					<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"  onClick="addFun()">新增</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="corp:update">
					<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="editFun()">修改</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="corp:delete">
					<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="delFun()">删除</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="corp:create">
					<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="addProgFun()">新增项目进度</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="corp:create">
					<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="editProgFun()">编辑项目进度</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="corp:create">
					<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="delProgFun()">删除项目进度</a>
					</shiro:hasPermission>
				</div>
    </div>
	
	<div id="ictprog_window"></div>
	<script type="text/javascript">
		var basepath="${pageContext.request.contextPath}";
		function fmtDate(){
			$('.easyui-datebox').attr("readonly","readonly");
			$('.easyui-datebox').datebox({
			    formatter: function(date){ 
			    	if(date){
			    		var day = date.getDate() > 9 ? date.getDate() : "0" + date.getDate();
			    		var month = (date.getMonth() + 1) > 9 ? (date.getMonth() + 1) : "0"+ (date.getMonth() + 1);
			    		return date.getFullYear()+'-'+month+'-'+day;
			    	}
			    },
			    parser: function(date){ 
			    	if(date){
			    	return new Date(Date.parse(date.replace(/-/g,"/")));
			    	}
			    }
			});
		}
		$(document).ready(function(){
			fmtDate();
		});	
		$('#list_data').datagrid({
			height : 'auto',
			nowrap : false,
			striped : true,
			border : true,
			collapsible : false,//是否可折叠的 
			fit : true,//自动大小 
			loadMsg : '数据加载中请稍后……',
			url : basepath+'/ictproj/datagrid',
			remoteSort : false,
			fitColums : true,
			checkOnSelect : true,
			singleSelect : true,//是否单选 
			pagination : true,//分页控件 
			rownumbers : true,//行号 
			idField: 'id',
			columns : [ [ {
				field : 'id',
				title : '编号',
				width : 150,
				checkbox : true
			}, {
				field : 'name',
				title : '项目名称',
				width : 100
			}, {
				field : 'planstartdateStr',
				title : '项目开始时间',
				width : 80
			}, {
				field : 'planenddateStr',
				title : '项目结束时间',
				width : 80
			}, {
				field : 'ussm',
				title : '项目金额',
				width : 80
			}, {
				field : 'telephone',
				title : '联系电话',
				width : 100
			}, {
				field : 'status',
				title : '状态',
				width : 50,
				formatter:function(value,row){
			    	var str = "";
			    	if(value=="1"){
			    		str = "<font style=''>进行中 </font>";
			    	}else if(value=="0"){
			    		str = "<font style=''>未开始</font>";
			    	}else if(value=="-1"){
			    		str = "<font style=''>关闭</font>";
			    	}
			    	 return str;
				} 
			}, {
				field : 'remark',
				title : '备注说明',
				width : 100
			}] ],
			toolbar : '#toobar',
			pageSize : 15,
			pageList : [10, 15 ],
			onClickRow:function () {
				
		        var projrow = $('#list_data').datagrid("getSelected");
		        selectProj(projrow.id);
		       
		    }
		});
		//设置分页控件 
		var p = $('#list_data').datagrid('getPager');
		$(p).pagination({
			pageSize : 10,				//每页显示的记录条数，默认为10 
			pageList : [ 5, 10, 15 ],	//可以设置每页记录条数的列表 
			beforePageText : '第',		//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		}); 
		
		//添加
		function addFun() {
	    	document.location = basepath+'/ictproj/dataform';
	    }

		//编辑
		function editFun(){
			var checkedRows = $("#list_data").datagrid('getChecked');
			if(checkedRows.length == 1) {
				document.location = basepath+'/ictproj/dataform?id='+checkedRows[0].id;
			}else if(checkedRows.length > 1) {
				$.messager.show({
					title : '提示',
					msg : '只能选择一条信息编辑!',
					timeout : 3000,
					showType : 'slide'
				});
			}else if(checkedRows.length < 1){
				$.messager.show({
					title : '提示',
					msg : '请勾选想要编辑的信息!',
					timeout : 3000,
					showType : 'slide'
				});
			}else {
				$.messager.show({
					title : '提示',
					msg : '请勾选想要编辑的信息!',
					timeout : 3000,
					showType : 'slide'
				});
			}
		}
		
		//添加施工进度
		function addProgFun(){
			var checkedRows = $("#list_data").datagrid('getChecked');
			if(checkedRows.length == 1) {
				var ictprog_window_dialog = $('#ictprog_window').dialog({
	    			title : '添加项目进度',
	    			width : 600,
	    			height : 400,
	    			closed : false,
	    			cache : false,
	    			href : basepath+'/projprog/dataform?pid='+checkedRows[0].id,
	    			modal : true,
	    			buttons : [ {
	    				text : '保   存',
	    				handler : function() {
	    					var valid = $("#prog_form").form('validate');
	    					if(!valid){
	    						return;
	    					}
	    					$('#prog_form').form('submit',{
	    						url : basepath+'/projprog/create',
	    						success : function(data) {
	    							var result = $.parseJSON(data);
	    							if (result.success) {
	    								$('#prog_list_data').datagrid('load');
	    								ictprog_window_dialog.dialog('close');
	    							}
	    							$.messager.show({
	    								title : '提示',
	    								msg : result.msg,
	    								timeout : 3000,
	    								showType : 'slide'
	    							});
	    						}
	    					});
	    				}
	    			} ],
	    			onLoad:function(){
	    				fmtDate();
	    			}
	    		});
			}else if(checkedRows.length > 1) {
				$.messager.show({
					title : '提示',
					msg : '只能选择一条ICT项目添加其项目进度!',
					timeout : 3000,
					showType : 'slide'
				});
			}else if(checkedRows.length < 1){
				$.messager.show({
					title : '提示',
					msg : '请勾选想要添加的ICT项目!',
					timeout : 3000,
					showType : 'slide'
				});
			}else {
				$.messager.show({
					title : '提示',
					msg : '请勾选想要添加的ICT项目!',
					timeout : 3000,
					showType : 'slide'
				});
			}
		}
		
		//编辑施工进度
		function editProgFun(){
			var checkedRows = $("#prog_list_data").datagrid('getChecked');
			if(checkedRows.length == 1) {
				var ictprog_window_dialog = $('#ictprog_window').dialog({
	    			title : '编辑项目进度',
	    			width : 600,
	    			height : 400,
	    			closed : false,
	    			cache : false,
	    			href : basepath+'/projprog/dataform?id='+checkedRows[0].id,
	    			modal : true,
	    			buttons : [ {
	    				text : '保   存',
	    				handler : function() {
	    					$('#prog_form').form('submit',{
	    						url : basepath+'/projprog/update',
	    						success : function(data) {
	    							var result = $.parseJSON(data);
	    							if (result.success) {
	    								$('#prog_list_data').datagrid('load');
	    								ictprog_window_dialog.dialog('close');
	    							}
	    							$.messager.show({
	    								title : '提示',
	    								msg : result.msg,
	    								timeout : 3000,
	    								showType : 'slide'
	    							});
	    						}
	    					});
	    				}
	    			} ],
	    			onLoad:function(){
	    				fmtDate();
	    			}
	    		});
			}else if(checkedRows.length > 1) {
				$.messager.show({
					title : '提示',
					msg : '只能选择一条项目进度进行编辑!',
					timeout : 3000,
					showType : 'slide'
				});
			}else if(checkedRows.length < 1){
				$.messager.show({
					title : '提示',
					msg : '请勾选想要编辑的项目进度!',
					timeout : 3000,
					showType : 'slide'
				});
			}else {
				$.messager.show({
					title : '提示',
					msg : '请勾选想要编辑的项目进度!',
					timeout : 3000,
					showType : 'slide'
				});
			}
		}
		
		//记录删除
		function delFun(){
			var checkedRows = $("#list_data").datagrid('getChecked');
			if(checkedRows.length == 1) {
				$.messager.confirm('确认', '您是否要删除当前选中的记录？', function(r) {
					if(r) {
						$.ajax({
							url : basepath+'/ictproj/delete',
							data : {
								id : checkedRows[0].id
							},
							type:'POST',
							dataType : 'json',
							success : function(json) {
								if (json.success) {
									$("#list_data").datagrid('load');
								}
								$.messager.show({
									title : '提示',
									msg : json.msg
								});
							}
						});
					}
				});
			} else if(checkedRows.length > 1) {
				$.messager.show({
					title : '提示',
					msg : '只能选择一个记录删除!',
					timeout : 3000,
					showType : 'slide'
				});
			}else {
				$.messager.show({
					title : '提示',
					msg : '请勾选想要删除的记录!',
					timeout : 3000,
					showType : 'slide'
				});
			}
		}
		
		//记录删除
		function delProgFun(){
			var checkedRows = $("#prog_list_data").datagrid('getChecked');
			if(checkedRows.length == 1) {
				$.messager.confirm('确认', '您是否要删除当前选中的记录？', function(r) {
					if(r) {
						$.ajax({
							url : basepath+'/projprog/delete',
							data : {
								id : checkedRows[0].id
							},
							type:'POST',
							dataType : 'json',
							success : function(json) {
								if (json.success) {
									$("#prog_list_data").datagrid('load');
								}
								$.messager.show({
									title : '提示',
									msg : json.msg
								});
							}
						});
					}
				});
			} else if(checkedRows.length > 1) {
				$.messager.show({
					title : '提示',
					msg : '只能选择一个记录删除!',
					timeout : 3000,
					showType : 'slide'
				});
			}else {
				$.messager.show({
					title : '提示',
					msg : '请勾选想要删除的记录!',
					timeout : 3000,
					showType : 'slide'
				});
			}
		}
		
		function searchFunc() {
			var param = $("#searchForm").serialize();
			var noticeobj={
					content:$("#notice_title").val()
			};
	        $("#list_data").datagrid("load",noticeobj);
	    }
	    //点击清空按钮出发事件
	    function clearSearch() {
	        $("#list_data").datagrid("load", {});
	        $("#searchForm").find("input").val("");
	    }
	    
	    window.onload = function () { 
	    	selectProj(null);
	    	
	    }

	function selectProj(pid){
		$('#prog_list_data').datagrid({
	    	height : 'auto',
	    	nowrap : false,
	    	striped : true,
	    	border : true,
	    	collapsible : false,//是否可折叠的 
	    	fit : true,//自动大小 
	    	loadMsg : '数据加载中请稍后……',
	    	url : basepath+'/projprog/datagrid?pid='+pid,
	    	remoteSort : false,
	    	fitColums : true,
	    	checkOnSelect : true,
	    	//singleSelect : false,//是否单选 
	    	pagination : true,//分页控件 
	    	rownumbers : true,//行号 
	    	columns : [ [ {
	    		field : 'id',
	    		title : '编号',
	    		width : 50,
	    		checkbox : true
	    	},{
	    		field : 'addtimeStr',
	    		title : '添加时间',
	    		width : 100
	    	},{
	    		field : 'progress',
	    		title : '进度%',
	    		width : 100
	    	},{
	    		field : 'remark',
	    		title : '情况说明',
	    		width : 150
	    	}] ]
	    });
	    //设置分页控件 
	    var p = $('#prog_list_data').datagrid('getPager');
	    $(p).pagination({
	    	pageSize : 10,//每页显示的记录条数，默认为10 
	    	pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
	    	beforePageText : '第',//页数文本框前显示的汉字 
	    	afterPageText : '页    共 {pages} 页',
	    	displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	    });
	}
	</script>
</body>

</html>
