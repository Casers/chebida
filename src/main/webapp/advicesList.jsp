<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>布局模板</title>
<link rel="stylesheet" type="text/css"
	href="UI/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="UI/themes/icon.css" />
<script type="text/javascript" src="Scripts/jquery-1.8.2.min.js"
	charset="utf-8"></script>
<script type="text/javascript" src="UI/jquery.easyui.min.js"
	charset="utf-8"></script>
<script type="text/javascript" src="UI/locale/easyui-lang-zh_CN.js"
	charset="utf-8"></script>
</head>
<body>
	<script type="text/javascript">
		$(function() {
			$('#advicesTable').datagrid({
				pagination : true,
				pageSize : 5,
				pageList : [ 5, 10, 20, 50 ],
				singleSelect : true,
				fitColumns :true,
				rownumbers:true,
				height : 400,
				width : 900, 
				toolbar : [
						{
							iconCls : 'icon-add',
							text : '新增',
							handler : function() {
								addAdvices();
							}
						},
						'-',
						{
							iconCls : 'icon-edit',
							text : '修改',
							handler : function() {
								var row = $('#advicesTable').datagrid('getSelected');
								if (row == null) {
									$.messager.alert('提示','请选中行!');
								} else {
									updateAdvices(row);
								}
							}
						} ,
						'-',
						 {
							iconCls : 'icon-remove',
							text : '删除',
							handler : function() {
								var row = $('#advicesTable').datagrid('getSelected');
								if (row == null) {
									$.messager.alert('提示','请选中行!');
								} else {
									deleteAdvices(row.id);
								}
							}
						} ],
				columns : [ [
				{
					field : 'id',
					title : '编号'
				} , {
					field : 'title',
					title : '标题'
				} , {
					field : 'content',
					title : '内容'
				} ] ],
				url : '${pageContext.request.contextPath }/advices/queryAllAdvice.action'
			});
		});
		function addAdvices() {
			//首先置空
			$('#myAdvicesAddForm').form('reset');
			$('#advicesAdd').show();
			$('#advicesAdd').dialog({
				height : 330,
				width : 360,
				title : '新增公告信息',
				modal :true,
				buttons : [ {
					text : '添加',
					iconCls : 'icon-save',
					handler : function() {
						$('#myAdvicesAddForm').form('submit', {
							url:"${pageContext.request.contextPath }/advices/saveUpdateDeleteAdvice.action",
							success : function(rst) {
								//对回馈的数据进行处理
								 var obj = eval(rst);  
								if (obj== "true") {
									$('#advicesAdd').dialog('close');
									$('#advicesAdd').hide();
									window.location.href="${pageContext.request.contextPath }/admin.action";
									//刷新列表
									$('#advicesTable').datagrid('reload');
								} else if(obj == "yicunzai") {
									$.messager.alert('提示', "该名称已存在!");
								}else{
									$.messager.alert('提示', "添加失败!服务器异常!");
								} 
							}
						});
					}
				} ]
			});
		}
		function updateAdvices(row) {
			$('#myAdvicesAddForm').form('reset');
			$('#myAdvicesAddForm').form('load',row);
			$('#advicesAdd').show();
			//数据回显
			$('#advicesAdd').dialog({
				height : 340,
				width : 330,
				title : '修改车辆信息',
				modal :true,
				buttons : [ {
					text : '修改',
					iconCls : 'icon-edit',
					handler : function() {
						$('#myAdvicesAddForm').form('submit', {
							url:"${pageContext.request.contextPath }/advices/saveUpdateDeleteAdvice.action",
							success : function(rst) {
								//对回馈的数据进行处理
								var obj = eval(rst);  
								if (obj== "true") {
									$('#advicesAdd').dialog('close');
									$('#advicesAdd').hide();
									//刷新列表
									window.location.href="${pageContext.request.contextPath }/admin.action";
									$('#advicesTable').datagrid('reload');
								} else if(obj == "yicunzai") {
									$.messager.alert('提示', "该名称已存在!");
								}else{
									$.messager.alert('提示', "修改失败!服务器异常!");
								}
							}
						});
					}
				} ]
			});
		}
		function deleteAdvices(id) {
			$.ajax({
				url : '${pageContext.request.contextPath }/advices/saveUpdateDeleteAdvice.action?id='+id,
				method : 'post',
				success : function(rst) {
					var obj = eval(rst);  
					if(obj=="false"){
						$.messager.alert('提示', "该类型正在被使用!");
					}
					//刷新列表
					window.location.href="${pageContext.request.contextPath }/admin.action";
					$('#advicesTable').datagrid('reload');
				}
			});
		}
	</script>
	
	<table id="advicesTable" style="width: 400px; height: 400px"></table>
	<div id="advicesAdd" style="display: none; padding: 20px">
		<form method="post" id="myAdvicesAddForm">
			<table>
				<tr>
					<td>编号:</td>
					<td><input type="text" id="id" readonly="readonly" name="id" /></td>
				</tr>
				<tr>
					<td>标题:</td>
					<td><input type="text" id="title" name="title" class="easyui-validatebox" data-options="required:true" /></td>
				</tr>
				<tr>
					<td>内容:</td>
					<td><textarea rows="10" cols="30"  id="content" name="content"  ></textarea></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>