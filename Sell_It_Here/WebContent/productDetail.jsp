<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/styles/searchbarStyle.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/styles/productDetailStyle.css" rel="stylesheet"
	type="text/css" />
<title>Product - ${product.name}</title>
</head>
<body>
	<%@ include file="/searchbar.jsp"%>

	<div class="wrapper">
		<p>Category > ${product.category}</p>
	</div>
	<div class="wrapper content">
		<div class="photo">
			<img
				src="https://sg.fiverrcdn.com/photos/116843855/original/e72c8ce8cd7ecf297e2be0d2b94a33d1cc20e85f.jpg?1536431532"
				alt="product-image">
		</div>
		<div class="other"></div>
		<div class="product">
			<div class="product-header">${product.name}</div>
			<div class="product-header">${product.price}</div>
			<p>Description</p>
			<div class="product-desc">${product.description}</div>
			<div class="product-btn">
				<c:choose>
					<c:when test="${seller.id == user.id}">
						<a
							href="${pageContext.request.contextPath}/products/product/edit?id=${product.productId}">Edit</a>
						<a
							href="${pageContext.request.contextPath}/products/product/delete?id=${product.productId}"
							id="btn-delete">Delete Post</a>
					</c:when>
					<c:otherwise>
						<a
							href="${pageContext.request.contextPath}/transaction/new?id=${product.productId}">Buy</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<div class="seller">
			<div class="product-btn">
				<h2>Seller Info</h2>
				<div class="seller-info">Username: ${seller.username}</div>
				<div class="seller-info">Location: ${seller.city}</div>
				<a
					href="${pageContext.request.contextPath}/transaction/new?id=${product.productId}">Send
					Message</a>
			</div>
		</div>

	</div>
</body>
</html>