<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>   
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>司机信息</title>
</head>
<body>

	<c:if test="${driver==null }">
		<h1 align="center">无信息</h1>
	</c:if>
	<c:if test="${driver!=null }">
	<h3 align="center" style="margin-top:100px" >司机信息</h3>
	<table style="margin-top:50px" align="center" border="1" cellspacing="0" width="800"
		height="200">
		<tr align="center">
			<td rowspan="4"><img width="170px" height="210px" src="${pageContext.request.contextPath }/upload/${driver.photo }" alt="加载异常"></td>
			<th>编号</th>
			<td width="80">${driver.driverId }</td>
			<th>姓名</th>
			<td>${driver.driverName }</td>
			<th>身份号</th>
			<td>${driver.idCard }</td>
		</tr>
		<tr align="center">
			<th>性别</th>
			<td>${driver.sex }</td>
			<th>驾龄</th>
			<td>${driver.driverAge } 年</td>
			<th>联系方式</th>
			<td>${driver.phone }</td>
		</tr>
		<tr align="center">
			<th>年龄</th>
			<td>${driver.age }</td>
			<th>状态</th>
			<td>${driver.status }</td>
			<th>住址</th>
			<td colspan="2">${driver.address }</td>
		</tr>
		<tr align="center">
			<th colspan="2">创建时间</th>
			<td colspan="4"><fmt:formatDate value="${driver.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
		</tr>
	</table>
	</c:if>
</body>
</html>