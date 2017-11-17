<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>数据字典分类</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/syUtil.js"
	charset="utf-8"></script>
</head>
<body>
<div class="easyui-layout" fit="true" border="false">
	<div data-options="region:'north',title:''" style="height: 40px; background: #F4F4F4;">
		<form id="searchForm">
			<table>
			  <tr>
	              <th>分类名称：</th>
	              <td><input id="title" name="title" value=""/></td>
	              <th>分类编码：</th>
	              <td><input id="code" name="code" value=""/></td>
	              <th>分类状态：</th>
	              <td>
	              	<select id="status" name="status">
	              		<option value="">----- 请选择-----</option>
	              		<option value="1">启用</option>
	              		<option value="0">禁用</option>
	              	</select>
	              </td>
	          	  <td><a class="easyui-linkbutton" href="javascript:void(0);" onclick="searchFunc();">查找</a></td>
	              <td><a class="easyui-linkbutton" href="javascript:void(0);" onclick="clearSearch();">清空</a></td>
	          </tr>                     
			</table>
		</form>                                    
	</div>            
	
	<div data-options="region:'center',split:false">
		<div class="easyui-layout" fit="true" border="false">
			<div data-options="region:'west',title:''" style="">
				<table id="list_data" cellspacing="0" cellpadding="0">
				<thead>
					<tr>
						<th field="id" width="100">ID</th>
						<th field="title" width="100">分类名称</th>
						<th field="code" width="100">分类代码</th>
					</tr>
				</thead>
				</table>
			</div>
			<div data-options="region:'east'" style="width:350px;">
				<table id="item_list_data" cellspacing="0" cellpadding="0"></table>
			</div>
		</div>
		
	</div>
</div>
    
