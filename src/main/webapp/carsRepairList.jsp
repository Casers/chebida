<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>车辆维修保养记录</title>
</head>
<body>
	<h3 align="center" style="margin-top:100px" >车辆维修保养记录</h3>
	<table style="margin-top:50px" align="center" border="1" cellspacing="0">
		<tr>
			<th>编号</th>
			<th>类型</th>
			<th>备注</th>
			<th>车辆编号</th>
			<th>时间</th>
		</tr>
		<c:forEach items="${CarsRepairList }"  var="carsRepairList">
		<tr align="center">
			<td>${carsRepairList.carsRepairId }</td>
			<td width="80">${carsRepairList.carsRepairType }</td>
			<td width="380">${carsRepairList.carsRepairText }</td>
			<td>${carsRepairList.carId }</td>
			<td width="200">${carsRepairList.createTime }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>