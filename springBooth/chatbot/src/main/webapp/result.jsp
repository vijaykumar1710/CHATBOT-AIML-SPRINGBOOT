<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PRODUCTS</title>
</head>
<body>
	<h2> All Products Suiting your preferences: </h2>
	
	<table border='1'>
		<tr>
			<th>NAME</th>
			<th>ACUITY</th>
			<th>SCREEN TYPE</th>
			<th>SCREEN SIZE</th>
			<th>BASIC FEATURES</th>
			<th>ADDONS</th>
			<th>PERCENTAGE</th>	
		</tr>
		
	 <c:forEach items="${devices}" var = "device">
			<tr>
				<td>${device.productName}</td>
				<td>${device.acuity}</td>
				<td>${device.screenType}</td>
				<td>${device.screenSize}</td>
				<td>${device.basicfeatures}</td>
				<td>${device.addons}</td>
				<td>${device.percentage}</td>
			
			</tr>
			
	</c:forEach>
			
		
		
	 </table>


</body>
</html>