<div id="dd"></div>
<script type="text/javascript">
		var basepath = "${pageContext.request.contextPath}";
		$('#list_data').datagrid({
			height : 'auto',
			nowrap : false,
			striped : true,
			border : true,
			collapsible : false,//是否可折叠的 
			fit : true,//自动大小 
			loadMsg : '数据加载中请稍后……',
			url : basepath+'/dict/group/datagrid',
			remoteSort : false,
			fitColums : true,
			checkOnSelect : true,
			singleSelect : true,//是否单选 
			pagination : true,//分页控件 
			rownumbers : true,//行号 
			frozenColumns : [ [ {
				field : 'ck',
				checkbox : true
			} ] ],
			toolbar : [ 
	 		            {
				text : '添加分类',
				iconCls : 'icon-add',
				handler : function() {
					add();
				}
			}, '-', {
				text : '修改分类',
				iconCls : 'icon-edit',
				handler : function() {
					edit();
				}
			}, '-', {
				text : '删除分类',
				iconCls : 'icon-remove',
				handler : function() {
					del();
				}
			}, '-', {
				text : '增加字典',
				iconCls : 'icon-remove',
				handler : function() {
					adddictitem();
				}
			}, '-', {
				text : '修改字典',
				iconCls : 'icon-remove',
				handler : function() {
					editdictitem();
				}
			} , '-', {
				text : '删除字典',
				iconCls : 'icon-remove',
				handler : function() {
					deldictitem();
				}
			} ],
			onClickRow:function () {
		        var grouprow = $('#list_data').datagrid("getSelected");
		        var groupid = grouprow.id;
		        loadDictItem(groupid);
		    },
			pageSize : 20,				 
			pageList : [ 10, 20, 30 ]
		});
		//设置分页控件 
		var p = $('#list_data').datagrid('getPager');
		$(p).pagination({
			pageSize : 15,//每页显示的记录条数，默认为10 
			pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',
		});
		
		function loadDictItem(groupid){
			$('#item_list_data').datagrid({
				height : 'auto',
				nowrap : false,
				striped : true,
				border : true,
				collapsible : false,//是否可折叠的 
				fit : true,//自动大小 
				loadMsg : '数据加载中请稍后……',
				url : basepath+'/dict/item/datagrid?groupid='+groupid,
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
					field : 'title',
					title : '字典名称',
					width : 150
				},{
					field : 'code',
					title : '字典标识',
					width : 150
				},{
					field : 'remark',
					title : '字典备注',
					width : 150
				}] ]
			});
			//设置分页控件 
			var p = $('#item_list_data').datagrid('getPager');
			$(p).pagination({
				pageSize : 20,				//每页显示的记录条数，默认为10 
				pageList : [ 10, 20, 30 ],	//可以设置每页记录条数的列表 
				beforePageText : '第',		//页数文本框前显示的汉字 
				afterPageText : '页    共 {pages} 页',
				displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
			});
		}
		

		//编辑
		function edit(){
			 var checkedRows = $("#list_data").datagrid('getChecked');
			 if(checkedRows.length == 1) {
				 var dictgroup_dialog = $('#dd').dialog({
						title: '字典分类编辑',
					    width: 500,
					    height:300,
					    closed: false,
					    cache: false,
					    href: basepath+'/dict/group/form?id='+checkedRows[0].id,
					    modal: true,
					    buttons : [ {
							text : '保   存',
							iconCls : 'icon-add',
							handler : function() {
								$('#dictgroup_form').form('submit', {
									url : basepath+'/dict/group/save',
									type: 'POST',
									success : function(data) {
										var json = $.parseJSON(data);
											if (json.success) {
												$('#list_data').datagrid('load');
												dictgroup_dialog.dialog('close');
											}
											$.messager.show({
												title : '提示',
												msg : json.msg,
												timeout : 3000,
												showType : 'slide'
											});
									}
								});
							}
						} ]
					});
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
		
		//新增
		 function add(){
			 var dictgroup_form_dialog = $('#dd').dialog({
					title: '自动分类新增',
				    width: 600,
				    height:300,
				    closed: false,
				    cache: false,
				    href: basepath+'/dict/group/form',
				    modal: true,
				    buttons : [ {
						text : '保    存',
						iconCls : 'icon-add',
						handler : function() {
							$('#dictgroup_form').form('submit', {
								url : basepath+'/dict/group/save',
								type: 'POST',
								success : function(data) {
									var json = $.parseJSON(data);
									if (json.success) {
										$('#list_data').datagrid('load');
										dictgroup_form_dialog.dialog('close');
									}
									$.messager.show({
											title : '提示',
											msg : json.msg,
											timeout : 3000,
											showType : 'slide'
									});
								}
							});
						}
					} ]
				});
			
		} 
	
		//删除
		function del(){
			var checkedRows = $("#list_data").datagrid('getChecked');
			if(checkedRows.length == 1) {
				$.messager.confirm('确认', '您是否要删除当前选中的记录？', function(r) {
					if(r) {
						$.ajax({
							url : basepath+'/dict/group/delete',
							data : {
								id : checkedRows[0].id
							},
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
					msg : '只能选择一条记录删除!',
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
		
		function adddictitem(){
			var checkedRows = $("#list_data").datagrid('getChecked');
			 if(checkedRows.length == 1) {
				 var dictitem_dialog = $('#dd').dialog({
						title: '新增字典项',
					    width: 400,
					    height:300,
					    closed: false,
					    cache: false,
					    href: basepath+'/dict/item/form?groupid='+checkedRows[0].id,
					    modal: true,
					    buttons : [ {
							text : '保   存',
							iconCls : 'icon-add',
							handler : function() {
								$('#dictitem_form').form('submit', {
									url : basepath+'/dict/item/save',
									type: 'POST',
									success : function(data) {
										var json = $.parseJSON(data);
											if (json.success) {
												$('#list_data').datagrid('load');
												dictitem_dialog.dialog('close');
											}
											$.messager.show({
												title : '提示',
												msg : json.msg,
												timeout : 3000,
												showType : 'slide'
											});
									}
								});
							}
						} ]
					});
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
		
		
		function editdictitem(){
			var checkedRows = $("#item_list_data").datagrid('getChecked');
			 if(checkedRows.length == 1) {
				 var dictitem_dialog = $('#dd').dialog({
						title: '修改字典项',
					    width: 400,
					    height:300,
					    closed: false,
					    cache: false,
					    href: basepath+'/dict/item/form?id='+checkedRows[0].id,
					    modal: true,
					    buttons : [ {
							text : '保   存',
							iconCls : 'icon-add',
							handler : function() {
								$('#dictitem_form').form('submit', {
									url : basepath+'/dict/item/save',
									type: 'POST',
									success : function(data) {
										var json = $.parseJSON(data);
											if (json.success) {
												$('#list_data').datagrid('load');
												dictitem_dialog.dialog('close');
											}
											$.messager.show({
												title : '提示',
												msg : json.msg,
												timeout : 3000,
												showType : 'slide'
											});
									}
								});
							}
						} ]
					});
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
		
		
		//删除
		function deldictitem(){
			var checkedRows = $("#item_list_data").datagrid('getChecked');
			if(checkedRows.length == 1) {
				$.messager.confirm('确认', '您是否要删除当前选中的记录？', function(r) {
					if(r) {
						$.ajax({
							url : basepath+'/dict/item/delete',
							data : {
								id : checkedRows[0].id
							},
							dataType : 'json',
							success : function(json) {
								if (json.success) {
									$("#item_list_data").datagrid('load');
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
					msg : '只能选择一条记录删除!',
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
	</script>
</body>
</html>
