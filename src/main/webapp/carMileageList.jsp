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
	<h3 align="center" style="margin-top:100px" >车辆里程/日营业额记录</h3>
	<table style="margin-top:50px" align="center" border="1" cellspacing="0">
		<tr>
			<th>编号</th>
			<th>里程</th>
			<th>营业额</th>
			<th>车辆编号</th>
			<th>时间</th>
		</tr>
		<c:forEach items="${CarsMileageList }"  var="carsMileage">
		<tr align="center">
			<td>${carsMileage.carsMileageId }</td>
			<td width="100px">${carsMileage.mileage }公里</td>
			<td width="100px">${carsMileage.sales }元</td>
			<td>${carsMileage.carId }</td>
			<td width="200">${carsMileage.createTime }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>