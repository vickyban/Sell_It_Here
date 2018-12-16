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
		<h1>${product.name}</h1>
		<h2>$${product.price}</h2>
		<p>${product.category}</p>
		<p>${product.description}</p>

		<c:choose>
			<c:when test="${seller.id == user.id}">
				<a href="${pageContext.request.contextPath}/products/product/edit?id=${product.productId}">Edit</a>
				<a href="${pageContext.request.contextPath}/products/product/delete?id=${product.productId}">Delete Post</a>
			</c:when>
			<c:otherwise>
				<a href="${pageContext.request.contextPath}/transaction/new?id=${product.productId}">Buy</a>
				<a href="${pageContext}/message/new?">Send Message</a>
			</c:otherwise>
		</c:choose>

	</div>

	<div>
		<p>Seller: ${seller.username}</p>
		<p>Location: ${seller.city}
		<p>
	</div>
</body>
</html>