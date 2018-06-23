<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>布局模板
	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/UI/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/UI/themes/icon.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/Scripts/jquery-1.8.2.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/UI/jquery.easyui.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/UI/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
</head>
<body>
	<script type="text/javascript">
		$(function(){
			//定义的树形结构数据，可以直接从数据库中获取，url设置即可
			var dt=[{
				"id":"1",
				"text":"系统管理",
				"children":[{
					"id":"11",
					"text":"公告管理",
					"url":"${pageContext.request.contextPath }/advicesList.jsp"
				},{
					"id":"12",
					"text":"系统用户管理",
					"url":"usersList.jsp"
				}]},{
					"id":"2",
					"text":"信息管理",
					"children":[{
						"id":"21",
						"text":"司机信息",
						"url":"driversList.html"
					},{
						"id":"22",
						"text":"车辆信息",
						"url":"carsList.html"
					},{
						"id":"23",
						"text":"维修保养信息",
						"url":"carsRepairListUI.jsp"
					},{
						"id":"24",
						"text":"运营里程日营业记录",
						"url":"carMileageListUI.html"
					}]
			}];
			$("#tree").tree({
				data:dt,
				onClick:function(node){
					var myurl=node.url;
					var admin=$("#userAdminText").val();
					if(myurl=="usersList.jsp" && admin!="管理员" ){
						myurl="noAdmin.html";
					}
					//右侧打开一个tab，引用树形节点的url
					var tab=$("#mytab").tabs("getTab",node.text);
					//判断是否已经打开
					if(tab==null&&node.url!=null){
						$("#mytab").tabs("add",{
							title:node.text,
							href:myurl,
							closable:true
						})
					}else{
						//如果已经打开则选择
						$("#mytab").tabs("select",node.text);
					}
				}

			});
		});
	</script>
	<div id="cc" class="easyui-layout" data-options="fit:true">   
	    <div data-options="region:'north',split:false" style="height:100px;">
	    	<h1>车必达出租车管理系统</h1>
	    	<br>
	    	<font size="2">${loginNickName },欢迎您!&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/users/outLogin.action">系统退出</a></font>
	    </div>   
	    <div data-options="region:'south',title:'版权部分',split:true" style="height:100px;"></div>   
		<div data-options="region:'east',iconCls:'icon-reload',title:'公告',split:true" style="width:410px;">
	     	<div id="aa" class="easyui-accordion" style="width:400px;height:300px;">   
	     	<c:forEach items="${adviceList }" var="advice" >
	     		<div title="${advice.title }" data-options="" style="overflow:auto;padding:10px;">   
			        <h3 style="color:#0099FF;">${advice.title }</h3>   
			        <p>${advice.content }</p>   
			    </div> 
	     	</c:forEach>
			    <div title="公告标题" data-options="iconCls:'icon-save',selected:true" style="overflow:auto;padding:10px;">   
			        <h3 style="color:#0099FF;">车必达出租车管理系统</h3>   
			        <p>这是车必达出租车管理系统，主要功能有用户管理，司机信息管理，车辆信息管理，车辆维修保养信息管理，运营里程日营业额信息管理。</p>   
			    </div>   
			</div> 
	     </div>  	   
		<div data-options="region:'west',title:'功能菜单',split:true" style="width:170px;">
	    	<div id="tree"></div>
	    </div>   
	    <div data-options="region:'center'" style="padding:5px;background:#eee;">
	    	<div id="mytab" class="easyui-tabs" >
	    		<div title="欢迎页面" >欢迎</div>
	    	</div>
	    </div>   
	     <input type="hidden" value="${userAdmin}" id="userAdminText" >
	</div>  
</body>
</html>