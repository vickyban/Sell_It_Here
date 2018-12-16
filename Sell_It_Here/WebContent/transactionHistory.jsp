<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h2>Sales History</h2>
		<table>
			<tr>
				<th>Buyer</th>
				<th>Item</th>
				<th>Price</th>
				<th>Date of Sale</th>
			</tr>
			<c:forEach var="record" items="${sales}">
				<tr>
					<td>${record.buyer.username}</td>
					<td>${record.product.name}</td>
					<td>$${record.product.price}</td>
					<td>${record.created_at}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div>
		<h2>Purchases History</h2>
		<table>
			<tr>
				<th>Seller</th>
				<th>Item</th>
				<th>Price</th>
				<th>Date of Sale</th>
			</tr>
			<c:forEach var="record" items="${purchases}">
				<tr>
					<td>${record.seller.username}</td>
					<td>${record.product.name}</td>
					<td>$${record.product.price}</td>
					<td>${record.created_at}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>