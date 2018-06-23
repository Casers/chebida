<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>车辆信息</title>
</head>
<body>
	
	<c:if test="${car==null }">
		<h1 align="center">无信息</h1>
	</c:if>
	<c:if test="${car!=null }">
	<h3 align="center" style="margin-top: 100px">车辆信息</h3>
	<table align="center" border="1" cellspacing="0" width="800"
		height="200" style="margin-top: 50px">
		<tr align="center">
			<td rowspan="3"><img src="${pageContext.request.contextPath }/upload/${car.photo }" width="360px" height="200px" alt="图片加载异常" ></td>
			<th>编号</th>
			<td width="100">${car.carId }</td>
			<th width="100">车牌号</th>
			<td>${car.carNumber }</td>
			<th width="130">发动机号码</th>
			<td>${car.engineNumber }</td>
		</tr>
		<tr align="center">
			<th>司机编号</th>
			<td>${car.driverId }</td>
			<th>年检到期</th>
			<td>${car.endTime }</td>
			<th>出厂日期</th>
			<td>${car.startTime }</td>
		</tr>
		<tr align="center">
			<th colspan="3">创建时间</th>
			<td colspan="4"><fmt:formatDate value="${car.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		</tr>
	</table>
	</c:if>
</body>
</html>
