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
			$('#carsRepairTable').datagrid({
				pagination : true,
				pageSize : 5,
				pageList : [ 5, 10, 20, 50 ],
				singleSelect : true,
				fitColumns :true,
				rownumbers:true,
				height : 400,
				width : 900, 
				toolbar : [{
						iconCls : 'icon-add',
						text : '新增维修/保养记录',
						handler : function() {
								addCarsRepair1();
						}
					},'-',
						{
							iconCls : 'icon-edit',
							text : '修改',
							handler : function() {
								var row = $('#carsRepairTable').datagrid('getSelected');
								if (row == null) {
									$.messager.alert('提示','请选中行!');
								} else {
									updateCarsRepair(row);
								}
							}
						} ,
						'-',
						 {
							iconCls : 'icon-remove',
							text : '删除',
							handler : function() {
								var row = $('#carsRepairTable').datagrid('getSelected');
								if (row == null) {
									$.messager.alert('提示','请选中行!');
								} else {
									deleteCarsRepair(row.carsRepairId);
								}
							}
						} ],
				columns : [ [
				{
					field : 'carsRepairId',
					title : '编号'
				} ,
				{
					field : 'carNumber',
					title : '车牌号'
				} ,
				{
					field : 'driverName',
					title : '司机姓名'
				},
				{
					field : 'carsRepairType',
					title : '类型'
				} , {
					field : 'carsRepairText',
					title : '备注'
				} , {
					field : 'carId',
					title : '车辆信息',
					formatter:function(value,row,index){
						return '<a href="cars/queryCarsById.action?carId='+row.carId+'" target="_blank" >查看</a>';
					}
				}  ] ],
				url : '${pageContext.request.contextPath }/carsRepair/queryAllCarsRepair.action'
			});
		});
		function addCarsRepair1() {
			//首先置空
			$('#myCarsRepairUpdateForm').form('reset');
			$('#carsRepairUpdate').show();
			$('#carsRepaircarId').combobox({    
			    url:'cars/queryAll.action',    
			    valueField:'carId',    
			    textField:'carNumber'   
			});  
			
			$('#carsRepairUpdate').dialog({
				height : 400,
				width : 410,
				title : '新增维修/保养记录',
				modal :true,
				buttons : [ {
					text : '添加',
					iconCls : 'icon-save',
					handler : function() {
						$('#myCarsRepairUpdateForm').form('submit', {
							url:"${pageContext.request.contextPath }/carsRepair/saveCarsRepair.action",
							success : function(rst) {
								//对回馈的数据进行处理
								 var obj = eval(rst);  
								if (obj== "true") {
									$('#carsRepairUpdate').dialog('close');
									$('#carsRepairUpdate').hide();
									//刷新列表
									$('#carsRepairTable').datagrid('reload');
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
		function updateCarsRepair(row) {
			$('#myCarsRepairUpdateForm').form('reset');
			
			$('#carsRepaircarId').combobox({    
			    url:'cars/queryAll.action',    
			    valueField:'carId',    
			    textField:'carNumber'   
			});  
			
			$('#myCarsRepairUpdateForm').form('load',row);
			$('#carsRepairUpdate').show();
			//数据回显
			$('#carsRepairUpdate').dialog({
				height : 400,
				width : 410,
				title : '修改车辆信息',
				modal :true,
				buttons : [ {
					text : '修改',
					iconCls : 'icon-edit',
					handler : function() {
						$('#myCarsRepairUpdateForm').form('submit', {
							url:"${pageContext.request.contextPath }/carsRepair/saveUpdateDeleteCarsRepair.action",
							success : function(rst) {
								//对回馈的数据进行处理
								var obj = eval(rst);  
								if (obj== "true") {
									$('#carsRepairUpdate').dialog('close');
									$('#carsRepairUpdate').hide();
									//刷新列表
									$('#carsRepairTable').datagrid('reload');
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
		function deleteCarsRepair(id) {
			$.ajax({
				url : '${pageContext.request.contextPath }/carsRepair/saveUpdateDeleteCarsRepair.action?carsRepairId='+id,
				method : 'post',
				success : function(rst) {
					var obj = eval(rst);  
					if(obj=="false"){
						$.messager.alert('提示', "服务器错误!");
					}
					//刷新列表
					$('#carsRepairTable').datagrid('reload');
				}
			});
		}
		function searchCarRepair(value,name){
			$('#carsRepairTable').datagrid({
				pagination : true,
				pageSize : 5,
				pageList : [ 5, 10, 20, 50 ],
				singleSelect : true,
				fitColumns :true,
				rownumbers:true,
				height : 400,
				width : 900, 
				toolbar : [{
						iconCls : 'icon-add',
						text : '新增维修/保养记录',
						handler : function() {
								addCarsRepair1();
						}
					},'-',
						{
							iconCls : 'icon-edit',
							text : '修改',
							handler : function() {
								var row = $('#carsRepairTable').datagrid('getSelected');
								if (row == null) {
									$.messager.alert('提示','请选中行!');
								} else {
									updateCarsRepair(row);
								}
							}
						} ,
						'-',
						 {
							iconCls : 'icon-remove',
							text : '删除',
							handler : function() {
								var row = $('#carsRepairTable').datagrid('getSelected');
								if (row == null) {
									$.messager.alert('提示','请选中行!');
								} else {
									deleteCarsRepair(row.carsRepairId);
								}
							}
						} ],
				columns : [ [
				{
					field : 'carsRepairId',
					title : '编号'
				} ,
				{
					field : 'carNumber',
					title : '车牌号'
				} ,
				{
					field : 'driverName',
					title : '司机姓名'
				},
				{
					field : 'carsRepairType',
					title : '类型'
				} , {
					field : 'carsRepairText',
					title : '备注'
				} , {
					field : 'carId',
					title : '车辆信息',
					formatter:function(value,row,index){
						return '<a href="cars/queryCarsById.action?carId='+row.carId+'" target="_blank" >查看</a>';
					}
				}  ] ],
				url : '${pageContext.request.contextPath }/carsRepair/queryLikeAll.action?'+name+'='+value
			});
		}
	</script>
	<input id="ssCarRepair" class="easyui-searchbox" style="width:300px"
	    data-options="searcher:searchCarRepair,prompt:'Please Input Value',menu:'#carRepairOptions'"></input>
	<div id="carRepairOptions" style="width:120px">
	    <div data-options="name:'carNumber',iconCls:'icon-ok'">车牌号</div>
	    <div data-options="name:'driverName',iconCls:'icon-ok'">司机姓名</div>
	</div>
	<table id="carsRepairTable" style="width: 400px; height: 400px"></table>
	<div id="carsRepairUpdate" style="display: none; padding: 20px">
		<form method="post" id="myCarsRepairUpdateForm">
			<table>
				<tr>
					<td>编号:</td>
					<td><input type="text" id="carsRepairId" readonly="readonly" name="carsRepairId" /></td>
				</tr>
				<tr>
					<td>类型:</td>
					<td>
						<select name="carsRepairType" id="carsRepairType1" style="width:170px;" class="easyui-combobox" >
						    <option value="维修">维修</option>   
						    <option value="保养">保养</option>  
						    <option value="其他">其他</option>   
						</select>
					</td>
				</tr>
				<tr>
					<td>备注:</td>
					<td><textarea rows="10" cols="30"  id="carsRepairText1" name="carsRepairText"  ></textarea></td>
				</tr>
				<tr>
					<td>车牌号:</td>
					<td>
						<input id="carsRepaircarId" name="carId" >  
					</td>
				</tr>
				<tr>
					<td>创建时间:</td>
					<td><input class="easyui-datetimebox" name="createTime" data-options="required:true,showSeconds:false"  style="width:173px">  </td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>