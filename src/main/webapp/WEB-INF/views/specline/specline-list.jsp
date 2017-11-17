<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>专线数据列表</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
	<link href="${pageContext.request.contextPath}/static/uploadify/uploadify.css" rel="stylesheet" type="text/css" />
  <%-- <script type="text/javascript" src="${pageContext.request.contextPath}/static/uploadify/jquery-1.4.2.min.js"></script> --%>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/uploadify/swfobject.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/uploadify/jquery.uploadify.js"></script>
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
                             <th>集团编码：</th>
                             <td><input type="text" id="ispcode" name="ispcode"> </td>
				               <th>运营商：</th>
				              <td>
				              	<select id="isptype" name="isptype" class="textbox textbox_indent">
				              		<option value="">----- 请选择-----</option>
				              		<c:forEach var="bean" items="${ispList}" varStatus="status">
										<option value="${bean.id }" >${bean.title }</option>
									</c:forEach>
				              	</select>
				              </td>
				               <th>专线类型：</th>
				              <td>
				              	<select id="linetype" name="linetype" class="textbox textbox_indent">
				              		<option value="">----- 请选择-----</option>
				              		<c:forEach var="bean" items="${lineList}" varStatus="status">
										<option value="${bean.id }" >${bean.title }</option>
									</c:forEach>
				              	</select>
				              </td>
				              <th>所在地域：</th>
				              <td>
				              	<input id="areaid" name="areaid" /> 
				              </td>
                              <td><a class="easyui-linkbutton" href="javascript:void(0);" onclick="searchFunc();">查找</a></td>
                             <td><a class="easyui-linkbutton" href="javascript:void(0);" onclick="clearSearch();">清空</a></td>
                        </tr>
                    </table>
                </form>
            </div>
            <div>
           <!--  -->
            </div>
            <div data-options="region:'center',split:false">
                <table id="list_data" cellspacing="0" cellpadding="0">
				</table>
            </div>
            <div id="toobar" style="padding:5px;height:auto">
				<div style="margin-bottom:5px">
					<shiro:hasPermission name="specline:create">
					<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"  onClick="addFun()">新增</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="specline:update">
					<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="editFun()">修改</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="specline:delete">
					<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="delFun()">删除</a>
					</shiro:hasPermission>
					
				</div>
			</div>
    </div>
	
	<div id="specline_window"></div>
	<script type="text/javascript">
	var basepath = "${pageContext.request.contextPath}";
	
	$(document).ready(function(){
		$('#areaid').combotree({
		    url: basepath+'/area/tree',
		    valueField:'id',
		    textField:'name',
		    method:'post'
		}); 
	    $("#upload").uploadify({
	         'uploader': basepath+'/static/uploadify/uploadify.swf',
	         'script':basepath+"/specline/upload",
	         'cancelImg':  basepath+'/static/uploadify/cancel.png',
	         'queueID': 'fileQueue',
	         'auto': true,
	         'buttonText': 'select',
	         'simUploadLimit' : 1,
	         'queueSizeLimit' : 1,
	         'fileExt': '*.jpg;*.gif;*.jpeg;*.png;*.bmp;*.zip;*.rar;*.7z',
	         onComplete: function(event, queueID, fileObj, response, data) {
	             //转换为json对象
	             var dataObj = eval("("+response+")");
	             //conslon.info(dataObj);
	              var json = $.parseJSON(response);
	              
	              $.messager.show({
						title : '提示',
						msg : json.msg,
						timeout : 3000,
						showType : 'slide'
					});
	              
	              $('#list_data').datagrid('load');
	            
	               saveFile(dataObj);
	             
	         },
	         onSelect:function(){
	        	
	         },
	         onError: function(event, queueID, fileObj) {
	             alert("文件:" + fileObj.name + "上传失败");
	         },
	      // 在每一个文件上传成功后触发
	         onUploadSuccess : function(file, data, response) {
	        	 var json = $.parseJSON(data);
	        	 alert('json+'+json);
	        	 if(json.success) {
	        		var data = json.data;
	        		alert(data);
	        	 }
	         }
	        
	     });
	});
	
	
	$('#list_data').datagrid({
		height : 'auto',
		nowrap : false,
		striped : true,
		border : true,
		collapsible : false,//是否可折叠的 
		fit : true,//自动大小 
		loadMsg : '数据加载中请稍后……',
		url : basepath+'/specline/datagrid',
		remoteSort : false,
		fitColums : true,
		checkOnSelect : true,
		singleSelect : true,//是否单选 
		pagination : true,//分页控件 
		rownumbers : true,//行号 
		columns : [ [  {
			field : 'id',
			title : '编号',
			width : 150,
			checkbox : true
		}, {
			field : 'ispcode',
			title : '集团编码',
			width : 100
		}, {
			field : 'corptitle',
			title : '客户名称',
			width : 150
		}, {
			field : 'customer',
			title : '客户经理',
			width : 80
		},{
			field : 'hasline',
			title : '是否使用专线',
			width : 50,
			 formatter:function(value,row){
		    	var str = "";
		    	if(value=="1"){
		    		str = "<font style=''>是 </font>";
		    	}else if(value=="0"){
		    		str = "<font style=''>否</font>";
		    	}else{
		    		str = "<font style=''>未知</font>";
		    	}
		    	 return str;
			} 
		},{
			field : 'ispname',
			title : '运营商',
			width : 80
		},{
			field : 'linename',
			title : '专线类型',
			width : 100
		}, {
			field : 'bitsize',
			title : '带宽',
			width : 50
		}, {
			field : 'feemonth',
			title : '月资费',
			width : 50
		}, {
			field : 'paytype',
			title : '缴费方式',
			width : 50
		}, {
			field : 'yeartariff',
			title : '年资费',
			width : 50
		}, {
			field : 'feemonth',
			title : '协议签订时期',
			width : 100
		}, {
			field : 'pactnumber',
			title : '合同编号',
			width : 80
		}, {
			field : 'pactname',
			title : '合同名称',
			width : 100
		}, {
			field : 'pactvalidity',
			title : '合同有效期',
			width : 50
		}, {
			field : 'worknumber',
			title : '计划建设工单编号',
			width : 100
		}, {
			field : 'speclinename',
			title : '计划建设专线名称',
			width : 100
		}, {
			field : 'esopnumber',
			title : 'ESOP专线编号',
			width : 100
		}, {
			field : 'esoptheme',
			title : 'ESOP专线主题',
			width : 100
		}, {
			field : 'opentime',
			title : '实际开通时间',
			width : 100
		}, {
			field : 'bossnumber',
			title : 'BOSS计费号',
			width : 100
		}, {
			field : 'ftolltime',
			title : '首次收费时间',
			width : 100
		}, {
			field : 'ftollsum',
			title : '首次收费金额',
			width : 100
		}, {
			field : 'remark',
			title : '备注',
			width : 150
		} ] ],
		
		toolbar : [ {
			text : '添加',
			iconCls : 'icon-add',
			handler : function() {
				addFun();
			}
		}, '-', {
			text : '修改',
			iconCls : 'icon-edit',
			handler : function() {
				editFun();
			}
		}, '-', {
			text : '删除',
			iconCls : 'icon-remove',
			handler : function() {
				delFun();
			}
		} ],
		pageSize : 30,				 
		pageList : [ 30,40,50 ],
	});
	//设置分页控件 
	var p = $('#list_data').datagrid('getPager');
	$(p).pagination({
		pageSize : 30,				//每页显示的记录条数，默认为10 
		pageList : [ 30,40,50 ],	//可以设置每页记录条数的列表 
		beforePageText : '第',		//页数文本框前显示的汉字 
		afterPageText : '页    共 {pages} 页',
		displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	}); 
			
	function searchFunc() {
		var param={
			ispcode:$("#ispcode").val(),
			isptype:$("#isptype").val(),
			linetype:$("#linetype").val(),
			areacode:$("#areaid").combotree("getValue")
		};
        $("#list_data").datagrid("load",param);
    }
    //点击清空按钮出发事件
    function clearSearch() {
        $("#list_data").datagrid("load", {});
        $("#searchForm").find("input").val("");
    }
	    
    function addFun() {
    	document.location = basepath+'/specline/dataform';
    }

    /*编辑*/
    function editFun() {
    	var checkedRows = $("#list_data").datagrid('getChecked');
    	if (checkedRows.length == 1) {
    		document.location = basepath+'/specline/dataform?id='+checkedRows[0].id;
    	} else if(checkedRows.length > 1) {
    		$.messager.show({
    			title : '提示',
    			msg : '只能选择一个记录编辑!',
    			timeout : 3000,
    			showType : 'slide'
    		});
    	}else {
    		$.messager.show({
    			title : '提示',
    			msg : '请勾选想要编辑的记录!',
    			timeout : 3000,
    			showType : 'slide'
    		});
    	}
    }	
    

    function addFun1() {
    	var specline_window_dialog = $('#specline_window').dialog({
    		title : '专线信息',
    		width : 600,
    		height : 600,
    		closed : false,
    		cache : false,
    		href : basepath+'/specline/dataform',
    		modal : true,
    		buttons : [ {
    			text : '保   存',
    			handler : function() {
    				$('#specline_form').form('submit',{
    					url : basepath+'/specline/create',
    					success : function(data) {
    						var result = $.parseJSON(data);
    						if (result.success) {
    							$('#list_data').datagrid('load');
    							specline_window_dialog.dialog('close');
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
    		} ]
    	});
    }


    /*编辑*/
    function editFun1() {
    	var checkedRows = $("#list_data").datagrid('getChecked');
    	if (checkedRows.length == 1) {
    		var specline_window_dialog = $('#specline_window').dialog({
    			title : '系统用户信息编辑',
    			width : 600,
    			height : 600,
    			closed : false,
    			cache : false,
    			href : basepath+'/specline/dataformEdit?id='+checkedRows[0].id,
    			modal : true,
    			buttons : [ {
    				text : '保   存',
    				handler : function() {
    					$('#specline_form').form('submit',{
    						url : basepath+'/specline/update',
    						success : function(data) {
    							var result = $.parseJSON(data);
    							if (result.success) {
    								$('#list_data').datagrid('load');
    								specline_window_dialog.dialog('close');
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
    			} ]
    		});
    	} else if(checkedRows.length > 1) {
    		$.messager.show({
    			title : '提示',
    			msg : '只能选择一个记录编辑!',
    			timeout : 3000,
    			showType : 'slide'
    		});
    	}else {
    		$.messager.show({
    			title : '提示',
    			msg : '请勾选想要编辑的记录!',
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
    					url : basepath+'/specline/delete',
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
	</script>
</body>

</html>
