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
			$('#usersTable').datagrid({
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
								addUser();
							}
						},
						'-',
						{
							iconCls : 'icon-edit',
							text : '修改',
							handler : function() {
								var row = $('#usersTable').datagrid('getSelected');
								if (row == null) {
									$.messager.alert('提示','请选中行!');
								} else {
									updateUser(row);
								}
							}
						} ,
						'-',
						 {
							iconCls : 'icon-remove',
							text : '删除',
							handler : function() {
								var row = $('#usersTable').datagrid('getSelected');
								if (row == null) {
									$.messager.alert('提示','请选中行!');
								} else {
									deleteUser(row.userId);
								}
							}
						} ],
				columns : [ [
				{
					field : 'userId',
					title : '编号'
				} , {
					field : 'userName',
					title : '姓名'
				} , {
					field : 'nickName',
					title : '昵称'
				}, {
					field : 'userAdmin',
					title : '权限'
				} ] ],
				url : '${pageContext.request.contextPath }/users/queryAllUsers.action'
			});
		});
		function addUser() {
			//首先置空
			$('#myUserAddForm').form('reset');
			$('#userAdd').show();
			$('#userAdd').dialog({
				height : 230,
				width : 330,
				title : '新增用户',
				modal :true,
				buttons : [ {
					text : '添加',
					iconCls : 'icon-save',
					handler : function() {
						$('#myUserAddForm').form('submit', {
							url:"${pageContext.request.contextPath }/users/saveUpdateDeleteUsers.action",
							success : function(rst) {
								//对回馈的数据进行处理
								 var obj = eval(rst);  
								if (obj== "true") {
									$('#userAdd').dialog('close');
									$('#userAdd').hide();
									//刷新列表
									$('#usersTable').datagrid('reload');
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
		function updateUser(row) {
			$('#myUserAddForm').form('reset');
			$('#myUserAddForm').form('load',row);
			$('#userAdd').show();
			//数据回显
			$('#userAdd').dialog({
				height : 230,
				width : 330,
				title : '修改用户信息',
				modal :true,
				buttons : [ {
					text : '修改',
					iconCls : 'icon-edit',
					handler : function() {
						$('#myUserAddForm').form('submit', {
							url:"${pageContext.request.contextPath }/users/saveUpdateDeleteUsers.action",
							success : function(rst) {
								//对回馈的数据进行处理
								var obj = eval(rst);  
								if (obj== "true") {
									$('#userAdd').dialog('close');
									$('#userAdd').hide();
									//刷新列表
									$('#usersTable').datagrid('reload');
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
		function deleteUser(id) {
			$.ajax({
				url : '${pageContext.request.contextPath }/users/saveUpdateDeleteUsers.action?userId='+id,
				method : 'post',
				success : function(rst) {
					var obj = eval(rst);  
					if(obj=="false"){
						$.messager.alert('提示', "该类型正在被使用!");
					}
					//刷新列表
					$('#usersTable').datagrid('reload');
				}
			});
		}
	</script>
	
	<table id="usersTable" style="width: 400px; height: 400px"></table>
	<div id="userAdd" style="display: none; padding: 20px">
		<form method="post" id="myUserAddForm">
			<table>
				<tr>
					<td>编号:</td>
					<td><input type="text" id="userId" readonly="readonly" name="userId" /></td>
				</tr>
				<tr>
					<td>昵称:</td>
					<td><input type="text" id="nickName" name="nickName" class="easyui-validatebox" data-options="required:true" /></td>
				</tr>
				<tr>
					<td>账号:</td>
					<td><input type="text" id="userName" name="userName" class="easyui-validatebox" data-options="required:true" /></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input type="password" id="pwd" name="pwd" class="easyui-validatebox" data-options="required:true" /></td>
				</tr>
				<tr>
					<td>权限:</td>
					<td><input type="radio" name="userAdmin" value="管理员" />管理员<input type="radio" name="userAdmin" checked="checked" value="普通用户" />普通用户</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>